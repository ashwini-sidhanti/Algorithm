package nl.ashwini.testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SolutionMaximumGcdSumPair {
	static int maximumGcdAndSum(int[] A, int[] B) {
		List<String> pair = makePairs(A, B);
		Map<String, Long> resultPair = gcd(pair);
		long tempValue = 0L;
		String tempPair = "";
		int sumValue = 0;
		for (String values : resultPair.keySet()) {

			tempValue = resultPair.get(values);
			tempPair = values;
			for (String key : resultPair.keySet()) {
				if (tempValue < resultPair.get(key)) {
					tempValue = resultPair.get(key);
					tempPair = key;
					sumValue = findSumReturnlargestsum(tempPair, "");
				} else if (tempValue == resultPair.get(key)) {
					tempValue = resultPair.get(key);
					tempPair = findSumReturnlargest(tempPair, key);
					sumValue = findSumReturnlargestsum(tempPair, key);
				}
			}
			break;
		}
		Map<String, Long> result = new HashMap<String, Long>();
		result.put(tempPair, tempValue);
		return sumValue;
	}

	private static int findSumReturnlargestsum(String pair1, String pair2) {

		String[] pairIntegers = pair1.split(",");
		int sum = Integer.parseInt(pairIntegers[0]) + Integer.parseInt(pairIntegers[1]);
		pairIntegers = pair2.split(",");
		int sum2 =0;
		if (!pair2.equals("")) {
			 sum2 = Integer.parseInt(pairIntegers[0]) + Integer.parseInt(pairIntegers[1]);
		}
		if (sum > sum2) {
			return sum;
		} else if (sum == sum2) {
			return sum;
		} else {
			return sum2;
		}

	}

	private static String findSumReturnlargest(String pair1, String pair2) {
		String[] pairIntegers = pair1.split(",");
		int sum = Integer.parseInt(pairIntegers[0]) + Integer.parseInt(pairIntegers[1]);
		pairIntegers = pair2.split(",");
		int sum2 = Integer.parseInt(pairIntegers[0]) + Integer.parseInt(pairIntegers[1]);
		if (sum > sum2) {
			return pair1;
		} else if (sum == sum2) {
			return pair1;
		} else {
			return pair2;
		}
	}

	private static Map<String, Long> gcd(List<String> pairs) {
		Map<String, Long> resultGcd = new HashMap<String, Long>();

		for (String pair : pairs) {
			String[] x = pair.split(",");
			long a = Integer.parseInt(x[0]);
			long b = Integer.parseInt(x[1]);
			while (b > 0) {
				long temp = b;
				b = a % b; // % is remainder
				a = temp;
			}

			resultGcd.put(pair, a);
		}
		return resultGcd;
	}

	private static List<String> makePairs(int[] A, int[] B) {
		List<String> c = new ArrayList<>();
		// Make a pair of elements
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				c.add(A[i] + "," + B[j]);

			}
		}

		return c;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		// Array A:
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = in.nextInt();
		}
		// Array B:
		int[] B = new int[n];
		for (int i = 0; i < n; i++) {
			B[i] = in.nextInt();
		}
		// calling the Method
		/*
		 * Map<String, Long> result = maximumGcdAndSum(A, B); for (String pair :
		 * result.keySet()) { System.out.println("final result is: " +
		 * result.get(pair)); System.out.println("final result is: " + pair); }
		 */
		System.out.println(maximumGcdAndSum(A, B));
		in.close();
	}

}
