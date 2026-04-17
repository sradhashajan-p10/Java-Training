class Pen{
    public String buyPen(int Price){
        if (Price >= 10){
            return("Pen");
        }
        else{
            return("Not enough money for pen");
        }
    }
}

class Eraser{
    public String buyEraser(int cost){
        if (cost >= 15){
            return("Eraser");
        }
        else{
            return("Not enough money for eraser");
        }
    }
}
public class Buy{
    public static void main(String a[]){
        String p,e;
        Pen p1=new Pen();
        Eraser e1=new Eraser();
        System.out.println(p1.buyPen(11));
        System.out.println(e1.buyEraser(12));
    }
}