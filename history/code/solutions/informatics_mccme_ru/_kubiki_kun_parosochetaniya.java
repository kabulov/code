import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter("output.txt");
		
		n = in.nextInt();
		String name = in.next();
		
		m = name.length();		
		sz = n + m;
		map = new int[sz][sz];
		
		for (int i = 0; i < sz; ++i)
			Arrays.fill(map[i], 0);
		
		String tmp;
		for (int i = 0; i < n; ++i) {
			tmp = in.next();
			for (int j = 0; j < m; ++j) 
				if (can(tmp, name.charAt(j)))
					map[i][n + j] = map[n + j][i] = 1;
		}
		
//		for (int i = 0; i < sz; ++i) {
//			for (int j = 0; j < sz; ++j) System.out.print(map[i][j] + " ");
//			System.out.println();
//		}
//		
		used = new boolean[sz];
		pair = new int[sz];
		Arrays.fill(pair, -1);
		
		int size = 0;
		for (int i = n; i < sz; ++i) {//0..n
			if (pair[i] != -1) continue;
			Arrays.fill(used, false);
			if (offer(i)) ++size;
		}
		
		if (size < m)
			out.println("NO");
		else {
			out.println("YES");
			for (int i = n; i < sz; ++i)
				out.print((pair[i] + 1) + " ");
		}
		
		out.close();
	}
	
	static boolean offer(int v) {
		if (used[v]) return false;
		used[v] = true;
		for (int i = 0; i < sz; ++i) {
			if (map[v][i] == 0) continue;
			if (pair[i] == -1 || offer(pair[i])) {
				pair[i] = v;
				pair[v] = i;
				return true;
			}
		}
		return false;
	}
	
	static int[] pair;
	static boolean[] used;
	
	static boolean can(String str, char c) {
		return str.indexOf(c) >= 0;
	}
	
	static int n, m, sz;
	static int[][] map;
}