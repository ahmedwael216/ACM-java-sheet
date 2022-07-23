import java.util.ArrayList;

public class SieveOfErathosthenes {
	static int[] sieve;
	static boolean[] prime;
	static ArrayList<Integer> fprime = new ArrayList<Integer>();

	public static void main(String[] args) {
		int n = 500;
		sieve = new int[n];
		prime = new boolean[n];
		for (int i = 2; i < n; i++) {
			if (sieve[i] == 0) {
				// if the number doesn't have any value assigned, then it's prime
				prime[i] = true;
				sieve[i] = i;
				fprime.add(i);
				// added it to the found prime array list
				for (int j = 0; j < fprime.size(); j++) {
					// Iterate over the found prime array list
					int c = fprime.get(j);
					if (c * i >= n || j > sieve[i]) {
						/*
						 * if out of range break
						 * or a prime is greater than the minimum prime factor of current
						 * the second condition is make the code O(n)
						 * example 12 will be accessed by 2*6 not 3*4
						 * Because the prime factorization must be sorted
						 * so 12 = 2*2*3 not 3*2*3
						 */
						break;
					}
					// else add the prime number c as the smallest prime factor if number c*i
					sieve[c * i] = c;
				}
			} else {
				// if the number is not prime
				for (int j = 0; j < fprime.size(); j++) {
					// Iterate over the found prime array list
					int c = fprime.get(j);
					if (c * i >= n || j > sieve[i]) {
						break;
					}
					sieve[c * i] = c;
				}
			}
		}
		System.out.print("count: ");
		for (int i = 0; i < n; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.print("sieve: ");
		for (int i = 0; i < n; i++) {
			// this is just for printing nicely
			String s = i + "";
			String sol = "";
			String s2 = sieve[i] + "";
			for (int j = 0; j < s.length() - s2.length(); j++) {
				sol += " ";
			}
			System.out.print(sieve[i] + sol + " ");
		}
	}
}
