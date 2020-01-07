package com.littlepage.airplaneticketsystem.utils;

/**
 * validate the strings
 */
public class ValidateUtils {
    /**
     * special character
     */
    private static char[] oth = {'~','.','!','@','#','$','%','^','&','*','(',')'};

    /**
     * validate character
     * @param str
     * @return is or not special character
     */
    private static Boolean containsSpecialChar(char str){
        for (char c : oth) {
            if(c == str) return true;
        }
        return false;
    }

    /**
     * validate the password is or not correct
     * @param password
     * @return is or not correct password
     */
    public static boolean valiPassword(String password){
        boolean hasDigit = false,hasUpper = false,hasLower = false,specialChar = false;
        for(int i = 0; i < password.length(); i++){
            if(!(Character.isAlphabetic(password.charAt(i)) ||
                Character.isDigit(password.charAt(i)) ||
                    containsSpecialChar(password.charAt(i)))){
                return false;
            }else {
                if(Character.isUpperCase(password.charAt(i))) hasUpper = true;
                if(Character.isLowerCase(password.charAt(i))) hasLower = true;
                if(Character.isDigit(password.charAt(i))) hasDigit=true;
                if(containsSpecialChar(password.charAt(i))) specialChar = true;
            }
        }
        System.out.println(specialChar);
        return hasUpper && hasLower && hasDigit && specialChar;
    }

    /**
     * validate is or not correct username
     * @param username
     * @return is or not correct5 username
     */
    public static boolean valiUsername(String username) {
        for(int i = 0; i < username.length(); i++){
            if(!Character.isDigit(username.charAt(i)) &&
                    !Character.isAlphabetic(username.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
