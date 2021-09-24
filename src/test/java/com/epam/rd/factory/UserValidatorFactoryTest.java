package com.epam.rd.factory;

import com.epam.rd.enums.UserEnum;
import com.epam.rd.exception.InvalidUserValidatorException;
import com.epam.rd.validator.AccountNameValidator;
import com.epam.rd.validator.PasswordValidator;
import com.epam.rd.validator.UserNameValidator;
import com.epam.rd.validator.UserValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


// Todo: getUserValidateShouldReturnObjOfAccountNameValidatorType
// Todo: getUserValidateShouldReturnObjOfAccountNameValidatorType
// Todo: getUserValidateShouldReturnObjOfPasswordValidatorType
@RunWith(MockitoJUnitRunner.class)
public class UserValidatorFactoryTest {

    @InjectMocks
    UserValidatorFactory userValidatorFactory;
    @Mock
    UserValidator userValidator;
    @Mock
    AccountNameValidator accountNameValidator;
    @Mock
    UserNameValidator userNameValidator;
    @Mock
    PasswordValidator passwordValidator;

    @Test
    @DisplayName("getUserValidateShouldReturnObjOfAccountNameValidatorType")
    public void getUserValidateShouldReturnObjOfAccountNameValidatorType() throws InvalidUserValidatorException {
        when(userValidatorFactory.getUserValidate(any())).thenReturn(accountNameValidator);
        assertEquals(accountNameValidator, userValidatorFactory.getUserValidate(UserEnum.ACCOUNT_NAME));
    }
}
