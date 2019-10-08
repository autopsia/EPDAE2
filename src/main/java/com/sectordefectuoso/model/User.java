package com.sectordefectuoso.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int userid;
    private String password;
    private String loginStatus = "Inactivo";
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date registerDate = new Date();

    public User(int userid, String password, String loginStatus) {
        this.userid = userid;
        this.password = password;
        this.loginStatus = loginStatus;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        if (registerDate == null){
            this.registerDate = registerDate;
        }

    }
}
