/* package services;


import data.models.Offence;
import data.models.Officer;
import data.models.Ticket;
import data.models.Vehicle;
import data.repositories.*;
import dtos.requests.IssueTicketRequest;
import dtos.responses.SettleTicketResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SettleTicketsTest {

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

    }

    @Test
        void testThatTicketCanBeSettled(){
        IssueTicketRequest request = new IssueTicketRequest();
        request.setVehicleId(1);
        request.setOfficerEmail("ford@gmail.com");
        request.setOffence(Offence.OVER_SPEEDING);
        ticketServices.issueTicket(request);
        SettleTicketResponse settled = ticketServices.settleTicket();

        assertTrue(settled.getHasPaid().equals("has paid"));
    }
} */
