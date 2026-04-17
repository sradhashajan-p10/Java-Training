public class D4Exception {
    public static void main(String args[])
    {
        int i=7;
        int j=0;
        int n[]=new int[5];
        String s=null;
        try{
           j=6/i;
           if (j==0){
            throw new ArithmeticException("no need !!!");
           }
            System.out.println(n[5]);
            
             System.out.println(s.length());
        }
        catch(ArithmeticException e){
            System.out.println("Cat divide by 0"+e);
        }

        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("wrong"+e);
        }

        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("end");
        }
        
    }
    

