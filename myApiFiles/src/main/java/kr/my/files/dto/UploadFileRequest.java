package kr.my.files.dto;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UploadFileRequest {
    private String fileName;
    private String ownerPermission;  //rw
    private String groupPermission;  //rw
    private String publicPermission; //rw

}
