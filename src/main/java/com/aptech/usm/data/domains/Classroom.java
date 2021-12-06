package com.aptech.usm.data.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
@Getter
@Setter
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Instant startTime;
    private Instant endTime;
    private String address;

    private Long subjectId;
    private Long teacherId;
}
