/*
	Дана строка, состоящая из русских слов, набранных заглавными буквами и разделенных пробелами
	(одним или несколькими). Найти количество слов, которые начинаются и заканчиваются одной и 
	той же буквой.
*/
class String42 {
	public static void main(String[] args) {
		String str = "Арка  мышь аббревиатура рука спас Тест";
		int start = (int)(str.charAt(0));	//	первая буква слова
		int end = 0;						//	последняя буква слова
		int count  = 0;						//	счётчик слов с одинаковыми буквами

		for (int i = 1; i < str.length(); i++) {	
			int num = (int)(str.charAt(i));		//	текущая буква

			//	проверяем последнее слово
			if (i == (str.length() - 1)) {
				end = str.charAt(i);
				if ((end == start) || (end == (start + 32))) 
					count++;
			}
			//	пробел = 32
			//	когда найдена последня буква слова, делаем проверку
			if ((num == 32) && ((int)(str.charAt(i-1))) != 32) {
				end = str.charAt(i-1);				
				if ((end == start) || (end == (start + 32))) 
					count++;				
			} 
			//	записываем в переменную start первую букву слова
			if ((num == 32) && ((int)(str.charAt(i+1)) != 32))
				start = (int)(str.charAt(i+1));			
		}

		System.out.println("В строке: " + str);
		System.out.println("Количество слов, начинающихся и заканчивающихся одной и той же буквой: " + count);
	}
}