package kr.my.files.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import kr.my.files.entity.MyFiles;
import kr.my.files.enums.UserFilePermissions;
import lombok.*;

import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonAutoDetect(fieldVisibility = ANY)
public class FileMetadata {
    private String contentType;
    private long length;
    private String originFileName;
    private Set<String> userFilePermissions;

}
