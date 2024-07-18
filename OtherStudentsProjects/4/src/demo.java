class Film {
    // initialize object variables
    private String name;
    private Man actor1;
    private Man actor2;
    private Man actor3;
    private int year;
    private float score;
    private Man director;
    private Man producer;

    // empty constructor
    public Film() {
    }

    // main constructor
    public Film(String name, int year, Man actor1, Man actor2, Man actor3, float IMDB, Man producer, Man director) {
        this.name = name;
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.actor3 = actor3;
        this.year = year;
        this.score = IMDB;
        this.producer = producer;
        this.director = director;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("Name = %s - Actors = %s, %s, %s - Year = %d - IMDB = %f - Producer = %s %s - Director = %s %s",
                name, actor1, actor2, actor3, year, score, producer.getName(), producer.getlastName(),
                director.getName(), director.getlastName());
    }

    // setter method for name of the film
    public void setName(String name) {
        this.name = name;
    }

    // setter method for year of the film
    public void setYear(int year) {
        this.year = year;
    }

    // setter method for director of the film
    public void setDirector(Man director) {
        this.director = director;
    }

    // setter method for producer of the film
    public void setProducer(Man producer) {
        this.producer = producer;
    }

    // setter method for first actor of the film
    public void setActor1(Man actor1) {
        this.actor1 = actor1;
    }

    // setter method for second actor of the film
    public void setActor2(Man actor2) {
        this.actor2 = actor2;
    }

    // setter method for third actor of the film
    public void setActor3(Man actor3) {
        this.actor3 = actor3;
    }

    // setter method for IMDB score of the film
    public void setScore(float score) {
        this.score = score;
    }

    // getter method for name of the film
    public String getName() {
        return name;
    }

    // getter method for year of the film
    public int getYear() {
        return year;
    }

    // getter method for IMDB score of the film
    public float getScore() {
        return score;
    }

    // getter method for first actor of the film
    public Man getActor1() {
        return actor1;
    }

    // getter method for second actor of the film
    public Man getActor2() {
        return actor2;
    }

    // getter method for third actor of the film
    public Man getActor3() {
        return actor3;
    }

    // getter method for director of the film
    public Man getDirector() {
        return director;
    }

    // getter method for producer of the film
    public Man getProducer() {
        return producer;
    }
}

class Man {
    // initialize object variables
    private String name;
    private String lastName;
    private String ID;
    private String phone;
    private int age;

    // constructor for naming the actors, director and producer
    public Man(String fullName) {
        String[] name = fullName.split(" ");
        this.name = name[0];
        this.lastName = name[1];
    }

    // constructor for people who we have their ID and age and phone
    public Man(String ID, String name, String lastName, int age, String phone) {
        setID(ID);
        this.name = name;
        this.lastName = lastName;
        setAge(age);
        setPhone(phone);
    }

    // toString method
    @Override
    public String toString() {
        return String.format("ID = %s - Name = %s %s - Phone = %s", ID, name, lastName, phone);
    }

    // setter method for name of the person
    public void setName(String name) {
        this.name = name;
    }

    // setter method for last name of the person
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // setter method for age of the person, checks if it's between 0 and 150
    public void setAge(int age) {
        if (age > 0 && age < 150)
            this.age = age;
        else {
            System.out.println("Age must be between 0 and 150 !");
            this.age = 1;
        }
    }

    // setter method for ID of the person, checks if it's 10 characters
    public void setID(String ID) {
        if (ID.length() != 10) {
            System.out.println("ID must be 10 numbers.");
            this.ID = "-";
        } else {
            this.ID = ID;
        }
    }

    // setter method for phone of the person, checks if it's starts with 0
    public void setPhone(String phone) {
        if (phone.startsWith("0")) {
            this.phone = phone;
        } else {
            System.out.println("Phone number must start with 0.");
            this.phone = "-";
        }
    }

    // getter method for name of the person
    public String getName() {
        return name;
    }

    // getter method for last name of the person
    public String getlastName() {
        return lastName;
    }

    // getter method for age of the person
    public int getAge() {
        return age;
    }

    // getter method for ID of the person
    public String getID() {
        return ID;
    }

    // getter method for phone of the person
    public String getPhone() {
        return phone;
    }
}

