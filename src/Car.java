public class Car {
    private double price;
    private String color;
    private int numberOfDoors;

    public Car(String price, String color, String numberOfDoor){
        this.color=color;
        this.price=Double.valueOf(price);
        this.numberOfDoors=Integer.valueOf(numberOfDoor);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getColor(){
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
    public void displayInfo(){
        System.out.printf("Type->Car->\t Price:\t$%.2f \tColor:\t%-10s\tDoors:\t%d\n",price,color,numberOfDoors);
    }

}
