package com.portfolio.portfolio;

import org.springframework.stereotype.Repository;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class UsersRepository {
    private final DynamoDbTable<Users> users;

    public UsersRepository(DynamoDbEnhancedClient enhancedClient) {
        this.users = enhancedClient.table("Users", TableSchema.fromBean(Users.class));
    }

    public void saveUser(Users user) {
        users.putItem(user);
    }

    public Users getUserById(String id) {
        return users.getItem(Key.builder().partitionValue(id).build());
    }

    public Users getUserByUsername(String username) {
        
        return null;
    }

    public void deleteUserById(String id) {
        users.deleteItem(Key.builder().partitionValue(id).build());
    }

    public void updateUser(Users user) {
        users.updateItem(user);
    }

    public Iterable<Users> getAllUsers() {
        return users.scan().items();
    }
}
