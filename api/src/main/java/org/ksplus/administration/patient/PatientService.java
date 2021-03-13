package org.ksplus.administration.patient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient createPatient() {
        return patientRepository.save(new PatientDao());
    }
}
