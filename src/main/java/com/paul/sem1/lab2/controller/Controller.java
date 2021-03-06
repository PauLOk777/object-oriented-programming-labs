package com.paul.sem1.lab2.controller;

import com.paul.sem1.lab2.controller.validatorExceptions.IncorrectlyElective;
import com.paul.sem1.lab2.controller.validatorExceptions.IncorrectlyMainBranching;
import com.paul.sem1.lab2.controller.validatorExceptions.IncorrectlyTeacher;
import com.paul.sem1.lab2.model.ElectiveService;
import com.paul.sem1.lab2.view.View;
import com.paul.sem1.lab2.view.RetrieveInfo;


public class Controller {
    private static final View menuView = new View();
    private static final RetrieveInfo retrieveInfo = new RetrieveInfo();
    private static final Validator validator = new Validator();
    private static final ElectiveService service = new ElectiveService();

    public void run() {
        while (true) {
            menuView.printOneMessage(View.MAIN_MENU);
            String data = retrieveInfo.getUserLine();
            try {
                validator.checkCorrectnessMainBranching(data);
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
                        menuView.printOneMessage(View.QUIT);
                        return;
                }
            } catch (IncorrectlyMainBranching incorrectlyMainBranching){
                menuView.printOneMessage(incorrectlyMainBranching.getMessage());
            }
        }
    }

    private void invitationToWriteTeacher() {
        while (true) {
            menuView.printOneMessage(View.INVITATION_TO_WRITE_TEACHER);
            String teacher = retrieveInfo.getUserLine();
            try {
                validator.checkTeacher(teacher);
                String result = service.getElectivesFromOneTeacher(teacher);
                menuView.showElectives(result);
                break;
            } catch (IncorrectlyTeacher incorrectlyTeacher) {
                menuView.printOneMessage(incorrectlyTeacher.getMessage());
            }
        }
    }

    private void invitationToWriteElective() {
        while (true) {
            menuView.printOneMessage(View.INVITATION_TO_WRITE_ELECTIVE);
            String elective = retrieveInfo.getUserLine();
            try {
                validator.checkElective(elective);
                double result = service.getAverageMark(elective);
                menuView.averageMark(elective, result);
                break;
            } catch (IncorrectlyElective incorrectlyElective){
                menuView.printOneMessage(incorrectlyElective.getMessage());
            }
        }
    }
}