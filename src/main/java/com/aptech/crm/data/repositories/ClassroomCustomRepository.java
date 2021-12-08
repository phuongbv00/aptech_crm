package com.aptech.crm.data.repositories;

import com.aptech.crm.dto.classroom.ClassRegistrationDTO;
import com.aptech.crm.dto.classroom.ClassroomDTO;

import java.util.List;

public interface ClassroomCustomRepository {
    List<ClassroomDTO> findAllWithJoin();

    List<ClassRegistrationDTO> findClassRegistrationsByStudentId(Long studentId);
}
