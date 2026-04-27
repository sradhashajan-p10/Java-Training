class Add1{
    int r=0;
    public int demo(int n1, int n2){
        r=n1+n2;
        return r;
    }
}


public class Calculator{
    public static void main (String a[]){
        int num1=5;
        int num2=7;
        int result;
        Add1 a1= new Add1();
        result=a1.demo(num1,num2);
        System.out.println(result);
    }
}