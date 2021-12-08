package com.aptech.crm.data.repositories;

import com.aptech.crm.data.domains.ClassRegistration;
import com.aptech.crm.utils.enums.ClassRegistrationStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClassRegistrationRepository extends JpaRepository<ClassRegistration, Long> {
    List<ClassRegistration> findByClassroomId(Long classroomId);

    Optional<ClassRegistration> findByClassroomIdAndStudentIdAndStatus(Long classroomId, Long studentId, ClassRegistrationStatusEnum status);
}
