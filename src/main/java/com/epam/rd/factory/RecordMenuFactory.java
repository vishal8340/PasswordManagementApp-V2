package com.epam.rd.factory;

import com.epam.rd.console.*;
import com.epam.rd.enums.RecordOperationEnum;
import com.epam.rd.exception.InvalidConsoleInputException;
import com.epam.rd.exception.NoConsoleInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecordMenuFactory {
    @Autowired
    AddRecordMenu addRecordMenuObj;

    @Autowired
    UpdateRecordMenu updateRecordMenuObj;

    @Autowired
    ViewRecordMenu viewRecordMenuObj;

    @Autowired
    DeleteRecordMenu deleteRecordMenuObj;

    @Autowired
    MainMenu mainMenuObj;

    public Menu getRecordOperationMenu(RecordOperationEnum recordOperationEnum)
            throws NoConsoleInputException, InvalidConsoleInputException {

        switch (recordOperationEnum) {
            case ADD_RECORD:
                return addRecordMenuObj;
            case UPDATE_RECORD:
                return updateRecordMenuObj;
            case VIEW_RECORD:
                return viewRecordMenuObj;
            case DELETE_RECORD:
                return deleteRecordMenuObj;
            case MAIN_MENU:
                return mainMenuObj;
        }
        throw new NoConsoleInputException();
    }
}
