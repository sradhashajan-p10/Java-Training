import java.util.Scanner;
public class Arrays{
    public static void main(String a[]){
        int n,i;
        System.out.println("Array limit is: ");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int arr[]= new int[n];
        for(i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Array is: ");
        for(i=0;i<n;i++)
        {
            System.out.println(arr[i]);
        }
        }
    }