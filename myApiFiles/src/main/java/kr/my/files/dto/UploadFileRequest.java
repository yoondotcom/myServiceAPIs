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
    private List<String> idAccessCodes;

    public void addFile(MultipartFile file){
        this.file = file;
    }

    public void addFiles(MultipartFile[] files){
        this.files = files;
    }

    public void addUserFilePermissions(List <UserFilePermissions> userFilePermissions){
        this.userFilePermissions = userFilePermissions;
    }

    public void addFileName(String fileName){
        this.fileName = fileName;
    }

}
