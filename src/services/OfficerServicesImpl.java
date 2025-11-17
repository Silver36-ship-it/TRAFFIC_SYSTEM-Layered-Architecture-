package services;

import data.models.Officer;
import data.repositories.OfficerRepository;
import dtos.requests.OfficerRequest;
import dtos.responses.OfficerResponse;

public class OfficerServicesImpl implements OfficerServices {
    private final OfficerRepository officers;

    public OfficerServicesImpl(OfficerRepository officers){
        this.officers = officers;
    }

    @Override
    public OfficerResponse registerOfficer(OfficerRequest request) {
        Officer officer = new Officer();
        officer.setName(request.getName());
        officer.setEmail(request.getEmail());
        officers.save(officer);
        return new OfficerResponse();
    }
}
