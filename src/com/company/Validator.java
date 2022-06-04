package com.company;

import javax.security.auth.login.LoginException;
import java.util.Objects;

public class Validator {
    private Validator(){

    }
    public static final String validSymbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    public static boolean check(String login, String password, String confirmPassword) {
        try{
            validate(login, password, confirmPassword);
            return true;
        }catch (LoginException e){
        }catch (PasswordException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public static void validate (String login, String password, String confirmPassword) throws LoginException, PasswordException{

        if (Objects.isNull(login)|| login.length()>20||!containsValidSymbols(login))  {
            throw new LoginException("Длина логина должна быть меньше или равно 20");
        }
        if (!containsValidSymbols(login)){
            throw new LoginException("Логин содержит не допустимые символы");
        }
        if (Objects.isNull(password)|| password.length()<20||!containsValidSymbols(password)){
            throw new PasswordException("Длина пароля должна быть меньше 20");
        }
        if (!password.equals(confirmPassword)){
            throw new PasswordException("Пароли не совпадают");
        }
    }

    public static boolean containsValidSymbols(String s){
        char [] symbols =s.toCharArray();
        for ( char symbol :symbols){
            if (!validSymbols.contains(String.valueOf(symbol))) {
                continue;
            }
            return false;
        }
        return true;
    }

}
