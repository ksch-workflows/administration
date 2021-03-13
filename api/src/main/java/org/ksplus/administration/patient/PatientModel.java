package org.ksplus.administration.patient;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@RequiredArgsConstructor
class PatientModel extends RepresentationModel<PatientModel> {

    @JsonUnwrapped
    private final Patient patient;
}
