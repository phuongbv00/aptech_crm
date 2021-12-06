package com.aptech.usm.data.repositories;

import com.aptech.usm.data.domains.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
