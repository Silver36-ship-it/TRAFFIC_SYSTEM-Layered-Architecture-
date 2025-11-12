package services;

import dtos.requests.TicketRequest;
import dtos.responses.TicketResponse;

public interface TicketServices {
    TicketResponse registerTicket(TicketRequest request);
}
