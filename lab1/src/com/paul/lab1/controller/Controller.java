package com.paul.lab1.controller;

import com.paul.lab1.model.Elective;
import com.paul.lab1.model.ElectiveService;
import com.paul.lab1.view.MenuView;
import com.paul.lab1.view.RetriveInfo;
import com.paul.lab1.view.Validator;


public class Controller {
    private static final MenuView menuView = new MenuView();
    private static final RetriveInfo retrieveInfo = new RetriveInfo();
    private static final Validator validator = new Validator();
    private static final ElectiveService service = new ElectiveService();

    public void run() {
        Elective[] electives = service.getElectives();

        while (true) {
            menuView.showAbilities();
            String data = retrieveInfo.getUserLine();
            if (validator.checkCorrectnessMainBranching(data)) {
                switch (data) {
                    case "1":
                        while (true) {
                            menuView.invitationToWriteTeacher();
                            String info = retrieveInfo.getUserLine();
                            if (validator.checkTeacher(info)) {
                                String result = service.getElectivesFromOneTeacher(electives, info);
                                menuView.showElectives(result);
                                break;
                            } else {
                                menuView.badTeacherName();
                            }
                        }
                        break;
                    case "2":
                        menuView.invitationToWriteElective();
                        String info = retrieveInfo.getUserLine();
                        if (validator.checkElective(info)) {
                            double result = service.getAverageMark(electives, info);
                            menuView.averageMark(info, result);
                        } else {
                            menuView.badElectiveName();
                        }
                        break;
                    case "3":
                        menuView.showAllElectives(electives);
                        break;
                    case "quit":
                        menuView.quit();
                        return;
                }
            } else {
                menuView.badQuery();
            }
        }
    }
}
