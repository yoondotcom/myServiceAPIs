package kr.my.files.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonAutoDetect(fieldVisibility = ANY)
public class FileMetadata {
    private String name;
    private String contentType;
    private int ownerPermission;  //rw = 6, r = 4, w = 2
    private int groupPermission;  //rw = 6, r = 4, w = 2
    private int publicPermission; //rw = 6, r = 4, w = 2
    private long length;
    private String downloadPath;

    public FileMetadata(String name, int ownerPermission, int groupPermission, int publicPermission) {
        this.name = name;
        this.ownerPermission = ownerPermission;
        this.groupPermission = groupPermission;
        this.publicPermission = publicPermission;
    }
}
