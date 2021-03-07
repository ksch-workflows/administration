package org.ksplus.administration.registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
class PatientDao implements Patient {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(unique = true)
    private UUID id;

    private String patientNumber;

    private String name;

    private Integer age;

    private String gender;

    private String phoneNumber;

    private String residentialAddress;

    private String patientCategory;

    PatientDao(Patient patient) {
        id = patient.getId();

        if (patient.getPatientNumber() != null) {
            setPatientNumber(patient.getPatientNumber().toString());
        }
        if (patient.getName() != null) {
            setName(patient.getName().toString());
        }
        if (patient.getAge() != null) {
            setAge((Integer) patient.getAge());
        }
        if (patient.getGender() != null) {
            setGender(patient.getGender().toString());
        }
        if (patient.getPhoneNumber() != null) {
            setPhoneNumber(patient.getPhoneNumber().toString());
        }
        if (patient.getResidentialAddress() != null) {
            setResidentialAddress(patient.getResidentialAddress().toString());
        }
        if (patient.getPatientCategory() != null) {
            setPatientCategory(patient.getPatientCategory().toString());
        }
    }
}
