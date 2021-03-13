package org.ksplus.administration.patient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
@Setter
class PatientModel extends RepresentationModel<PatientModel> implements Patient {

    @JsonProperty("_id")
    private UUID id;

    private String patientNumber;

    private String name;

    private Integer age;

    private Gender gender;

    private String phoneNumber;

    private String residentialAddress;

    private String patientCategory;
}
