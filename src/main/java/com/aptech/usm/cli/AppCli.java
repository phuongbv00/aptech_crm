package com.aptech.usm.cli;

import com.aptech.usm.cli.account.AccountCli;
import com.aptech.usm.cli.classroom.ClassroomCli;
import com.aptech.usm.cli.student.StudentCli;
import com.aptech.usm.cli.subject.SubjectCli;
import com.aptech.usm.cli.teacher.TeacherCli;

import java.util.List;

public class AppCli implements Cli {
    @Override
    public String getLabel() {
        return "MAIN MENU";
    }

    @Override
    public List<Cli> getSubCli() {
        return List.of(
                new AccountCli(),
                new SubjectCli(),
                new StudentCli(),
                new TeacherCli(),
                new ClassroomCli()
        );
    }

    @Override
    public void run() {

    }
}
