package org.ksplus.administration.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.ksplus.administration.registration.PatientMapper.toDao;

@RestController
@RequiredArgsConstructor
class PatientController {

    private final PatientRepository patientRepository;

    @PostMapping("/patients")
    Patient createPatient(PatientRequest request) {
        return patientRepository.save(toDao(request));
    }

    @AllArgsConstructor
    @Getter
    class PatientRequest implements Patient {
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
