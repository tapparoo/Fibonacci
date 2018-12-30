import java.util.Scanner;
import java.util.Date;

public class Fibonacci{
  public static void main(String args[]){
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a number: ");
    int fibNum = scanner.nextInt();

    while(true){
      if (fibNum > 42){
        System.out.print("\t\t** WARNING **\n\tNumbers greater than 42 will begin " +
          "to take a very long time\n\tTry a lower number? (Y/N): ");
        if (scanner.next().toUpperCase().equals("Y")){
          System.out.print("New number: ");
          fibNum = scanner.nextInt();
        }else
          break;
      }
    }

    long d = new Date().getTime();
    System.out.println("\n*** Recursive function ***");
    System.out.println("The Fibonacci number in position " + fibNum + " is: " +
      fibRecursive(fibNum));
    long dd = new Date().getTime();
    System.out.println("This took: " + (dd-d) + " ms.");

    d = new Date().getTime();
    System.out.println("\n*** My function ***");
    System.out.println("The Fibonacci number in position " + fibNum + " is: " +
      myFib(fibNum));
    dd = new Date().getTime();
    System.out.println("This took: " + (dd-d) + " ms.\n");
  }

  public static int fibRecursive(int n){
    if (n <= 0) return 0;
    else if (n == 1) return 1;
    else return (fibRecursive(n - 1) + fibRecursive(n - 2));
  }

  public static int myFib(int n){
    if (n <= 0) return 0;
    if (n == 1) return 1;

    int prev = 1;
    int current = 1;

    for (int i = 2; i < n; i++){
      int temp = current + prev;
      prev = current;
      current = temp;
    }
    return current;
  }
}
