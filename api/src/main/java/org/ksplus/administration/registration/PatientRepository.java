package org.ksplus.administration.registration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface PatientRepository extends JpaRepository<PatientDao, UUID> {
}
