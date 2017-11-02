/*	Дана целочисленная матрица размера mxn. Найти номер последней из её строк, содержащих
	только чётные числа.	*/
class Matrix34 {
	public static void main(String[] args) {
		int m = 5;
		int n = 4;
		int[][] arr = new int[m][n];
		Rnd(arr);
		if (Even(arr) == -1) System.out.println("Строк содержащих только чётные числа нет");
		else System.out.println("Номер последней строки, содержащей только чётные числа: " + Even(arr));
	}

	//	Заполняет массив случайными числами
	static void Rnd(int[][] arr) {
		System.out.println("Массив случайных чисел: ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int) (10 + Math.random() * 9);
				System.out.print(arr[i][j] + " "); 
			}
			System.out.println();
		}
		System.out.println();
	}

	//	Ищет номер последней строки, содержащей только чётные числа. Если таких строк
	//	нет, то возвращает -1
	static int Even(int[][] arr) {
		int num = -1;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] % 2 != 0) break;
				count++;
			}
			if (count == arr[i].length) num = i;
		}
		return num;		
	}
}