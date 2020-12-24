package com.bachinalabs.mongodemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document(collection = "todos")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Id
    private String id;
    private String name;
    private String description;
    private String createdDate;
    private String createdBy;
    private String updatedDate;
    private String updatedBy;

}
