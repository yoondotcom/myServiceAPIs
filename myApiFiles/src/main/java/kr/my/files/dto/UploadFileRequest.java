package kr.my.files.dto;


import kr.my.files.enums.UserFilePermissions;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UploadFileRequest {
    private String fileName;
    private MultipartFile file;
    private List <UserFilePermissions> userFilePermissions;
}
