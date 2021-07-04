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
    @Column(name = "OWNER_PERMISSION", nullable = false, insertable = true, updatable = true, length = 1)
    private Integer ownerPermission;
    @Column(name = "GROOUP_PERMISSION", nullable = false, insertable = true, updatable = true, length = 1)
    private Integer groupPermission;
    @Column(name = "PUBLIC_PERMISSION", nullable = false, insertable = true, updatable = true, length = 1)
    private Integer publicPermission;
    @Column(name = "REG_DATE", nullable = false, insertable = true, updatable = true)
    private LocalDateTime regDate;
    @Column(name = "UPT_DATE", nullable = true, insertable = true, updatable = true)
    private LocalDateTime uptDate;

    public FilePermission(Integer ownerPermission, Integer groupPermission, Integer publicPermission) {
        this.ownerPermission = ownerPermission;
        this.groupPermission = groupPermission;
        this.publicPermission = publicPermission;
    }
}
