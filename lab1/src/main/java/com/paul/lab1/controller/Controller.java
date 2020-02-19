package main.java.com.paul.lab1.controller;

import main.java.com.paul.lab1.model.Elective;
import main.java.com.paul.lab1.model.ElectiveService;
import main.java.com.paul.lab1.view.RetriveInfo;
import main.java.com.paul.lab1.view.ShowInfo;
import main.java.com.paul.lab1.view.Validator;

public class Controller {
    public void run() {
        ElectiveService service = new ElectiveService();
        Elective[] electives = service.getElectives();
    }
}
