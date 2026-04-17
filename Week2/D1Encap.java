class Human{
    private int age;
    private String Name;

    public void setAge(int a){
        age=a;
    }

    public void setName(String n){
        Name=n;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return Name;
    }
}
public class D1Encap{
    public static void main(String a[]){
        Human h=new Human();
        h.setAge(10);
        h.setName("Kichi");
        System.out.println("Name :"+ h.getName()+ "Age :"+h.getAge());
    }
}