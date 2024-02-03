import java.io.*;

public class conditional {

	public static boolean isPrime(int n, int i) {

		if (n <= 2) {
			if (n == 2) {
				return true;
			} else {
				return false;
			}
		}
		if (n % i == 0) {
			return false;
		}
		if (Math.pow(i, 2) > n) {
			return true;
		}
		return isPrime(n, i + 1);
	}

	public static void main(String[] args) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Input number: ");
		int number;

		try {
			number = Integer.parseInt(input.readLine());
		} catch (IOException e) {
			System.out.println("Error!");
			number = 0;
		}

		boolean prime = isPrime(number, 2);

		if (prime == true)
			System.out.println("The number " + number + " IS a PRIME.");
		else
			System.out.println("The number " + number + " is NOT a prime.");

	}

}
