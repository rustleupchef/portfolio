package com.portfolio.portfolio;

import org.springframework.stereotype.Repository;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class TicketsRepository {
    private final DynamoDbTable<Tickets> tickets;

    public TicketsRepository(DynamoDbEnhancedClient enhancedClient) {
        this.tickets = enhancedClient.table("Tickets", TableSchema.fromBean(Tickets.class));
    }

    public void saveTicket(Tickets ticket) {
        tickets.putItem(ticket);
    }

    public Tickets getTicketById(Long id) {
        return tickets.getItem(Key.builder().partitionValue(id).build());
    }

    public void deleteTicketById(Long id) {
        tickets.deleteItem(Key.builder().partitionValue(id).build());
    }

    public void updateTicket(Tickets ticket) {
        tickets.updateItem(ticket);
    }

    public Iterable<Tickets> getAllTickets() {
        return tickets.scan().items();
    }
}
