package gym.management;
import gym.customers.Client;
import gym.customers.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.Period;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionType;
import gym.management.exceptions.ClientNotRegisteredException;
import gym.management.exceptions.DuplicateClientException;
import gym.management.exceptions.InstructorNotQualifiedException;
import gym.management.exceptions.InvalidAgeException;

import javax.naming.InvalidNameException;


public class Secretary extends Person{
    private ArrayList<Instructor> instructors;
    private ArrayList<SessionType> instructorAllowed;
    private ArrayList<Client> clients;
    private SessionType sessionType;
    private Client client;
    private Session session;
    private Instructor instructor;
    private ArrayList<Client> lesson;
    private LocalDate date;
    private String secMessage;
    private ForumType f;
    private String sessionTime;

    public Secretary(String name, int balance, Gender gender, String dOb) {
        super(name, balance, gender, dOb);
    }

    public Client registerClient(Person person) throws InvalidAgeException, DuplicateClientException {
        if(person.getAge()<18) {
            throw new InvalidAgeException("Client must be at least 18 years old to register");
        } else if (clients.contains(person)) {
            throw new DuplicateClientException("The client is already registered");
        }
        this.client = new Client(person);
        this.clients.add(client);

        return client;
    }

    public void unregisterClient(Client c) throws ClientNotRegisteredException {
        if(!clients.contains(c)) {
            throw new ClientNotRegisteredException("Registration is required before attempting to unregister");
        }
        this.clients.remove(c);
    }


    public Instructor hireInstructor(Person p, int salary, ArrayList<SessionType> sessionTypes) {
        this.instructor = new Instructor(p, salary, sessionTypes);
        return instructor;
    }

    public void removeInstructor(Instructor i) {
        this.instructors.remove(i);
    }

    public void registerClientToLesson(Client c, Session s) {
        this.session = s;
        this.client = c;
        lesson.add(c);
    }
    public Session addSession(SessionType s, String time, ForumType a, Instructor i) throws InstructorNotQualifiedException {
        this.f=a;
        this.sessionType=s;
        this.instructor=i;
        this.sessionTime=time;
        return session;
    }
    public String notify(Session se, String st){
        this.session=se;
        this.secMessage=st;
        return secMessage;
    }
    public String notify(String date, String st){
        date = this.date.toString();
        this.secMessage=st;
        return secMessage;
    }
    public String notify(String st){
        this.secMessage=st;
        return secMessage;
    }
    public void paySalaries(){

    }
    public void printActions(){

    }

}

