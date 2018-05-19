package com.revature.eval.java.core;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String string1 = phrase;
		String string2 = "";
		char a;
		
		for( int i = 0; i < string1.length();i++) {
			if(i == 0) {
				a = string1.charAt(0);
				string2 += a;
			}
			else if(string1.charAt(i) == ' '|| string1.charAt(i) == '-' ) {
				a = string1.charAt(i+1);
				string2 += a;		
				}
		}
		string2.toUpperCase();
		return string2;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			boolean out = false;
			if(sideOne == sideTwo && sideTwo == sideThree) {
			out = true;;
			}
			else {
				out = false;
			}
			return out; 
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			boolean out = false;
			if((sideOne == sideTwo && sideTwo != sideThree) 
					|| (sideOne != sideTwo && sideThree == sideOne) 
					||(sideThree == sideTwo && sideThree != sideOne )) {
				out = true;
			}
			else {
				out = false;
			}
			return out;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			boolean out = false;
			if(sideOne != sideTwo && sideTwo != sideThree && sideThree != sideOne  ) {
				out = true;
			}
			else {
				out = false;
			}
				
			return out;
			
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		int score = 0;
		String string1 = string.toUpperCase();
        for (int i = 0; i < string1.length(); i++){
            char calculatedLetter = string1.charAt(i);
            switch (calculatedLetter) {
                case 'A':
                case 'E':
                case 'I':
                case 'L':
                case 'N':
                case 'O':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                    score +=1; break;
                case 'D':
                case 'G':
                    score +=2; break;
                case 'B':
                case 'C':
                case 'M':
                case 'P':
                    score +=3; break;
                case 'F':
                case 'H':
                case 'V':
                case 'W':
                case 'Y':
                    score +=4; break;
                case 'K':
                    score +=5; break;
                case 'J':
                case 'X':
                    score +=8; break;
                case 'Q':
                case 'Z':
                    score +=10; break;
                default: break;
            }
        }
        return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		String string1 = null;
		string1 = string;
		String string2 = " ";
		int numcsount = 0;
		char c = ' ';
		for(int i = 0;i< string1.length();i++){
			c = string1.charAt(i);
			if(Character.isDigit(c) == true ) {
				string2 += c;
				numcsount++;				
			}	
		}
		
		if( numcsount > 10 || numcsount < 9) {
			
		}
		return string2;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		HashMap<String, Integer> map = new HashMap<>();
		String sentence = string.toLowerCase();

		for(String word : sentence.split("\\W")) {
		    if(word.isEmpty()) {
		        continue;
		    }
		    if(map.containsKey(word)) {
		        map.put(word, map.get(word)+1);
		    }
		    else {
		        map.put(word, 1);
		    }
		}
		return map;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			
//			List<T> ThisList = getSortedList();
//		    // get the start index of target number
//		    int startIndex = -1;
//		    int left = 0;
//		    int right = ThisList.size() - 1;
//		    while (left <= right)
//		    {
//	            int m = left + (right-left)/2;
//	            if (ThisList.get(m) == t)
//	                return m;
//		            if (ThisList.get(m) < t)
//	                left = m + 1;
//	            else
//	                right = m - 1;
//	        }
		    return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		Scanner pig = new Scanner(System.in);
		String word;  
	     String latin = "";  
	     char first;
	     boolean cap = false;
	     String line = string;
	     pig = new Scanner(line);
	    // loop through all the words in the line
	     while (pig.hasNext())
	     {
	        word = pig.next();
	        first = word.charAt(0);
	        if ('A' <= first && first <= 'Z')  
	        {
	           first = Character.toLowerCase(first);
	           cap = true;
	        }
	        else
	            cap = false;
	        if (first=='a' || first=='e' || first=='i' || first=='o' || first=='u')
	           latin = word + "ay";
	       else
	        {   
	           if (cap)
	           {
	              latin = "" + Character.toUpperCase(word.charAt(1));  // char to String conversion
	              latin = latin + word.substring(2) + first + "ay";
	           }
	           else  
	              latin = word.substring(1) + first + "ay";
	        }
	     }
	     pig.close();
	     return latin;
	  }

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		int c = 0;
	    int a = 0;
	    int temp = 0;
	    int n = input;
	    temp = n;  
	    while(n>0)  
	    {  
	    a=n%10;  
	    n=n/10;  
	    c=c+(a*a*a);  
	    }  
	    if(temp==c)  
	    	return true;   
	    else  
	        return false;   
	   }

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		List<Long> factors = new ArrayList<Long>();
		long factorizing = l;
		for (long i = 2; i <= factorizing / i; i++) {
			while (factorizing % i == 0) {
				factors.add(i);
				factorizing /= i;
			}
		}
		if (factorizing > 1) {
			factors.add(factorizing);
		}
		return factors;