class Client extends Man {
    // initialize object variable
    Film rentFilm;

    // constructor method
    public Client(String ID, String name, String lastName, int age, String phone) {
        // send variables to base class with super.
        super(ID, name, lastName, age, phone);
    }

    // setter method for rent film of client
    public void setRentFilm(Film rentFilm) {
        this.rentFilm = rentFilm;
    }

    // getter method for rent film of client
    public Film getRentFilm() {
        return rentFilm;
    }

    // toString method
    @Override
    public String toString() {
        if (rentFilm == null)
            return String.format("ID = %s - Name = %s %s - Phone = %s", getID(), getName(), getlastName(), getPhone());
        else
            return String.format("ID = %s - Name = %s %s - Phone = %s - Rent = %s", getID(), getName(), getlastName(), getPhone(), rentFilm.getName());
    }
}

class Manager extends Man {
    // constructor method
    public Manager(String ID, String name, String lastName, int age, String phone) {
        super(ID, name, lastName, age, phone);
    }

    // toString method
    @Override
    public String toString() {
        return String.format("ID = %s - Name = %s %s - Phone = %s", getID(), getName(), getlastName(), getPhone());
    }

    // method to create a new film and put it in array, and return
    public Film[] createFilm(Film[] films, Film film) {
        for (Film f : films) {
            if (f.getName().equals(film.getName())) {
                System.out.println("This film is already in films.");
                return films;
            }
        }
        // new array with one more place
        Film[] newFilm = new Film[films.length + 1];
        // copy old info
        System.arraycopy(films, 0, newFilm, 0, films.length);
        // add the film to the new one
        newFilm[films.length] = film;
        System.out.println("Film created.");
        return newFilm;
    }

    // method to create a new client and put it in array, and return
    public Client[] createClient(Client[] clients, Client temp) {
        for (Client client : clients) {
            if (client.getID().equals(temp.getID())) {
                System.out.println("This client is already in clients.");
                return clients;
            }
        }
        // new array with one more place
        Client[] newClient = new Client[clients.length + 1];
        // copy old info
        System.arraycopy(clients, 0, newClient, 0, clients.length);
        // add the film to the new one
        newClient[clients.length] = temp;
        System.out.println("Client created.");
        return newClient;
    }

    // method to rent a film for client
    public void rentFilm(Client client, Film film) {
        client.setRentFilm(film);
    }

    // method to print report of the client and films
    public void reportFilm(Client[] clients) {
        System.out.println("\nReport:");
        for (Client client : clients) {
            if (client.getRentFilm() != null)
                System.out.printf("Client = %s %s - Rent Movie = %s\n", client.getName(), client.getlastName(), client.getRentFilm().getName());
        }
    }
}

public class demo {
    public static void main(String[] args) {
        // arrays to keep clients and films
        Client[] clients = new Client[0];
        Film[] films = new Film[0];

        // create a new manager for adding client, adding film, renting film and reporting
        Manager manager = new Manager("1281244124", "John", "Hale", 35, "09134567890");

        // create two new client
        Client newClient = new Client("1279843157", "Mohammad", "Hale", 30, "09134567891");
        Client newClient2 = new Client("1279843158", "Mohammad Ali", "Hale", 31, "09134567892");

        // create two new film with same actors
        Man actor1 = new Man("Bill Skarsgard");
        Man actor2 = new Man("Finn Wolfhard");
        Man actor3 = new Man("Sophia Lillis");
        Man producer = new Man("Dan Lin");
        Man director = new Man("Andrés Muschietti");
        Film film = new Film("IT", 2018, actor1, actor2, actor3, 7.3f, producer, director);
        Film film2 = new Film("IT2", 2020, actor1, actor2, actor3, 8.3f, producer, director);

        // create clients
        clients = manager.createClient(clients, newClient);
        clients = manager.createClient(clients, newClient2);

        // create films
        films = manager.createFilm(films, film);
        films = manager.createFilm(films, film); // duplicated film
        films = manager.createFilm(films, film2);

        // rent two film for two different client
        manager.rentFilm(newClient, film);
        manager.rentFilm(newClient2, film2);

        // print the report
        manager.reportFilm(clients);
    }
}