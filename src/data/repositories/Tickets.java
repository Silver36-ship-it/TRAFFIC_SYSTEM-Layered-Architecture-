package data.repositories;

import data.models.Ticket;
import exceptions.TicketsNotFoundException;
import exceptions.VehicleNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tickets implements TicketRepository{
    Map<Integer, Ticket> tickets = new HashMap<>();
    int nextId = 1;

    @Override
    public Ticket save(Ticket ticket) {
        if(ticket.getId() == 0){
            ticket.setId(nextId++);
        }
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    @Override
    public Ticket findById(int id) {
        Ticket ticket = tickets.get(id);
        if(ticket == null){
            throw new TicketsNotFoundException("Ticket not found");
        }
        return ticket;
    }

    @Override
    public Map<Integer, Ticket> findall() {
        return tickets;
    }

    @Override
    public void delete(Ticket ticket) {
        if(!tickets.containsKey(ticket.getId())) {
            throw new VehicleNotFoundException("Vehicle not found");
        }
        tickets.remove(ticket.getId());

    }

    @Override
    public void deleteAll() {
        tickets.clear();

    }

    @Override
    public void deleteById(int id) {
        tickets.remove(id);

    }

    @Override
    public long count() {
        return tickets.size();
    }
    public List<Ticket> findByVehicleId(int vehicleId){
        List<Ticket> ticketList = new ArrayList<>();

        for(Ticket ticket : tickets.values()){
            if(ticket.getVehicle() != null && ticket.getVehicle().getId() == vehicleId){
                ticketList.add(ticket);
            }
        }
        return ticketList;

    }
}
