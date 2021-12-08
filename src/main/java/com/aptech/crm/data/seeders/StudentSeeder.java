package com.aptech.crm.data.seeders;

import com.aptech.crm.data.repositories.StudentRepository;
import com.aptech.crm.dto.student.StudentCreateDTO;
import com.aptech.crm.services.StudentService;
import com.aptech.crm.utils.BeanUtil;

public class StudentSeeder implements Runnable {
    @Override
    public void run() {
        var stdRepo = BeanUtil.getBean(StudentRepository.class);
        var stdService = BeanUtil.getBean(StudentService.class);
        if (stdRepo.count() > 0)
            return;
        stdService.create(StudentCreateDTO
                .builder()
                .fullName("Nguyễn Văn A")
                .identityCard("001200001234")
                .username("anv1")
                .password("123456")
                .build());
    }
}
