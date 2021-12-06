package com.aptech.usm.data.repositories;

import com.aptech.usm.data.domains.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
