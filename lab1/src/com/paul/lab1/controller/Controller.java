package com.paul.lab1.controller;

import com.paul.lab1.model.ElectiveService;
import com.paul.lab1.view.MenuView;
import com.paul.lab1.view.RetriveInfo;


public class Controller {
    private static final MenuView menuView = new MenuView();
    private static final RetriveInfo retrieveInfo = new RetriveInfo();
    private static final Validator validator = new Validator();
    private static final ElectiveService service = new ElectiveService();

    public void run() {
        while (true) {
            menuView.printOneMessage(MenuView.mainMenu);
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
                        menuView.printOneMessage(MenuView.quit);
                        return;
                }
            } else {
                menuView.printOneMessage(MenuView.badQuery);
            }
        }
    }

    private void invitationToWriteTeacher() {
        while (true) {
            menuView.printOneMessage(MenuView.invitationToWriteTeacher);
            String info = retrieveInfo.getUserLine();
            if (validator.checkTeacher(info)) {
                String result = service.getElectivesFromOneTeacher(
                        service.getElectives(), info
                );
                menuView.showElectives(result);
                break;
            } else {
                menuView.printOneMessage(MenuView.badTeacherName);
            }
        }
    }

    private void invitationToWriteElective() {
        while (true) {
            menuView.printOneMessage(MenuView.invitationToWriteElective);
            String info = retrieveInfo.getUserLine();
            if (validator.checkElective(info)) {
                double result = service.getAverageMark(
                        service.getElectives(), info
                );
                menuView.averageMark(info, result);
                break;
            } else {
                menuView.printOneMessage(MenuView.badElectiveName);
            }
        }
    }
}
