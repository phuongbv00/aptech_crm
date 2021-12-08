package com.aptech.crm.services;

import com.aptech.crm.data.domains.Student;
import com.aptech.crm.dto.classroom.ClassRegistrationDTO;
import com.aptech.crm.dto.classroom.ClassroomDTO;

import java.util.List;

public interface ClassroomService {
    List<ClassroomDTO> findAll();

    List<ClassRegistrationDTO> findClassRegistrationsByStudentId(Long studentId);

    List<Student> findStudentsByClassId(Long classId);

    boolean apply(Long studentId, Long classId);

    boolean leave(Long studentId, Long classId);
}
