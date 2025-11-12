package data.repositories;

import data.models.Ticket;

import java.util.Map;

public interface TicketRepository {
    Ticket save(Ticket ticket);
    Ticket findById(int id);
    Map<Integer,Ticket> findall();
    void delete(Ticket ticket);
    void deleteAll();
    void deleteById(int id);
    long count();
}
