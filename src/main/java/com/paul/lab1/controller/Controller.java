package com.paul.lab1.controller;

import com.paul.lab1.controller.validatorExceptions.IncorrectlyElective;
import com.paul.lab1.controller.validatorExceptions.IncorrectlyMainBranching;
import com.paul.lab1.controller.validatorExceptions.IncorrectlyTeacher;
import com.paul.lab1.model.ElectiveService;
import com.paul.lab1.view.RetrieveInfo;
import com.paul.lab1.view.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class Controller {
    private static View view = new View();
    private static RetrieveInfo retrieveInfo = new RetrieveInfo();
    private static Validator validator = new Validator();
    private static ElectiveService service;
    private static Logger logger = LogManager.getLogger();

    public void run() {
        if (!this.readElectives()) return;

        view.printOneMessage(View.langMenu);
        String langChoice = retrieveInfo.getUserLine();
        this.languageChoice(langChoice);

        while (true) {
            view.printOneMessage(View.mainMenu);
            String data = retrieveInfo.getUserLine();
            try {
                validator.checkCorrectnessMainBranching(data);
                switch (data) {
                    case "1":
                        logger.debug("User get invitation to write teacher.");
                        this.invitationToWriteTeacher();
                        break;
                    case "2":
                        logger.debug("User get invitation to write elective.");
                        this.invitationToWriteElective();
                        break;
                    case "3":
                        logger.debug("User get all electives.");
                        view.showAllElectives(service.getElectives());
                        break;
                    case "quit":
                        logger.debug("User exit from application.");
                        view.printOneMessage(View.quit);
                        return;
                }
            } catch (IncorrectlyMainBranching incorrectlyMainBranching) {
                logger.error(incorrectlyMainBranching.getMessage() + "\n" +
                        Arrays.toString(incorrectlyMainBranching.getStackTrace()));
                view.printOneMessage(View.incorrectMainBranching);
            }
        }
    }

    private void languageChoice(String langChoice) {
        switch (langChoice) {
            case "2":
                view.setLocaleAndResBundle(new Locale("ru", "RU"));
                break;
            case "3":
                view.setLocaleAndResBundle(new Locale("uk", "UA"));
                break;
            default:
                view.setLocaleAndResBundle(new Locale("en", "GB"));
        }
    }

    private boolean readElectives() {
        try {
            service = new ElectiveService();
            logger.debug("Electives was defined successful.");
            return true;
        } catch (FileNotFoundException e) {
            logger.fatal(View.fileNotFound + "\n" + Arrays.toString(e.getStackTrace()));
            view.printOneMessage(View.fileNotFound);
            return false;
        } catch (IOException e) {
            logger.fatal(View.fileException + "\n" + Arrays.toString(e.getStackTrace()));
            view.printOneMessage(View.fileException);
            return false;
        }
    }

    private void invitationToWriteTeacher() {
        while (true) {
            view.printOneMessage(View.invitationToWriteTeacher);
            String teacher = retrieveInfo.getUserLine();
            try {
                validator.checkTeacher(teacher);
                String result = service.getElectivesFromOneTeacher(teacher);
                view.showElectives(result);
                this.invitationToSaveElectives(result);
                break;
            } catch (IncorrectlyTeacher incorrectlyTeacher) {
                logger.error(incorrectlyTeacher.getMessage() + "\n" +
                        Arrays.toString(incorrectlyTeacher.getStackTrace()));
                view.printOneMessage(View.incorrectTeacher);
            }
        }
    }

    private void invitationToSaveElectives(String electives) {
        view.printOneMessage(View.invitationToRecordInFile);
        String option = retrieveInfo.getUserLine();
        if (option.equals("1")) {
            try {
                service.writeTextElectives(electives);
                view.printOneMessage(View.successfulSave);
            } catch (FileNotFoundException e) {
                logger.error("File not found." + "\n" + Arrays.toString(e.getStackTrace()));
                view.printOneMessage(View.fileNotFound);
            } catch (IOException e) {
                logger.error("File exception" + "\n" + Arrays.toString(e.getStackTrace()));
                view.printOneMessage(View.fileException);
            }
        }
    }

    private void invitationToWriteElective() {
        while (true) {
            view.printOneMessage(View.invitationToWriteElective);
            String elective = retrieveInfo.getUserLine();
            try {
                validator.checkElective(elective);
                double result = service.getAverageMark(elective);
                view.averageMark(elective, result);
                break;
            } catch (IncorrectlyElective incorrectlyElective) {
                logger.error(incorrectlyElective.getMessage() + "\n" +
                        Arrays.toString(incorrectlyElective.getStackTrace()));
                view.printOneMessage(View.incorrectElective);
            }
        }
    }
}
