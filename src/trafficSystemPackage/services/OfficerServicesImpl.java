package trafficSystemPackage.services;

import trafficSystemPackage.data.models.Officer;
import trafficSystemPackage.data.repositories.OfficerRepository;
import trafficSystemPackage.dtos.requests.OfficerRequest;
import trafficSystemPackage.dtos.responses.OfficerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficerServicesImpl implements OfficerServices {

    @Autowired
    private  OfficerRepository officers;

    public OfficerServicesImpl(OfficerRepository officers){
        this.officers = officers;}

    @Override
    public OfficerResponse registerOfficer(OfficerRequest request) {
        Officer officer = new Officer();
        officer.setName(request.getName());
        officer.setEmail(request.getEmail());

        Officer savedOfficer = officers.save(officer);
        OfficerResponse response = new OfficerResponse();
        response.setId(savedOfficer.getId());
        response.setOfficerEmail(savedOfficer.getEmail());
        response.setOfficerName(savedOfficer.getName());
        return response;
    }
}
