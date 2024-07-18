// import needed libraries
import java.util.ArrayList;
import java.util.Scanner;

// demo class
public class demo {
    static boolean isAdmin = true; // if admin is using this program
    static boolean continues = true; // if program can continue
    // define default admin or user
    static Admin defaultAdmin = new Admin("5129651251", "Nick", "Fiori", 45, "+1 512 789 4213");
    static User defaultUser = new User();

    // main method
    public static void main(String[] args) {
        Admin.users.add(defaultUser); // add default user to users of Admin class

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To Program !");
        System.out.print("\nWhat can I do for you ? ");

        while (continues) { // repeat the loop forever
            if (isAdmin) { // if admin is using this program
                System.out.println("(You are default admin: " + defaultAdmin.getName() + ")");

                System.out.println("1)Add User\n2)Add Film\n3)Rent Film\n4)Give Films Report\n5)Search User\n6)Search Film\n0)Exit");
                menuAdmin(sc.nextInt()); // find if need to continue ot not

            } else { // if user is using this program
                if (defaultUser.getName().equals("guest")) // if user is guest
                    System.out.println("(You are guest)");
                else // if not
                    System.out.println("(You are default user: " + defaultUser.getName() + ")");

                System.out.println("1)Enter My Information\n2)Available Films\n0)Exit");
                menuUser(sc.nextInt()); // find if need to continue ot not
            }
        }
        // exit the program
        System.out.println("\nGood bye !");
    }

    // the menu of admins
    public static void menuAdmin(int input) {
        Scanner sc = new Scanner(System.in);

        switch (input) {
            case 0: // exit the program if enter 0
                continues = false;
                break;

            case 1:
                // get the new user information
                System.out.println("Enter user's name:");
                String name = sc.nextLine();

                System.out.println("Enter user's family:");
                String family = sc.nextLine();

                System.out.println("Enter user's ID:");
                String id = sc.nextLine();

                System.out.println("Enter user's number:");
                String number = sc.nextLine();

                System.out.println("Enter user's age:");
                int age = sc.nextInt();

                // add user to users, make this user the default user and print
                defaultAdmin.addUsers(id, name, family, age, number);
                defaultUser = Admin.users.get(Admin.users.size() - 1);
                System.out.println("User created:\n" + Admin.users.get(Admin.users.size() - 1) + "\n");
                break;

            case 2:
                // get the new film information
                System.out.println("Enter name of film:");
                String filmName = sc.nextLine();

                System.out.println("Enter name of 1st super star of film:");
                String superStar1 = sc.nextLine();

                System.out.println("Enter name of 2nd super star of film:");
                String superStar2 = sc.nextLine();

                System.out.println("Enter name of 3rd super star of film:");
                String superStar3 = sc.nextLine();

                System.out.println("Enter name of director of film:");
                String director = sc.nextLine();

                System.out.println("Enter name of producer of film:");
                String producer = sc.nextLine();

                System.out.println("Enter genre of film:");
                String genre = sc.nextLine();

                System.out.println("Enter year of film:");
                int filmYear = sc.nextInt();

                System.out.println("Enter IMDB grade of film:");
                double IMDB = sc.nextDouble();

                // add film to films and print
                defaultAdmin.addFilms(filmName, filmYear, superStar1, superStar2, superStar3, IMDB, new Person(director), new Person(producer), genre);
                System.out.println("Film created:\n" + Admin.films.get(Admin.films.size() - 1) + "\n");
                break;

            case 3:
                // if there is no film to rent
                if (Admin.films.size() == 0) {
                    System.out.println("Add some films first !\n");
                    break;
                }

                // find out if this user is guest or not
                if (defaultUser.getName().equals("guest"))
                    System.out.println("Choose the film to rent to guest:");
                else
                    System.out.println("Choose the film to rent to " + defaultUser.getName());

                // print all films information, user can choose
                for (int i = 0; i < Admin.films.size(); i++) {
                    System.out.println(i + ") " + Admin.films.get(i));
                }

                // find film, rent film for default user and print it
                Film film = Admin.films.get(sc.nextInt());
                defaultUser.rentFilm(film);
                System.out.println(film.getName() + ": " + defaultUser.getName());
                System.out.println();
                break;

            case 4:
                // find rent films for users
                System.out.println("Films rent for each user: ");
                for (User user : Admin.users) {
                    if (user.getFilms().size() > 0) // films arraylist of user have at least a film
                        System.out.println(user.getName() + ": " + user.getFilms());
                }
                System.out.println();
                break;

            case 5:
                // find user with id
                System.out.println("Enter the user ID to search:");
                String ID = sc.nextLine();
                int notThis1 = 0;

                for (User user : Admin.users) {
                    if (user.getId().equals(ID)) { // if user id is equal to given id
                        System.out.println("User with this ID is in users:");
                        System.out.println(user);
                        break;
                    } else
                        notThis1++;
                }

                if (notThis1 == Admin.users.size()) // if not user found with this id
                    System.out.println("No user found with this ID.");
                System.out.println();
                break;

            case 6:
                // find film with name
                System.out.println("Enter the film name to search:");
                String nameF = sc.nextLine();
                int notThis2 = 0;

                for (Film f : Admin.films) {
                    if (f.getName().equals(nameF)) { // if film name is equal to given name
                        System.out.println("Film with this name is in films:");
                        System.out.println(f);
                        break;
                    } else
                        notThis2++;
                }

                if (notThis2 == Admin.films.size()) // if no film found with this name
                    System.out.println("No film found with this name.");

                System.out.println();
                break;

            default: // if user enter wrong command
                System.out.println("Entered number is wrong ! Enter 0 to finish program.\n");
                break;
        }
    }

