package kr.my.files.api;

import kr.my.files.dto.FileMetadata;
import kr.my.files.dto.UploadFileMetadataResponse;
import kr.my.files.dto.UploadFileRequest;
import kr.my.files.enums.UserFilePermissions;
import kr.my.files.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.*;
import java.util.stream.Collectors;

import static kr.my.files.enums.UserFilePermissions.OWNER_READ;
import static kr.my.files.enums.UserFilePermissions.OWNER_WRITE;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private final FileStorageService fileStorageService;

    public FileController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload-file")
    public UploadFileMetadataResponse uploadFile(
            @ModelAttribute UploadFileRequest uploadFileRequest, ModelMap modelMap
    ) {
        String fileName = fileStorageService.storeFile(uploadFileRequest.getFile());

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return UploadFileMetadataResponse.builder()
                .fileName(fileName)
                .fileType(uploadFileRequest.getFile().getContentType())
                .fileDownloadUri(fileDownloadUri)
                .filePermissions(uploadFileRequest.getUserFilePermissions())
                .size(uploadFileRequest.getFile().getSize())
                .build();
    }


    /**
     * Form 으로 파일 퍼미미션 Permission 정보 전송.
     *
     * @param
     * @param
     * @return
     */
    @Deprecated
    @PostMapping(value = "/upload-file-permission")
    public UploadFileMetadataResponse uploadFileAndPerMissionJustForm(
            @ModelAttribute UploadFileRequest uploadFileRequest, ModelMap modelMap) {

        modelMap.addAttribute("fileInfo", uploadFileRequest);

        String fileName = fileStorageService.storeFile(uploadFileRequest.getFile());

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return UploadFileMetadataResponse.builder()
                .fileName(fileName)
                .fileType(uploadFileRequest.getFile().getContentType())
                .fileDownloadUri(fileDownloadUri)
                .filePermissions(uploadFileRequest.getUserFilePermissions())
                .size(uploadFileRequest.getFile().getSize())
                .build();
    }

    /**
     * Form 과 json 파일로 요청
     *
     * @param file
     * @param metadata
     * @return
     */
    @PostMapping(value = "/upload-file-permission-json-file")
    public ResponseEntity<UploadFileMetadataResponse> uploadFileAndPerMissionWithJsonFile(
            @RequestPart(value = "file") MultipartFile file,
            @RequestPart(value = "metadata", required = false) UploadFileRequest metadata) {

        //권한정보가 없을 경우 파일업로드 주체는 read, write 권한을 가진다.
        if (metadata == null) {
            List<UserFilePermissions> filePermissions = new ArrayList<>();
            filePermissions.add(OWNER_WRITE);
            filePermissions.add(OWNER_READ);

            metadata = UploadFileRequest.builder()
                        .fileName(file.getOriginalFilename())
                        .userFilePermissions(filePermissions)
                        .build();
        }

        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return ResponseEntity.ok(UploadFileMetadataResponse.builder()
                .fileName(fileName)
                .fileDownloadUri("")
                .fileType("")
                .originFileName("")
                .size(0)
                .filePermissions(metadata.getUserFilePermissions())
                .build());
    }

    /**
     * Form 과 Json 으로 요청
     *
     * @param file
     * @param metadata
     * @return
     */
    @PostMapping(value = "/upload-file-permission-json",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<UploadFileMetadataResponse> uploadFileAndPerMissionWithJson(
            @RequestPart(value = "file") MultipartFile file,
            @RequestPart(value = "metadata", required = false) UploadFileRequest metadata) {

        //권한정보가 없을 경우 파일업로드 주체는 read, write 권한을 가진다.
        if (metadata == null) {
            List<UserFilePermissions> filePermissions = new ArrayList<>();
            filePermissions.add(OWNER_WRITE);
            filePermissions.add(OWNER_READ);

            metadata = UploadFileRequest.builder()
                    .fileName(file.getOriginalFilename())
                    .userFilePermissions(filePermissions)
                    .build();
        }

        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return ResponseEntity.ok(UploadFileMetadataResponse.builder()
                .fileName(fileName)
                .fileDownloadUri("")
                .fileType("")
                .originFileName("")
                .size(0)
                .filePermissions(metadata.getUserFilePermissions())
                .build());
    }


    /**
     * TODO 다중파일 저장. 작업 중.
     *
     * @param files
     * @return
     */
    @PostMapping("/upload-files-permission")
    public List<FileMetadata> uploadMultipleFiles(
            @RequestParam("files") MultipartFile[] files,
            @RequestPart(value = "metadata", required = false) FileMetadata metaData) {

         Arrays.asList(files)
                .stream()
                .map(file -> fileStorageService.storeFile(file))
                .collect(Collectors.toList());

         return null;
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