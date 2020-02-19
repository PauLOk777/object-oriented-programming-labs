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
            switch (validator.checkCorrectness(retrieveInfo.readInfo())) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:    
                    return;
                default:
                    menuView.badQuery();
            }
        }
    }
}
