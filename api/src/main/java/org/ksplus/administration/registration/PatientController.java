package org.ksplus.administration.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.ksplus.administration.registration.PatientMapper.toDao;
import static org.ksplus.administration.registration.PatientMapper.toPayload;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequiredArgsConstructor
class PatientController {

    private final PatientRepository patientRepository;

    @PostMapping("/patients")
    EntityModel<PatientPayload> createPatient(PatientPayload request) {
        var patientDao = patientRepository.save(toDao(request));
        return toResourceRepresentationModel(toPayload(patientDao));
    }

    private EntityModel<PatientPayload> toResourceRepresentationModel(PatientPayload patient) {
        var result = EntityModel.of(patient);
        var selfLink = linkTo(PatientController.class).slash(patient.getId()).withSelfRel();
        result.add(selfLink);
        return result;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    @NoArgsConstructor
    static class PatientPayload implements Patient {
        @JsonProperty("_id")
        private UUID id;
        private String patientNumber;
        private String name;
        private Integer age;
        private String gender;
        private String phoneNumber;
        private String residentialAddress;
        private String patientCategory;
    }
}
