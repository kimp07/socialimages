package org.senlacourse.images.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "imageFiles")
@Data
@Accessors(chain = true)
public class Image {

    @Id
    private String id;
    @Indexed(direction = IndexDirection.ASCENDING)
    @Field(value = "Created_Date")
    private LocalDateTime createdDate;
    @Field(value = "File_Name")
    private String fileName;
}
