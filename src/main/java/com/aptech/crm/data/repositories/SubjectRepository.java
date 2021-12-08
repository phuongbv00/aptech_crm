package com.aptech.crm.data.repositories;

import com.aptech.crm.data.domains.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
