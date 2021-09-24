package com.epam.rd.enums;

public enum RecordOperationEnum {
    INVALID(0),
    ADD_RECORD(1),
    UPDATE_RECORD(2),
    VIEW_RECORD(3),
    DELETE_RECORD(4),
    MAIN_MENU(5);

    private int choice;

    RecordOperationEnum(int choice) {
        this.choice = choice;
    }

    public static RecordOperationEnum getRecordMenuEnum(int choice) {
        for (RecordOperationEnum e : RecordOperationEnum.values()) {
            if (e.choice == choice) {
                return e;
            }
        }
        return INVALID;
    }
}
