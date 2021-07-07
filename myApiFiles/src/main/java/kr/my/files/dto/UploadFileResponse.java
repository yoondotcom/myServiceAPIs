package kr.my.files.dto;

import kr.my.files.enums.UserFilePermissions;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Builder
public class UploadFileResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private Set<String> userFilePermissions;
    private long size;

}
