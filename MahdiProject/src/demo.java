import java.util.*;

/**
 * This class is for project.
 *
 * @author Ali Badiee
 * @version 2.3
 */

public class demo {
    /**
     * Initialize class variables in private and static
     */
    private static Map<Person, String> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static String mode;
    private static Club club = new Club();
    private static Customer customer;
    private static ClubManager clubManager;

    /**
     * main method
     */
    public static void main(String[] args) throws InvalidNumberCharacters, InvalidNumberLength, InvalidScore, InvalidYear, DuplicatedElement {
        defaults();

        // Customer: user = alibad , pass = 1234
        // Club Manager: user = rezabad , pass = 1234
        if (login())
            menu();
    }

    /**
     * defaults method to create default variables
     */
    public static void defaults() throws InvalidNumberCharacters, InvalidNumberLength, InvalidScore, InvalidYear {
        // default customers and manager
        Customer cst1 = new Customer("alibad", "Ali", "Badiee", "1243465789", "09151234567");
        Customer cst2 = new Customer("mohammadbad", "Mohammad", "Badiee", "1241234572", "09111234567");
        Customer cst3 = new Customer("hamedbad", "Hamed", "Badiee", "1241234567", "09121234567");
        ClubManager clb = new ClubManager("rezabad", "Alireza", "Akbari", "1437654321", "09154567321");
        users.put(cst1, "1234");
        users.put(cst2, "1234");
        users.put(cst3, "1234");
        users.put(clb, "1234");

        // default actors
        Person actor1 = new Person("Matthew", "McConaughey");
        Person actor2 = new Person("Anne", "Hathaway");
        Person actor3 = new Person("Jessica", "Chastain");
        Movie movie1 = new Movie("Interstellar", new Person[]{actor1, actor2, actor3}, 8.6,
                new Person("Christopher", "Nolan"), new Person("Christopher", "Nolan"), 2014);

        Person actor4 = new Person("Christian", "Bale");
        Person actor5 = new Person("Heath", "Ledger");
        Person actor6 = new Person("Michel", "Caine");
        Movie movie2 = new Movie("The Dark Knight", new Person[]{actor4, actor5, actor6}, 9,
                new Person("Christopher", "Nolan"), new Person("Christopher", "Nolan"), 2008);

        // add customers and movies
        club.customers.add(cst1);
        club.customers.add(cst2);
        club.customers.add(cst3);
        club.movies.add(movie1);
        club.movies.add(movie2);
    }

    /**
     * login method
     */
    public static boolean login() {
        System.out.println("*** Welcome To Club Manager ***");
        System.out.print("+ LOGIN +\n\nEnter your username > ");
        String username = scanner.next();
        System.out.print("Enter your password > ");
        String password = scanner.next();

        // check for every person with this credentials
        for (Person user : users.keySet()) {
            if (user.getUsername().equals(username) && users.get(user).equals(password)) {
                // figure out if is person is customer
                if (user instanceof Customer) {
                    mode = "Customer";
                    customer = (Customer) user;


                } else { // figure out if is person is Club Manager
                    mode = "ClubManager";
                    clubManager = (ClubManager) user;
                }
                return true;
            }
        }
        // exit the program
        System.out.println("Username or password is wrong !\nExiting ...");
        return false;

    }

