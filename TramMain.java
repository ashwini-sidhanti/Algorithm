package nl.ashwini.testing;

public class TramMain {

	public static void main(String[] args) {
		int number = 123456;
		while(!TramMain.nextLuckyNumber(number)){
			number++;
		}
			System.out.println("Found the number"+number);
		
	}

	public static boolean nextLuckyNumber(int number) {
		int count = 0;
		int sumRHS = 0, sumLHS = 0;
		boolean result =false;
			while (number > 0) {
				int digit = number % 10;
				// System.out.print(digit);
				number = number / 10;
				if (count < 3) {
					sumRHS = sumRHS + digit;
				} else {
					sumLHS = sumLHS + digit;
				}
				count++;
				if(sumLHS== sumRHS){
					result =  true;
				} else {
					result =  false;
				}
			}
			return result;
			
			
	}

}
