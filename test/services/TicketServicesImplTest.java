package services;

import data.models.Offence;
import data.models.Officer;
import data.models.Ticket;
import data.models.Vehicle;
import data.repositories.*;
import dtos.requests.IssueTicketRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketServicesImplTest {
    private TicketServices ticketServices;
    private VehicleRepository vehicles;
    private TicketRepository tickets;
    private OfficerRepository officers;

    @BeforeEach
    void setUp() {
        vehicles = new Vehicles();
        tickets = new Tickets();
        officers = new Officers();
        ticketServices = new TicketServicesImpl(tickets, vehicles, officers);

        Vehicle vehicle = new Vehicle();
        vehicle.setName("Toyota");
        vehicle.setModel("Corolla");
        vehicle.setPlateNumber("plateNumber");
        vehicle.setColor("Black");
        vehicles.save(vehicle);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setName("Honda");
        vehicle2.setModel("Corolla");
        vehicle2.setPlateNumber("plateNumber2");
        vehicle2.setColor("Blue");
        vehicles.save(vehicle2);

        Officer officer = new Officer();
        officer.setName("Ford");
        officer.setEmail("ford@gmail.com");
        officer.setRank("rank");
        officers.save(officer);
    }
    @Test
        void testThatTicketsCanCountWhenIssued() {
        IssueTicketRequest  request = new IssueTicketRequest();
        request.setVehicleId(1);
        request.setVehicleColor("Black");
        request.setVehicleName("Toyota");
        request.setOfficerEmail("ford@gmail.com");
        request.setOfficerRank("rank");
        request.setOfficerName("Ford");
        request.setOffence(Offence.OVER_SPEEDING);

        ticketServices.issueTicket(request);
        assertEquals(1, tickets.count());
        }

    @Test
        void testThatTicketsCanSeeTheOfficerNameWhenIssued() {
        IssueTicketRequest  request = new IssueTicketRequest();
        request.setVehicleId(1);
        request.setVehicleColor("Black");
        request.setVehicleName("Toyota");
        request.setOfficerEmail("ford@gmail.com");
        request.setOfficerRank("rank");
        request.setOfficerName("Ford");
        request.setOffence(Offence.OVER_SPEEDING);

        ticketServices.issueTicket(request);
        assertEquals(1, tickets.count());

        Ticket ticketIssued = tickets.findById(1);
        assertEquals("Ford", ticketIssued.getIssuer().getName());
    }
    @Test
        void testThatTicketCanSeeTheVehicleNameWhenIssued() {
        IssueTicketRequest  request = new IssueTicketRequest();
        request.setVehicleId(1);
        request.setVehicleName("Toyota");
        request.setOfficerEmail("ford@gmail.com");
        request.setOfficerRank("rank");
        request.setOfficerName("Ford");
        request.setOffence(Offence.OVER_SPEEDING);

        IssueTicketRequest  request1 = new IssueTicketRequest();
        request1.setVehicleId(2);
        request1.setOfficerEmail("ford1@gmail.com");
        request1.setOfficerRank("rank");
        request1.setOfficerName("Ford1");
        request1.setOffence(Offence.OVER_SPEEDING);

        ticketServices.issueTicket(request);
        ticketServices.issueTicket(request1);
        assertEquals(2, tickets.count());

        Ticket ticketIssued = tickets.findById(1);
        assertEquals("Toyota", ticketIssued.getVehicle().getName());
        }

}