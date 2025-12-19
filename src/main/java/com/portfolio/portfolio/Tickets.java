package com.portfolio.portfolio;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Tickets {
    private Long ticket_id;
    private String user;
    private String subject;
    private String message;
    private String contact;

    @DynamoDbPartitionKey
    public Long getTicket_id() {
        return ticket_id;
    }
    public void setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
}
