package kr.co.hankk.pilot.core.member;

import lombok.Getter;

@Getter
public enum EmployeeCount {
    FIVE("5인 이하"),
    TEN("10인 이하"),
    THIRTY("30인 이하"),
    LESS_FIFTY("50인 이하"),
    MORE_FIFTY("50인 이상"),
    MORE_HUNDRED("100인 이상");

    private String label;
    private EmployeeCount(String label){
        this.label = label;
    }
}
