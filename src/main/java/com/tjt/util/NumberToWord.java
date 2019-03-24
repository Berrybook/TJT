package com.tjt.util;

public class NumberToWord {

	 String word;
	 String oneToNine[] = { "Zero", "One", "Two", "Three", "Four", "Five", "Six",
	   "Seven", "Eight", "Nine", };
	 String hundredToCrore[] = { "Hundred", "Thousand", "Lac", "Crore" };
	 String tenToNinty[] = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
	   "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen", };
	 String twentyToNinty[] = { "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy",
	   "Eighty", "Ninty" };

//convert the number into word
	 public String convert(int number) {
	  int n = 1;
	  int num;
	  word = "";
	  while (number != 0) {
	   switch (n) {
	   case 1:
	    num = number % 100;
	    //call parse Method
	    pass(num);
	    if (number > 100 && number % 100 != 0) {
	     show("and ");
	    }
	    number /= 100;
	    break;
	   case 2:
	    num = number % 10;
	    if (num != 0) {
	     show(" ");
	     show(hundredToCrore[0]);
	     show(" ");
	     pass(num);
	    }
	    number /= 10;
	    break;
	   case 3:
	    num = number % 100;
	    if (num != 0) {
	     show(" ");
	     show(hundredToCrore[1]);
	     show(" ");
	     pass(num);
	    }
	    number /= 100;
	    break;
	   case 4:
	    num = number % 100;
	    if (num != 0) {
	     show(" ");
	     show(hundredToCrore[2]);
	     show(" ");
	     pass(num);
	    }
	    number /= 100;
	    break;
	   case 5:
	    num = number % 100;
	    if (num != 0) {
	     show(" ");
	     show(hundredToCrore[3]);
	     show(" ");
	     pass(num);
	    }
	    number /= 100;
	    break;
	   }
	   n++;
	  }
	  return word;
	 }


	 public void pass(int number) {
	  int word, q;
	  if (number < 10) {
	   show(oneToNine[number]);
	  }
	  if (number > 9 && number < 20) {
	   show(tenToNinty[number - 10]);
	  }
	  if (number > 19) {
	   word = number % 10;
	   if (word == 0) {
	    q = number / 10;
	    show(twentyToNinty[q - 2]);
	   } else {
	    q = number / 10;
	    show(oneToNine[word]);
	    show(" ");
	    show(twentyToNinty[q - 2]);
	   }
	  }
	 }


	 public void show(String s) {
	  String st;
	  st = word;
	  word = s;
	  word += st;
	 }
}