    /**
     * menu method
     */
    public static void menu() throws InvalidNumberCharacters, InvalidNumberLength, DuplicatedElement, InvalidScore, InvalidYear {
        System.out.println("+ Main +");

        // if this person is customer
        if (mode.equals("Customer")) {
            String request = "";
            while (!request.equals("4")) { // while not exit
                System.out.print("\n- Choose a option:\n\n1. Movies List\n2. Search A Movie\n3. Edit My Information\n" +
                        "4. Exit\n > ");
                // first request
                request = scanner.next();
                // sub requests
                String subrequest;

                switch (request) {
                    case "1": // see movies list
                        System.out.printf("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n\n", "Name", "IMDBScore", "Year",
                                "Producer", "Director", "Rent", "Rent To", "Actors");
                        for (Movie movie : club.movies)
                            System.out.print(movie);
                        break;

                    case "2": // search movies with modes
                        System.out.print("\n-- Choose a option:\n\n1. Search by name\n2. Search by director\n3. Back\n > ");
                        subrequest = scanner.next();
                        scanner = new Scanner(System.in);

                        if (Objects.equals(subrequest, "1")) {
                            System.out.print("Enter the movie name > ");
                            String name = scanner.nextLine();
                            club.findMovie("name", name);

                        } else if (Objects.equals(subrequest, "2")) {
                            System.out.print("Enter the movie director full name > ");
                            String director = scanner.nextLine();
                            club.findMovie("director", director);
                        }
                        break;

                    case "3": // edit customer information
                        scanner = new Scanner(System.in);
                        System.out.print("Enter your first name > ");
                        customer.setFirstName(scanner.nextLine());
                        System.out.print("Enter your last name > ");
                        customer.setLastName(scanner.nextLine());
                        System.out.print("Enter your number ID > ");
                        customer.setNumberID(scanner.nextLine());
                        System.out.print("Enter your phone number > ");
                        customer.setPhoneNumber(scanner.nextLine());
                        System.out.println("\nDone! Your new credentials are:");
                        System.out.printf("%-20s | %-20s | %-20s\n", "Full Name", "Number ID", "Phone Number");
                        System.out.println(customer);
                        break;
                    case "4":
                        break;

                    default:
                        System.out.println("Wrong input !");
                }
            }

        } else { // if this person is manager
            String request = "";
            while (!request.equals("10")) {
                System.out.print("\n- Choose a option:\n\n1. Add A Movie\n2. Add A Customer\n3. Movies List\n" +
                        "4. Customers List\n5. Search A Movie\n6. Search A Customer\n7. Rent A Movie\n8. Return A Movie\n" +
                        "9. Report\n10. Exit\n > ");
                // first request
                request = scanner.next();
                // sub requests
                String subrequest;

                switch (request) {
                    case "1": // add a movie
                        scanner = new Scanner(System.in);

                        // get name
                        System.out.print("Enter the movie name > ");
                        String nameMovie = scanner.nextLine();

                        // get actors
                        System.out.print("Enter the name of 3 movie actors separating with ',' > ");
                        String[] actors = scanner.nextLine().replace(", ", ",").replace(" ,", "").split(",");
                        Person[] actorsP = new Person[3];

                        for (int i = 0; i < 3; i++) {
                            String[] fullName = actors[i].split(" ");
                            actorsP[i] = new Person(fullName[0], fullName[1]);
                        }

                        // get IMDB score
                        System.out.print("Enter the IMDB score > ");
                        double score = scanner.nextDouble();

                        // get year
                        System.out.print("Enter the movie year > ");
                        int year = scanner.nextInt();

                        // get producer
                        scanner = new Scanner(System.in);
                        System.out.print("Enter the producer name > ");
                        String[] producerL = scanner.nextLine().split(" ");

                        // get director
                        System.out.print("Enter the director name > ");
                        String[] directorL = scanner.nextLine().split(" ");

                        // add this movie
                        clubManager.addMovie(club.movies, nameMovie, actorsP, score, new Person(producerL[0], producerL[1]),
                                new Person(directorL[0], directorL[1]), year);
                        break;

                    case "2": // add customer
                        // get username
                        System.out.print("Enter the username > ");
                        String username = scanner.next();

                        // get first name
                        scanner = new Scanner(System.in);
                        System.out.print("Enter the first name > ");
                        String firstName = scanner.nextLine();

                        // get last name
                        System.out.print("Enter the last name > ");
                        String lastName = scanner.nextLine();

                        // get number ID
                        System.out.print("Enter the number ID > ");
                        String numberID = scanner.next();

                        // get phone number
                        System.out.print("Enter the phone number > ");
                        String phoneNumber = scanner.next();

                        // add a customer
                        clubManager.addCostumer(club.customers, username, firstName, lastName, numberID, phoneNumber);
                        break;

                    case "3":  // see movies list
                        System.out.printf("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n\n", "Name", "IMDBScore", "Year",
                                "Producer", "Director", "Rent", "Rent To", "Actors");
                        for (Movie movie : club.movies)
                            System.out.print(movie);
                        break;

                    case "4":  // see customers list
                        System.out.printf("%-20s | %-20s | %-20s | %-20s\n\n", "Username", "Full Name", "Number ID", "Phone Number");
                        for (Customer customer : club.customers)
                            System.out.print(customer);
                        break;

                    case "5": // search movies with modes
                        System.out.print("\n-- Choose a option:\n\n1. Search by name\n2. Search by director\n3. Back\n > ");
                        subrequest = scanner.next();
                        scanner = new Scanner(System.in);

                        if (Objects.equals(subrequest, "1")) {
                            System.out.print("Enter the movie name > ");
                            String name = scanner.nextLine();
                            club.findMovie("name", name);

                        } else if (Objects.equals(subrequest, "2")) {
                            System.out.print("Enter the movie director full name > ");
                            String director = scanner.nextLine();
                            club.findMovie("director", director);
                        }
                        break;

                    case "6": // search customers with modes
                        System.out.print("\n-- Choose a option:\n\n1. Search by name\n2. Search by number ID\n" +
                                "3. Search by phone number\n4. Back\n > ");
                        subrequest = scanner.next();

                        if (Objects.equals(subrequest, "1")) {
                            System.out.print("Enter the customer full name > ");
                            scanner = new Scanner(System.in);
                            String customerName = scanner.nextLine();
                            club.findCostumer("name", customerName);

                        } else if (Objects.equals(subrequest, "2")) {
                            System.out.print("Enter the customer number ID > ");
                            String CustomerID = scanner.next();
                            club.findCostumer("numberID", CustomerID);

                        } else if (Objects.equals(subrequest, "3")) {
                            System.out.print("Enter the customer phone number > ");
                            String CustomerID = scanner.next();
                            club.findCostumer("phoneNumber", CustomerID);
                        }
                        break;

                    case "7": // rent a movie
                        System.out.println("\n-- Choose a movie to rent: ");

                        // print all movies and ask to choose one
                        int x = 0;
                        for (Movie movie : club.movies) {
                            System.out.printf("%d) %s", x + 1, movie);
                            x++;
                        }
                        System.out.print("\n > ");

                        int index = scanner.nextInt();
                        if (index <= 0 || index > club.movies.size()) {
                            System.out.println("There is no such a movie !");
                            break;
                        }
                        Movie movie = club.movies.get(index);


                        System.out.println("\n-- Choose a customer:");

                        // print all customers and ask to choose one
                        x = 0;
                        for (Customer customer : club.customers) {
                            System.out.printf("%d) %s", x + 1, customer);
                            x++;
                        }
                        System.out.print("\n > ");

                        index = scanner.nextInt();

                        if (index <= 0 || index > club.customers.size()) {
                            System.out.println("There is no such a customer !");
                            break;
                        }
                        Customer customer = club.customers.get(index);

                        clubManager.rentMovie(movie, customer);
                        break;

                    case "8": // return a movie
                        System.out.println("\n-- Choose the movie to return:");
                        // print all films with rented preson ans ask to choose one to return
                        int y = 0;
                        for (Movie film : club.movies) {
                            if (film.isRent()) {
                                System.out.printf("%d) %s => %s", y + 1, film.getRentPerson().getFullName(),
                                        film.getName());
                                y++;
                            }
                        }

                        if (y == 0) {
                            System.out.println("No one rent any movie yet !");
                            break;
                        }

                        System.out.print("\n > ");

                        index = scanner.nextInt();

                        if (index <= 0 || index > y) {
                            System.out.println("There is no such a request !");
                            break;
                        }
                        clubManager.returnMovie(club.movies.get(index));
                        break;

                    case "9": // get the report of program actions with renting
                        club.report();
                        break;

                    case "10": // exit
                        break;

                    default: // if entered string is wrong
                        System.out.println("Wrong input !");
                }
            }
        }
        // in case of exiting
        System.out.println("Have a good day !");
    }
}

