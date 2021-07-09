package com.saketProject.springMongoCrud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Document(collection = "todos")
public class Todo {
    @Id
    private String id;

    @NotEmpty(message = "todo can not be empty")
    @NotNull(message = "todo can not be null")
    private String todo;

    @NotNull(message = "description can not be null")
    private String description;

    @NotNull(message = "completed can not be null")
    private Boolean completed;

    private Date createdDate;
    private Date updatedDate;
}
