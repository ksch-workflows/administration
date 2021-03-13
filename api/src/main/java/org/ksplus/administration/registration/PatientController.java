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

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequiredArgsConstructor
class PatientController {

    private final PatientRepository patientRepository;

    @PostMapping("/patients")
    EntityModel<PatientPayload> createPatient(@RequestBody PatientPayload request) {
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
