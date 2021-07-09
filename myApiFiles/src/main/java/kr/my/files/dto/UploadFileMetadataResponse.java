package kr.my.files.dto;

import kr.my.files.entity.FilePermissionGroup;
import kr.my.files.entity.MyFiles;
import kr.my.files.enums.UserFilePermissions;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Builder
public class UploadFileMetadataResponse extends RepresentationModel<UploadFileMetadataResponse> implements Serializable {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private String originFileName;
    private long size;
    private List<UserFilePermissions> filePermissions;


    public void setFileMetadata(MyFiles myFiles) {
        this.fileName = myFiles.getFilePhyName();
        this.fileDownloadUri = myFiles.getFileDownloadPath();
        this.fileType = myFiles.getFileContentType();
        this.originFileName = myFiles.getFileOrgName();
        this.size = myFiles.getFileSize();
    }

    public void addFilePermission(List<UserFilePermissions> filePermissions){
        this.filePermissions = filePermissions;
    }
}
