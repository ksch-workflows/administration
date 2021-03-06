package org.ksplus.administration.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonPropertyOrder({"_id"})
public interface Patient {
    @JsonProperty("_id")
    UUID getId();
    Object getPatientNumber();
    Object getName();
    Object getAge();
    Object getGender();
    Object getPhoneNumber();
    Object getResidentialAddress();
    Object getPatientCategory();
}
