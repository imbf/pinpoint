package com.navercorp.pinpoint.web.alarm.vo.sender.payload;

public class UserMember {

    private String memberId;
    private String name;
    private String email;
    private String department;
    private String phoneNumber;
    private int phoneCountryCode;
    
    public UserMember() {
    }
    
    public UserMember(String memberId, String name, String email, String department, String phoneNumber, int phoneCountryCode) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.department = department;
        this.phoneNumber = phoneNumber;
        this.phoneCountryCode = phoneCountryCode;
    }
    
    public String getMemberId() {
        return memberId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public int getPhoneCountryCode() {
        return phoneCountryCode;
    }
}
