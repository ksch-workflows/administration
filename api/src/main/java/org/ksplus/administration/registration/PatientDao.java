package org.ksplus.administration.registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
