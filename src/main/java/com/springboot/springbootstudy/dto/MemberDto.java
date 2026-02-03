package com.springboot.springbootstudy.dto;

/*
DTO(Data Transfer Object)
각 클래스 및 인터페이스를 호출하면서 전달하는 매개변수로 사용되는 데이터 객체(데이터 전송을 위해 사용됨)
*/

public class MemberDto {
    private String name;
    private String email;
    private String organization;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }
}
