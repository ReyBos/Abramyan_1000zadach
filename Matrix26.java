/*	Дана матрица размера mxn. Найти номер ее столбца с наименьшим произведением элементов и 
	вывести данный номер, а также значение наименьшего произведения.	*/
class Matrix26 {
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] arr = new int[n][m];
		Rnd(arr);
		MinProdColumn(arr);
	}

	//	Заполняет массив случайными числами
	static void Rnd(int[][] arr) {
		System.out.println("Массив случайных чисел: ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int) (1 + Math.random() * 8);
				System.out.print(arr[i][j] + " "); 
			}
			System.out.println();
		}
		System.out.println();
	}

	//	Ищет столбец с наименьшим произведением его элементов, выводит это произведение
	//	и номер столбца
	static void MinProdColumn(int[][] arr) {
		int min = 0;
		int num = 0;
		for (int i = 0; i < arr[0].length; i++) {
			int prod = 1;
			for (int j = 0; j < arr.length; j++) {
				prod *= arr[j][i];
			}
			if (i == 0) {
				min = prod;
				num = i;
			} else if (min > prod) {
				min = prod;
				num = i;
			}
		}
		System.out.println("У столбца " + num + " наименьшее произведение элементов, равное " + min);
	}
}