package com.aptech.usm.data.repositories;

import com.aptech.usm.dto.classroom.ClassRegistrationDTO;
import com.aptech.usm.dto.classroom.ClassroomDTO;
import com.aptech.usm.utils.enums.ClassRegistrationStatusEnum;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClassroomCustomRepositoryImpl implements ClassroomCustomRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ClassroomDTO> findAllWithJoin() {
        var sql = "select clr.id,\n" +
                "       clr.name,\n" +
                "       clr.start_date startDate,\n" +
                "       clr.end_date   endDate,\n" +
                "       clr.address,\n" +
                "       s.name         subjectName,\n" +
                "       t.full_name    teacherName\n" +
                "from classroom clr\n" +
                "         left join teacher t on clr.teacher_id = t.id\n" +
                "         left join subject s on clr.subject_id = s.id;";
        var query = em.createNativeQuery(sql);
        var rs = (List<Object[]>) query.getResultList();
        return rs.stream()
                .map(tuple -> ClassroomDTO.builder()
                        .id(((Number) tuple[0]).longValue())
                        .name(((String) tuple[1]))
                        .startDate(((Date) tuple[2]).toLocalDate())
                        .endDate(((Date) tuple[3]).toLocalDate())
                        .address(((String) tuple[4]))
                        .subjectName(((String) tuple[5]))
                        .teacherName(((String) tuple[6]))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<ClassRegistrationDTO> findClassRegistrationsByStudentId(Long studentId) {
        var sql = "select clr.id,\n" +
                "       clr.name,\n" +
                "       clr.start_date startDate,\n" +
                "       clr.end_date   endDate,\n" +
                "       clr.address,\n" +
                "       s.name         subjectName,\n" +
                "       t.full_name    teacherName,\n" +
                "       cr.registration_time,\n" +
                "       cr.status,\n" +
                "       std.full_name  studentName\n" +
                "from classroom clr\n" +
                "         join class_registration cr on clr.id = cr.classroom_id\n" +
                "         left join teacher t on clr.teacher_id = t.id\n" +
                "         left join subject s on clr.subject_id = s.id\n" +
                "         left join student std on cr.student_id = std.id\n" +
                "where cr.student_id = :studentId and cr.status = 1";
        var query = em.createNativeQuery(sql);
        query.setParameter("studentId", studentId);
        var rs = (List<Object[]>) query.getResultList();
        return rs.stream()
                .map(tuple -> ClassRegistrationDTO.builder()
                        .id(((Number) tuple[0]).longValue())
                        .name(((String) tuple[1]))
                        .startDate(((Date) tuple[2]).toLocalDate())
                        .endDate(((Date) tuple[3]).toLocalDate())
                        .address(((String) tuple[4]))
                        .subjectName(((String) tuple[5]))
                        .teacherName(((String) tuple[6]))
                        .registrationTime(((Timestamp) tuple[7]).toInstant())
                        .status(ClassRegistrationStatusEnum.values()[(Integer) tuple[8]])
                        .studentName((String) tuple[9])
                        .build())
                .collect(Collectors.toList());
    }
}
