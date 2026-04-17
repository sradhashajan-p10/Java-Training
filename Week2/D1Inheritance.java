import calculator.AdvCalc;

public class D1Inheritance{
    public static void main(String args[]){
        int a=10;
        int b=2;
        AdvCalc c=new AdvCalc();
        System.out.println(c.addition(a,b));
        System.out.println(c.subtraction(a,b));
        System.out.println(c.multiplication(a,b));
        System.out.println(c.division(a,b));
    }
}