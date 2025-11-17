package services;

import data.models.Officer;
import data.models.Ticket;
import data.models.Vehicle;
import data.repositories.OfficerRepository;
import data.repositories.TicketRepository;
import data.repositories.VehicleRepository;
import dtos.requests.IssueTicketRequest;
import dtos.requests.ViewTicketRequest;
import dtos.requests.ViewTicketsByVehicleRequest;
import dtos.responses.IssueTicketResponse;

import java.time.LocalDateTime;
import java.util.List;

public class TicketServicesImpl implements TicketServices {
    private final TicketRepository tickets;
    private final VehicleRepository vehicles;
    private final OfficerRepository officers;

    public TicketServicesImpl(TicketRepository tickets, VehicleRepository vehicles, OfficerRepository officers) {
        this.tickets = tickets;
        this.vehicles = vehicles;
        this.officers = officers;
    }

    @Override
    public IssueTicketResponse issueTicket(IssueTicketRequest request) {
        Officer officer = officers.findByEmail(request.getOfficerEmail());
        Vehicle vehicle = vehicles.findById(request.getVehicleId());

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setOffence(request.getOffence());
        ticket.setIssuer(officer);
        ticket.setDateOfBooking(LocalDateTime.now());
        tickets.save(ticket);
        return new IssueTicketResponse();

    }

    @Override
    public Ticket viewTicket(ViewTicketRequest request) {
        if(request == null) {
            throw new NullPointerException("Request is null");
        }
        return tickets.findById(request.getTicketId());
    }

    @Override
    public List<Ticket> viewAllTickets(ViewTicketsByVehicleRequest request) {
        if(request == null){
            throw new NullPointerException("Request is null");
        }
        return tickets.findByVehicleId(request.getVehicleId());
    }

    @Override
    public Ticket settleTicket(int ticketId) {
        Ticket ticket = tickets.findById(ticketId);
        ticket.setSettled(true);
        tickets.save(ticket);
        return ticket;
    }
}
