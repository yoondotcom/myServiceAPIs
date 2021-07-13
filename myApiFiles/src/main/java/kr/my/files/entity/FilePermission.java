package kr.my.files.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by goodjwon on 16. 1. 16..
 * 파일에 접근 정책을 설정 한다.
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "filesRoleFileRoleSeq")
@Getter
@Entity
@Table(name = "FILE_PERMISSION")
public class FilePermission extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "FILE_ROLE_SEQ", nullable = false, insertable = true, updatable = true)
    private Long fileRoleSeq;
    @Column(name = "OWNER_READ", nullable = false, insertable = true, updatable = true, length = 20)
    private String ownerRead;
    @Column(name = "OWNER_WRITE", nullable = false, insertable = true, updatable = true, length = 20)
    private String ownerWrite;
    @Column(name = "GROUP_READ", nullable = false, insertable = true, updatable = true, length = 20)
    private String groupRead;
    @Column(name = "GROUP_WRITE", nullable = false, insertable = true, updatable = true, length = 20)
    private String groupWrite;
    @Column(name = "PUBLIC_READ", nullable = false, insertable = true, updatable = true, length = 20)
    private String publicRead;
    @Column(name = "PUBLIC_WRITE", nullable = false, insertable = true, updatable = true, length = 20)
    private String publicWrite;
    @ManyToOne
    private MyFiles myFileSeq;

}
