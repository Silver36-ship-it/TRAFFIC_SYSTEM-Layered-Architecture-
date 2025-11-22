package trafficSystemPackage.services;

import trafficSystemPackage.data.models.Officer;
import trafficSystemPackage.data.models.Ticket;
import trafficSystemPackage.data.models.Vehicle;
import trafficSystemPackage.data.repositories.OfficerRepository;
import trafficSystemPackage.data.repositories.TicketRepository;
import trafficSystemPackage.data.repositories.VehicleRepository;
import trafficSystemPackage.dtos.requests.IssueTicketRequest;
import trafficSystemPackage.dtos.requests.SettleTicketRequest;
import trafficSystemPackage.dtos.requests.ViewTicketRequest;
import trafficSystemPackage.dtos.requests.ViewTicketsByVehicleRequest;
import trafficSystemPackage.dtos.responses.IssueTicketResponse;
import trafficSystemPackage.dtos.responses.SettleTicketResponse;
import trafficSystemPackage.dtos.responses.ViewTicketResponse;
import trafficSystemPackage.dtos.responses.ViewTicketsByVehicleResponse;
import trafficSystemPackage.exceptions.OfficerNotFoundException;
import trafficSystemPackage.exceptions.TicketsNotFoundException;
import trafficSystemPackage.exceptions.VehicleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static trafficSystemPackage.utils.Mapper.mapToViewTicket;


@Service
public class TicketServicesImpl implements TicketServices {
    @Autowired
    private TicketRepository tickets;
    @Autowired
    private VehicleRepository vehicles;
    @Autowired
    private OfficerRepository officers;

    public TicketServicesImpl(TicketRepository tickets, VehicleRepository vehicles, OfficerRepository officers) {
        this.tickets = tickets;
        this.vehicles = vehicles;
        this.officers = officers;
    }
    public TicketServicesImpl(){
    }
    @Override
    public IssueTicketResponse issueTicket(IssueTicketRequest request) {
        Optional<Officer> officer = officers.findByEmail(request.getOfficerEmail());
        if(!officer.isPresent()){
            throw new OfficerNotFoundException("Officer not found");
        }
        Optional<Vehicle> vehicle = vehicles.findById(request.getVehicleId());
        if(!vehicle.isPresent()){
            throw new VehicleNotFoundException("Vehicle not found");
        }
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle.get());
        ticket.setOffence(request.getOffence());
        ticket.setIssuer(officer.get());
        ticket.setDateOfBooking(LocalDateTime.now());

        Ticket savedTicket = tickets.save(ticket);
        IssueTicketResponse response = new IssueTicketResponse();
        response.setId(savedTicket.getId());
        response.setAmount(savedTicket.getOffence().getFineAmount());
        response.setIssuer(savedTicket.getIssuer().getName());
        response.setVehicle(savedTicket.getVehicle().getName() + " " + savedTicket.getVehicle().getModel() + " " + savedTicket.getVehicle().getYear());
        response.setOffence(savedTicket.getOffence().getOffenceDescription());
        response.setIssueDate(savedTicket.getDateOfBooking());
        return response;
    }

    @Override
    public ViewTicketResponse viewTicket(ViewTicketRequest request) {
        if(request == null) {
            throw new NullPointerException("Request is null");
        }
        Optional<Ticket> foundTicket = tickets.findById(request.getTicketId());
       if(!foundTicket.isPresent()) {
           throw new TicketsNotFoundException("Ticket not found");
       }
        return mapToViewTicket(foundTicket.get());
    }

    @Override
    public ViewTicketsByVehicleResponse viewAllTickets(ViewTicketsByVehicleRequest request) {
        if(request == null){
            throw new NullPointerException("Request is null");
        }
        List<Ticket> allTickets = tickets.findByVehicleId(request.getVehicleId());
        ViewTicketsByVehicleResponse response = new ViewTicketsByVehicleResponse();
        response.setVehicleId(request.getVehicleId());
        response.setTickets(allTickets);
        return response;

    }

    @Override
    public SettleTicketResponse settleTicket(SettleTicketRequest request) {
        Optional<Ticket> ticket = tickets.findById(request.getTicketId());
        if(!ticket.isPresent()) {
            throw new TicketsNotFoundException("Ticket not found");
        }
        ticket.get().setSettled(true);
        Ticket ticketSaved = tickets.save(ticket.get());
        SettleTicketResponse response = new SettleTicketResponse();
        response.setTicketId(ticketSaved.getId());
        response.setVehicle(ticketSaved.getVehicle().getName()  + " " + ticketSaved.getVehicle().getModel() + " " + ticketSaved.getVehicle().getYear());
        response.setAmountPaid(ticketSaved.getOffence().getFineAmount());
        response.setOfficer(ticketSaved.getIssuer().getName());
        response.setDateSettled(ticketSaved.getDateOfBooking());
        response.setHasPaid(ticketSaved.isSettled() ?"has paid": "has not paid");
        return response;
    }

}
