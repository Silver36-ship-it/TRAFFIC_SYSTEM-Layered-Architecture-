package trafficSystemPackage.controllers;

import org.springframework.web.bind.annotation.*;
import trafficSystemPackage.dtos.requests.OfficerRequest;
import trafficSystemPackage.dtos.responses.OfficerResponse;

import org.springframework.beans.factory.annotation.Autowired;

import trafficSystemPackage.services.OfficerServices;

@RestController
@RequestMapping("/officer")
public class OfficerControllers {

    private OfficerServices officerServices;

    @Autowired
    public OfficerControllers(OfficerServices officerServices) {
        this.officerServices = officerServices;
    }

    @PostMapping("/register")
    public OfficerResponse registerOfficer(@RequestBody OfficerRequest officerRequest) {
        return officerServices.registerOfficer(officerRequest);
    }

}
