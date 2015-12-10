//Name: Adam Schoelz

import java.util.*;

public class Assignment3A {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter a string of capital B's and W's, followed by enter.");
		String toTest = s.nextLine();
		System.out.println("Tile count: " + Assignment3A.numPaint(toTest));
		
		System.out.println("Please enter a bracketed, comma separated list of numbers, followed by enter.");
		String toTest = s.nextLine();
		StringBuilder str = new StringBuilder();
		str.append(toTest);
		toTest = toTest.replaceAll("\\s", "");
		toTest = toTest.replaceAll("\\{", "");
		toTest = toTest.replaceAll("\\}", "");
		toTest = toTest.replaceAll("\\[", "");
		toTest = toTest.replaceAll("\\]", "");
		String[] strArray = toTest.split(",");
		int[] intArray = new int[strArray.length];
		for(int i = 0; i < strArray.length; i++){
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		
		//Use this array to enter values quickly, simply replace in function call
		int[] testArray = {1, 2, 3, 8, 500, 23545, 545, 34534, 654, 767, -123, 45, 654, 67547, 3, 2452, 634, 63, 653, 74, 23, 23, 452, 234, 534, 87, 67, 876, 678};
		
		System.out.println(Assignment3B.numStep(intArray));
		
		s.close();
	}
	
	public static int numPaint(String str){
		int stepcount = 0, bcount = 0, wcount = 0;
		StringBuilder editStr = new StringBuilder(str);
		
		if(str.indexOf("W") == -1){
			return 0;
		}
		
		for(int i = 0; i < editStr.length(); i++){
			if(editStr.charAt(i) == 'W'){
				wcount++;
			}
			if(editStr.charAt(i) == 'B'){
				bcount++;
			}
		}
		
		while(editStr.indexOf("W") < editStr.lastIndexOf("B")){
			int index1 = editStr.indexOf("W");
			int index2 = editStr.lastIndexOf("B");
			
			editStr.setCharAt(index1, 'B');
			editStr.setCharAt(index2, 'W');
			stepcount+=2;
		}
		
		return Math.min(stepcount, Math.min(bcount, wcount));
	}

}
