import java.util.Scanner;

public class demo {
    // arrays to keep information of videos, customers and rented videos
    protected static Video[] videos = new Video[100];
    protected static Customer[] customers = new Customer[100];
    protected static String[] rented = new String[100];

    static class Man {
        // name, age, national code and phone number of a person
        protected String name;
        protected String age;
        protected String nationalCode;
        protected String phoneNumber;

        // first constructor method
        public Man() {
        }

        // second constructor method
        public Man(String name) {
            this.name = name;
        }

        // third constructor method
        public Man(String name, String age, String nationalCode, String phoneNumber) {
            this.name = name;
            this.age = age;
            this.nationalCode = nationalCode;
            this.phoneNumber = phoneNumber;
        }

        // getter method for name of person
        public String getName() {
            return name;
        }

        // getter method for age of person
        public String getAge() {
            return age;
        }

        // getter method for national code of person
        public String getNationalCode() {
            return nationalCode;
        }

        // getter method for phone number of person
        public String getPhoneNumber() {
            return phoneNumber;
        }

        // setter method for age of person
        public void setAge(String age) {
            this.age = age;
        }

        // setter method for name of person
        public void setName(String name) {
            this.name = name;
        }

        // setter method for national code of person
        public void setNationalCode(String nationalCode) {
            this.nationalCode = nationalCode;
        }

