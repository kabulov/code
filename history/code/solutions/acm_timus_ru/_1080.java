
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class Main implements Runnable {
	public static void main(String[] args) {
		new Thread(new Main()).start();
	}

	PrintWriter out;
	Scanner in;
	
	public void run() {
		try {
			in = new Scanner(System.in);	
			out = new PrintWriter(System.out);
			solve();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			out.close();
		}
	}
	
	void solve() throws IOException {
		n = in.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; ++i) 
			Arrays.fill(map[i], 0);
		
		for (int i = 0, t; i < n; ++i) {
			while (true) {
				t = in.nextInt() - 1;
				if (t == -1) break;
				map[i][t] = map[t][i] = 1;
			}
		}
		
		col = new int[n];
		Arrays.fill(col, -1);
		
		int[] q = new int[n];
		int lt, rt;
		
		good = true;
		
outer:	for (int i = 0, cur; i < n; ++i) 
			if (col[i] == -1) {
				col[i] = 0;
				q[0] = i;
				lt = 0;
				rt = 1;
				while (lt < rt) {
					cur = q[lt++];
					for (int j = 0; j < n; ++j) 
						if (map[cur][j] == 1) {
							if (col[j] == -1) {
								col[j] = col[cur] ^ 1;
								q[rt++] = j;
							} else {
								if (col[cur] == col[j]) {
									good = false;
									break outer;
								}
							}
						}					
				}
			}
		
		if (!good) {
			out.println(-1);
			return;
		}
		
		for (int i = 0; i < n; ++i) out.print(col[i]);
	}
	
	int[] col;
	boolean good;
	int[][] map;
	int n;
}