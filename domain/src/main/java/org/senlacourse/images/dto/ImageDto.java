package org.senlacourse.images.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ImageDto {

    private String id;
    private String createdDate;
    private String fileName;
}
