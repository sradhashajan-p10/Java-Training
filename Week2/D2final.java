class A{
    final public void show(){
        System.out.println("in A");
    }
}
class B extends A{
    public void show(){
        System.out.println("in B");
    }
    
}

public class D2final {
    public static void main(String args[]){
        int num=9;
        //final num=8;
        B obj=new B();
        obj.show();
    }
    
}
