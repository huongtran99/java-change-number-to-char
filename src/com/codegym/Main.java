package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số cần chuyển sang chữ");
        int number = scanner.nextInt();
        String result = "";
        if (isNumberHasOneCharacter(number)) {
            result = readNumberInUnit(number);
        } else if (isNumberHasTwoCharacter(number)) {
            result = readNumberHasTwoCharacter(number);
        } else if (isNumberHasThreeCharacter(number)) {
            result = readNumberHasThreeCharacter(number);
        } else {
            System.out.println("Out of range");
        }
        System.out.println(result);
    }

    public static boolean isNumberHasOneCharacter(int number){
        return number < 10 && number > 0;
    }

    public static boolean isNumberHasTwoCharacter(int number){
        return number >= 10 && number < 100;
    }

    public static boolean isNumberHasThreeCharacter(int number){
        return number >= 100 && number < 1000;
    }

    public static String readNumberHasThreeCharacter(int number) {
        String result = "";
        int hundred = number / 100;
        int dozen = (number % 100) / 10;
        int unit = (number % 100) % 10;
        if (unit == 0) {
            if (dozen == 0) {
                result = readNumberInHundred(hundred);
            } else {
                result = readNumberInHundred(hundred) + " " + readNumberInDozen(dozen);
            }
        } else {
            if (dozen == 0) {
                result = readNumberInHundred(hundred) + " linh " + readNumberInUnit(unit);
            } else {
                result = readNumberInHundred(hundred) + " " + readNumberInDozen(dozen) + " " + readNumberInUnit(unit);
            }
        }
        return result;
    }

    public static String readNumberHasTwoCharacter(int number) {
        String result = "";
        int dozen = number / 10;
        int unit = number % 10;
        if (unit == 0) {
            result = readNumberInDozen(dozen);
        } else {
            result = readNumberInDozen(dozen) + " " + readNumberInUnit(unit);
        }
        return result;
    }

    public static String readNumberInHundred(int number) {
        return readNumberInUnit(number) + " trăm";
    }

    public static String readNumberInDozen(int number) {
        if (number == 1) {
            return "mười";
        }
        return readNumberInUnit(number) + " mươi";
    }

    public static String readNumberInUnit(int number) {
        String result = "";
        switch (number) {
            case 1: {
                result = "một";
                break;
            }
            case 2: {
                result = "hai";
                break;
            }
            case 3: {
                result = "ba";
                break;
            }
            case 4: {
                result = "bốn";
                break;
            }
            case 5: {
                result = "năm";
                break;
            }
            case 6: {
                result = "sáu";
                break;
            }
            case 7: {
                result = "bảy";
                break;
            }
            case 8: {
                result = "tám";
                break;
            }
            case 9: {
                result = "chín";
                break;
            }
        }
        return result;
    }
}