package com.aptech.usm.data.repositories;

import com.aptech.usm.data.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
