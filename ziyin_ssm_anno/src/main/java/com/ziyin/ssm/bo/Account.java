package com.ziyin.ssm.bo;

import java.io.Serializable;

/**
 * 帐户
 */
public class Account implements Serializable{

    private Integer id;
    private String name;
    private Double money;


    public Account(String name, Double money) {
        this.name = name;
        this.money = money;
    }


    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
