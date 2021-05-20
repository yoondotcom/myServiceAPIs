package kr.my.files.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import kr.my.files.dto.FileMetadata;
import kr.my.files.service.FileStorageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

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


    @Test
    @DisplayName("file, permission 정보 form submit 테스트 ")
    void uploadFileSubmitTest() throws Exception {

        MockMultipartFile file = new MockMultipartFile("file","test.txt" , "text/plain" , "hello file".getBytes());
        this.mockMvc.perform(multipart("/upload-file-permission")
                .file(file)
                .param("fileName", "aaa.txt")
                .param("ownerPermission", "6"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    @DisplayName("file, permission.json submit 테스트")
    void uploadShouldReturnMetadataName() throws Exception {
        //Given
        MockMultipartFile file = new MockMultipartFile("file", "hello.text",
                TEXT_PLAIN_VALUE, "Hello, World!".getBytes(StandardCharsets.UTF_8));


        MockMultipartFile metadata = new MockMultipartFile(
                "medadata",
                "metadata",
                APPLICATION_JSON_VALUE,
                new ObjectMapper()
                        .writeValueAsString( new FileMetadata("helloworld", 6, 6, 6))
                        .getBytes(StandardCharsets.UTF_8));

        mockMvc.perform(multipart("/upload-file-permission-json")
                .file(file).file(metadata))
                .andDo(print());

    }



}
