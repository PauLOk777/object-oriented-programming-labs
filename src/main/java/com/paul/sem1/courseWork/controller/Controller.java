package com.paul.sem1.courseWork.controller;

import com.paul.sem1.lab1.controller.Validator;
import com.paul.sem1.lab5.controller.validatorExceptions.IncorrectlyElective;
import com.paul.sem1.lab5.controller.validatorExceptions.IncorrectlyMainBranching;
import com.paul.sem1.lab5.controller.validatorExceptions.IncorrectlyTeacher;
import com.paul.sem1.lab5.model.ElectiveService;
import com.paul.sem1.lab5.view.ResourceBundleKeys;
import com.paul.sem1.lab5.view.RetrieveInfo;
import com.paul.sem1.lab5.view.View;
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

        view.printOneMessage(ResourceBundleKeys.LANG_MENU);
        String langChoice = retrieveInfo.getUserLine();
        this.languageChoice(langChoice);

        while (true) {
            view.printOneMessage(ResourceBundleKeys.MAIN_MENU);
            String data = retrieveInfo.getUserLine();
            try {
                validator.checkCorrectnessMainBranching(data);
                switch (data) {
                    case "1":
                        logger.info("User get invitation to write teacher.");
                        this.invitationToWriteTeacher();
                        break;
                    case "2":
                        logger.info("User get invitation to write elective.");
                        this.invitationToWriteElective();
                        break;
                    case "3":
                        logger.info("User get all electives.");
                        view.showAllElectives(service.getElectives());
                        break;
                    case "quit":
                        logger.info("User exit from application.");
                        view.printOneMessage(ResourceBundleKeys.QUIT);
                        return;
                }
            } catch (IncorrectlyMainBranching incorrectlyMainBranching) {
                logger.error(incorrectlyMainBranching.getMessage() + "\n" +
                        Arrays.toString(incorrectlyMainBranching.getStackTrace()));
                view.printOneMessage(ResourceBundleKeys.INCORRECT_MAIN_BRANCHING);
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
            logger.info("Electives was defined successful.");
            return true;
        } catch (FileNotFoundException e) {
            logger.fatal(ResourceBundleKeys.FILE_NOT_FOUND + "\n" + Arrays.toString(e.getStackTrace()));
            view.printOneMessage(ResourceBundleKeys.FILE_NOT_FOUND);
            return false;
        } catch (IOException e) {
            logger.fatal(ResourceBundleKeys.FILE_EXCEPTION + "\n" + Arrays.toString(e.getStackTrace()));
            view.printOneMessage(ResourceBundleKeys.FILE_EXCEPTION);
            return false;
        }
    }

    private void invitationToWriteTeacher() {
        while (true) {
            view.printOneMessage(ResourceBundleKeys.INVITATION_TO_WRITE_TEACHER);
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
                view.printOneMessage(ResourceBundleKeys.INCORRECT_TEACHER);
            }
        }
    }

    private void invitationToSaveElectives(String electives) {
        view.printOneMessage(ResourceBundleKeys.INVITATION_TO_RECORD_IN_FILE);
        logger.info("User get invitation to save file.");
        String option = retrieveInfo.getUserLine();
        if (option.equals("1")) {
            try {
                service.writeTextElectives(electives);
                view.printOneMessage(ResourceBundleKeys.SUCCESSFUL_SAVE);
            } catch (FileNotFoundException e) {
                logger.error("File not found." + "\n" + Arrays.toString(e.getStackTrace()));
                view.printOneMessage(ResourceBundleKeys.FILE_NOT_FOUND);
            } catch (IOException e) {
                logger.error("File exception" + "\n" + Arrays.toString(e.getStackTrace()));
                view.printOneMessage(ResourceBundleKeys.FILE_EXCEPTION);
            }
        }
    }

    private void invitationToWriteElective() {
        while (true) {
            view.printOneMessage(ResourceBundleKeys.INVITATION_TO_WRITE_ELECTIVE);
            String elective = retrieveInfo.getUserLine();
            try {
                validator.checkElective(elective);
                double result = service.getAverageMark(elective);
                view.averageMark(elective, result);
                break;
            } catch (IncorrectlyElective incorrectlyElective) {
                logger.error(incorrectlyElective.getMessage() + "\n" +
                        Arrays.toString(incorrectlyElective.getStackTrace()));
                view.printOneMessage(ResourceBundleKeys.INCORRECT_ELECTIVE);
            }
        }
    }
}
