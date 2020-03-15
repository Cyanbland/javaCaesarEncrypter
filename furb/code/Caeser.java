package furb.code;

import java.lang.*;
import java.util.*;

public class Caeser {
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Informe a palavra a ser encriptada: ");
		String myString = scanner.nextLine();
		System.out.println("Informe a chave: ");
		int key = scanner.nextInt();
		scanner.close();


		char[] characters = getCharArray(myString);
		//Integer[] values;
		int[] valuesSrc = {};
		int[] values = Arrays.copyOf(valuesSrc, valuesSrc.length + 1);

		

		values = getAlphaNum(characters);
		int[] encryptedArray = encryptArray(values, key); 
		char[] lettersArray = buildLettersArrayByEncryptedArray(encryptedArray);
		String encryptedOutput = buildStringByLettersArray(lettersArray);
		
		System.out.println("A palavra " + myString + " encriptada pela chave " + key + " resulta: "	+ encryptedOutput);
		
//		System.out.println(lettersArray[0]);
//		System.out.println(lettersArray[1]);
//		System.out.println(lettersArray[2]);
//		System.out.println(lettersArray[3]);
//		System.out.println(lettersArray[4]);
//		System.out.println(lettersArray[5]);
		
		//a = 10; z = 35;
	}
	private static char[] getCharArray(String str)
	{
		return str.toCharArray();
	}
	private static int convertLetterToId(char ch)
	{
		return Character.getNumericValue(ch);
	}
	//	private static Integer[] addIntToArray(Integer[] srcArray, int num)
	private static int[] getAlphaNum(char[] arrayToConvert)
	{
		int[] newArray = new int[arrayToConvert.length];
		for (int i = 0; i < arrayToConvert.length; i++)
		{
			int charPos = getCharPos(arrayToConvert[i]);
			newArray[i] = charPos + 10;
		}
		return newArray;
		}
	
	private static int getCharPos(char letter)
	{
		char[] alphabetCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for (int i = 0; i < alphabetCharacters.length; i++)
		{
			letter = Character.toUpperCase(letter);
			if (alphabetCharacters[i] == letter)
			{
				return i;
			}
		}
		return 355;
	}
	private static char getChar(int number)
	{
		char[] alphabetCharacters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (int i = 0; i < alphabetCharacters.length; i++)
		{
			if (i == number - 10) 
			{
				return alphabetCharacters[i];
			}
		}
		return ".".toCharArray()[0];
	}
	//if((numero % 26))
	//setar como numero
	//28 % 26 = 2
	//2 = numero
	
	private static int[] encryptArray(int[] arr, int key)
	{
		int[] arrayFinished = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
		{
			arrayFinished[i] = arr[i] + key;
		}
		return arrayFinished;
	}
	
	private static char[] buildLettersArrayByEncryptedArray(int[] arr)
		{
			char[] finalCharArray = new char[arr.length];			
			for (int i = 0; i < arr.length; i++)
			{
				char c = getChar(arr[i]);
				finalCharArray[i] = c;
			}
			System.out.println(finalCharArray);
			return finalCharArray;
		}
	private static String buildStringByLettersArray(char[] charArray)
	{
		String str = String.valueOf(charArray);
		str = str.replace(".", "#");
		return str;
	}
	
}



