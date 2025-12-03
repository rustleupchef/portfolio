package com.portfolio.portfolio;

import org.springframework.stereotype.Repository;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class ProjectsRepository {
    private final DynamoDbTable<Projects> projects;

    public ProjectsRepository(DynamoDbEnhancedClient enhancedClient) {
        this.projects = enhancedClient.table("Projects", TableSchema.fromBean(Projects.class));
    }

    public void saveProject(Projects project) {
        projects.putItem(project);
    }

    public Projects getProjectById(Long id) {
        return projects.getItem(Key.builder().partitionValue(id).build());
    }

    public void deleteProjectById(Long id) {
        projects.deleteItem(Key.builder().partitionValue(id).build());
    }

    public void updateProject(Projects project) {
        projects.updateItem(project);
    }

    public Iterable<Projects> getAllProjects() {
        return projects.scan().items();
    }
}