/**
 * This class represents a person.
 */
class Person {
    /**
     * Initialize object variables in private
     */
    private String firstName;
    private String lastName;
    private String numberID;
    private String phoneNumber;
    private String username;

    /**
     * Initialize empty constructor method
     */
    Person() {
    }

    /**
     * Initialize constructor method with first name and last name for director, producer and actors
     *
     * @param firstName String value of first name of the person
     * @param lastName  String value of last name of the person
     */
    Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    /**
     * Initialize constructor method with full information for customers and managers
     *
     * @param firstName   String value of first name of the person
     * @param lastName    String value of last name of the person
     * @param numberID    String value of number ID of the person
     * @param phoneNumber String value of phone number of the person
     */
    public Person(String firstName, String lastName, String numberID, String phoneNumber) throws InvalidNumberCharacters,
            InvalidNumberLength {
        setFirstName(firstName);
        setLastName(lastName);
        setNumberID(numberID);
        setPhoneNumber(phoneNumber);
    }

    /**
     * Getter method for person's username
     *
     * @return A string value of person's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter method for person's full name (first name + last name)
     *
     * @return A string value of person's full name
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Getter method for person's first name
     *
     * @return A string value of person's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter method for person's last name
     *
     * @return A string value of person's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter method for person's number ID
     *
     * @return A string value of person's number ID
     */
    public String getNumberID() {
        return numberID;
    }

