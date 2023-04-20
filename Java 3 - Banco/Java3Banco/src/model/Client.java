package model;

import helper.Utils;

import java.util.Date;

public class Client {
    private static int counter = 101;

    private int code;
    private String name;
    private String email;
    private String cpf;
    private Date birthdayDate;
    private Date registerDate;

    public Client(String name, String email, String cpf, Date birthdayDate) {
        this.code = Client.counter;
        this.registerDate = new Date();

        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthdayDate = birthdayDate;

        Client.counter++;
    }

    public int getCode() {
        return code;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    @Override
    public String toString() {
        return "Code: " + this.getCode() + "\n" +
                "Name: " + this.getName() + "\n" +
                "CPF: " + this.getCpf() + "\n" +
                "E-mail: " + this.getEmail() + "\n" +
                "Birthday Date: " + Utils.dateToString(this.getBirthdayDate()) + "\n" +
                "Register Date: " + Utils.dateToString(this.getRegisterDate()) + "\n";

    }
}
