package com.epam.rd.factory;

import com.epam.rd.console.ExitMenu;
import com.epam.rd.console.LoginUserMenu;
import com.epam.rd.console.Menu;
import com.epam.rd.console.UserRegistrationMenu;
import com.epam.rd.enums.MenuEnum;
import com.epam.rd.exception.InvalidConsoleInputException;
import com.epam.rd.exception.NoConsoleInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsoleMenuFactory {

    @Autowired
    LoginUserMenu loginUserMenuObj;

    @Autowired
    UserRegistrationMenu userRegistrationMenuObj;

    @Autowired
    ExitMenu exitMenuObj;

    public Menu getConsoleMenu(MenuEnum consoleMenuEnum)
            throws NoConsoleInputException, InvalidConsoleInputException {

        switch (consoleMenuEnum) {
            case LOGIN_USER:
                return loginUserMenuObj;
            case REGISTER_USER:
                return userRegistrationMenuObj;
            case EXIT:
                return exitMenuObj;
            case INVALID:
                throw new InvalidConsoleInputException();
        }
        throw new NoConsoleInputException();
    }
}
