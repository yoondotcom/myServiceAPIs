package kr.my.files.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "shareSeq")
@Getter
@Entity
@Table(name = "FILE_SHARES", schema = "", catalog = "MY_MEMBER")
public class FileShares {
    @Id @GeneratedValue @Column(name = "SHARE_SEQ", nullable = false, insertable = true, updatable = true)
    private Long shareSeq;

    @Column(name = "FILE_LINKED", nullable = true, insertable = true, updatable = true, length = 255)
    private String fileLinked;

    @Column(name = "FILE_LINK_TYPE", nullable = true, insertable = true, updatable = true, length = 50)
    private String fileLinkType;

    @Column(name = "REG_DATE", nullable = true, insertable = true, updatable = true)
    private Timestamp regDate;

    @Column(name = "MY_FILES_FILE_SEQ", nullable = false, insertable = true, updatable = true)
    private Long myFilesFileSeq;

    @JoinColumn(name = "MY_FILES_FILE_SEQ", referencedColumnName = "FILE_SEQ", nullable = false)
    @ManyToOne
    private MyFiles myFilesByMyFilesFileSeq;

    public FileShares(String fileLinked, String fileLinkType, Timestamp regDate, Long myFilesFileSeq, MyFiles myFilesByMyFilesFileSeq) {
        this.fileLinked = fileLinked;
        this.fileLinkType = fileLinkType;
        this.regDate = regDate;
        this.myFilesFileSeq = myFilesFileSeq;
        this.myFilesByMyFilesFileSeq = myFilesByMyFilesFileSeq;
    }
}
