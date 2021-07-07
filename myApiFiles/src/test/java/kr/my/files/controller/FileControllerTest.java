package kr.my.files.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import kr.my.files.dto.FileMetadata;
import kr.my.files.enums.UserFilePermissions;
import kr.my.files.service.FileStorageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import static kr.my.files.enums.UserFilePermissions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FileControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("file, permission 정보 form submit 테스트 ")
    void uploadFileSubmitTest() throws Exception {

        MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", "hello file".getBytes());
        this.mockMvc.perform(multipart("/upload-file-permission")
                .file(file)
                .param("fileName", "aaa.txt")
                .param("filePermissions.ownerRead", OWNER_READ.getPermission())
                .param("filePermissions.ownerWrite", OWNER_WRITE.getPermission()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
        ;
    }

    @Test
    @DisplayName("file, permission.json submit 테스트")
    void uploadShouldReturnMetadataNameWithJsonFile() throws Exception {
        //Given 파일생성
        MockMultipartFile file = new MockMultipartFile("file", "hello.txt",
                TEXT_PLAIN_VALUE, "Hello, World!".getBytes(StandardCharsets.UTF_8));

        //Given Json 파일 생성
        //Json 요청 생성
        Set<String> filePermissions = new HashSet();
        filePermissions.add(OWNER_WRITE.getPermission());
        filePermissions.add(OWNER_READ.getPermission());

        MockMultipartFile metadata = new MockMultipartFile(
                "metadata",
                "metadata",
                APPLICATION_JSON_VALUE,
                new ObjectMapper()
                        .writeValueAsString(FileMetadata.builder()
                                .fileName(file.getOriginalFilename())
                                .userFilePermissions(filePermissions)
                                .build())
                        .getBytes(StandardCharsets.UTF_8));

        //then
        mockMvc.perform(multipart("/upload-file-permission-json-file")
                .file(file).file(metadata))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
        ;
    }

    @Test
    @DisplayName("file, permission 정보 ")
    void uploadShouldReturnMetadataNameWithJson() throws Exception {
        //Given
        MockMultipartFile file = new MockMultipartFile("file", "hello2.txt",
                TEXT_PLAIN_VALUE, "Hello, World! JSON Meta".getBytes(StandardCharsets.UTF_8));
        //Json 요청 생성
        Set<String> filePermissions = new HashSet();

        filePermissions.add(OWNER_WRITE.getPermission());
        filePermissions.add(OWNER_READ.getPermission());

        FileMetadata metadata = FileMetadata.builder()
                .userFilePermissions(filePermissions)
                .fileName(file.getOriginalFilename())
                .build();

        mockMvc.perform(multipart("/upload-file-permission-json")
                .file(file)
                .accept(APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(metadata)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @DisplayName("모두 공계 파일일때 별도 지정된 디렉터리로 저장 여부 확인")
    void uploadFPublicFile() throws Exception {
        //given
        //when
        //then
    }

    @Test
    @DisplayName("파일 저장시 일자에 맞는 디렉터리 구조로 저장 되는지 확인")
    void checkFileSavePath() throws Exception {
        //given
        //when
        //then
    }

    @Test
    @DisplayName("파일 사용자 정보를 DB에 입력 한다.")
    void saveFileUserinfo() throws Exception {
        //given
        //when
        //then
    }


    @Test
    @DisplayName("파일 메타정보 DB 입력")
    void saveFileMetainfo() throws Exception {
        //given
        //when
        //then
    }

    @Test
    @DisplayName("파일요청서 퍼미션에 대당 하지 않으면 정보 열람을 거부한다.")
    void checkFilePermission() throws Exception {
        //given
        //when
        //then
    }

    @Test
    @DisplayName("업로드된 파일에 대해서 파일 다운로드 요청 관련 정보를 던지면 파일을 다운로드 한다.")
    void downloadFile() throws Exception {
        //given
        //when
        //then
    }

    @Test
    @DisplayName("업로드된 파일에 대해서 파일 다운로드 요청 요청정보를 던지면 소유주만 파일을 다운로드 한다.")
    void downloadFilecheckFilePermission() throws Exception {
        //given
        //when
        //then
    }



    @Test
    @DisplayName("파일 다운로드 기록 저장")
    void saveFileDownloadPath() throws Exception {
        //given
        //when
        //then

    }

    @Test
    @DisplayName("파일 권한에 열람 가능자 정보를 저장한다. ")
    void testPermission() {
        //given
        //when
        //then
    }

    @Test
    @DisplayName("파일 권한에 열람 가능자 정보가 있으면 맞는지 확인 하고 다운로드 시킨다. ")
    void groupPermissionHashKeyCorrectCaseCheck() {
        //given
        //when
        //then
    }

    @Test
    @DisplayName("파일 권한에 열람 가능자 정보를 확인 하고 틀릴경우 401 권한 없음 에러를 던진다. ")
    void groupPermissionHashKeyBadCaseCheck() {
        //given
        //when
        //then
    }



}
