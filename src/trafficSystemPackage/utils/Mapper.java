package trafficSystemPackage.utils;

import trafficSystemPackage.data.models.Owner;
import trafficSystemPackage.data.models.Ticket;
import trafficSystemPackage.data.models.Vehicle;
import trafficSystemPackage.dtos.requests.VehicleRequest;
import trafficSystemPackage.dtos.responses.ViewTicketResponse;

public class Mapper {
    public static Vehicle map(VehicleRequest request){
        Vehicle vehicle = new Vehicle();

        vehicle.setName(request.getVehicleName());
        vehicle.setYear(request.getProductionYear());
        vehicle.setColor(request.getVehicleColor());
        vehicle.setModel(request.getVehicleModel());
        vehicle.setChasisNumber(request.getChasisNumber());

        Owner owner = new Owner();
        owner.setFullName(request.getOwnerFullName());
        owner.setEmail(request.getOwnerEmail());

        vehicle.setOwner(owner);
        return vehicle;

    }
    public static ViewTicketResponse mapToViewTicket(Ticket response){
        ViewTicketResponse viewTicketResponse = new ViewTicketResponse();
        viewTicketResponse.setTicketId(response.getId());
        viewTicketResponse.setAmountPaid(response.getOffence().getFineAmount());
        viewTicketResponse.setOfficerName(response.getIssuer().getName());
        viewTicketResponse.setVehicle(response.getVehicle().getName() + " " + response.getVehicle().getModel() + " " + response.getVehicle().getYear());
        viewTicketResponse.setOffence(response.getOffence().getOffenceDescription());
        viewTicketResponse.setHasPaid(response.isSettled()?"has paid": "has not paid");
        return viewTicketResponse;


    }

}
