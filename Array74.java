/*	Дан массив размера n. Обнулить элементы массива, расположенные между его минимальными
	и максимальными элементами (не включая минимальный и максимальный элементы).	*/

class Array74 {
	public static void main(String[] args) {
		int numMin = 0;		
		int numMax = 0;
		int n = 10;
		int[] crr = new int[n];
		Rnd(crr);

		//	находим позиции минимального и максимального элементов
		numMin = Min(crr);	
		System.out.println("numMin = " + numMin);	
		numMax = Max(crr);	
		System.out.println("numMax = " + numMax);	

		if (numMin < numMax) {
			for (int i = (numMin + 1); i < numMax; i++) {
				crr[i] = 0;
			}
		}
		else {
			for (int i = (numMax + 1); i < numMin; i++) {
				crr[i] = 0;
			}
		}
		
		System.out.println("Изменённый массив: ");
		for (int i = 0; i < crr.length; i++) {
			System.out.print(crr[i] + " ");
		}
		System.out.println();
	}


	//	Заполняет массив случайными числами от 1 до 15 и выводит их на консоль
	static void Rnd(int[] arr) {
		System.out.println("Массив случайных чисел: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (1 + (Math.random() * 14));
			System.out.print(arr[i] + " ");			
		}
		System.out.println();
	}

	//	Находит позицию минимального элемента
	static int Min(int[] arr) {
		int min = arr[0];
		int numMin = 0;
		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
				numMin = i;
			}			
		}
		return numMin;
	}

	//	Находит позицию максимального элемента
	static int Max(int[] arr) {
		int max = arr[0];
		int numMax = 0;
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				numMax = i;
			}			
		}
		return numMax;
	}
}