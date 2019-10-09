package com.sectordefectuoso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class Costumer extends User{
    private String costumerName;
    private String address;
    private String email;
    private String creditCardInfo;
    private Double accountBalance;

    public Costumer(String password, String loginStatus) {
        super( password, loginStatus);
    }
    public Costumer(int userid,  String password, String loginStatus, String costumerName, String address, String email, String creditCardInfo, Double accountBalance) {
        super(userid, password, loginStatus);
        this.costumerName = costumerName;
        this.address = address;
        this.email = email;
        this.creditCardInfo = creditCardInfo;
        this.accountBalance = accountBalance;
    }
    public Costumer( String password, String loginStatus, String costumerName, String address, String email, String creditCardInfo, Double accountBalance) {
        super( password, loginStatus);
        this.costumerName = costumerName;
        this.address = address;
        this.email = email;
        this.creditCardInfo = creditCardInfo;
        this.accountBalance = accountBalance;
    }

    public Costumer() {
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(String creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