        // setter method for phone number of person
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "Man => name: " + name + ",age: " + age + ",national code: " + nationalCode + ",phone number: " + phoneNumber;
        }
    }

    static class Customer extends Man {
        // first constructor method
        public Customer() {
        }

        // second constructor method
        public Customer(String name, String age, String nationalCode, String phoneNumber) {
            super(name, age, nationalCode, phoneNumber);
        }

        @Override
        public String toString() {
            return "Customer => name: " + name + ",age: " + age + ",national code: " + nationalCode + ",phone number: " + phoneNumber;
        }
    }

    static class Manager extends Man {
        // first constructor method
        public Manager() {
        }

        // second constructor method
        public Manager(String name, String age, String nationalCode, String phoneNumber) {
            super(name, age, nationalCode, phoneNumber);
        }

        @Override
        public String toString() {
            return "Manager => name: " + name + ",age: " + age + ",national code: " + nationalCode + ",phone number: " + phoneNumber;
        }
    }

    static class Director extends Man {
        // first constructor method
        public Director(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Director => name: " + name;
        }
    }

    static class Producer extends Man {
        // first constructor method
        public Producer(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Producer => name: " + name;
        }
    }

    public static class Video {
        // name, grades, famous actors, producer, director, production year of a film
        private String name;
        private double grades;
        private String[] famousActors;
        private Producer producer;
        private Director director;
        private int productionYear;

        // first constructor method
        public Video() {
        }

        // second constructor method
        public Video(String name, double grades, String[] famousActors, Producer producer, Director director, int productionYear) {
            this.name = name;
            this.grades = grades;
            this.famousActors = famousActors;
            this.producer = producer;
            this.director = director;
            this.productionYear = productionYear;
        }

        // setter method for name of the film
        public void setName(String name) {
            this.name = name;
        }

        // setter method for IMDB grades of the film
        public void setGrades(double grades) {
            this.grades = grades;
        }

        // setter method for famous actors of the film
        public void setFamousActors(String[] famousActors) {
            this.famousActors = famousActors;
        }

        // setter method for producer of the film
        public void setProducer(Producer producer) {
            this.producer = producer;
        }

        // setter method for director of the film
        public void setDirector(Director director) {
            this.director = director;
        }

        // setter method for production year of the film
        public void setProductionYear(int productionYear) {
            this.productionYear = productionYear;
        }

        // getter method for name of the film
        public String getName() {
            return name;
        }

        // getter method for IMDB grades of the film
        public double getGrades() {
            return grades;
        }

        // getter method for famous actors of the film
        public String[] getFamousActors() {
            return famousActors;
        }

        // getter method for producer of the film
        public Producer getProducer() {
            return producer;
        }

        // getter method for director of the film
        public Director getDirector() {
            return director;
        }

        // getter method for production year of the film
        public int getProductionYear() {
            return productionYear;
        }

        @Override
        public String toString() {
            return "Film => name: " + name + ",grades: " + grades + ",production year: " + productionYear +
                    ",famous actors: " + famousActors[0] + " - " + famousActors[1] + " - " + famousActors[2] + ",producer: " +
                    producer.getName() + ",director: " + director.getName();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // first menu to choose customer or manager
        System.out.println("Which one are you ?\n1. Customer\n2. Manager\n3. EXIT");
        System.out.print("Answer: ");
        int user = scanner.nextInt();

        if (user == 1) { // if choose customer
            Customer customer = new Customer();

            while (true) {
                // second menu for customer
                System.out.println("\nWhich part ?\n1. Enter information\n2. EXIT");
                System.out.print("Answer: ");
                int part = scanner.nextInt();
                scanner = new Scanner(System.in);

                if (part == 1) {
                    // get the information of the user
                    System.out.print("Enter your name: ");
                    customer.setName(scanner.nextLine());

                    System.out.print("Enter your age: ");
                    customer.setAge(scanner.nextLine());

                    System.out.print("Enter your national code: ");
                    customer.setNationalCode(scanner.nextLine());

                    System.out.print("Enter your phone number: ");
                    customer.setPhoneNumber(scanner.nextLine());

                    System.out.println("Done.");
                    System.out.println(customer);

                } else if (part == 2) {
                    // exit the program
                    System.out.println("\nProgram ended.");
                    break;

                } else {
                    System.out.println("Wrong number.");
                }
            }

        } else if (user == 2) { // if choose manager
            Manager manager = new Manager();

            while (true) {
                // second menu for manager
                System.out.println("\nWhich part ?\n1. Search video\n2. Search customer\n3. Add video\n4. Add customer\n5. Rent video\n6. Get Report\n7. EXIT");
                System.out.print("Answer: ");
                int part = scanner.nextInt();
                scanner = new Scanner(System.in);

                if (part == 1) {
                    // get information of a video and search
                    System.out.print("Enter video name: ");
                    String videoName = scanner.nextLine();

                    System.out.print("Enter video production year: ");
                    int productionYear = scanner.nextInt();

                    searchVideo(videoName, productionYear);

                } else if (part == 2) {
                    // get information of a customer and search
                    System.out.print("Enter customer's name: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Enter customer's national code: ");
                    String nationalCode = scanner.nextLine();

                    searchCustomer(customerName, nationalCode);

                } else if (part == 3) {
                    // get information of a video and create a new one
                    Video newVideo = new Video();

                    System.out.print("Enter video name: ");
                    newVideo.setName(scanner.nextLine());

                    System.out.print("Enter video IMDB grade: ");
                    newVideo.setGrades(scanner.nextDouble());
                    scanner = new Scanner(System.in);

                    String[] famousActors = new String[3];
                    System.out.print("Enter video first famous actor/actress: ");
                    famousActors[0] = scanner.nextLine();
                    System.out.print("Enter video second famous actor/actress: ");
                    famousActors[1] = scanner.nextLine();
                    System.out.print("Enter video third famous actor/actress: ");
                    famousActors[2] = scanner.nextLine();
                    newVideo.setFamousActors(famousActors);

                    System.out.print("Enter video producer: ");
                    Producer producer = new Producer(scanner.nextLine());
                    newVideo.setProducer(producer);

                    System.out.print("Enter video director: ");
                    Director director = new Director(scanner.nextLine());
                    newVideo.setDirector(director);

                    System.out.print("Enter video production year: ");
                    newVideo.setProductionYear(scanner.nextInt());

                    addVideo(newVideo);
                    System.out.println("Done:");
                    System.out.println(newVideo);

                } else if (part == 4) {
                    // get information of a customer and create a new one
                    Customer newCustomer = new Customer();

                    System.out.print("Enter customer name: ");
                    newCustomer.setName(scanner.nextLine());

                    System.out.print("Enter customer age : ");
                    newCustomer.setAge(scanner.nextLine());

                    System.out.print("Enter customer national code: ");
                    newCustomer.setNationalCode(scanner.nextLine());

                    System.out.print("Enter customer phone number: ");
                    newCustomer.setPhoneNumber(scanner.nextLine());

                    addCustomer(newCustomer);
                    System.out.println("Done:");
                    System.out.println(newCustomer);

                } else if (part == 5) {
                    // get name of a video and a customer to rent a video
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Enter video name : ");
                    String videoName = scanner.nextLine();

                    rentVideo(videoName, customerName);

                } else if (part == 6) {
                    // print the report of rented videos
                    getReport();

                } else if (part == 7) {
                    // exit the program
                    System.out.println("\nProgram ended.");
                    break;

                } else {
                    System.out.println("Wrong number.");
                }
            }

        } else if (user == 3) { // if want to exit
            System.out.println("\nProgram ended.");

        } else { // invalid input
            System.out.println("Wrong number.");
            System.out.println("\nProgram ended.");
        }
    }

    public static void addVideo(Video newVideo) {
        int nulls = 0;
        for (Video video : videos) { // find all null elements
            if (video == null)
                nulls++;
        }
        // put video in first not null place
        videos[100 - nulls] = newVideo;
        System.out.println("New video created.");
    }

    public static void addCustomer(Customer newCustomer) {
        int nulls = 0;
        for (Customer customer : customers) {  // find all null elements
            if (customer == null)
                nulls++;
        }
        // put customer in first not null place
        customers[100 - nulls] = newCustomer;
        System.out.println("New customer created.");
    }

    public static void searchVideo(String name, int productionYear) {
        boolean find = false;
        for (Video video : videos) {
            // search for video, if name and production year is the same, print
            if (video != null && name.equals(video.getName()) && productionYear == video.getProductionYear()) {
                System.out.println("\nfound: " + video);
                find = true;
                break;
            }
        }
        if (!find)
            System.out.println("No video found.");
    }

    public static void searchCustomer(String name, String nationalCode) {
        boolean find = false;
        for (Customer customer : customers) {
            // search for customer, if name and national code is the same, print
            if (customer != null && name.equals(customer.getName()) && nationalCode.equals(customer.getNationalCode())) {
                System.out.println("\nfound: " + customer);
                find = true;
                break;
            }
        }
        if (!find)
            System.out.println("No customer found.");
    }

    public static void rentVideo(String videoName, String customerName) {
        boolean videoFind = false, CustomerFind = false;
        int customerIndex = 0;
        for (int i = 0; i < 100; i++) {
            // try to find and keep the customer with name
            if (customerName.equals(customers[i].getName())) {
                customerIndex = i;
                CustomerFind = true;
                break;
            }
        }

        for (int i = 0; i < 100; i++) {
            if (videoName.equals(videos[i].getName())) {
                // try to find and keep the video with name
                videoFind = true;
                break;
            }
        }

        if (!CustomerFind)
            System.out.println("There is no customer with this name.");
        else if (!videoFind)
            System.out.println("There is no video with this name.");
        else {
            // if there were customer and video available
            rented[customerIndex] = videoName;
            System.out.println("Done.");
        }
    }

    public static void getReport() {
        boolean empty = true;
        for (int i = 0; i < 100; i++) {
            // find each element in rented array and print the its information
            if (rented[i] != null) {
                System.out.println("Customer " + customers[i].getName() + " rented " + rented[i] + ".");
                empty = false;
            }
        }
        if (empty)
            System.out.println("Nothing to report.");
    }
}
