package services;

import dtos.requests.OfficerRequest;
import dtos.responses.OfficerResponse;

public interface OfficerServices  {
    OfficerResponse registerOfficer(OfficerRequest officerRequest);
}
