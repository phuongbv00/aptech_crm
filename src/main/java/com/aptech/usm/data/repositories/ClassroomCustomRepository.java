package com.aptech.usm.data.repositories;

import com.aptech.usm.dto.classroom.ClassRegistrationDTO;
import com.aptech.usm.dto.classroom.ClassroomDTO;

import java.util.List;

public interface ClassroomCustomRepository {
    List<ClassroomDTO> findAllWithJoin();

    List<ClassRegistrationDTO> findClassRegistrationsByStudentId(Long studentId);
}
