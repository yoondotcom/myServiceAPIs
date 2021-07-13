package kr.my.files.dto;


import kr.my.files.enums.UserFilePermissions;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class UploadFileRequest {
    private String fileName;
    private MultipartFile file;
    private MultipartFile[] files;
    private List <UserFilePermissions> userFilePermissions;

    public void addFile(MultipartFile file){
        this.file = file;
    }

    public void addFiles(MultipartFile[] files){
        this.files = files;
    }

}