    // the menu of users
    public static void menuUser(int input) {
        Scanner sc = new Scanner(System.in);
        switch (input) {
            case 0: // exit the program if enter 0
                continues = false;
                break;

            case 1:
                // enter the default user information
                System.out.println("Enter your name:");
                String name = sc.next();

                System.out.println("Enter your family:");
                String family = sc.next();

                System.out.println("Enter your ID:");
                String id = sc.next();

                System.out.println("Enter your age:");
                int age = sc.nextInt();

                System.out.println("Enter your number:");
                String number = sc.next();

                // add this user to users
                defaultAdmin.addUsers(id, name, family, age, number);
                System.out.println("You changed to:\n" + Admin.users.get(Admin.users.size() - 1) + "\n");
                break;

            case 2:
                // show available films
                System.out.println("Available Films:");
                if (Admin.films.size() == 0) { // if there is no film
                    System.out.println("Ask admin to add some films.\n");
                    break;
                }

                for (Film film : Admin.films) {
                    if (!Admin.rentedFilms.contains(film)) {
                        System.out.println(film); // show films not in rented films
                    }
                }
                break;

            default: // if user enter wrong command
                System.out.println("Entered number is wrong ! Enter 0 to finish program.\n");
                break;
        }
    }
}

class Person {
    // initial a person
    protected String id;
    protected String name;
    protected String family;
    protected int age;
    protected String number;

    // constructor method
    public Person() {
    }

    // constructor method with name
    public Person(String name) {
        setName(name);
    }

    // constructor method with id, name, family, age and number
    public Person(String id, String name, String family, int age, String number) {
        // user its setter to set values to variables
        setId(id);
        setName(name);
        setFamily(family);
        setAge(age);
        setNumber(number);
    }

    // toString method for returning string of this object
    @Override
    public String toString() {
        return "Person) id = " + id + ", name = " + name + ", family = " + family + ", age = " + age +
                ", number = " + number;
    }

    // setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // setter method for id
    public void setId(String id) {
        // check if length of id is exactly 10 characters
        if (id.length() == 10)
            this.id = id;
        else { // if not
            this.id = "-";
            System.out.println("Set the id again. It must have 10 chars.");
        }
    }

    // setter method for family name
    public void setFamily(String family) {
        this.family = family;
    }

    // setter method for age
    public void setAge(int age) {
        // check if 0 < age < 101
        if (age > 0 && age <= 100)
            this.age = age;
        else { // if not
            this.age = 1;
            System.out.println("Set the age again. It must be 0 < age < 100");
        }
    }

    // setter method for number (like 0910......)
    public void setNumber(String number) {
        this.number = number;
    }

    // getter method for name
    public String getName() {
        return name;
    }

    // getter method for family name
    public String getFamily() {
        return family;
    }

    // getter method for id
    public String getId() {
        return id;
    }

    // getter method for age
    public int getAge() {
        return age;
    }

    // getter method number
    public String getNumber() {
        return number;
    }
}

class User extends Person {
    // an arraylist to keep rent films of User
    ArrayList<Film> films = new ArrayList<Film>();

    // empty constructor when the user is a guest
    public User() {
        this.name = "guest";
    }

    // constructor with id, name, family, age, number
    public User(String id, String name, String family, int age, String number) {
        super(id, name, family, age, number);
    }

    // constructor with id, name, family, age, number, films
    public User(String id, String name, String family, int age, String number, ArrayList<Film> films) {
        super(id, name, family, age, number);
        setFilms(films); // use its setter
    }

    // setter method for films
    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    // getter method for films
    public ArrayList<Film> getFilms() {
        return films;
    }

    // method to rent film
    public void rentFilm(Film film) {
        // add film to Admin rented films
        Admin.rentedFilms.add(film);
        // add film to user rented films
        films.add(film);
    }

