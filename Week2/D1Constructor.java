class Human{
    private int age;
    private String Name;

    public Human(int age, String Name){
        this.age=age;
        this.Name=Name;
        System.out.println("Inside 1st Constructor");
        System.out.println("Name :"+ Name + " Age :"+ age);
    }

    public Human(String Name){
        this.Name=Name;
        System.out.println("Inside 2nd Constructor");
        System.out.println("Name :"+ Name + " Age :"+ age);
    }

    public Human(){
        age=15;
        Name="Sradha";
        System.out.println("Inside 3rd Constructor");
        System.out.println("Name :"+ Name + " Age :"+ age);
    }

}
public class D1Constructor{
    public static void main(String a[]){
        Human h1=new Human(10,"Aaron");
        Human h2=new Human("ANNA");
        Human h3=new Human();
        
    }
}