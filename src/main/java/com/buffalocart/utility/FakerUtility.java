package com.buffalocart.utility;

import com.github.javafaker.Faker;

public class FakerUtility {
    Faker faker=new Faker();
    public String userName(){
       String uname= faker.name().username();
        return uname;
    }
    public String password(){
        String pass= faker.internet().password();
        return pass;
    }
    public String emailId(){
        String mail=faker.internet().emailAddress();
        return mail;
    }
}
