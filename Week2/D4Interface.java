interface A{
    int age=11;
    String Name="Anna";
    void display();
    
}
interface B{
    void data();
}
class C implements A,B{
    public void display()
    {
        System.out.println(Name);
    }
    public void data()
    {
        System.out.println(age);
    }
}
public class D4Interface {
    public static void main(String args[])
    {
        C obj=new C();
        obj.display();
        obj.data();
    }
    
}
