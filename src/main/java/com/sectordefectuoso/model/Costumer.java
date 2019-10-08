package com.sectordefectuoso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class Costumer extends User{
    private String costumerName;
    private String address;
    private String email;
    private String creditCardInfo;
    private Double accountBalance;

    public Costumer(String costumerName, String address, String email, String creditCardInfo, Double accountBalance) {
        this.costumerName = costumerName;
        this.address = address;
        this.email = email;
        this.creditCardInfo = creditCardInfo;
        this.accountBalance = accountBalance;
    }

    public Costumer(int userid, String password, String loginStatus, Date registerDate, String costumerName, String address, String email, String creditCardInfo, Double accountBalance) {
        super(userid, password, loginStatus, registerDate);
        this.costumerName = costumerName;
        this.address = address;
        this.email = email;
        this.creditCardInfo = creditCardInfo;
        this.accountBalance = accountBalance;
    }

    public Costumer(int userid, String password, String loginStatus, String costumerName, String address, String email, String creditCardInfo, Double accountBalance) {
        super(userid, password, loginStatus);
        this.costumerName = costumerName;
        this.address = address;
        this.email = email;
        this.creditCardInfo = creditCardInfo;
        this.accountBalance = accountBalance;
    }
}
