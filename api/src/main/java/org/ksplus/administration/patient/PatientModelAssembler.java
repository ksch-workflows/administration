package org.ksplus.administration.patient;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class PatientModelAssembler implements RepresentationModelAssembler<Patient, PatientModel> {

    @Override
    public PatientModel toModel(Patient patient) {
        return new PatientModel(patient);
    }
}
