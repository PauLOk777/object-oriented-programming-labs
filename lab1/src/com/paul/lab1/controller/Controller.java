package com.paul.lab1.controller;

import com.paul.lab1.controller.validatorExceptions.IncorrectlyElective;
import com.paul.lab1.controller.validatorExceptions.IncorrectlyMainBranching;
import com.paul.lab1.controller.validatorExceptions.IncorrectlyTeacher;
import com.paul.lab1.model.ElectiveService;
import com.paul.lab1.view.View;
import com.paul.lab1.view.RetrieveInfo;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Controller {
    private static View view = new View();
    private static RetrieveInfo retrieveInfo = new RetrieveInfo();
    private static Validator validator = new Validator();
    private static ElectiveService service;

    public void run() {
        if (!this.readElectives()) return;

        while (true) {
            view.printOneMessage(View.MAIN_MENU);
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
                        view.showAllElectives(service.getElectives());
                        break;
                    case "quit":
                        view.printOneMessage(View.QUIT);
                        return;
                }
            } catch (IncorrectlyMainBranching incorrectlyMainBranching){
                view.printOneMessage(incorrectlyMainBranching.getMessage());
            }
        }
    }

    private boolean readElectives() {
        try {
            service = new ElectiveService();
//            service.fillJSONFile();
            return true;
        } catch (FileNotFoundException e) {
            view.printOneMessage(View.FILE_NOT_FOUND);
            return false;
        } catch (IOException e) {
            view.printOneMessage(View.FILE_EXCEPTION);
            return false;
        }
    }

    private void invitationToWriteTeacher() {
        while (true) {
            view.printOneMessage(View.INVITATION_TO_WRITE_TEACHER);
            String teacher = retrieveInfo.getUserLine();
            try {
                validator.checkTeacher(teacher);
                String result = service.getElectivesFromOneTeacher(teacher);
                view.showElectives(result);
                this.invitationToSaveElectives(result);
                break;
            } catch (IncorrectlyTeacher incorrectlyTeacher) {
                view.printOneMessage(incorrectlyTeacher.getMessage());
            }
        }
    }

    private void invitationToSaveElectives(String electives) {
        view.printOneMessage(View.INVITATION_TO_RECORD_IN_FILE);
        String option = retrieveInfo.getUserLine();
        if (option.equals("1")) {
            try {
                service.writeTextElectives(electives);
                view.printOneMessage(View.SUCCESSFUL_SAVE);
            } catch (FileNotFoundException e) {
                view.printOneMessage(View.FILE_NOT_FOUND);
            } catch (IOException e) {
                view.printOneMessage(View.FILE_EXCEPTION);
            }
        }
    }

    private void invitationToWriteElective() {
        while (true) {
            view.printOneMessage(View.INVITATION_TO_WRITE_ELECTIVE);
            String elective = retrieveInfo.getUserLine();
            try {
                validator.checkElective(elective);
                double result = service.getAverageMark(elective);
                view.averageMark(elective, result);
                break;
            } catch (IncorrectlyElective incorrectlyElective){
                view.printOneMessage(incorrectlyElective.getMessage());
            }
        }
    }
}
