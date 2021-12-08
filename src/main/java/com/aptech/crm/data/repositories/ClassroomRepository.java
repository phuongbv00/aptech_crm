package com.aptech.crm.data.repositories;

import com.aptech.crm.data.domains.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long>, ClassroomCustomRepository {
}
