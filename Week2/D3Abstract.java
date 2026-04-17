abstract class Animal{
    abstract public void Bark();
    abstract public void Eat();

    public void Sleep(){
        System.out.println("Animal is sleeping");
    }
}
class Animal1 extends Animal{
    public void Bark(){
        System.out.println("Animal barks");
    }
    public void Eat(){
        System.out.println("Animal eats");
    }
}

public class D3Abstract {
    public static void main(String args[]){
        Animal1 a=new Animal1();
        a.Sleep();
        a.Bark();
        a.Eat();

}
}
