package com.epam.rd.enums;

public enum MenuEnum {
    INVALID(0),
    LOGIN_USER(1),
    REGISTER_USER(2),
    EXIT(3);

    private int choice;

    MenuEnum(int choice) {
        this.choice = choice;
    }

    public static MenuEnum getConsoleMenuEnum(int choice) {
        for (MenuEnum e : MenuEnum.values()) {
            if (e.choice == choice) {
                return e;
            }
        }
        return INVALID;
    }

}
