import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter("output.txt");
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		int sol = 1;
		for (int i = 0; i < k; i++) {
			sol = sol * n % 10;
		}
		
		out.println(sol);
		out.close();
	}
}
