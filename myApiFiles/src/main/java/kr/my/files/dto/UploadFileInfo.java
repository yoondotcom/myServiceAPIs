package kr.my.files.dto;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UploadFileInfo {
    private String fileName;
    private int ownerPermission;  //rw = 6, r = 4, w = 2
    private int groupPermission;  //rw = 6, r = 4, w = 2
    private int publicPermission; //rw = 6, r = 4, w = 2
    private MultipartFile file;

}
