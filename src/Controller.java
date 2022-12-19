import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Controller {

    public static void main(String[] args) throws Exception {
        yourInfoHeader();
        System.out.println();

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Data.txt output");
        System.out.println("=========================================");

        try {

            String fileLocation = "./Data/data.txt";

            BufferedReader br = new BufferedReader(new FileReader("./data/data.txt"));
            String line;

            String strCurrentLine;

            while ((strCurrentLine = br.readLine()) != null) {
                System.out.println(strCurrentLine);

            }
        } catch (IOException e) {

            e.printStackTrace();

        }
        ArrayList<Car> cars = new ArrayList<Car>();
        ArrayList<Human> humans = new ArrayList<Human>();
        ArrayList<Fruit> fruits = new ArrayList<Fruit>();
        ArrayList<Bowl> bowls = new ArrayList<Bowl>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("./Data/data.txt"));
            String line;
            String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                String[] tokens = strCurrentLine.split(",");
                if (tokens[0].strip().equals("Car")) {
                    Car c = new Car(tokens[1], tokens[2], tokens[3]);
                    cars.add(c);
                } else if (tokens[0].strip().equals("Human")) {
                    Human human;
                    if (tokens.length > 2) {
                        Car c1 = new Car(tokens[4], tokens[5], tokens[6]);
                        human = new Human(c1, tokens[1]);
                    } else {
                        human = new Human(tokens[1]);
                    }
                    humans.add(human);

                } else if (tokens[0].strip().equals("Fruit")) {
                    Fruit fruit = new Fruit(tokens[1], tokens[2]);
                    fruits.add(fruit);
                } else if (tokens[0].equals("Bowl")) {
                    ArrayList<Fruit> tmp = new ArrayList<>();
                    if (tokens.length ==3) {
                        bowls.add (new Bowl(tmp, tokens[1], tokens[2]));

                    }else{
                        for(int i=4;i<tokens.length;i+=3){
                            String type = tokens[i+1];
                            String weight = tokens[i+2];
                            tmp.add(new Fruit(type,weight));
                        }
                        bowls.add(new Bowl(tmp,tokens[1],tokens[2]));
                    }
                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println();
        System.out.println("=========================================");
        System.out.println("Car List");
        System.out.println("=========================================");
        for (Car car : cars) {
            car.displayInfo();
        }
        System.out.println();
        System.out.println("=========================================");
        System.out.println("Human List");
        System.out.println("=========================================");
        for (Human human : humans) {
            human.displayInfo();
        }
        System.out.println();
        System.out.println("=========================================");
        System.out.println("Fruit List");
        System.out.println("=========================================");
        for (Fruit fruit : fruits){
            fruit.displayInfo();
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Bowl List");
        System.out.println("=========================================");
        for (Bowl bowl : bowls){
            bowl.displayInfo();
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Youngest Human Without Car");
        System.out.println("=========================================");

        findYoungestHumanWithoutCar(humans).displayInfo();
        System.out.println();


        System.out.println();
        System.out.println("=========================================");
        System.out.println("Oldest Human Without Car");
        System.out.println("=========================================");

        findOldestHumanWithoutCar(humans).displayInfo();
        System.out.println();

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Bowl With Most Fruit Weight");
        System.out.println("=========================================");

        bowlWithMostFruitWeight(bowls).displayInfo();
        System.out.println();
    }



    public static Human findYoungestHumanWithoutCar(ArrayList<Human> human){
        Human youngestHuman = null;
        for(Human humans: human){
            if (humans.getCar()==null){
                if(youngestHuman==null){
                    youngestHuman = humans;
                }else if(youngestHuman.getAge()> humans.getAge()){
                    youngestHuman=humans;
                }
            }
        }

        return youngestHuman;
    }
    public static Human findOldestHumanWithoutCar(ArrayList<Human> human) {
        Human oldestHuman=null;
        for(Human humans: human){
            if (humans.getCar()!=null){
                if(oldestHuman==null){
                    oldestHuman = humans;
                }else if(oldestHuman.getAge()> humans.getAge()){
                    oldestHuman=humans;
                }
            }
        }
        return oldestHuman;
    }

    public static Bowl bowlWithMostFruitWeight(ArrayList<Bowl>bowls){
        Bowl heaviest= null;
        for(Bowl bowl:bowls){
            if (heaviest ==null){
                heaviest =bowl;
            }else{
                double heaviestWeight= 0.0;
                for(Fruit fruit: heaviest.getFruits()){
                    heaviestWeight+= fruit.getWeight();
                }
                double currentWeight = 0.0;
                for(Fruit cf: bowl.getFruits()){
                    currentWeight+= cf.getWeight();
                }
                if(heaviestWeight<currentWeight){
                    heaviest = bowl;
                }
            }
        }
        return heaviest;

    }


    public static void yourInfoHeader () {
        System.out.println("==============================================");
        System.out.println("PROGRAMMER: " + "Grecia Lara");
        System.out.println("PNTHER ID: " + "6236370");
        System.out.println();
        System.out.println("CLASS: \t\t COP2210");
        System.out.println("SECTION: \t " + "U02");
        System.out.println("SEMESTER:" + "FALL2022");
        System.out.println("CLASSTIME:" + "6:25-9:00");
        System.out.println();
        System.out.println("Assignment:" + "Lab 10");
        System.out.println("certification:\n I undertand FIU's academic policies, and i certify");
        System.out.println("that this work is my own and that name of it is the");
        System.out.println("work of any other person.");
        System.out.println("========================================================");
        System.out.println();
    }
}
