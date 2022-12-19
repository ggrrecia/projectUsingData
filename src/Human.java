public class Human {
    private int age;
    private Car cars;
    public Human(String age){
        this.age = Integer.valueOf(age);
    }
    public Human(Car car, String age){

        this.cars =car;
        this.age=Integer.valueOf(age);
    }
    public Car getCar(){
        return cars;
    }
    public void setCat(Car car){

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }
    public void displayInfo(){
        System.out.printf("Type->Human-> Age:%d\t\n",age);
        if(cars != null){
            System.out.print("\t\t");
            cars.displayInfo();
        }
    }

}
