package it.linkshare.service.mapper;

import it.linkshare.controller.dto.Tag;
import it.linkshare.controller.dto.TagCreationRequest;
import it.linkshare.repository.entity.TagEntity;

// Framework: MapStruct
public class TagMapper {

    public static TagEntity mapToEntity(TagCreationRequest request){
        return new TagEntity(request.getName(), request.getNsfw());
    }

    public static Tag mapToRest(TagEntity entity){
        return new Tag(entity.getId(), entity.getName(), entity.getNsfw());
    }

}
