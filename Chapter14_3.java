//	Задачи из раздела 14.3 "Преобразование матриц". При выполнении заданий из данного раздела
//	не следует использовать вспомогательные двумерные массивы
class Chapter14_3 {
	public static void main(String[] args) {
		int m = 4;
		int n = 6;
		int[][] arr = new int[m][n];
		
		Matrix obj = new Matrix();
		//	Заполнить массив случайными числами
		obj.Fill(arr);
		//	Вывести массив на консоль
		obj.Show(arr, "Массив случайных чисел: ");

		//	Matrix47: поменять местами две строки с номерами k1 и k2
		/*
		int k1 = 0;
		int k2 = 1;
		obj.ChangeLine(arr, k1, k2);
		obj.Show(arr, "В массиве поменяны строки");
		*/

		//	Matrix50: поменять минимальный и максимальный элемент в каждом столбце
		/*
		obj.ChangeMinMaxColumn(arr);
		obj.Show(arr, "Массив с поменяными минимальными и максимальными элементами в каждом столбце: ");
		*/

		//	Matrix51: поменять местами минимальный и максимальный элементы массива
		/*
		obj.ChangeMinMax(arr);
		obj.Show(arr, "В массиве поменяны местами минимум и максимум: ");
		*/

		//	Matrix55: поменять местами нижнюю и верхнюю половины матрицы, с четным числом строк
		/*
		obj.ChangeTopBot(arr);
		obj.Show(arr, "Поменяны местами верхняя и нижная половины матрицы: ");
		*/

		//	Matrix60: Зеркально отразить элементы матрицы относительно вертикальной
		//	оси симметрии
		
		obj.VerticalMirror(arr);
		obj.Show(arr, "Зеркально отраженная матрица, относительно вертикальной оси");
				
	}
}

class Matrix {	

	//	Заполняет матрицу случайными числами
	void Fill(int[][] arr) {		
		for (int i = 0; i < arr.length; i++) 
			for (int j = 0; j < arr[i].length; j++) 
				arr[i][j] = (int) (10 + Math.random() * 89);			
	}

	//	Выводит массив на консоль
	void Show(int[][] arr, String msg) {
		System.out.println(msg);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) 				
				System.out.print(arr[i][j] + " "); 			
			System.out.println();
		}		
	}

	//	Matrix47	//
	//	Меняет местами две строки
	void ChangeLine(int[][] arr, int k1, int k2) {
		for (int i = 0; i < arr[0].length; i++) {
			int num = arr[k1][i];
			arr[k1][i] = arr[k2][i];
			arr[k2][i] = num;
		}
	}

	//	Matrix50	//
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

	//	Matrix51	//
	//	Меняет местами минимальный и максимальный элемент матрицы
	void ChangeMinMax(int[][] arr) {
		MinMax(arr);
		int chg = arr[minLine][minColumn];
		arr[minLine][minColumn] = arr[maxLine][maxColumn];
		arr[maxLine][maxColumn] = chg;
	}

	int minLine	= 0;		//	пизиция минимального элемента (строка)
	int minColumn = 0;		//	пизиция минимального элемента (столбец)
	int maxLine = 0;		//	пизиция максимального элемента (строка)
	int maxColumn = 0;		//	пизиция максимального элемента (столбец)

	//	Ищет минимальный и максимальный элементы массива
	void MinMax(int[][] arr) {
		int min = arr[0][0];
		int max = arr[0][0];
		minLine = minColumn = maxLine = maxColumn = 0;

		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[i].length; j++) {
				if (min > arr[i][j]) {
					min = arr[i][j];
					minLine = i;
					minColumn = j;
				}
				else if (max < arr[i][j]) {
					max = arr[i][j];
					maxLine = i;
					maxColumn = j;
				}
			}
	}

	//	Matrix55	//
	//	Меняет местами верхнюю половину массива с нижней
	void ChangeTopBot(int[][] arr) {
		int temp = 0;
		int count = arr.length / 2;
		for (int i = 0; i < (arr.length / 2); i++) {
			for (int j = 0; j < arr[i].length; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[count][j];
				arr[count][j] = temp;
			}
			count++;
		}
	}

	//	Matrix60	//
	//	Отражает зеркально элементы матрицы относительно вертикальной оси симметрии
	void VerticalMirror(int[][] arr) {
		int k = arr[0].length - 1;
		for (int i = 0; i < arr[0].length/2; i++) {
			for (int j = 0; j < arr.length; j++) {
				int temp = arr[j][i];
				arr[j][i] = arr[j][k];
				arr[j][k] = temp;
			}
			k--;
		}
	}
}
