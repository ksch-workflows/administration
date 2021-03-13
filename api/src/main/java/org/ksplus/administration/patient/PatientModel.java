package org.ksplus.administration.patient;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
class PatientModel extends RepresentationModel<PatientModel> implements Patient {

    private UUID id;

    private String patientNumber;

    private String name;

    private Integer age;

    private Gender gender;

    private String phoneNumber;

    private String residentialAddress;

    private String patientCategory;
}
