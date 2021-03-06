package EmailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity =500;
    private int defaultPasswordLength=10;
    private String alternateEmail;
    private String companyNameSuffix = "eas.com";

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is "+ this.password);

        //Combine elements to generate an email
        email=firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." +companyNameSuffix;

    }

    private String setDepartment(){
        System.out.println("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int departmentChoiceNum = in.nextInt();

        if(departmentChoiceNum ==1){
            return "sales";
        } else if(departmentChoiceNum == 2){
            return "dev";
        } else if(departmentChoiceNum ==3){
            return "accounting";
        } else {
            return "none";
        }
    }


    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVXYZ123456789!@#$%";
        char[] password = new char[length];
        for (int i =0; i< length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return new String(password);

    }

    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail= alternateEmail;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Display name: " + firstName + " " + lastName
                + "\nCompany email: " + email +
                "\nMailbox capacity: " + mailboxCapacity;
    }

}
