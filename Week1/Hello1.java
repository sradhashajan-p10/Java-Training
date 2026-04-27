class Calculator{
   
    public int add(int n1,int n2){
        r=n1+n2;
        return r;
    }
}

public class CalculatorDemo{

    public static void main(String a[]){
        int r=0;
        int n1=2;
        int n2=3;
        Calculator c=new Calculator();
        r=c.add(n1,n2);
        System.out.println(r);
    }
    
    
}