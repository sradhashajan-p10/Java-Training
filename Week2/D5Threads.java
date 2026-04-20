class A extends Thread{
    public void run()
    {
        int i;
        for(i=0;i<100;i++)
        {
            System.out.println("Hi");
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
class B extends Thread{
    public void run()
    {
        int i;
        for(i=0;i<100;i++)
        {
            System.out.println("Hello");
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
public class D5Threads{
    public static void main(String args[])
    {
        A o1=new A();
        B o2=new B();
        o1.start();
        o2.start();
    }
}