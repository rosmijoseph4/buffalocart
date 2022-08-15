package com.buffalocart.utility;

import com.github.javafaker.Faker;

public class FakerUtility {
    Faker faker=new Faker();
    public String userName(){
       String u_name= faker.name().username();
        return u_name;
    }
    public String password(){
        String pass_word= faker.internet().password();
        return pass_word;
    }
    public String emailId(){
        String mail=faker.internet().emailAddress();
        return mail;
    }
    public String emailIdNew(){
        String newmail=faker.internet().emailAddress();
        return newmail;
    }
    public String contactNumber(){
        String cnumber=faker.phoneNumber().cellPhone();
        return cnumber;
    }
    public String firstName(){
        String fname=faker.name().firstName();
        return fname;
    }
    public String lastName(){
        String lname=faker.name().lastName();
        return lname;
    }
    public String prefix(){
        String pre_fix=faker.name().prefix();
        return pre_fix;
    }
    public String role(){
        String userrole=faker.job().position();
        return userrole;
    }
    public String roleNew(){
        String newrole=faker.job().position();
        return newrole;
    }
    public String salesDecimalNumber(){
        Double num=faker.number().randomDouble(2,10,50);
        String val=String.valueOf(num);
        if(val.length()==4){
            val.concat("0");
        }
        return val;
    }

}
