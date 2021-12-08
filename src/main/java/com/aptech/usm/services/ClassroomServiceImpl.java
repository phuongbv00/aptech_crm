package com.aptech.usm.services;

import com.aptech.usm.data.repositories.ClassroomRepository;
import com.aptech.usm.dto.classroom.ClassRegistrationDTO;
import com.aptech.usm.dto.classroom.ClassroomDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public List<ClassroomDTO> findAll() {
        return classroomRepository.findAllWithJoin();
    }

    @Override
    public List<ClassRegistrationDTO> findClassRegistrationsByStudentId(Long studentId) {
        return classroomRepository.findClassRegistrationsByStudentId(studentId);
    }
}
