package drills;

import java.util.Scanner;
import java.util.Date;
import java.util.HashMap;

public class Fibonacci {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		HashMap<Integer, Long> hm = new HashMap<>();

		System.out.print("Enter a number: ");
		int fibNum = scanner.nextInt();
		long fibArr[] = new long[fibNum]; // for last method
		boolean skip = false;

		if (fibNum > 42) {
			while (true) {
				System.out.print("\t\t** WARNING **\n\tNumbers greater than 42 will begin "
						+ "to take a very long time\n\tTry a lower number? (Y/N): ");
				if (scanner.next().toUpperCase().equals("Y")) {
					System.out.print("New number: ");
					fibNum = scanner.nextInt();
				} else {
					System.out.print("\tSkip the slow method? (Y/N): ");
					if (scanner.next().toUpperCase().equals("Y")) {
						skip = true;
					}
					break;
				}
			}
		}
		long d, dd;

		if (!skip) {
			d = new Date().getTime();
			System.out.println("\n*** Slow Recursive function ***");
			System.out.println("The Fibonacci number in position " + fibNum + " is: " + recursiveFib(fibNum));
			dd = new Date().getTime();
			System.out.println("This took: " + (dd - d) + " ms.");
		}

		d = new Date().getTime();
		System.out.println("\n*** Quicker Recursive function /w Map ***");
		System.out.println("The Fibonacci number in position " + fibNum + " is: " + myQuickerRecursiveFib(fibNum, hm));
		dd = new Date().getTime();
		System.out.println("This took: " + (dd - d) + " ms.");

		d = new Date().getTime();
		System.out.println("\n*** With a for loop ***");
		System.out.println("The Fibonacci number in position " + fibNum + " is: " + myFib(fibNum));
		dd = new Date().getTime();
		System.out.println("This took: " + (dd - d) + " ms.");

		d = new Date().getTime();
		System.out.println("\n*** Recursive with an array ***");
		System.out.println("The Fibonacci number in position " + fibNum + " is: " + funWithArrays(fibNum, fibArr));
		dd = new Date().getTime();
		System.out.println("This took: " + (dd - d) + " ms.\n");

		scanner.close();
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
	public static long myQuickerRecursiveFib(int n, HashMap<Integer, Long> hm) {
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
	public static long myFib(long n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;

		long prev = 1;
		long current = 1;

		for (int i = 2; i < n; i++) {
			long temp = current + prev;
			prev = current;
			current = temp;
		}
		return current;
	}

	public static long funWithArrays(int i, long[] arr) {
		if (i <= 0)
			return 0;
		else if (i == 1)
			return 1;
		else if (arr[i - 1] != 0) {
			return arr[i - 1];
		} else {
			arr[i - 1] = funWithArrays(i - 1, arr) + funWithArrays(i - 2, arr);
			return arr[i - 1];
		}
	}
}
