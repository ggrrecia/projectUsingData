import java.util.ArrayList;

public class Bowl {
    private String color;
    private int size;
    private ArrayList<Fruit>fruits;

    public Bowl(ArrayList<Fruit> fruits, String color, String size){
        this.color =color;
        this.fruits =fruits;
        this.size =Integer.valueOf(size);

    }
    public ArrayList<Fruit> getFruits(){
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public void displayInfo(){
        System.out.printf("Type->Bowl-> Color:%10s\t\t\t size:%d\n",color,size);
        if(fruits.size() !=0){
            for(Fruit f: fruits){
                System.out.print("\t\t");
                f.displayInfo();
            }

        }
    }
}
