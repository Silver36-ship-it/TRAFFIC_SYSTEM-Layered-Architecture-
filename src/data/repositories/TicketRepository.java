package data.repositories;

import data.models.Ticket;

import java.util.List;
import java.util.Map;

public interface TicketRepository {
    Ticket save(Ticket ticket);
    Ticket findById(int id);
    Map<Integer,Ticket> findall();
    void delete(Ticket ticket);
    void deleteAll();
    void deleteById(int id);
    long count();
    List<Ticket> findByVehicleId(int vehicledId);
}
