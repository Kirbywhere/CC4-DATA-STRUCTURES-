import java.io.*;

public class sequential {

	public static void main(String[] args) {
		double height, base;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Input base of triangle: ");
		try {
			base = Double.parseDouble(reader.readLine());
		} catch (IOException e) {
			System.out.println("Error");
			base = 0;
		}

		System.out.print("Input height of triangle: ");
		try {
			height = Double.parseDouble(reader.readLine());
		} catch (IOException e) {
			System.out.println("Error");
			height = 0;
		}

		double area = 1.0 / 2 * base * height;

		System.out.println("The area of the triangle is: " + area);
	}
}