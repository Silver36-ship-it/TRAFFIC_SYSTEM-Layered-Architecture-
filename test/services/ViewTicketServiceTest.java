package services;

import data.models.Offence;
import data.models.Officer;
import data.models.Ticket;
import data.models.Vehicle;
import data.repositories.*;
import dtos.requests.ViewTicketRequest;
import dtos.requests.ViewTicketsByVehicleRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTicketServiceTest {

    private TicketRepository tickets;
    private VehicleRepository vehicles;
    private OfficerRepository officers;
    private TicketServicesImpl ticketServices;

    @BeforeEach
    public void setUp() {
        tickets = new Tickets();
        vehicles = new Vehicles();
        officers = new Officers();
        ticketServices = new TicketServicesImpl(tickets, vehicles, officers);

        Vehicle vehicle = new Vehicle();
        vehicle.setName("Toyota");
        vehicle.setModel("Corolla");
        vehicle.setColor("Red");
        vehicle.setPlateNumber("plateNumber");
        vehicles.save(vehicle);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setName("BMW");
        vehicle2.setModel("BMW");
        vehicle2.setColor("Blue");
        vehicle2.setPlateNumber("plateNumber2");
        vehicles.save(vehicle2);

        Officer officer = new Officer();
        officer.setName("Ford");
        officer.setEmail("ford@gmail.com");
        officer.setRank("Rank");
        officers.save(officer);

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setIssuer(officer);
        ticket.setOffence(Offence.OVER_SPEEDING);
        ticket.setDateOfBooking(LocalDateTime.now());
        tickets.save(ticket);

        Ticket ticket2 = new Ticket();
        ticket2.setVehicle(vehicle2);
        ticket2.setIssuer(officer);
        ticket2.setOffence(Offence.DRUNK_DRIVING);
        ticket2.setDateOfBooking(LocalDateTime.now());
        tickets.save(ticket2);

        Ticket ticket3 = new Ticket();
        ticket3.setVehicle(vehicle2);
        ticket3.setIssuer(officer);
        ticket3.setOffence(Offence.NO_SEAT_BELT);
        ticket3.setDateOfBooking(LocalDateTime.now());
        tickets.save(ticket3);

        Ticket ticket4 = new Ticket();
        ticket4.setVehicle(vehicle2);
        ticket4.setIssuer(officer);
        ticket4.setOffence(Offence.NO_SEAT_BELT);
        ticket4.setDateOfBooking(LocalDateTime.now());
        tickets.save(ticket4);
    }
    @Test
        void testThatViewTicketServiceWorks(){
        ViewTicketRequest request = new ViewTicketRequest();

        request.setTicketId(2);
        Ticket checkTicket = ticketServices.viewTicket(request);
        assertEquals(2, checkTicket.getId());

    }
    @Test
        void testThatViewTicketServiceCanCheckForCarName(){
        ViewTicketRequest request = new ViewTicketRequest();

        request.setTicketId(2);
        Ticket checkTicket = ticketServices.viewTicket(request);
        assertEquals(2, checkTicket.getId());
        assertEquals("BMW", checkTicket.getVehicle().getName());

    }
    @Test
        void testThatViewTicketServiceCanCheckForTheOffenceCommited(){
        ViewTicketRequest request = new ViewTicketRequest();

        request.setTicketId(2);
        Ticket checkTicket = ticketServices.viewTicket(request);
        assertEquals(2, checkTicket.getId());
        assertEquals("Drinking while driving is a higher sin than adultery", checkTicket.getOffence().getOffenceDescription());
    }
    @Test
        void testThatAllTicketsForAVehicleCanBeViewed(){
        ViewTicketsByVehicleRequest request = new ViewTicketsByVehicleRequest();

        request.setVehicleId(2);
        List<Ticket> checkTickets = ticketServices.viewAllTickets(request);
        assertEquals(3, checkTickets.size());
    }
}
