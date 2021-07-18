package kr.my.files.entity;


import jdk.jfr.Enabled;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * 파일애 대한 공동 사용자에 대한 키 등록
 * 파일 등록시 열람 가능자에 대한 정보를 입력 한다.
 * 1. 담당자
 * 2. 담당자가 속한 부서 등 소그룹
 * 3. 담당자가 속한 부서의 속한 대 그룹
 * 파일 1개 당 총 N개의 정보가 입력 될 수 있다.
 */

@NoArgsConstructor
@Getter
@Embeddable
public class FilePermissionGroup {

    @Column(name = "ACCESS_CODE")
    private String idAccessCode;    //열람자 고유코드 , 사용자 id hash, 사용자 소속 부서 hash, 사용자 조직 hash 등.

    @Builder
    public FilePermissionGroup(String idAccessCode) {
        this.idAccessCode = idAccessCode;
    }
}
