package org.ksplus.administration.registration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatientPayloadTest {

    @Test
    public void should_provide_mapping_constructor() {
        var originalPayload = PatientPayload.builder()
                .id(UUID.randomUUID())
                .age(21)
                .gender("MALE")
                .name("John Doe")
                .patientCategory("GENERAL")
                .patientNumber("2021-2343243")
                .phoneNumber("0123456789")
                .residentialAddress("Guesthouse")
                .build();
        verifyAllFieldsAreSet(originalPayload);

        var convertedPayload = new PatientPayload(originalPayload);

        assertEquals(originalPayload, convertedPayload);
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
