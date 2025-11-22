package trafficSystemPackage.services;

import trafficSystemPackage.dtos.requests.OfficerRequest;
import trafficSystemPackage.dtos.responses.OfficerResponse;

public interface OfficerServices  {
    OfficerResponse registerOfficer(OfficerRequest officerRequest);
}
