package kr.my.files.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by goodjwon on 16. 1. 16..
 * 문건을 필요시애 다른 사용자에게 열람권한을 준다.
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "shareSeq")
@Getter
@Entity
@Table(name = "FILE_SHARES")
public class FileShares extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "SHARE_SEQ", nullable = false, insertable = true, updatable = true)
    private Long shareSeq;
    @Column(name = "FILE_LINK_URL", nullable = true, insertable = true, updatable = true, length = 255)
    private String fileLinkUrl;
    @Column(name = "FILE_LINK_TYPE", nullable = true, insertable = true, updatable = true, length = 50)
    private String fileLinkType;
    @Column(name = "REG_DATE", nullable = true, insertable = true, updatable = true)
    private Timestamp regDate;

    @JoinColumn(name = "MY_FILES_FILE_SEQ", referencedColumnName = "FILE_SEQ", nullable = false)
    @ManyToOne
    private MyFiles myFileSeq;

    @Builder
    public FileShares(String fileLinkUrl, String fileLinkType, Timestamp regDate, MyFiles myFileSeq) {
        this.fileLinkUrl = fileLinkUrl;
        this.fileLinkType = fileLinkType;
        this.regDate = regDate;
        this.myFileSeq = myFileSeq;
    }
}
