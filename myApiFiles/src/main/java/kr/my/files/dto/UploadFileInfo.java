package kr.my.files.dto;


import kr.my.files.enums.UserFilePermissions;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Deprecated
public class UploadFileInfo {
    private String fileName;
    private MultipartFile file;
    private Set<String> UserFilePermissions;
}
