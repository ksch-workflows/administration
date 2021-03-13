/*
 * Copyright 2021 KS-plus e.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ksplus.administration.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
class PatientPayload implements Patient {
    @JsonProperty("_id")
    private UUID id;
    private String patientNumber;
    private String name;
    private Integer age;
    private String gender;
    private String phoneNumber;
    private String residentialAddress;
    private String patientCategory;

    PatientPayload(Patient patient) {
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
