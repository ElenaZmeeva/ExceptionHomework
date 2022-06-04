package com.company;

public class Main {

    public static void main(String[] args) {
boolean result = Validator.check("fdaaw", "oiugt5", "oiugt5");
if (result){
    System.out.println("Поздравляем!");
}else {
    System.out.println("Попробуйте снова");
}

    }
}
