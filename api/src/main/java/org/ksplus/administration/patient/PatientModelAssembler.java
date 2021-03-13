package org.ksplus.administration.patient;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
class PatientModelAssembler implements RepresentationModelAssembler<Patient, PatientModel> {

    @Override
    public PatientModel toModel(Patient patient) {
        var result = PatientTypeConverter.convertTo(patient, PatientModel.class);


        var selfLink = linkTo(PatientController.class).slash(patient.getId()).withSelfRel();
        result.add(selfLink);
        return result;
    }
}
