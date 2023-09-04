package com.example.sumprofiles;

public class Profile {
    private String login;
    private Integer money;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Profile(String login, Integer money) {
        this.login = login;
        this.money = money;
    }
}
