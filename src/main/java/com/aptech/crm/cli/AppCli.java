package com.aptech.crm.cli;

import com.aptech.crm.cli.account.AccountCli;
import com.aptech.crm.cli.classroom.ClassroomCli;
import com.aptech.crm.cli.student.StudentCli;
import com.aptech.crm.cli.subject.SubjectCli;
import com.aptech.crm.cli.teacher.TeacherCli;
import com.aptech.crm.services.AuthService;
import com.aptech.crm.utils.BeanUtil;

import java.util.List;

public class AppCli implements Cli {
    private final AuthService auth = BeanUtil.getBean(AuthService.class);

    @Override
    public String getLabel() {
        return "MAIN MENU";
    }

    @Override
    public List<Cli> getSubCli() {
        return auth.isAdmin() ? List.of(
                new AccountCli(),
                new SubjectCli(),
                new StudentCli(),
                new TeacherCli(),
                new ClassroomCli()
        ) : List.of(
                new AccountCli(),
                new SubjectCli(),
                new TeacherCli(),
                new ClassroomCli()
        );
    }

    @Override
    public void run() {

    }
}
