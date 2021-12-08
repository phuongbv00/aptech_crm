package com.aptech.crm.data.repositories;

import com.aptech.crm.data.domains.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
