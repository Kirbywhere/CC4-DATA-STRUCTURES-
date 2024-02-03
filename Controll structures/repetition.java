import java.io.*;

public class repetition {

	public static void main(String[] args) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Input the height: ");
		int height;
		try {
			height = Integer.parseInt(input.readLine());
		} catch (IOException e) {
			System.out.println("Error!");
			height = 0;
		}

		for (int i = 1; i <= height; i++) {
			for (int spaces = 1; spaces <= height - i; spaces++) {
				System.out.print(" ");
			}
			for (int stars = 1; stars <= (i * 2) - 1; stars++) {
				System.out.print("*");
			}
			System.out.println("");

		}
	}

}
