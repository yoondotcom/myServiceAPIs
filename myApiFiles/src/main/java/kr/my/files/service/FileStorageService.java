package kr.my.files.service;

import kr.my.files.dto.UploadFileMetadataResponse;
import kr.my.files.dto.UploadFileRequest;
import kr.my.files.entity.MyFiles;
import kr.my.files.enums.FileStatus;
import kr.my.files.enums.UserFilePermissions;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.tika.Tika;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static kr.my.files.enums.UserFilePermissions.OWNER_READ;
import static kr.my.files.enums.UserFilePermissions.OWNER_WRITE;

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
     *
     */
    public UploadFileMetadataResponse saveFile(UploadFileRequest fileRequest) {

        String uuidFileName = storeFile(fileRequest.getFile());
        String fileDownloadUri = getFileDownloadUri(uuidFileName);
        String fileHash = getFileHash(fileRequest.getFile());
        MultipartFile file = fileRequest.getFile();

        MyFiles myFile = MyFiles.builder()
                .fileDownloadPath(uuidFileName)
                .fileContentType(file.getContentType())
                .fileHashCode(fileHash)
                .fileOrgName(file.getOriginalFilename())
                .filePath("")
                .fileSize(file.getSize())
                .fileStatus(FileStatus.Registered)
                .fileOwnerDisplayName("")
                .userFilePermissions(addDefaultPermission(fileRequest).getUserFilePermissions())
                .filePermissionGroups(null)
                .filePhyName(uuidFileName)
                .postLinkType("")
                .postLinked(0L)
                .fileDownloadPath(fileDownloadUri)
                .build();

        return UploadFileMetadataResponse.builder().myFiles(myFile).build();

    }

    private UploadFileRequest addDefaultPermission(UploadFileRequest fileRequest) {
        if(fileRequest.getUserFilePermissions().isEmpty()){
            List<UserFilePermissions> filePermissions = new ArrayList<>();
            filePermissions.add(OWNER_WRITE);
            filePermissions.add(OWNER_READ);
            fileRequest.addUserFilePermissions(filePermissions);
        }
        return fileRequest;
    }

    /**
     * 1. 업로드된 파일을 지정된 경로에 저장한다.
     *
     * @param file
     * @return
     */
    private String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String ext = FilenameUtils.getExtension(fileName);

        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            String uuidFileName = getUUIDFileName(file, ext);

            Path targetLocation = this.fileStorageLocation.resolve(uuidFileName); //경로 만들기.

            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return uuidFileName;

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    private String getFileDownloadUri(String fileName){
        return  ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
    }

    /**
     * file hash 값 찾기 만든가.
     * @param file
     * @return
     * @throws IOException
     */
    private String getFileHash(MultipartFile file)  {
        String digestFileName = "";
        try{
            digestFileName = DigestUtils.md5Hex(file.getInputStream());
        }catch (IOException ioe){
            throw new FileStorageException("file md5 Hash is failed");
        }
        return digestFileName;
    }

    /**
     * 파일명 저장하기.
     * @param file
     * @param ext
     * @return
     * @throws IOException
     */
    private String getUUIDFileName(MultipartFile file, String ext) throws IOException {
        String uuidFileName = UUID.randomUUID().toString();
        return uuidFileName.concat(".").concat(ext);
    }

    /**
     * 파일 mine type을 확인 한다.
     *
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
            if (resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}
