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
		/*
		int k1 = 0;
		int k2 = 1;
		obj.ChangeLine(arr, k1, k2);
		obj.Show(arr, "В массиве поменяны строки");
		*/

		//	Matrix50: поменять минимальный и максимальный элемент в каждом столбце
		obj.ChangeMinMaxColumn(arr);
		obj.Show(arr, "Массив с поменяными минимальными и максимальными элементами в каждом столбце: ");
	}
}

class Matrix {	

	//	Заполняет матрицу случайными числами
	void Fill(int[][] arr) {		
		for (int i = 0; i < arr.length; i++) 
			for (int j = 0; j < arr[i].length; j++) 
				arr[i][j] = (int) (10 + Math.random() * 30);			
	}

	//	Выводит массив на консоль
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

	//	Меняет минимальный и максимальный элемент в каждом столбце
	void ChangeMinMaxColumn(int[][] arr) {
		for (int j = 0; j < arr[0].length; j++) {
			int min = PositionMinColumn(arr, j);
			int max = PositionMaxColumn(arr, j);

			int num = arr[min][j];
			arr[min][j] = arr[max][j];
			arr[max][j] = num;
		}
	}

	//	Находит позицию минимального элмента в столбце
	int PositionMinColumn(int[][] arr, int j) {
		int min = arr[0][j];
		int pos = 0;
		for (int i = 1; i < arr.length; i++)
			if (arr[i][j] < min) {
				min = arr[i][j];
				pos = i;
			}
		return pos;
	}

	//	Находит позицию максимального элмента в столбце
	int PositionMaxColumn(int[][] arr, int j) {
		int max = arr[0][j];
		int pos = 0;
		for (int i = 1; i < arr.length; i++)
			if (arr[i][j] > max) {
				max = arr[i][j];
				pos = i;
			}
		return pos;
	}

}