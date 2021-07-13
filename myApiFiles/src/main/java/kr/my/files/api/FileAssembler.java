package kr.my.files.api;

import kr.my.files.dto.FileMetadata;
import kr.my.files.dto.UploadFileMetadataResponse;
import kr.my.files.entity.MyFiles;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class FileAssembler extends RepresentationModelAssemblerSupport<MyFiles, UploadFileMetadataResponse> {
    public FileAssembler() {
        super(FileController.class, UploadFileMetadataResponse.class);
    }

    @Override
    public UploadFileMetadataResponse toModel(MyFiles entity) {

        UploadFileMetadataResponse fileMetadata
                = UploadFileMetadataResponse.builder().build();
        fileMetadata.builder().myFiles(entity).build();

        WebMvcLinkBuilder selfLinkBuilder = linkTo(FileController.class);
        fileMetadata.add(selfLinkBuilder.withRel("query-file"));
        fileMetadata.add(selfLinkBuilder.slash(entity.getFileDownloadPath()).withSelfRel());

        return fileMetadata;
    }
}