    // toString method for returning string of this object
    @Override
    public String toString() {
        return "User) id = " + id + ", name = " + name + ", family = " + family + ", age = " + age +
                ", number = " + number;
    }
}

class Admin extends Person {
    // static arraylists to keep users, films, rented films
    static ArrayList<User> users = new ArrayList<User>();
    static ArrayList<Film> films = new ArrayList<Film>();
    static ArrayList<Film> rentedFilms = new ArrayList<Film>();

    // constructor for admin with id, name, family, age, number
    public Admin(String id, String name, String family, int age, String number) {
        super(id, name, family, age, number);
    }

    // constructor for admin with id, name, family, age, number, films, users
    public Admin(String id, String name, String family, int age, String number, ArrayList<User> users, ArrayList<Film> films) {
        super(id, name, family, age, number);
        setUsers(users);
        setFilms(films);
    }

    // setter method for films
    public static void setFilms(ArrayList<Film> films) {
        Admin.films = films;
    }

    // getter method for films
    public static ArrayList<Film> getFilms() {
        return films;
    }

    // setter method for users
    public void setUsers(ArrayList<User> users) {
        Admin.users = users;
    }

    // getter method for users
    public ArrayList<User> getUsers() {
        return users;
    }

    // method to add a user to users
    public ArrayList<User> addUsers(String id, String name, String family, int age, String number) {
        User user = new User(id, name, family, age, number);
        users.add(user);
        return users;
    }

    // method to add a film to films
    public ArrayList<Film> addFilms(String name, int year, String superStar1, String superStar2, String superStar3, double IMDB, Person director, Person producer, String genre) {
        Film film = new Film(name, year, superStar1, superStar2, superStar3, IMDB, director.getName(), producer.getName(), genre);
        films.add(film);
        return films;
    }

    // toString method for returning string of this object
    @Override
    public String toString() {
        return "Admin) id = " + id + ", name = " + name + ", family = " + family + ", age = " + age +
                ", number = " + number;
    }
}

class Film {
    // initial a film
    private String name;
    private int year;
    private String superStar1;
    private String superStar2;
    private String superStar3;
    private double IMDB;
    private String director;
    private String producer;
    private String genre;

    // constructor method for film with name, year, super stars, imdb, director, producer, and genre
    public Film(String name, int year, String superStar1, String superStar2, String superStar3, double IMDB, String director, String producer, String genre) {
        setName(name);
        setYear(year);
        setSuperStar1(superStar1);
        setSuperStar2(superStar2);
        setSuperStar3(superStar3);
        setIMDB(IMDB);
        setDirector(director);
        setProducer(producer);
        setGenre(genre);
    }

    // setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // setter method for genre
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // setter method for director's name
    public void setDirector(String director) {
        this.director = director;
    }

    // setter method for producer's name
    public void setProducer(String producer) {
        this.producer = producer;
    }

    // setter method for year
    public void setYear(int year) {
        this.year = year;
    }

    // setter method for IMDB
    public void setIMDB(double IMDB) {
        // check if 0 <= imdb <= 10
        if (IMDB >= 0 && IMDB <= 10)
            this.IMDB = IMDB;
        else
            System.out.println("Set the IMDB again. It must be 0 < IMDB < 10");
    }

    // setter method for super star 1
    public void setSuperStar1(String superStar1) {
        this.superStar1 = superStar1;
    }

    // setter method for super star 2
    public void setSuperStar2(String superStar2) {
        this.superStar2 = superStar2;
    }

    // setter method for super star 3
    public void setSuperStar3(String superStar3) {
        this.superStar3 = superStar3;
    }

    // getter method for name
    public String getName() {
        return name;
    }

    // getter method for genre
    public String getGenre() {
        return genre;
    }

    // getter method for director's name
    public String getDirector() {
        return director;
    }

    // getter method for producer's name
    public String getProducer() {
        return producer;
    }

    // getter method for year
    public int getYear() {
        return year;
    }

    // getter method for IMDB
    public double getIMDB() {
        return IMDB;
    }

    // getter method for super star 1
    public String getSuperStar1() {
        return superStar1;
    }

    // getter method for super star 2
    public String getSuperStar2() {
        return superStar2;
    }

    // getter method for super star 3
    public String getSuperStar3() {
        return superStar3;
    }

    // toString method for returning string of this object
    @Override
    public String toString() {
        return "Film) name = " + name + ", year = " + year + ", superStar1 = " + superStar1 + ", superStar2 = " + superStar2 +
                ", superStar3 = " + superStar3 + ", IMDB = " + IMDB + ", director = " + director + ", producer = " + producer;
    }
}