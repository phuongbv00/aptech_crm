package com.aptech.crm.dto.classroom;

import com.aptech.crm.utils.enums.ClassRegistrationStatusEnum;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassRegistrationDTO {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String address;

    private String subjectName;
    private String teacherName;

    private Instant registrationTime;
    private ClassRegistrationStatusEnum status;
    private String studentName;
}
