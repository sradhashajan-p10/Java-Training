class Outer{
    public void show(){
        System.out.println("Inside Outer");
    }

    class Inner{
        public void show1(){
            System.out.println("Inside Inner");
        }
    }
}
public class D3Innerclass {
    public static void main(String args[])
    {
        Outer o=new Outer();
        Outer.Inner o1= o.new Inner();
        o.show();
        o1.show1();
    }
}
