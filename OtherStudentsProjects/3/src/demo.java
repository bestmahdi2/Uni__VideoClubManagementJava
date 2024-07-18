//demo class
public class demo {
    public static void main(String[] args) {
    }
}

//Film class
class Film {
    //Movie  object variables
    private String FilmName;
    private String[] ImportantActors;
    private double IMDB;
    private String ProductionYear;
    public String producer;
    public String Director;
    private FilmStatus status = FilmStatus.LENDED;

    //constructor method for movie specifications
    public Film(String filmName, String[] importantActors, double IMDB, String productionYear, String producer, String director) {
        FilmName = filmName;
        ImportantActors = importantActors;
        this.IMDB = IMDB;
        ProductionYear = productionYear;
        this.producer = producer;
        Director = director;
    }

    //Initialize enum for status of movie
    enum FilmStatus {
        LENDED, PRESENT
    }



   /* static boolean SearchFilmName(String FilmName){
        if( FilmName.equals(Film.getFilmName()) {
            System.out.println(Film);
        }
    }


    SearchFilmName
   public boolean equals() {
        return FilmName.equals(FilmName);
    }*/


    // getter method for film name
    public String getFilmName() {
        return FilmName;
    }

    // setter method for film name
    public void setFilmName(String filmName) {
        FilmName = filmName;
    }

    // getter method for names of superstars
    public String[] getImportantActors() {
        return ImportantActors;
    }

    // setter method for names of superstars
    public void setImportantActors(String[] importantActors) {
        ImportantActors = importantActors;
    }

    // getter method for Internet Movie Database
    public double getIMDB() {
        return IMDB;
    }

    // setter method for Internet Movie Database, 0<IMDB<10 Condition
    public void setIMDB(double IMDB) {
        if (IMDB >= 0 && IMDB <= 10)
            this.IMDB = IMDB;
        else
            System.out.println("IMDB out of range!");
    }

    // getter method for year of film production
    public String getProductionYear() {
        return ProductionYear;
    }

    // setter method for year of film production
    public void setProductionYear(String productionYear) {
        ProductionYear = productionYear;
    }

    // getter method for producer's name
    public String getProducer() {
        return producer;
    }

    //setter method for producer's name
    public void setProducer(String producer) {
        this.producer = producer;
    }

    //getter method for director's name
    public String getDirector() {
        return Director;
    }

    //setter method for director's name
    public void setDirector(String director) {
        Director = director;
    }


    //toString method
    @Override
    public String toString() {
        return "Film{" +
                "FilmName='" + FilmName + '\'' +
                ", ImportantActors='" + ImportantActors[0] +
                ", '" + ImportantActors[1] +
                ", '" + ImportantActors[2] +
                ", IMDB=" + IMDB +
                ", ProductionYear='" + ProductionYear + '\'' +
                ", producer='" + producer + '\'' +
                ", Director='" + Director + '\'' +
                '}';
    }
}

//Person class
class Person {
    // object variables
    public String name;
    public String PhoneNumber;
    public String ID;

    //constructor method
    public Person(String name, String phoneNumber, String ID) {
        this.name = name;
        PhoneNumber = phoneNumber;
        this.ID = ID;
    }

    // getter method for name
    public String getName() {
        return name;
    }

    //setter method for name
    public void setName(String name) {
        this.name = name;
    }

    //getter method for ID
    public String getID() {
        return ID;
    }

    //setter method for ID, ID = 10 character Condition
    public void setID(String ID) {
        if (ID.length() == 10)
            this.ID = ID;
        else {
            this.ID = "---";
            System.out.println("ID must be 10 chars!");
        }
    }

    //getter method for phone number
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    //setter method for phone number
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    //toString method
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}

//Customer class is subclass and Inherits from person class
class Customer extends Person {
    public Customer(String name, String phoneNumber, String ID) {
        super(name, phoneNumber, ID);
    }


    //toString method
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}

//manager class is subclass and Inherits from person class
class manager extends Person {
    public manager(String name, String phoneNumber, String ID) {
        super(name, phoneNumber, ID);
    }

    //function for add film
    static void AddFilm(String FilmName, String ImportantActors, double IMDB, String ProductionYear, String producer, String Director) {
    }

    //function for add Customer
    static void AddCustomer(String name, String PhoneNumber, String ID) {

    }

    //toString method
    @Override
    public String toString() {
        return "manager{" +
                "name='" + name + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}

