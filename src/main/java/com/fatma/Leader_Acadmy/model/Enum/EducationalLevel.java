package com.fatma.Leader_Acadmy.model.Enum;

import lombok.Data;


public enum EducationalLevel  {
    FIRST_YEAR_OF_MIDDLE_SCHOOL(1),
    SECOND_YEAR_OF_MIDDLE_SCHOOL(2),
    THIRD_YEAR_OF_MIDDLE_SCHOOL(3),
    FIRST_YEAR_OF_HIGH_SCHOOL(4),
    SECOND_YEAR_OF_HIGH_SCHOOL(5),
    THIRD_YEAR_OF_HIGH_SCHOOL(6);

    private final int i;

    EducationalLevel(int i) {
        this.i=i;
    }
    public int getValue() {
        return i;
    }
}
