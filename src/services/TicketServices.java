package services;

import data.models.Ticket;
import dtos.requests.IssueTicketRequest;
import dtos.requests.ViewTicketRequest;
import dtos.requests.ViewTicketsByVehicleRequest;
import dtos.responses.IssueTicketResponse;

import java.util.List;

public interface TicketServices {
    IssueTicketResponse issueTicket(IssueTicketRequest request);

    Ticket viewTicket(ViewTicketRequest request);

    List<Ticket> viewAllTickets(ViewTicketsByVehicleRequest request);

    Ticket settleTicket(int ticketId);
}