    /**
     * Getter method for person's phone number
     *
     * @return A string value of person's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter method for person's first name
     *
     * @param firstName A String value for person's first name
     */
    public void setFirstName(String firstName) {
        // upper case the first letter of the first name
        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
    }

    /**
     * Setter method for person's last name
     *
     * @param lastName A String value for person's last name
     */
    public void setLastName(String lastName) {
        // upper case the first letter of the last name
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
    }

    /**
     * Setter method for person's number ID,
     * also checks if given number id is numbric and is exactly 10 characters
     *
     * @param numberID A String value for person's number ID
     */
    public void setNumberID(String numberID) throws InvalidNumberLength, InvalidNumberCharacters {
        // if length of number id is not 10
        if (numberID.length() != 10) // throw exception
            throw new InvalidNumberLength("The number id length must be 10 !");

            // if number id characters are not all numbers
        else if (!isNumeric(numberID)) // throw exception
            throw new InvalidNumberCharacters("The number id is not numeric !");

        else
            this.numberID = numberID;
    }

    /**
     * Setter method for person's phone number,
     * also checks if given phone number is numbric and is exactly 11 characters (without +98)
     *
     * @param phoneNumber A String value for person's phone number
     */
    public void setPhoneNumber(String phoneNumber) throws InvalidNumberLength, InvalidNumberCharacters {
        // replace +98 with 0 in phone number characters
        phoneNumber = phoneNumber.replace("+98", "0");

        // if length of number phone is not 11
        if (phoneNumber.length() != 11) // throw exception
            throw new InvalidNumberLength("The number id length must be 11 (starting with 0) !");

            // if number phone characters are not all numbers
        else if (!isNumeric(phoneNumber)) // throw exception
            throw new InvalidNumberCharacters("The number id is not numeric !");

        else {
            this.phoneNumber = phoneNumber;
        }
    }

    /**
     * method to check if the given string is all numbers and return the result
     *
     * @param str A String value to check it is all numbers
     * @return A boolean value of if string is all numbers or not
     */
    public static boolean isNumeric(String str) {
        // check if str is not null and matches the given regex
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }

    /**
     * toString method for getting string value of person information
     *
     * @return A string value of person information in table form
     */
    @Override
    public String toString() {
        return String.format("%-20s | %-20s | %-20s\n", getFullName(), numberID, phoneNumber);
    }
}

/**
 * This class represents a movie.
 */
class Movie {
    /**
     * Initialize object variables in private
     */
    private String name;
    private Person[] actors;
    private double IMDBScore;
    private Person producer;
    private Person director;
    private int year;
    private boolean rent;
    private Person lendPerson;

