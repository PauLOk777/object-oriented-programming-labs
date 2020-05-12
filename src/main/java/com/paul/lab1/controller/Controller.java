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

public class Controller {
    private static View view = new View();
    private static RetrieveInfo retrieveInfo = new RetrieveInfo();
    private static Validator validator = new Validator();
    private static ElectiveService service;
    private static Logger logger = LogManager.getLogger();

    public void run() {
        if (!this.readElectives()) return;

        while (true) {
            view.printOneMessage(View.MAIN_MENU);
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
                        view.printOneMessage(View.QUIT);
                        return;
                }
            } catch (IncorrectlyMainBranching incorrectlyMainBranching) {
                logger.error(incorrectlyMainBranching.getMessage() + "\n" +
                        Arrays.toString(incorrectlyMainBranching.getStackTrace()));
                view.printOneMessage(incorrectlyMainBranching.getMessage());
            }
        }
    }

    private boolean readElectives() {
        try {
            service = new ElectiveService();
            logger.debug("Electives was defined successful.");
            return true;
        } catch (FileNotFoundException e) {
            logger.fatal(View.FILE_NOT_FOUND + "\n" + Arrays.toString(e.getStackTrace()));
            view.printOneMessage(View.FILE_NOT_FOUND);
            return false;
        } catch (IOException e) {
            logger.fatal(View.FILE_EXCEPTION + "\n" + Arrays.toString(e.getStackTrace()));
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
                logger.error(incorrectlyTeacher.getMessage() + "\n" +
                        Arrays.toString(incorrectlyTeacher.getStackTrace()));
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
                logger.debug(View.SUCCESSFUL_SAVE);
                view.printOneMessage(View.SUCCESSFUL_SAVE);
            } catch (FileNotFoundException e) {
                logger.error(View.FILE_NOT_FOUND + "\n" + Arrays.toString(e.getStackTrace()));
                view.printOneMessage(View.FILE_NOT_FOUND);
            } catch (IOException e) {
                logger.error(View.FILE_EXCEPTION + "\n" + Arrays.toString(e.getStackTrace()));
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
            } catch (IncorrectlyElective incorrectlyElective) {
                logger.error(incorrectlyElective.getMessage() + "\n" +
                        Arrays.toString(incorrectlyElective.getStackTrace()));
                view.printOneMessage(incorrectlyElective.getMessage());
            }
        }
    }
}
