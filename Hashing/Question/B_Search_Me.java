package Question;

import java.util.*;
import java.io.*;

public class B_Search_Me implements Runnable {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	static String original, pattern = "to the";

	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new B_Search_Me(), "Main", 1 << 26).start();
	}

	static boolean is_present(int l, int m) {
		for (int i = 0; i < m; i++) {
			if (original.charAt(l + i) != pattern.charAt(i))
				return false;
		}
		return true;
	}

	@Override
	public void run() {
		FastReader fr = new FastReader();
		original = fr.nextLine();
		int n = original.length(), m = pattern.length();
		boolean ok = false;
		String res = "";
		for (int l = 0, r = m - 1; r < n; l++, r++) {
			if (is_present(l, m)) {
				ok = true;
				int x = l - 1, y = r + 1;
				if (x >= 0 && y < n) {
					res = ((original.charAt(x) != ' ' && original.charAt(y) != ' ') ? "NO" : "YES");
				} else if (x >= 0 && y >= n) {
					res = (original.charAt(x) != ' ' ? "NO" : "YES");
				} else if (x < 0 && y < n) {
					res = (original.charAt(y) != ' ' ? "NO" : "YES");
				} else
					res = ("YES");
				if (res.equals("YES")) {
					System.out.println(res);
					return;
				}
			}
		}
		System.out.println(!ok ? "NO" : res);
	}
}
