/*	Описать функцию логического типа IsPrime(n), возвращающую true, если целый
	параметр n является простым числом, и false в противном случае	*/

class Proc28 {
	public static void main(String[] args) {
		int rnd;
		int count = 0;

		System.out.print("В наборе чисел: ");
		for (int i = 0; i < 10; i++) {
			//	формируем набор случайных чисел от 2 до 200
			rnd = (int) (2 + Math.random() * 198);
			System.out.print(rnd + " ");
			if (IsPrime(rnd)) count++;
		}
		System.out.println("\nКоличество простых чисел: " + count);
	}

	static boolean IsPrime(int rnd) {
		for (int i = 2; i <= (rnd/2); i++) {
			//	если исходное число делиться на цело на какое-либо число из промежутка 
			//	[2; rnd/2], то оно не является простым
			if ((rnd % i) == 0) return false;
		}
		return true;
	}
}