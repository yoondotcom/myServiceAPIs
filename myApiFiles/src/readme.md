
1. 프로젝트 구성안내
2. 프로젝트 설치 안내
3. 프로젝트 구동 안내 
4. 프로젝트 사용법
5. 프로젝트 기능설명
6. 저작권 및 사용자 정보
7. 버그
8. 프로그램 작성자 및 도움을 준 사람
9. 버전 (업데이트 소식)
10. FAQ

##File upload
#### 파일저장: path YYYY/MM/DD/HH
#### 파일명: hash (MD5) 저장
    1. 파일을 업로드 한다.
    2. 파일을 로컬에 복사 한다.
    3. 복사된 파일로 채크썸으로 파일명을 만든다. 
    4. 채크썸으로 복사된 파일을 리네임 하여 저장한다.
        => 체크섬을 체크섬으로 리네임 하면 체크썸이 유지가 되나?? 
        => 체크썸으로 리네임 한다는 것은 리네임된 체크썸으로 저장하겠다느 뜻이 아님
        => 그냥 그렇게 원본을 MD5 저장 하겠단 뜻임
    5. 파일 요청 퍼미션 요청사항에 따라 저장 위치를 달리 한다.
        => 전체 공계 파일 file.public-space-dir
        => 보호된 파일 file.protect-space-dir
    6. 파일 유형을 분석해서 경로 분류
        => https://myhappyman.tistory.com/133

### 파일업로그 기능 목록
    1. 파일업로드 기능
    2. 파일복사 기능 
    3. 경로분리 기능 공개, 비공계
    4. 경로작성 기능  ~/filePaht/YYYY/MM/DD/HH
    5. 파일읽어 http, https 로 내려주기 


####
~.hwp =>  application/x-tika-msoffice
~.xlsx => application/vnd.openxmlformats-officedocument.spreadsheetml.sheet 
~.pptx => application/vnd.openxmlformats-officedocument.presentationml.presentation
~.docx => application/vnd.openxmlformats-officedocument.wordprocessingml.document
~.doc =>  application/x-tika-msoffice
~.xls  => application/x-tika-msoffice
~.json => text/plain

jellyfish-4925772__340.jpg => image/jpeg
2021-01-14 08;40;18.PNG => image/png

r(Read) : 4
w(Write) : 2
x(Execute) : 1
r + w + x : 7



####확장자: file 로 통일 (public 파일 제외)
####원본파일 정보는 DB에 별도 저장
#### 말단 디렉터리에 파일 정보 저장 : 원본파일.확장자 => MD5.file
####권한정의 
    - 소유자 
    - 읽기, 쓰기

####파일일 특정 태그 일때 특정 서버 경로로 저장 가능
 - ConfigurationProperties 
 - https://sgc109.github.io/2020/07/07/spring-boot-configuration-properties/
 - spring boot json 과 파일 동시 처리 관련 포스트 : 
    - https://blogs.perficient.com/2020/07/27/requestbody-and-multipart-on-spring-boot/
    - test case는 되나 post man으로는 처리 되지 않음.
  - 사용자 파일 저장 프로퍼티 값   
```
file.upload-dir= ${user.home}/Download
file.public-space-dir= ${user.home}/Download
file.protect-space-dir= D${user.home}/Download
```

####전문포멧
```
    {
        id: hashKey,
        파일명: 
        작성일:
        크기:
        원본확장자:
        소유자: 
        다운로드 경로: https
        다운로드 권한 표시: owner, every, group ...  
    }
```
