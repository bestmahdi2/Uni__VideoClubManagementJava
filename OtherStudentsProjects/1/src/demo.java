import java.util.Arrays;

public class demo {
    public static void main(String[] args) {
        Manager manager = new Manager("Ali", "khodaiee", "09127452131", "7893124512");

        manager.addCustomer("Alireza", "Yousefi", "09283217428", "1283213241");
        manager.customers[0].setCustomerCode(1);
        manager.addCustomer("Yegane", "Yousefi", "09365432511", "1285212412");
        manager.customers[1].setCustomerCode(2);

        String[] actors = {"Emilia Jones", "Eugenio", "Marlee Martlin"};
        manager.addFilm("Coda", actors, 8.1f, "Philippe Rousselet", "Sian Heder", 2021);

        String[] actors2 = {"Ray Romano", "John Lenguizamo", "Denis Leary"};
        manager.addFilm("Ice Age", actors2, 4.8f, "20th Century Studios", "John C. Donkin", 2022);
    }
}

class Human {
    private String name;
    private String familyName;
    private String nationalCode;
    private String phone;

    public Human() {
    }

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, String familyName, String phone, String nationalCode) {
        this.name = name;
        this.familyName = familyName;
        this.phone = phone;
        setNationalCode(nationalCode);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setNationalCode(String nationalCode) {
        if (nationalCode.length() == 10)
            this.nationalCode = nationalCode;
        else
            System.out.println("National code should be 10 !");
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Human: " + getName() + " " + getFamilyName() + ", " + getNationalCode() +
                ", " + getPhone();
    }
}

class Customer extends Human {
    private int customerCode;

    public Customer() {
    }

    public Customer(String name) {
        super(name);
    }

    public Customer(String name, String familyName, String phone, String nationalCode) {
        super(name, familyName, phone, nationalCode);
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    @Override
    public String toString() {
        return "Customer: " + getCustomerCode() + ", " + getName() + " " + getFamilyName() + ", National Code: " + getNationalCode() +
                ", Phone: " + getPhone();
    }
}

class Manager extends Human {
    private int managerCode;
    protected Film[] films = new Film[100];
    protected Customer[] customers = new Customer[100];

    public Manager() {
    }

    public Manager(String name) {
        super(name);
    }

    public Manager(String name, String familyName, String phone, String nationalCode) {
        super(name, familyName, phone, nationalCode);
    }

    public void setManagerCode(int managerCode) {
        this.managerCode = managerCode;
    }

    public int getManagerCode() {
        return managerCode;
    }

    public void addCustomer(String name, String familyName, String phone, String nationalCode) {
        Customer customer = new Customer(name, familyName, phone, nationalCode);
        boolean done = false;
        for (int i = 0; i < 100; i++) {
            if (customers[i] == null) {
                customers[i] = customer;
                done = true;
                break;
            }
        }

        if (done == true)
            System.out.println("New Customer added !");
        else
            System.out.println("Can't add any new customer !");
    }

    public void addFilm(String name, String[] actors, float IMDB, String producer, String director, int year) {
        Film film = new Film(name, actors, IMDB, producer, director, year);
        boolean done = false;
        for (int i = 0; i < 100; i++) {
            if (films[i] == null) {
                films[i] = film;
                done = true;
                break;
            }
        }

        if (done == true)
            System.out.println("New film added !");
        else
            System.out.println("Can't add any new film !");
    }


    @Override
    public String toString() {
        return "Manager: " + getManagerCode() + ", " + getName() + " " + getFamilyName() + ", National Code: " + getNationalCode() +
                ", Phone: " + getPhone();
    }
}

class Film {
    private String name;
    private String[] actors;
    private float IMDB;
    private String producer;
    private String director;
    private int year;

    public Film(String name) {
        this.name = name;
    }

    public Film(String name, String[] actors, float IMDB, String producer, String director, int year) {
        this.name = name;
        this.actors = actors;
        this.IMDB = IMDB;
        this.producer = producer;
        this.director = director;
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public String[] getActors() {
        return actors;
    }

    public void setIMDB(float IMDB) {
        this.IMDB = IMDB;
    }

    public float getIMDB() {
        return IMDB;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Film: " + getName() + ", Actors: " + Arrays.toString(getActors()) + ", IMDB: " + getIMDB() +
                ", Producer: " + getProducer() + ", Director: " + getDirector() + ", Year: " + getYear();
    }
}