import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter("output.txt");
		
		int n = in.nextInt();
		int pos = 0;
		
		for (int i = 1; i <= n; i++) {
			if (in.nextInt() <= 437) {
				pos = i;
				break;
			}
		}
		
		if (pos == 0) {
			out.println("No crash");
		} else {
			out.println("Crash " + pos);
		}
		
		out.close();
	}
}
