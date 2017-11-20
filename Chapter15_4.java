/*
	Во всех заданиях данного пункта предполагается, что исходные строки являются непустыми
	и не содержат начальных и конечных пробелов.
	Дана строка, состоящая из русских слов, разделенных пробелами.
*/

class Chapter15_4 {
	public static void main(String[] args) {			

		//	String41: Найти количество слов в строке
		/*
		String str = "Создаем класс в котором объявляется массив для хранения очереди";
		OperationsOnStrings obj = new OperationsOnStrings(str);
		System.out.println("Исходная строка: \n" + str);
		System.out.println("Количество слов в строке: " + obj.NumberOfWords(str));
		*/

		//	String42: Найти количество слов, которые начинаются 
		//	и заканчиваются одной и той же буквой
		
		String str = "Арка  мышь аббревиатура рука спас Тест";
		OperationsOnStrings obj = new OperationsOnStrings(str);
		System.out.println("Исходная строка: \n" + str);
		System.out.println("Количество слов с одинаковым началом и концом: " + obj.TheSameStartEnd());				
	}
}

class OperationsOnStrings {
	String[] words;			//	Массив содержащий все слова строки
	String changeStr = "";	//	Записывается измененная строка, согласно задания

	//	Разбиваееет строку на слова и записывает в массив
	OperationsOnStrings(String str) {
		words = new String[NumberOfWords(str)];	

		int i = 0;
		String word = "";
		for (int j = 0; j < str.length(); j++)  {
			char ch = str.charAt(j);
			
			if ((int) ch != 32) 
				word += ch;

			if ((((int) ch == 32) && ((int)(str.charAt(j+1)) != 32)) || (j == (str.length() - 1))) {
				words[i] = word;
				word = "";
				i++;
			}
			else continue;			
		}	
	}	
	
	//	Выводит на консоль измененную строку
	void ShowString() {
		System.out.println("Изменённая строка: " + changeStr);
	}

	//	String41	//
	//	возвращает количество слов в строке
	int NumberOfWords(String str) {
		int count = 1;	//	счётчик
		for (int i = 0; i < str.length(); i++) {
			if (((int)(str.charAt(i)) == 32) && ((int)(str.charAt(i+1)) != 32)) count++;
		}
		return count;
	}

	//	String42	//
	//	возвращает количество слов, которые начинаются и заканчиваются одной и той же буквой
	int TheSameStartEnd() {
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			int start = (int)(words[i].charAt(0));						//	первая буква слова
			int end = (int)(words[i].charAt(words[i].length() - 1));	//	последняя буква слова
			if ((start == end) || ((start + 32) == end)) count++;
		}
		return count;
	}
}