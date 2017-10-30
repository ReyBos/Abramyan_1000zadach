/*	Описать функцию IsPalindrome(k), возвращающую true, если целый параметр k является
	полидромом (то есть его запись читается одинаково слева направо и справа налево), 
	и false в противном случае.		*/

class Proc31 {
	public static void main(String[] args) {
		int k = 123321;
		System.out.println("Число k = " + k + " является полидромом: " + IsPalindrome(k));
		k = 12321;
		System.out.println("Число k = " + k + " является полидромом: " + IsPalindrome(k));
		k = 1;
		System.out.println("Число k = " + k + " является полидромом: " + IsPalindrome(k));
		k = 125621;
		System.out.println("Число k = " + k + " является полидромом: " + IsPalindrome(k));
	}

	//	определяет является ли число полидромом
	static boolean IsPalindrome(int k) {
		int k1 = k;			
		int num = 0; 	

		//	определяем количество цифр в числе
		while (k >= 10) {			
			num++;
			k /= 10;
		}
		num++;

		//	если число состоит из одной цифры - оно не полидром
		if (num == 1) return false;

		//	сравниваем между собой 1 и последнюю, 2 и предпоследнюю и т.д. цифру числа
		int j = 1;
		for (int i = num; i >= j; i--, j++) {
			if (DigitN(k1, i) != DigitN(k1, j)) return false;
		} 
		return true;		
	}

	//	возвращает n-ю цифру числа, если цифры под нужным номером нет, возвращает -1
	static int DigitN(int k, int n) {
		int count = 0;
		while (k >= 10) {
			count++;
			if (count == n) return (k % 10);
			k /= 10;
		}
		count++;
		if (count == n) return k;
		else return -1;
	}
}