import java.util.Scanner;
import java.util.Date;
import java.util.HashMap;

public class Fibonacci {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		HashMap<Integer, Integer> hm = new HashMap<>();

		System.out.print("Enter a number: ");
		int fibNum = scanner.nextInt();

		if (fibNum > 42) {
			while (true) {
				System.out.print("\t\t** WARNING **\n\tNumbers greater than 42 will begin "
						+ "to take a very long time\n\tTry a lower number? (Y/N): ");
				if (scanner.next().toUpperCase().equals("Y")) {
					System.out.print("New number: ");
					fibNum = scanner.nextInt();
				} else
					break;
			}
		}

		long d = new Date().getTime();
		System.out.println("\n*** Recursive function ***");
		System.out.println("The Fibonacci number in position " + fibNum + " is: " + recursiveFib(fibNum));
		long dd = new Date().getTime();
		System.out.println("This took: " + (dd - d) + " ms.");

		d = new Date().getTime();
		System.out.println("\n*** Quicker Recursive function ***");
		System.out.println("The Fibonacci number in position " + fibNum + " is: " + myQuickerRecursiveFib(fibNum, hm));
		dd = new Date().getTime();
		System.out.println("This took: " + (dd - d) + " ms.");

		d = new Date().getTime();
		System.out.println("\n*** My function ***");
		System.out.println("The Fibonacci number in position " + fibNum + " is: " + myFib(fibNum));
		dd = new Date().getTime();
		System.out.println("This took: " + (dd - d) + " ms.\n");
	}

	// Standard recursive solution
	public static int recursiveFib(int n) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return recursiveFib(n - 1) + recursiveFib(n - 2);
	}

	// Store previous results in a map for future use
	public static int myQuickerRecursiveFib(int n, HashMap<Integer, Integer> hm) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (hm.get(n) != null) {
			// System.out.println("Grabbing " + n);
			return hm.get(n);
		} else {
			hm.put(n, myQuickerRecursiveFib(n - 1, hm) + myQuickerRecursiveFib(n - 2, hm));
			// System.out.println("Adding " + n);
			return hm.get(n);
		}
	}

	// With a loop
	public static int myFib(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;

		int prev = 1;
		int current = 1;

		for (int i = 2; i < n; i++) {
			int temp = current + prev;
			prev = current;
			current = temp;
		}
		return current;
	}
}
