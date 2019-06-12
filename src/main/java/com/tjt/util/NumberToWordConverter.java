package com.tjt.util;

public class NumberToWordConverter {
	
	public String NumberToWord(String amount){
	String afterDecimal="";
	NumberToWord number=new NumberToWord();
	int rupees=Integer.parseInt(amount.split("\\.")[0]);
	String rupeesInWord=number.convert(rupees);
	rupeesInWord+=" Rupees ";
	int paisa=Integer.parseInt(amount.split("\\.")[1]);
	if(paisa !=0){
		afterDecimal +=" and ";
		afterDecimal=number.convert(paisa);
		afterDecimal +=" Paise";
	}
	String inWord=rupeesInWord+afterDecimal+" only";
	
		return inWord;
	}
}
