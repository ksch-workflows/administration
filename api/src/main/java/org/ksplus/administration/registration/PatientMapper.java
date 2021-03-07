package org.ksplus.administration.registration;

import org.ksplus.administration.registration.PatientController.PatientPayload;

class PatientMapper {

    static PatientDao toDao(PatientPayload request) {
        return PatientDao.builder()
                .name("John Doe")
                .patientCategory(request.getName())
                .build();
    }

    static PatientPayload toPayload(Patient patient) {
        var result = new PatientPayload();

        result.setId(patient.getId());

        if (patient.getName() != null) {
            result.setName(patient.getName().toString());
        }
        if (patient.getPhoneNumber() != null) {
            result.setPhoneNumber(patient.getPhoneNumber().toString());
        }



        return result;
    }
}
