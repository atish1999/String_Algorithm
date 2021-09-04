package Concepts;

import java.util.*;
import java.io.*;

public class Sliding_Window_Technique implements Runnable {

	/*
	 * In dsu we generally denote a particular set with its parents.ie. an element
	 * of the set will be an unique identifier of that particular set.
	 */
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

	static int mod = (int) (1e5 + 1), n, m;
	static String original, pattern;

	public static void main(String[] args) throws java.lang.Exception {
		new Thread(null, new Sliding_Window_Technique(), "Main", 1 << 26).start();
	}

	static boolean match(int l) {// O(m)
		for (int i = 0; i < m; i++) {
			if (original.charAt(l + i) != pattern.charAt(i))
				return false;
		}
		return true;
	}

	@Override
	public void run() {
		long start = System.nanoTime(); // Program Start
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		while (t-- > 0) {
			original = fr.next();
			pattern = fr.next();
			n = original.length();
			m = pattern.length();
//		    As total number of iterations are (n-m+1)
//		    then total time complexity is O(n-m+1)*(m) i.e. O(n*m)
			for (int l = 0, r = m - 1; r < n; l++, r++) {
				if (match(l))
					System.out.println(l + " " + r);
			}

		}
		long end = System.nanoTime(); // Program End
		System.err.println("Time taken: " + (end - start) / 1000000 + " ms");
	}

}
