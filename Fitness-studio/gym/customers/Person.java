package gym.customers;

import gym.management.Gender;
import java.time.Period;
import java.time.LocalDate;

public class Person {
    private String name;
    private String dOb;
    private Gender gender;
    private int balance;
    private String notifications;
    private LocalDate currentDate=LocalDate.now();

    public Person(String name,int balance, Gender gender, String dOb) {
        this.name = name;
        this.gender = gender;
        this.dOb = dOb;
        this.balance = balance;
    }
    public String getName() {
        return name;

    }
    public Gender getGender() {
        return gender;
    }
    public String getDoB() {
        return dOb;
    }
    public int getBalance(){
        return balance;
    }

    public String getNotifications() {
        return notifications;
    }
    public double getAge(){
        LocalDate dOb = LocalDate.parse(this.dOb);
        Period period = Period.between(this.currentDate,dOb);
        return period.getYears();
    }
}

