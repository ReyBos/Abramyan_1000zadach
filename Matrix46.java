/*	Дана целочсленная матрица размера mxn. Найти элемент, являющийся максимальным в своей
	строке и минимальным в своем столбце. Если такой элемент отсутствует, то вывести 0	*/
class Matrix46 {
	public static void main(String[] args) {
		int[][] arr = 
		{
			{2, 10, 3, 4, 9, 0},
			{1, 11, 3, 6, 15, 9},
			{3, 12, 2, 3, 4, 8},
			{9, 15, 9, 3, 7, 8},
			{7, 19, 2, 5, 4, 2},
		};

		for (int i = 0; i < arr.length; i++) 
			if (MinColumn(arr, i)) 
				System.out.println("Элемент " + MaxLine(arr, i) + " является максимальным в cтроке " + i + " и минимальным в своем столбце.");
			else 
				System.out.println("Максимальный элемент в строке " + i + " не является минимальным в своем столбце.");
	}	

	//	Проверяет является ли максимальный элемент в строке, минимальным в столбце
	//	i - номер проверяемой строки
	static boolean MinColumn(int[][] arr, int i) {
		int j = MaxLine(arr, i); 	//	номер столбца максимального элемента
		int min = arr[i][j];
		for (int k = 0; k < arr.length; k++)
			if (arr[k][j] < min) return false;
		return true;
	}

	//	Ищет позицию максимального элемента в строке
	static int MaxLine(int[][] arr, int i) {
		int max = arr[i][0];
		int pos = 0;
		for (int j = 1; j < arr[i].length; j++) 
			if (arr[i][j] > max) {
				max = arr[i][j];
				pos = j;
			}		
		return pos;
	}

}