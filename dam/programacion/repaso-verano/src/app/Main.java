package app;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		//Text to number converter
		/*Example 1:
		 * Input: "Three hundred million"
		 * Output: 300,000,000
		 * 
		 * Example 2:
		 * Input: "Five hundred thousand"
		 * Output: 500,000	
		 */
		
		// Phase one: 0 to 1000
		Scanner entrada = new Scanner(System.in);
		String textIn;
		Main main = new Main();
		
		System.out.println("Please enter the text to convert:");
		textIn = entrada.nextLine();
		
		System.out.println(main.textDivider(textIn));
		
	}
	public static int[] arrNumbers = new int[101];
	public static String[] arrNumbersName = {
            "cero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
            "twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five", "twenty-six", "twenty-seven", "twenty-eight", "twenty-nine", "thirty",
            "thirty-one", "thirty-two", "thirty-three", "thirty-four", "thirty-five", "thirty-six", "thirty-seven", "thirty-eight", "thirty-nine", "forty",
            "forty-one", "forty-two", "forty-three", "forty-four", "forty-five", "forty-six", "forty-seven", "forty-eight", "forty-nine", "fifty",
            "fifty-one", "fifty-two", "fifty-three", "fifty-four", "fifty-five", "fifty-six", "fifty-seven", "fifty-eight", "fifty-nine", "sixty",
            "sixty-one", "sixty-two", "sixty-three", "sixty-four", "sixty-five", "sixty-six", "sixty-seven", "sixty-eight", "sixty-nine", "seventy",
            "seventy-one", "seventy-two", "seventy-three", "seventy-four", "seventy-five", "seventy-six", "seventy-seven", "seventy-eight", "seventy-nine", "eighty",
            "eighty-one", "eighty-two", "eighty-three", "eighty-four", "eighty-five", "eighty-six", "eighty-seven", "eighty-eight", "eighty-nine", "ninety",
            "ninety-one", "ninety-two", "ninety-three", "ninety-four", "ninety-five", "ninety-six", "ninety-seven", "ninety-eight", "ninety-nine", "one-hundred"
        };
	
	private void fillArrNumbers() {
		for (int i = 0; i < arrNumbers.length; i++) {
			arrNumbers[i] = i;
		}
	}
	
	public int toInt(String text) { 
		return 0;
	}
	
	public String textDivider(String fullText) { //This method will take the diferents parts of the string and return one by one each word
		String result = "";
		String[] arrStr = fullText.split(" ");	//We´ll divide it in two parts, if the string is one word then the number its between 0-100 otherwise it´ll be higher
		if (arrStr.length > 1) {				//Multiple words case scenario 
			int midResult = 0;				//Doesnt recognise thousand 
			for (String word:arrStr) {
				midResult += Integer.parseInt(textDivider(word));
			}
			result += midResult;
		}else if (arrStr.length == 1) {			//One word case scenario
			fillArrNumbers();
			int number = 0;
			boolean continuar = true;
			
			do {
				if (number == 100) {			
					continuar = false;
				}
				if (arrNumbersName[number].equalsIgnoreCase(arrStr[0])) {
					result = number + "";
					continuar = false;
				}
					
				number++;
			}while (continuar);
		}
		return result;
	}
}

//String resul = "3"+"00"+"2";
//System.out.println(resul);
//int suma = 1;
//System.out.println(resul + suma);