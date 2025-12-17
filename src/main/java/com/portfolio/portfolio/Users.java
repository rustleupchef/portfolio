package com.portfolio.portfolio;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Users {
    
    private String username;
    private String password;
    private boolean role;

    @DynamoDbPartitionKey
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
   
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRole() {
        return role;
    }
    public void setRole(boolean role) {
        this.role = role;
    }

}
