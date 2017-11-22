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
		/*
		String str = "Арка  мышь аббревиатура рука спас Тест";
		OperationsOnStrings obj = new OperationsOnStrings(str);
		System.out.println("Исходная строка: \n" + str);
		System.out.println("Количество слов с одинаковым началом и концом: " + obj.TheSameStartEnd());	
		*/

		//	String45:	Найти длину самого короткого слова
		/*
		String str = "Создаем класс котором объявляется массив для хранения очереди";
		OperationsOnStrings obj = new OperationsOnStrings(str);
		System.out.println("Исходная строка: \n" + str);
		System.out.println("Длина самого короткого слова: " + obj.ShortestWord());
		*/

		//	String47:	Вывести строку с разделителем "." вместо пробелов
		
		String str = "Создаем класс в котором объявляется массив для хранения очереди";
		OperationsOnStrings obj = new OperationsOnStrings(str);
		System.out.println("Исходная строка: \n" + str);
		obj.Delimiter(".");
		System.out.println("Точки вместо пробелов: \n" + obj.changeStr);
		

	}
}

class OperationsOnStrings {
	String[] words;			//	Массив содержащий все слова исходной строки
	String changeStr = "";	//	Записывается измененная строка, согласно задания

	//	Разбивает строку на слова и записывает в массив
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

	//	String45	//
	//	ищет длину самого короткого слова
	int ShortestWord() {
		int min = words[0].length();
		for (int i = 1; i < words.length; i++)
			if (min > words[i].length()) min = words[i].length();
		return min;
	}

	//	String47	//
	//	создает строку с заданным разделителем
	void Delimiter(String str) {
		for (int i = 0; i < words.length; i++) {
			changeStr += words[i];
			if (i == (words.length - 1)) continue;
			changeStr += str;
		}
	}

}