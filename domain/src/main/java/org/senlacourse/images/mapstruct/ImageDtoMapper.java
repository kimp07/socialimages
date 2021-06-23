package org.senlacourse.images.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.senlacourse.images.domain.Image;
import org.senlacourse.images.dto.ImageDto;
import org.springframework.data.domain.Page;

@Mapper
public interface ImageDtoMapper {

    @Mapping(target = "createdDate", source = "createdDate", dateFormat = "yyyy-MM-dd hh:mm:ss")
    ImageDto fromModel(Image model);

    default Page<ImageDto> map(Page<Image> models) {
        return models.map(this::fromModel);
    }
}
