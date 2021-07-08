package com.saketProject.springMongoCrud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    @NotNull
    private String todo;
    @NotNull
    private String description;
    @NotNull
    private boolean completed;
    private Date createdDate;
    private Date updatedDate;
}
