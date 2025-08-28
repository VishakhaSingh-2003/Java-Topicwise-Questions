package OOPS;
class Pen {
    String color;
    String type;
    public void writing(){
        System.out.println("Writing Something");
    }
}

public class OOPS {
    public static void main(String[] args) {
    Pen pen1 = new Pen();
    pen1.color="black";
    pen1.type="gel";
    pen1.writing();
    
}
}
