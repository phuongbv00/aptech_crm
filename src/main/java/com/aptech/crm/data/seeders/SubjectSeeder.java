package com.aptech.crm.data.seeders;

import com.aptech.crm.data.domains.Subject;
import com.aptech.crm.data.repositories.SubjectRepository;
import com.aptech.crm.utils.BeanUtil;

import java.util.Arrays;

public class SubjectSeeder implements Runnable {
    private Subject[] dataset = new Subject[]{
            new Subject(null, "Nhập môn lập trình", 3),
            new Subject(null, "Lập trình web", 3),
            new Subject(null, "OOP", 3),
            new Subject(null, "Kiến trúc máy tính", 3),
            new Subject(null, "Trí tuệ nhân tạo", 3),
            new Subject(null, "Phân tích thiết kế hệ thống", 3),
            new Subject(null, "Lập trình game", 3),
    };

    @Override
    public void run() {
        var repo = BeanUtil.getBean(SubjectRepository.class);
        if (repo.count() > 0)
            return;
        repo.saveAll(Arrays.asList(dataset));
    }
}
