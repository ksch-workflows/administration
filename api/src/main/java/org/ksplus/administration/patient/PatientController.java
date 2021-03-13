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

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
class PatientController {

    private final PatientRepository patientRepository;

    private final PagedResourcesAssembler<Patient> pagedResourcesAssembler;

    private final PatientModelAssembler patientModelAssembler;

    @PostMapping
    PatientModel createPatient(@RequestBody Optional<PatientPayload> request) {
        // TODO Use service method to create patient
        var patientDao = patientRepository.save(PatientDao.from(request.orElse(new PatientPayload())));
        return patientModelAssembler.toModel(patientDao);
    }

    @GetMapping
    PagedModel<PatientModel> getPatients(Pageable pageable) {
        var patients = patientRepository.findAll(pageable).map(p -> (Patient) p);
        return pagedResourcesAssembler.toModel(patients, patientModelAssembler);
    }
}
