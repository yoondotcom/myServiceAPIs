package kr.my.files.api;

import kr.my.files.dto.FileMetadata;
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
public class FileAssembler extends RepresentationModelAssemblerSupport<MyFiles, FileMetadata> {
    public FileAssembler() {
        super(FileController.class, FileMetadata.class);
    }

    @Override
    public FileMetadata toModel(MyFiles entity) {

        FileMetadata fileMetadata = FileMetadata.builder().official(entity).build();
        WebMvcLinkBuilder selfLinkBuilder = linkTo(UserController.class);

        fileMetadata.add(selfLinkBuilder.withRel("query-users"));
        fileMetadata.add(selfLinkBuilder.slash(entity.getUserId()).withSelfRel());
        fileMetadata.add(selfLinkBuilder.slash(entity.getUserId()).withRel("update-user"));
        fileMetadata.add(Link.of("/docs/index.html").withRel("profile"));

        return officialResModel;
    }

    @Override
    public CollectionModel<FileMetadata> toCollectionModel(Iterable<? extends Official> entries){
        CollectionModel<FileMetadata> officialResModels = super.toCollectionModel(entries);
        //todo  .withSelfRel()) 전에 먼가 들어가야 할 수도 있다.
        //        officialResModels.add(linkTo(methodOn(UserController.class)).withSelfRel());

        return StreamSupport
                .stream(entries.spliterator(), false)
                .map(this::toModel)
                .collect(Collectors.collectingAndThen(Collectors.toList(), CollectionModel::of));


        //        officialResModels.add(Link.of("/docs/index.html").withRel("profile"));

        //        return officialResModels;
    }
}