//		return null;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			StringBuilder encoded = new StringBuilder();
			for (int i = 0; i < string.length(); i++) {
				if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
					encoded.append((char)(((int)string.charAt(i)+key-(int)'A')%26 + (int)'A'));
				} else if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
					encoded.append((char)(((int)string.charAt(i)+key-(int)'a')%26 + (int)'a'));
				} else {
					encoded.append(string.charAt(i));
				}
			}
return encoded.toString();
			
			//return null;
		}
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		int nth = i;		 
	    int j;
	    int numsum = 0;
	    int num = 1;
	    int count = 0;
	 if(i == 0) {
		 return 0;
		 
	 }
	 else {
	    while (count < nth){
	      num=num+1;
	      for (j = 2; j <= num; j++){
	        if (num % j == 0) {
	          break;
	        }
	      }
	      if ( j == num){
	        count = count+1;
	        numsum += count;
	      //  System.out.println(numsum);
	      }
	    }
	 }
		return numsum;
		}

	/**
	 * 13 & 14. , an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			int skipspace = 0;
			String allchar = "abcdefghijklmnopqrstuvwxyz";
			String plainText = string;
			plainText = plainText.replaceAll(" ", "");
			plainText = plainText.toLowerCase();
			int len = plainText.length();
			int len1 = allchar.length();
			String cipher = "";

			for (int i = 0; i < len; i++) {
				char b = plainText.charAt(i);
				for (int j = 0; j < len1; j++) {
					char c = allchar.charAt(j);
					if (c == b) {
						int index = allchar.indexOf(c);
						int position = (len1 - 1) - index;
						
						if(skipspace == 3) {
							cipher += ' ';
							skipspace = 0;
						}
						skipspace++;
						cipher += allchar.charAt(position);
						cipher.toLowerCase();
						break;

					}
				}
			}

			return cipher;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			String original = string.replaceAll("\\s", "");
			StringBuilder decoded = new StringBuilder();

			for (int i = 0; i < original.length(); i++) {
				if (Character.isLetter(original.charAt(i))) {
					decoded.append((char) ('a' + 'z' - Character.toLowerCase(original.charAt(i))));
				} else {
					decoded.append(original.charAt(i));
				}
			}
			return decoded.toString();	
//			return null;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		int digitcount = 10;
		char charspace = ' ';
		char chardash = '-';
		char digitati;
		int numsum = 0;
		
		for(int i =0; i< string.length();i++) {
			digitati = string.charAt(i);
			if (0 > digitati || 9 < digitati) {
				numsum += (digitati * (10 - digitcount));
				digitcount --;
			}
			else if(digitati == 'X') {
				numsum += 10;
				digitcount--;
			}
			else {
				
			}
		}
		if(numsum%11 ==0 && digitcount == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
//		List<Character> alphabets = new ArrayList<Character>();
//		alphabets.add('a');
//		alphabets.add('b');
//		alphabets.add('c');
//		alphabets.add('d');
//		alphabets.add('e');
//		alphabets.add('f');
//		alphabets.add('g');
//		alphabets.add('h');
//		alphabets.add('i');
//		alphabets.add('j');
//		alphabets.add('k');
//		alphabets.add('l');
//		alphabets.add('m');
//		alphabets.add('n');
//		alphabets.add('o');
//		alphabets.add('p');
//		alphabets.add('q');
//		alphabets.add('r');
//		alphabets.add('s');
//		alphabets.add('t');
//		alphabets.add('u');
//		alphabets.add('v');
//		alphabets.add('w');
//		alphabets.add('x');
//		alphabets.add('y');
//		alphabets.add('z');
//		String str = string;
//		str.toLowerCase();
//		str = str.replace(" ", "");
//		char[] strChar = str.toCharArray();
//		for (int i = 0; i < strChar.length; i++) {
//		    char inp = strChar[i];
//		    if (alphabets.contains(inp)) {
//		        alphabets.remove(inp);
//		    }
//		}
//		if (alphabets.isEmpty())
//		    return true;
//		else
//		    return false;
		Set<Character> checked = new HashSet<Character>();
		for (int i = 0; i < string.length(); i++) {
			if (Character.isLetter(string.charAt(i))) {
				checked.add(Character.toLowerCase(string.charAt(i)));
			}
		}
return checked.size() == 26;
		
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		
//		ChronoField.sec
			if (given.isSupported(ChronoUnit.SECONDS)) {
				
				return given.plus(1000000000l, ChronoUnit.SECONDS);
			} 
			else {
				return LocalDateTime.of(given.get(ChronoField.YEAR), given.get(ChronoField.MONTH_OF_YEAR), given.get(ChronoField.DAY_OF_MONTH), 0, 0).plus(1000000000l, ChronoUnit.SECONDS); 
	}
//		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
			Set<Integer> multiples = new HashSet<Integer>();
			for (int j = 0; j < set.length; j++) {
				for (int k = 1; k*set[j] < i; k++) {
					multiples.add(set[j]*k);
				}
			}
			int sum = 0;
			for (Integer multi : multiples) {
				sum += multi;
			}
	return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
//		int[] ints = new int[string.length()];
//		for (int i = 0; i < string.length(); i++) {
//			ints[i] = Integer.parseInt(string.substring(i, i + 1));
//		}
//		for (int i = ints.length - 2; i >= 0; i = i - 2) {
//			int j = ints[i];
//			j = j * 2;
//			if (j > 9) {
//				j = j - 9;
//			}
//			ints[i] = j;
//		}
//		int sum = 0;
//		for (int i = 0; i < ints.length; i++) {
//			sum += ints[i];
//		}
//			return sum % 10 == 0;
		
		String check = string.replaceAll(" ", "");
		int sum = 0;
		boolean doubleIt = false;
		for (int i = check.length()-1; i >= 0; i--) {
			if (!Character.isDigit(check.charAt(i))) {
				return false;
			}
			if (doubleIt) {
				if (Character.getNumericValue(check.charAt(i)) * 2 > 10) {
					sum += (Character.getNumericValue(check.charAt(i)) * 2) - 9;
				} else {
					sum += (Character.getNumericValue(check.charAt(i)) * 2);
				}
			} else {
				sum += Character.getNumericValue(check.charAt(i));
			}
			doubleIt = !doubleIt;
		}
return sum % 10 == 0;
		
	}
	

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		
		int numsum = 0;
		char c = ' ';
		String string1 = string;
		int firstValue =0;
		int secondValue = 0;
	    char operator = '+';
	    for(int i =0; i < string1.length()-1;i++) {
	    	c = string1.charAt(i);	    	
	    	if(Character.isDigit(c)) {
	    		
	    		firstValue = string1.indexOf(i);
	    		if(string.substring(i-1) == "-") {
	    			firstValue = firstValue *-1;
	    			}
	    		operator = string1.charAt(i +3);	
	    		for(int j =i+1; j < string1.length()-1;j++) {
	    	    	c = string1.charAt(j);
	    			if(Character.isDigit(c)) {
	    				secondValue =string1.indexOf(j);
	    				break;
	    					}
	    			break;
	    				}
    			break;
	    		} 
			break;
	    }
	    switch (operator){
	        case 'u':
	            numsum = firstValue + secondValue;
	        case 'n':
	        	numsum = firstValue - secondValue;
	        case 'v':
	        	numsum = firstValue / secondValue;
	        case 'l':
	        	numsum = firstValue * secondValue;
//	        default:
//	        	System.out.println("I didn't work.");
	    	}
	    return numsum;
	}
}