    /**
     * Initialize constructor method with full information for movie
     *
     * @param name      String value of name of the movie
     * @param actors    String array value of actors of the movie
     * @param IMDBScore double value of IMDBScore of the movie
     * @param producer  Person value of producer of the movie
     * @param director  Person value of director of the movie
     * @param year      int value of production year of the movie
     */
    public Movie(String name, Person[] actors, double IMDBScore, Person producer, Person director, int year) throws InvalidScore,
            InvalidYear {
        setName(name);
        setActors(actors);
        setIMDBScore(IMDBScore);
        setProducer(producer);
        setDirector(director);
        setYear(year);
    }

    /**
     * Initialize constructor method with full information for movie and rent status and lend Person
     *
     * @param name       String value of name of the movie
     * @param actors     String array value of actors of the movie
     * @param IMDBScore  double value of IMDBScore of the movie
     * @param producer   Person value of producer of the movie
     * @param director   Person value of director of the movie
     * @param year       int value of production year of the movie
     * @param rent       boolean value if this movie is rent to anyone
     * @param lendPerson Person value of the person who rent this movie
     */
    public Movie(String name, Person[] actors, double IMDBScore, Person producer, Person director, int year, boolean rent,
                 Person lendPerson) throws InvalidScore, InvalidYear {
        setName(name);
        setActors(actors);
        setIMDBScore(IMDBScore);
        setProducer(producer);
        setDirector(director);
        setYear(year);
        setRent(rent);
        setRentPerson(lendPerson);
    }

    /**
     * Getter method for movie's name
     *
     * @return A string value of movie's name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for movie's actors in array
     *
     * @return A string array value of movie's actors
     */
    public Person[] getActors() {
        return actors;
    }

    /**
     * Getter method for movie's IMDB score
     *
     * @return A double value of movie's IMDB score
     */
    public double getIMDBScore() {
        return IMDBScore;
    }

    /**
     * Getter method for movie's producer
     *
     * @return A Person value of movie's producer
     */
    public Person getProducer() {
        return producer;
    }

    /**
     * Getter method for movie's director
     *
     * @return A Person value of movie's director
     */
    public Person getDirector() {
        return director;
    }

    /**
     * Getter method for movie's production year
     *
     * @return An int value of movie's production year
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter method for movie's rent person
     *
     * @return A Person value of movie's rent person
     */
    public Person getRentPerson() {
        return lendPerson;
    }

    /**
     * Getter method for rent status of movie
     *
     * @return A boolean value of movie's rent status of movie
     */
    public boolean isRent() {
        return rent;
    }

    /**
     * Setter method for movie's name
     *
     * @param name A String value for movie's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for movie's actors in arrays
     *
     * @param actors A String array value for movie's actors
     */
    public void setActors(Person[] actors) {
        this.actors = actors;
    }

    /**
     * Setter method for movie's IMDB score,
     * also checks if score is between 0 and 10
     *
     * @param IMDBScore A double value for movie's IMDB score
     */
    public void setIMDBScore(double IMDBScore) throws InvalidScore {
        // check if score is between 0 and 10
        if (IMDBScore >= 0 && IMDBScore <= 10)
            this.IMDBScore = IMDBScore;
        else // throw exception
            throw new InvalidScore("IMDB score must be between 0 and 10 !");
    }

    /**
     * Setter method for movie's producer
     *
     * @param producer A Person value for movie's producer
     */
    public void setProducer(Person producer) {
        this.producer = producer;
    }

    /**
     * Setter method for movie's director
     *
     * @param director A Person value for movie's director
     */
    public void setDirector(Person director) {
        this.director = director;
    }

    /**
     * Setter method for movie's year,
     * also check if year is between 1900 and 2022
     *
     * @param year An int value for movie's year
     */
    public void setYear(int year) throws InvalidYear {
        // check if year is between 1900 and 2022
        if (year >= 1900 && year <= 2022)
            this.year = year;
        else // throw exception
            throw new InvalidYear("Year must be between 1900 and 2022 !");
    }

    /**
     * Setter method for movie's rent status
     *
     * @param rent A boolean value for movie's rent
     */
    public void setRent(boolean rent) {
        this.rent = rent;
    }

    /**
     * Setter method for movie's rent person
     *
     * @param lendPerson A Person value for movie's rent person
     */
    public void setRentPerson(Person lendPerson) {
        this.lendPerson = lendPerson;
    }

