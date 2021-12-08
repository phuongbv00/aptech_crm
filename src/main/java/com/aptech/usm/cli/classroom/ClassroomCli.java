package com.aptech.usm.cli.classroom;

import com.aptech.usm.cli.Cli;
import com.aptech.usm.data.domains.Student;
import com.aptech.usm.dto.classroom.ClassRegistrationDTO;
import com.aptech.usm.dto.classroom.ClassroomDTO;
import com.aptech.usm.services.AuthService;
import com.aptech.usm.services.ClassroomService;
import com.aptech.usm.utils.BeanUtil;
import com.aptech.usm.utils.CliUtil;

import java.util.List;

public class ClassroomCli implements Cli {
    private final AuthService auth = BeanUtil.getBean(AuthService.class);
    private final ClassroomService service = BeanUtil.getBean(ClassroomService.class);

    @Override
    public String getLabel() {
        return "Lớp học phần";
    }

    @Override
    public List<Cli> getSubCli() {
        return auth.isAdmin()
                ? List.of(new ClassroomDetailsCli(), new ClassroomCreateCli())
                : List.of(new ClassApplyCli(), new ClassLeaveCli());
    }

    @Override
    public void run() {
        if (auth.isAdmin()) {
            printAllClassrooms();
        } else {
            printMyClassrooms();
        }
    }

    private void printAllClassrooms() {
        var dataset = service.findAll();
        var titles = new String[]{"ID", "Tên học phần", "Ngày bắt đầu", "Ngày kết thúc", "Phòng học", "Môn học", "Giảng viên"};
        CliUtil.printTable(titles, dataset, ClassroomDTO.class);
    }

    private void printMyClassrooms() {
        var dataset = service.findClassRegistrationsByStudentId(auth.getAuthStd().map(Student::getId).orElse(null));
        var titles = new String[]{"ID", "Tên học phần", "Ngày bắt đầu", "Ngày kết thúc", "Phòng học", "Môn học", "Giảng viên", "Thời gian đăng ký", "Trạng thái", "Tên học viên"};
        CliUtil.printTable(titles, dataset, ClassRegistrationDTO.class);
    }
}
