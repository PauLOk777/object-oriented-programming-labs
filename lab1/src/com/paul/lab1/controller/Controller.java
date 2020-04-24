package com.paul.lab1.controller;

import com.paul.lab1.controller.validatorExceptions.IncorrectlyElective;
import com.paul.lab1.controller.validatorExceptions.IncorrectlyMainBranching;
import com.paul.lab1.controller.validatorExceptions.IncorrectlyTeacher;
import com.paul.lab1.model.ElectiveService;
import com.paul.lab1.view.View;
import com.paul.lab1.view.RetriveInfo;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Controller {
    private static View view = new View();
    private static RetriveInfo retrieveInfo = new RetriveInfo();
    private static Validator validator = new Validator();
    private static ElectiveService service;

    public void run() {
        try {
            service = new ElectiveService();
//            service.fillJSONFile();
        } catch (FileNotFoundException e) {
            view.printOneMessage("File not found\n" + e.getMessage());
            return;
        } catch (IOException e) {
            view.printOneMessage("Some problems with reading file\n" + e.getMessage());
            return;
        }

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

    private void invitationToWriteTeacher() {
        while (true) {
            view.printOneMessage(View.INVITATION_TO_WRITE_TEACHER);
            String teacher = retrieveInfo.getUserLine();
            try {
                validator.checkTeacher(teacher);
                String result = service.getElectivesFromOneTeacher(teacher);
                view.showElectives(result);
                break;
            } catch (IncorrectlyTeacher incorrectlyTeacher) {
                view.printOneMessage(incorrectlyTeacher.getMessage());
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
