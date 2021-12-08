package com.aptech.usm.services;

import com.aptech.usm.data.domains.ClassRegistration;
import com.aptech.usm.data.domains.Student;
import com.aptech.usm.data.repositories.ClassRegistrationRepository;
import com.aptech.usm.data.repositories.ClassroomRepository;
import com.aptech.usm.data.repositories.StudentRepository;
import com.aptech.usm.dto.classroom.ClassRegistrationDTO;
import com.aptech.usm.dto.classroom.ClassroomDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomRepository classroomRepository;
    private final StudentRepository studentRepository;
    private final ClassRegistrationRepository classRegistrationRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository,
                                StudentRepository studentRepository,
                                ClassRegistrationRepository classRegistrationRepository) {
        this.classroomRepository = classroomRepository;
        this.studentRepository = studentRepository;
        this.classRegistrationRepository = classRegistrationRepository;
    }

    @Override
    public List<ClassroomDTO> findAll() {
        return classroomRepository.findAllWithJoin();
    }

    @Override
    public List<ClassRegistrationDTO> findClassRegistrationsByStudentId(Long studentId) {
        return classroomRepository.findClassRegistrationsByStudentId(studentId);
    }

    @Override
    public List<Student> findStudentsByClassId(Long classId) {
        var stdIds = classRegistrationRepository.findByClassroomId(classId)
                .stream()
                .map(ClassRegistration::getStudentId)
                .collect(Collectors.toList());
        return studentRepository.findByIdIn(stdIds);
    }
}
