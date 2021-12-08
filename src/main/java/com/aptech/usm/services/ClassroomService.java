package com.aptech.usm.services;

import com.aptech.usm.data.domains.Student;
import com.aptech.usm.dto.classroom.ClassRegistrationDTO;
import com.aptech.usm.dto.classroom.ClassroomDTO;

import java.util.List;

public interface ClassroomService {
    List<ClassroomDTO> findAll();

    List<ClassRegistrationDTO> findClassRegistrationsByStudentId(Long studentId);

    List<Student> findStudentsByClassId(Long classId);
}
