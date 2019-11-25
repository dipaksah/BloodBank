package com.dipak.bloodbank;

public class LoginOperation {

    private String email;
    private String password;

    public LoginOperation(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Boolean login()
    {
        if (email.equals("dipak@gmail.com") && password.equals("dipak"))
        {
            return true;
        }else {
            return false;
        }
    }


}
