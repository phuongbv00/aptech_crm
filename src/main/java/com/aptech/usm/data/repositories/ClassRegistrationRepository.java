package com.aptech.usm.data.repositories;

import com.aptech.usm.data.domains.ClassRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRegistrationRepository extends JpaRepository<ClassRegistration, Long> {
    List<ClassRegistration> findByClassroomId(Long classroomId);
}
