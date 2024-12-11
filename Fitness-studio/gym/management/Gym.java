package gym.management;

import gym.customers.Person;

public class Gym {
    private static Gym instance;
    private Secretary secretary;
    private int salary;

    private Gym(){}
    public static Gym getInstance(){
        if(instance == null){
            instance = new Gym();
        }
        return instance;
    }

    public void setName() {
    }

    public Secretary setSecretary(Person p, int salary) {
        this.secretary = (Secretary) p;
        this.salary = salary;
        return secretary;
    }
    public static Secretary getSecretary() {
        return instance.secretary;
    }
}
