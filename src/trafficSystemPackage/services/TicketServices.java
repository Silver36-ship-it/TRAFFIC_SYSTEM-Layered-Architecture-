package trafficSystemPackage.services;

import trafficSystemPackage.dtos.requests.IssueTicketRequest;
import trafficSystemPackage.dtos.requests.SettleTicketRequest;
import trafficSystemPackage.dtos.requests.ViewTicketRequest;
import trafficSystemPackage.dtos.requests.ViewTicketsByVehicleRequest;
import trafficSystemPackage.dtos.responses.IssueTicketResponse;
import trafficSystemPackage.dtos.responses.SettleTicketResponse;
import trafficSystemPackage.dtos.responses.ViewTicketResponse;
import trafficSystemPackage.dtos.responses.ViewTicketsByVehicleResponse;

public interface TicketServices {
    IssueTicketResponse issueTicket(IssueTicketRequest request);

    ViewTicketResponse viewTicket(ViewTicketRequest request);

    ViewTicketsByVehicleResponse viewAllTickets(ViewTicketsByVehicleRequest request);

    SettleTicketResponse settleTicket(SettleTicketRequest request);
}
