package com.paul.lab1.controller;

import com.paul.lab1.model.ElectiveService;
import com.paul.lab1.view.View;
import com.paul.lab1.view.RetriveInfo;


public class Controller {
    private static final View menuView = new View();
    private static final RetriveInfo retrieveInfo = new RetriveInfo();
    private static final Validator validator = new Validator();
    private static final ElectiveService service = new ElectiveService();

    public void run() {
        while (true) {
            menuView.printOneMessage(View.mainMenu);
            String data = retrieveInfo.getUserLine();
            if (validator.checkCorrectnessMainBranching(data)) {
                switch (data) {
                    case "1":
                        this.invitationToWriteTeacher();
                        break;
                    case "2":
                        this.invitationToWriteElective();
                        break;
                    case "3":
                        menuView.showAllElectives(service.getElectives());
                        break;
                    case "quit":
                        menuView.printOneMessage(View.quit);
                        return;
                }
            } else {
                menuView.printOneMessage(View.badQuery);
            }
        }
    }

    private void invitationToWriteTeacher() {
        while (true) {
            menuView.printOneMessage(View.invitationToWriteTeacher);
            String teacher = retrieveInfo.getUserLine();
            if (validator.checkTeacher(teacher)) {
                String result = service.getElectivesFromOneTeacher(teacher);
                menuView.showElectives(result);
                break;
            } else {
                menuView.printOneMessage(View.badTeacherName);
            }
        }
    }

    private void invitationToWriteElective() {
        while (true) {
            menuView.printOneMessage(View.invitationToWriteElective);
            String elective = retrieveInfo.getUserLine();
            if (validator.checkElective(elective)) {
                double result = service.getAverageMark(elective);
                menuView.averageMark(elective, result);
                break;
            } else {
                menuView.printOneMessage(View.badElectiveName);
            }
        }
    }
}
