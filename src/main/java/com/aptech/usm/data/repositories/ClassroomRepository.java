package com.aptech.usm.data.repositories;

import com.aptech.usm.data.domains.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long>, ClassroomCustomRepository {
}
