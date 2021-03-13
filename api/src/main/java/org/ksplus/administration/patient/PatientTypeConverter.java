package org.ksplus.administration.patient;

import org.ksplus.administration.util.TypeConverter;

public class PatientTypeConverter {

    public static <T extends Patient> T convertTo(Patient patient, Class<T> target) {
        return new TypeConverter<>(Patient.class).convertTo(patient, target);
    }
}
