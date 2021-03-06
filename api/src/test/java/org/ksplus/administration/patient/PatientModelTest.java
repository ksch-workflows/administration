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
package org.ksplus.administration.patient;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.ksplus.administration.patient.Gender.MALE;
import static org.ksplus.administration.util.ObjectVerifier.verifyAllFieldsAreSet;

class PatientModelTest {

    @Test
    public void should_create_shallow_copy() {
        val originalPatientModel = PatientModel.builder()
                .id(UUID.randomUUID())
                .gender(MALE)
                .age(27)
                .name("John Doe")
                .patientCategory("GENERAL")
                .patientNumber("10-1000")
                .phoneNumber("0123456789")
                .residentialAddress("Guesthouse")
                .build();
        verifyAllFieldsAreSet(originalPatientModel);

        var convertedPatientModel = PatientModel.from(originalPatientModel);

        assertEquals(originalPatientModel, convertedPatientModel);
    }
}

