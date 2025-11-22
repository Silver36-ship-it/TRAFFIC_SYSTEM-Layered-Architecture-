package trafficSystemPackage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import trafficSystemPackage.services.TicketServices;
import trafficSystemPackage.dtos.requests.IssueTicketRequest;
import trafficSystemPackage.dtos.requests.SettleTicketRequest;
import trafficSystemPackage.dtos.requests.ViewTicketRequest;
import trafficSystemPackage.dtos.requests.ViewTicketsByVehicleRequest;
import trafficSystemPackage.dtos.responses.IssueTicketResponse;
import trafficSystemPackage.dtos.responses.SettleTicketResponse;
import trafficSystemPackage.dtos.responses.ViewTicketResponse;
import trafficSystemPackage.dtos.responses.ViewTicketsByVehicleResponse;

@RestController
@RequestMapping("/ticket")
public class TicketControllers {

    private TicketServices ticketServices;

    @Autowired
    public TicketControllers(TicketServices ticketServices) {
        this.ticketServices = ticketServices;
    }
    @PostMapping("/issue")
    public IssueTicketResponse issueTicket(@RequestBody IssueTicketRequest request) {
        return ticketServices.issueTicket(request);
    }
    @GetMapping("/view/{ticketId}")
    public ViewTicketResponse viewTicket(@PathVariable("ticketId") String ticketId) {
        ViewTicketRequest viewRequest = new ViewTicketRequest();
        viewRequest.setTicketId(ticketId);
        return ticketServices.viewTicket(viewRequest);
    }
    @GetMapping("/viewAll/{vehicleId}")
    public ViewTicketsByVehicleResponse viewTicketsByVehicle(@PathVariable("vehicleId") String vehicleId) {
        ViewTicketsByVehicleRequest viewRequest = new ViewTicketsByVehicleRequest();
        viewRequest.setVehicleId(vehicleId);
        return ticketServices.viewAllTickets(viewRequest);
    }
    @PostMapping("/settle")
    public SettleTicketResponse settleTicket(@RequestBody SettleTicketRequest request) {
        return ticketServices.settleTicket(request);
    }
}
