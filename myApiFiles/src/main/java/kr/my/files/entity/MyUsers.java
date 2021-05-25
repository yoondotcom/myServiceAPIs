package kr.my.files.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by goodjwon on 16. 1. 16..
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Entity
@Table(name = "MY_USERS")
public class MyUsers {
    @Id
    @Column(name = "USER_CODE", nullable = false, insertable = true, updatable = true, length = 15)
    private String userCode;
    @Column(name = "USER_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    private String userName;
    @Column(name = "USER_EMAIL", nullable = false, insertable = true, updatable = true, length = 100)
    private String email;
    @Column(name = "USER_NICE_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    private String userNiceName;
    @Column(name = "USER_ACTIVATION_KEY", nullable = false, insertable = true, updatable = true, length = 255)
    private String userActivationKey;
    @Column(name = "REG_DATE", nullable = false, insertable = true, updatable = true)
    private Timestamp regDate;
    @Column(name = "UPT_DATE", nullable = true, insertable = true, updatable = true)
    private Timestamp uptDate;

}
