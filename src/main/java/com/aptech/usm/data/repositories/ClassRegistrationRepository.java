package com.aptech.usm.data.repositories;

import com.aptech.usm.data.domains.ClassRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRegistrationRepository extends JpaRepository<ClassRegistration, Long> {
}
