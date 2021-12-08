package com.aptech.crm.services;

import com.aptech.crm.data.domains.ClassRegistration;
import com.aptech.crm.data.domains.Student;
import com.aptech.crm.data.repositories.ClassRegistrationRepository;
import com.aptech.crm.data.repositories.ClassroomRepository;
import com.aptech.crm.data.repositories.StudentRepository;
import com.aptech.crm.dto.classroom.ClassRegistrationDTO;
import com.aptech.crm.dto.classroom.ClassroomDTO;
import com.aptech.crm.utils.enums.ClassRegistrationStatusEnum;
import org.springframework.stereotype.Service;

import java.time.Instant;
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
                .distinct()
                .collect(Collectors.toList());
        return studentRepository.findByIdIn(stdIds);
    }

    @Override
    public boolean apply(Long studentId, Long classId) {
        return classRegistrationRepository
                .findByClassroomIdAndStudentIdAndStatus(classId, studentId, ClassRegistrationStatusEnum.ACTIVE)
                .map(r -> false)
                .orElseGet(() -> {
                    classRegistrationRepository.save(ClassRegistration.builder()
                            .classroomId(classId)
                            .studentId(studentId)
                            .registrationTime(Instant.now())
                            .build());
                    return true;
                });
    }

    @Override
    public boolean leave(Long studentId, Long classId) {
        return classRegistrationRepository
                .findByClassroomIdAndStudentIdAndStatus(classId, studentId, ClassRegistrationStatusEnum.ACTIVE)
                .map(r -> {
                    r.setStatus(ClassRegistrationStatusEnum.INACTIVE);
                    classRegistrationRepository.save(r);
                    return true;
                })
                .orElse(false);
    }
}
