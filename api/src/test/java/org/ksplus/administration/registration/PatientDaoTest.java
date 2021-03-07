package org.ksplus.administration.registration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatientDaoTest {

    @Test
    public void should_provide_copy_constructor() {
        var originalPatientDao = PatientDao.builder()
                .id(UUID.randomUUID())
                .name("John Doe")
                .patientCategory("GENERAL")
                .age(21)
                .phoneNumber("1234567890")
                .residentialAddress("Guest house")
                .patientNumber("2021-3247889")
                .gender("MALE")
                .build();
        verifyAllFieldsAreSet(originalPatientDao);

        var convertedPatientDao = new PatientDao(originalPatientDao);

        assertEquals(originalPatientDao, convertedPatientDao);
    }

    @SneakyThrows
    private void verifyAllFieldsAreSet(Object object) {
        var objectMapper = new ObjectMapper();
        var json = objectMapper.writeValueAsString(object);
        if (json.contains("null")) {
            var message = "The provided object contains one or more fields which are not initialized: " + json;
            throw new AssertionFailedError(message);
        }
    }

}