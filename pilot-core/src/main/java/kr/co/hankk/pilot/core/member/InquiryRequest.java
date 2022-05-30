package kr.co.hankk.pilot.core.member;


public record InquiryRequest(String companyName, String compnayKind, EmployeeCount employeeCount, String name
        , String phone, String email, String content, boolean agree) {
}
