package kr.my.files.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.Column;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonAutoDetect(fieldVisibility = ANY)
public class FileMetadata {
    private String fileName;
    private String contentType;
    private String ownerRead;
    private String ownerWrite;
    private String groupRead;
    private String groupWrite;
    private String publicRead;
    private String publicWrite;
    private long length;
    private String downloadPath;
    private String originFileName;



}
