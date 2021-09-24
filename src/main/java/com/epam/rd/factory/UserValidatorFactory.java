package com.epam.rd.factory;

import com.epam.rd.enums.UserEnum;
import com.epam.rd.exception.InvalidUserValidatorException;
import com.epam.rd.validator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorFactory {
    @Autowired
    AccountNameValidator accountNameValidator;

    @Autowired
    UserNameValidator userNameValidator;

    @Autowired
    PasswordValidator passwordValidator;

    public UserValidator getUserValidate(UserEnum userEnum) throws InvalidUserValidatorException {
        switch (userEnum) {
            case ACCOUNT_NAME:
                return accountNameValidator;
            case USER_NAME:
                return userNameValidator;
            case PASSWORD:
                return passwordValidator;
        }
        throw new InvalidUserValidatorException();
    }
}
