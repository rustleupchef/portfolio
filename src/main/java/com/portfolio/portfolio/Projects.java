package com.portfolio.portfolio;

import java.util.List;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.ser.std.ToStringSerializer;

@DynamoDbBean
public class Projects {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long project_id;
    private String description;
    private List<String> skills;
    private String title;
    private String img;

    @DynamoDbPartitionKey
    public Long getProject_id() {
        return project_id;
    }
    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSkills() {
        return skills;
    }
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
}
