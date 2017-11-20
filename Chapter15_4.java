/*
	Во всех заданиях данного пункта предполагается, что исходные строки являются непустыми
	и не содержат начальных и конечных пробелов.
	Дана строка, состоящая из русских слов, разделенных пробелами.
*/

class Chapter15_4 {
	public static void main(String[] args) {			

		//	String41: Найти количество слов в строке
		String str = "Создаем класс в котором объявляется массив для храненя очереди";
		OperationsOnStrings obj = new OperationsOnStrings(str);
		System.out.println("Исходная строка: \n" + str);
		System.out.println("Количество слов в строке: " + obj.NumberOfWords(str));


	}
}

class OperationsOnStrings {
	String[] words;			//	Массив содержащий все слова строки
	String changeStr = "";	//	Записывается измененная строка, согласно задания

	OperationsOnStrings(String str) {
		words = new String[NumberOfWords(str)];
	}

	//	String41	//
	//	возвращает количество слов в строке
	int NumberOfWords(String str) {
		int count = 1;	//	счётчик
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) == 32) && (str.charAt(i+1) != 32)) count++;
		}
		return count;
	}


	
	//	Выводит на консоль измененную строку
	void ShowString() {
		System.out.println("Изменённая строка: " + changeStr);
	}
}