    /**
     * toString method for getting string value of movie information,
     * it defines a String array of names of actors first, then return the values
     *
     * @return A string value of movie information in table form
     */
    @Override
    public String toString() {
        // string array for actors names
        String[] actorsName = new String[3];
        for (int i = 0; i < 3; i++) { // get each actor full name and add to array
            actorsName[i] = actors[i].getFullName();
        }
        return String.format("%-20s | %-20.1f | %-20d | %-20s | %-20s | %-20b | %-20s | %-20s\n", name,
                IMDBScore, year, producer.getFullName(), director.getFullName(), rent,
                lendPerson == null ? "-" : lendPerson.getFullName(), Arrays.toString(actorsName));
    }

    /**
     * Override equals method for this object,
     *
     * @param obj An object to be checked if it's equal to this object of this class
     * @return true if this object is equal to param's object
     */
    @Override
    public boolean equals(Object obj) {
        // self check
        if (this == obj)
            return true;
        // null check
        if (obj == null)
            return false;
        // type check and cast
        if (getClass() != obj.getClass())
            return false;
        Movie newMovie = (Movie) obj;
        // field comparison
        return Objects.equals(name, newMovie.getName())
                && Objects.equals(director.getFullName(), newMovie.getDirector().getFullName());
    }
}

/**
 * This class represents a customer.
 */
class Customer extends Person {
    /**
     * Initialize class variable in private
     */
    private static int ID = 0;

    /**
     * Initialize object variables in private
     */
    private final int id;
    private final String username;

    /**
     * Initialize constructor method with full information for customers,
     * program gives each new instance a unique id
     *
     * @param username    String value of username of the customer
     * @param firstName   String value of first name of the customer
     * @param lastName    String value of last name of the customer
     * @param numberID    String value of number ID of the customer
     * @param phoneNumber String value of phone number of customer
     */
    public Customer(String username, String firstName, String lastName, String numberID, String phoneNumber) throws InvalidNumberCharacters, InvalidNumberLength {
        super(firstName, lastName, numberID, phoneNumber);
        this.username = username;
        id = ID++;
    }

    /**
     * Getter method for customer's username
     *
     * @return A string value of customer's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * toString method for getting string value of customer information
     *
     * @return A string value of customer information in table form
     */
    @Override
    public String toString() {
        return String.format("%-20s | %-20s | %-20s | %-20s\n", username, getFullName(), getNumberID(), getPhoneNumber());
    }

    /**
     * Override equals method for this object,
     *
     * @param obj An object to be checked if it's equal to this object of this class
     * @return true if this object is equal to param's object
     */
    @Override
    public boolean equals(Object obj) {
        // self check
        if (this == obj)
            return true;
        // null check
        if (obj == null)
            return false;
        // type check and cast
        if (getClass() != obj.getClass())
            return false;
        Customer newCustomer = (Customer) obj;
        // field comparison
        return Objects.equals(getUsername(), newCustomer.getUsername());
    }
}

/**
 * This class represents a club manager.
 */
class ClubManager extends Person {
    /**
     * Initialize object variable in private
     */
    private final String username;

    /**
     * Initialize constructor method with full information for customers,
     * program gives each new instance a unique id
     *
     * @param username    String value of username of the club manager
     * @param firstName   String value of first name of the club manager
     * @param lastName    String value of last name of the club manager
     * @param numberID    String value of number ID of the club manager
     * @param phoneNumber String value of phone number of club manager
     */
    public ClubManager(String username, String firstName, String lastName, String numberID, String phoneNumber) throws InvalidNumberCharacters,
            InvalidNumberLength {
        super(firstName, lastName, numberID, phoneNumber);
        this.username = username;
    }

