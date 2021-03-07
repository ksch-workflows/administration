package org.ksplus.administration.registration;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequiredArgsConstructor
class PatientController {

    private final PatientRepository patientRepository;

    @PostMapping("/patients")
    EntityModel<PatientPayload> createPatient(PatientPayload request) {
        var patientDao = patientRepository.save(new PatientDao(request));
        return toResourceRepresentationModel(new PatientPayload(patientDao));
    }

    private EntityModel<PatientPayload> toResourceRepresentationModel(PatientPayload patient) {
        var result = EntityModel.of(patient);
        var selfLink = linkTo(PatientController.class).slash(patient.getId()).withSelfRel();
        result.add(selfLink);
        return result;
    }


}
