class Chapter14_3 {
	public static void main(String[] args) {
		int m = 5;
		int n = 6;
		int[][] arr = new int[m][n];
		
		Matrix obj = new Matrix();
		//	Заполнить массив случайными числами
		obj.Fill(arr);
		//	Вывести массив на консоль
		obj.Show(arr, "Массив случайных чисел: ");

		//	Matrix47: поменять местами две строки k1 и k2
		int k1 = 0;
		int k2 = 1;
		obj.ChangeLine(arr, k1, k2);
		obj.Show(arr, "В массиве поменяны строки");
	}
}

class Matrix {	

	//	заполняет матрицу случайными числами
	void Fill(int[][] arr) {		
		for (int i = 0; i < arr.length; i++) 
			for (int j = 0; j < arr[i].length; j++) 
				arr[i][j] = (int) (10 + Math.random() * 30);			
	}

	//	выводит массив на консоль
	void Show(int[][] arr, String msg) {
		System.out.println(msg);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) 				
				System.out.print(arr[i][j] + " "); 			
			System.out.println();
		}
		System.out.println();
	}

	//	Меняет местами две строки
	void ChangeLine(int[][] arr, int k1, int k2) {
		for (int i = 0; i < arr[0].length; i++) {
			int num = arr[k1][i];
			arr[k1][i] = arr[k2][i];
			arr[k2][i] = num;
		}
	}
}