    /**
     * Getter method for club manager's username
     *
     * @return A string value of club manager's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * method to add a movie to movies
     *
     * @param movies    ArrayList value of movies made till now
     * @param name      String value of name of the movie
     * @param actors    String array value of actors of the movie
     * @param IMDBScore double value of IMDBScore of the movie
     * @param producer  Person value of producer of the movie
     * @param director  Person value of director of the movie
     * @param year      int value of production year of the movie
     */
    public void addMovie(ArrayList<Movie> movies, String name, Person[] actors, double IMDBScore, Person producer, Person director, int year) throws DuplicatedElement, InvalidScore, InvalidYear {
        // create a new movie
        Movie movie = new Movie(name, actors, IMDBScore, producer, director, year);

        // check if created movie is same as any other movies created before
        for (Movie m : movies) {
            if (m.equals(movie)) { // throw exception
                throw new DuplicatedElement("Movies list already have this movie !");
            }
        }
        System.out.println("Movie added to movies !");
        movies.add(movie);
    }

    /**
     * method to add a movie to movies
     *
     * @param movies ArrayList value of movies made till now
     * @param movie  Movie value of new movie
     */
    public void addMovie(ArrayList<Movie> movies, Movie movie) throws DuplicatedElement {
        // check if created movie is same as any other movies created before
        for (Movie m : movies) {
            if (m.equals(movie)) { // throw exception
                throw new DuplicatedElement("Movies list already have this movie !");
            }
        }
        System.out.println("Movie added to movies !");
        movies.add(movie);
    }

    /**
     * method to add a customer to customers
     *
     * @param customers   ArrayList value of customer made till now
     * @param username    String value of username of the customer
     * @param firstName   String value of first name of the customer
     * @param lastName    String value of last name of the customer
     * @param numberID    String value of number ID of the customer
     * @param phoneNumber String value of phone number of customer
     */
    public void addCostumer(ArrayList<Customer> customers, String username, String firstName, String lastName, String numberID,
                            String phoneNumber) throws DuplicatedElement, InvalidNumberCharacters, InvalidNumberLength {
        // create a new customer
        Customer customer = new Customer(username, firstName, lastName, numberID, phoneNumber);

        // check if created customer is same as any other customers created before
        for (Customer c : customers) {
            if (c.equals(customer)) { // throw exception
                throw new DuplicatedElement("Costumers list already have this costumer !");
            }
        }
        System.out.println("Customer added to customers !");
        customers.add(customer);
    }

    /**
     * method to add a customer to customers
     *
     * @param customers ArrayList value of customer made till now
     * @param customer  Customer value of new customer
     */
    public void addCostumer(ArrayList<Customer> customers, Customer customer) throws DuplicatedElement {
        // check if created customer is same as any other customers created before
        for (Customer c : customers) {
            if (c.equals(customer)) { // throw exception
                throw new DuplicatedElement("Costumers list already have this costumer !");
            }
        }
        System.out.println("Customer added to customers !");
        customers.add(customer);
    }

    /**
     * method to rent a movie for a customer
     *
     * @param movie    A Movie value for movie
     * @param customer A Customer value for customer
     */
    public void rentMovie(Movie movie, Customer customer) {
        // set the rent person and change status of renting
        movie.setRentPerson(customer);
        movie.setRent(true);
        System.out.printf("%s rented for %s !\n", movie.getName(), customer.getFullName());
    }

    /**
     * method to return a movie
     *
     * @param movie A Movie value for movie
     */
    public void returnMovie(Movie movie) {
        // clear the rent person and status of renting
        movie.setRentPerson(null);
        movie.setRent(false);
        System.out.println("Movie returned !");
    }
}

/**
 * This class represents a club.
 */
class Club {
    /**
     * Initialize object variables in private to keep created movies and customers
     */
    ArrayList<Movie> movies = new ArrayList<Movie>();
    ArrayList<Customer> customers = new ArrayList<Customer>();

    /**
     * method to find a movie with name or name of the director
     *
     * @param mode  String value of mode which program should search by
     * @param value String value of what to be searched
     */
    public void findMovie(String mode, Object value) {
        if ("name".equals(mode)) {
            // check for every movie to find which one has the same name, print
            for (Movie movie : movies) {
                if (movie.getName().equals(value)) {
                    System.out.println("Movie found !");
                    System.out.printf("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n", "Name", "IMDBScore", "Year",
                            "Producer", "Director", "Rent", "Rent To", "Actors");
                    System.out.print(movie);
                    return;
                }
            }
        } else if ("director".equals(mode)) {
            // check for every movie to find which one has the same director, print
            for (Movie movie : movies) {
                if (movie.getDirector().getFullName().equals(value)) {
                    System.out.println("Movie found !");
                    System.out.printf("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n", "Name", "IMDBScore", "Year",
                            "Producer", "Director", "Rent", "Rent To", "Actors");
                    System.out.print(movie);
                    return;
                }
            }
        }
        // if couldn't find any one
        System.out.println("No Movie found !");
    }

