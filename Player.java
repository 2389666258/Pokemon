package Pokemons;

import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private final String account;
    private String password;
    private Mail mail;
    private PhoneNumber phoneNumber;
    ArrayList<Pokemon> pokemons = new ArrayList<>();


    /* --- Constructor --- */

    public Player(Mail mail, String password) {
        this.mail = mail;
        this.password = password;
        this.account = generateAccount();
    }

    public Player(PhoneNumber phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.account = generateAccount();
    }

    public Player(Mail mail, PhoneNumber phoneNumber, String password) {
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.account = generateAccount();
    }


    /* --- Checkers --- */

    public boolean checkIdentity(Mail mail, String password) {
        return this.mail.equals(mail) && this.password.equals(password);
    }

    public boolean checkIdentity(PhoneNumber phoneNumber, String password) {
        return this.phoneNumber.equals(phoneNumber) && this.password.equals(password);
    }


    /* --- Setters --- */

    public boolean setMail(PhoneNumber phoneNumber, String password, Mail mail) {
        if (checkIdentity(phoneNumber, password)) {
            this.mail = mail;
            return true;
        }
        return false;
    }

    public boolean setPhoneNumber(Mail mail, String password, PhoneNumber phoneNumber) {
        if (checkIdentity(mail, password)) {
            this.phoneNumber = phoneNumber;
            return true;
        }
        return false;
    }


    /* --- Getters --- */

    public String getAccount() {
        return account;
    }

    public Mail getMail() {
        return mail;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }


    /* --- Account Generator --- */

    public String generateAccount() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append((int) (Math.random() * 10));
        }
        if (sb.charAt(0) == '0') {
            sb.setCharAt(0, '1');
        }
            return sb.toString();
    }


    /* --- Change Password --- */

    public boolean changePassword(PhoneNumber phoneNumber, String oldPassword, String newPassword) {
        if (checkIdentity(phoneNumber, oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    public boolean changePassword(Mail mail, String oldPassword, String newPassword) {
        if (checkIdentity(mail, oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }


    /* --- Add Pokemon --- */

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }
}


class Mail {
    String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mail mail1 = (Mail) o;
        return Objects.equals(this.mail, mail1.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }
}


class PhoneNumber {
    String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber phoneNumber1 = (PhoneNumber) o;
        return Objects.equals(this.phoneNumber, phoneNumber1.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }
}

