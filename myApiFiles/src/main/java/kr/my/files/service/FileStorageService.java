package kr.my.files.service;

import kr.my.files.exception.FileStorageException;
import kr.my.files.exception.MyFileNotFoundException;
import kr.my.files.property.FileStorageProperties;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.tika.Tika;

@NoArgsConstructor
@Service
public class FileStorageService {

    private Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths
                .get(fileStorageProperties.getUploadDir())
                .toAbsolutePath()
                .normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }


    /**
     * 1. dffdddd
     * @param file dadad
     * @return
     */
    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String ext = FilenameUtils.getExtension(fileName);

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            String digestFileName = getHashFileName(file, ext);

            Path targetLocation = this.fileStorageLocation.resolve(digestFileName); //경로 만들기.

            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return digestFileName;

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    /**
     * file hash 명을 만든가.
     * @param file
     * @param ext
     * @return
     * @throws IOException
     */
    private String getHashFileName(MultipartFile file, String ext) throws IOException {
        String digestFileName = DigestUtils.md5Hex(file.getInputStream());
        digestFileName = digestFileName.concat(".").concat(ext);

        String mimeType = getFileMimeType(file);

        return digestFileName;
    }

    /**
     * 파일 mine type을 확인 한다.
     * @param file
     * @return
     * @throws IOException
     */
    private String getFileMimeType(MultipartFile file) throws IOException {
        String mimeType = new Tika().detect(file.getInputStream());
        return mimeType;
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}