    /**
     * method to find a movie with name or number ID or phone number
     *
     * @param mode  String value of mode which program should search by
     * @param value String value of what to be searched
     */
    public void findCostumer(String mode, Object value) {
        if ("name".equals(mode)) {
            // check for every customer to find which one has the same name, print
            for (Customer customer : customers) {
                if (customer.getFullName().equals(value)) {
                    System.out.println("User found !");
                    System.out.printf("%-20s | %-20s | %-20s | %-20s\n\n", "Username", "Full Name", "Number ID", "Phone Number");
                    System.out.print(customer);
                    break;
                }
            }
        } else if ("numberID".equals(mode)) {
            // check for every customer to find which one has the same number ID, print
            for (Customer customer : customers) {
                if (customer.getNumberID().equals(value)) {
                    System.out.println("User found !");
                    System.out.printf("%-20s | %-20s | %-20s | %-20s\n\n", "Username", "Full Name", "Number ID", "Phone Number");
                    System.out.print(customer);
                    break;
                }
            }
        } else if ("phoneNumber".equals(mode)) {
            // check for every customer to find which one has the same phone number, print
            for (Customer customer : customers) {
                if (customer.getPhoneNumber().equals(value)) {
                    System.out.println("User found !");
                    System.out.printf("%-20s | %-20s | %-20s | %-20s\n\n", "Username", "Full Name", "Number ID", "Phone Number");
                    System.out.print(customer);
                    break;
                }
            }
        }
        // if couldn't find any one
        System.out.println("No User found !");
    }

    /**
     * method to print a report of movies rented by customers
     */
    public void report() {
        System.out.println("- Report of customer who rent a movie:");
        int x = 0;
        for (Movie movie : movies) {
            if (movie.isRent()) { // check if movie is rented
                // print the values
                System.out.printf("%d) %s > %s%n", x + 1, movie.getRentPerson().getFullName(), movie.getName());
                x++;
            }
        }
        // if there is no customer
        if (x == 0)
            System.out.println("No customer rented any movie yet !");
    }
}

/**
 * This Exception class use for invalid number lengths.
 */
class InvalidNumberLength extends Exception {
    // empty constructor
    public InvalidNumberLength() {
        super();
    }

    // constructor with message
    public InvalidNumberLength(String message) {
        super(message);
    }
}

/**
 * This Exception class use for invalid number characters.
 */
class InvalidNumberCharacters extends Exception {
    // empty constructor
    public InvalidNumberCharacters() {
        super();
    }

    // constructor with message
    public InvalidNumberCharacters(String message) {
        super(message);
    }
}

/**
 * This Exception class use for invalid score.
 */
class InvalidScore extends Exception {
    // empty constructor
    public InvalidScore() {
        super();
    }

    // constructor with message
    public InvalidScore(String message) {
        super(message);
    }
}

/**
 * This Exception class use for invalid year.
 */
class InvalidYear extends Exception {
    // empty constructor
    public InvalidYear() {
        super();
    }

    // constructor with message
    public InvalidYear(String message) {
        super(message);
    }
}

/**
 * This Exception class use for duplicated elements of array or array list.
 */
class DuplicatedElement extends Exception {
    // empty constructor
    public DuplicatedElement() {
        super();
    }

    // constructor with message
    public DuplicatedElement(String message) {
        super(message);
    }
}

///////////////////////

//        mode = "Customer";
//        customer = new Customer("alibad", "Ali", "Badiee", "1273465789", "09101234567");
//        mode = "ClubManager";
//        clubManager = new ClubManager("rezabad", "Alireza", "Akbari", "1277654321", "09134567321");