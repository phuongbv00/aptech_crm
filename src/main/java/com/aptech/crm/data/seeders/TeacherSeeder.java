package com.aptech.crm.data.seeders;

import com.aptech.crm.data.domains.Teacher;
import com.aptech.crm.data.repositories.TeacherRepository;
import com.aptech.crm.utils.BeanUtil;

public class TeacherSeeder implements Runnable {
    @Override
    public void run() {
        var repo = BeanUtil.getBean(TeacherRepository.class);
        if (repo.count() > 0)
            return;
        repo.save(Teacher.builder()
                .fullName("Ms.Giang")
                .email("giangnh@mailtome.com")
                .phone("0987654321")
                .build());
    }
}
