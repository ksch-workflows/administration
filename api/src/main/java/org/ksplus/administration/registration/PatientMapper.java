package org.ksplus.administration.registration;

import org.ksplus.administration.registration.PatientController.PatientRequest;

class PatientMapper {

    static PatientDao toDao(PatientRequest request) {
        return PatientDao.builder()
                .name("John Doe")
                .patientCategory(request.getName())
                .build();
    }
}
