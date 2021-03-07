package org.ksplus.administration.registration;

import java.util.UUID;

public interface Patient {
    UUID getId();
    Object getPatientNumber();
    Object getName();
    Object getAge();
    Object getGender();
    Object getPhoneNumber();
    Object getResidentialAddress();
    Object getPatientCategory();
}
