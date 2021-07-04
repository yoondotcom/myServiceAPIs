package kr.my.files.controller;

import kr.my.files.dto.FileMetadata;
import kr.my.files.dto.UploadFileInfo;
import kr.my.files.dto.UploadFileResponse;
import kr.my.files.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private final FileStorageService fileStorageService;

    public FileController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }


    /**
     * Form and Permission 정보 저장.
     *
     * @param
     * @param
     * @return
     */
    @PostMapping(value = "/upload-file-permission")
    public UploadFileResponse uploadFileAndPerMissionJustForm(
            @ModelAttribute UploadFileInfo fileInfo, ModelMap modelMap) {

        modelMap.addAttribute("fileInfo", fileInfo);

        String fileName = fileStorageService.storeFile(fileInfo.getFile());

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                fileInfo.getFile().getContentType(), fileInfo.getFile().getSize());
    }

    /**
     * Form 과 json 파일로 요청
     *
     * @param file
     * @param metadata
     * @return
     */
    @PostMapping(value = "/upload-file-permission-json-file")
    public ResponseEntity<FileMetadata> uploadFileAndPerMissionWithJsonFile(
            @RequestPart(value = "file") MultipartFile file,
            @RequestPart(value = "metadata", required = false) FileMetadata metadata) {

        //권한정보가 없을 경우 파일업로드 주체는 read, write 권한을 가진다.
        if (metadata == null) {
            metadata = new FileMetadata(file.getName(), 6, 0, 0);
        }

        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        metadata.setName(fileName);
        metadata.setLength(file.getSize());
        metadata.setContentType(file.getContentType());
        metadata.setDownloadPath(fileDownloadUri);

        return ResponseEntity.ok(metadata);
    }

    /**
     * Form 과 Json으로 요청
     *
     * @param file
     * @param metadata
     * @return
     */
    @PostMapping(value = "/upload-file-permission-json",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<FileMetadata> uploadFileAndPerMissionWithJson(
            @RequestPart(value = "file") MultipartFile file,
            @RequestPart(value = "metadata", required = false) FileMetadata metadata) {

        //권한정보가 없을 경우 파일업로드 주체는 read, write 권한을 가진다.
        if (metadata == null) {
            metadata = new FileMetadata(file.getName(), 6, 0, 0);
        }

        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        metadata.setName(fileName);
        metadata.setLength(file.getSize());
        metadata.setContentType(file.getContentType());
        metadata.setDownloadPath(fileDownloadUri);
        metadata.setOriginFileName(file.getOriginalFilename());

        return ResponseEntity.ok(metadata);
    }


    /**
     * TODO 다중파일 저장. 작업 중.
     *
     * @param files
     * @return
     */
    @PostMapping("/upload-files-permission")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }


    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}