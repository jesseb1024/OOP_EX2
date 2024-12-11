package gym.customers;

public class Client extends Person {
    private int age;
    private int balance;
    private Person client;

    public Client(Person person) {
        super(person.getName(), person.getBalance(), person.getGender(), person.getDoB());
        this.client=person;
    }

}
