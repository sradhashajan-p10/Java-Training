abstract public class Outer{
    abstract void show();
}

public class D3AbstractAnonymousInner {
    public static void main(String args[])
    {
        Outer o=new Outer() 
            {
                void show(){
                    System.out.println("Anonymous Inner class");
                }
            };
        o.show();
    }
}
