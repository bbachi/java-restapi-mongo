package com.bachinalabs.mongodemo.dto;

import lombok.Data;

@Data
public class TaskDTO {

    private String id;
    private String name;
    private String description;
    private String createdBy;
    private String updatedBy;
}
