
public class AlgorithmsAssignment3A {
	public static void main(String args[]){
		
		int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8};
		
		System.out.println(AlgorithmsAssignment3B.numStep(testArray));
		//System.out.println(AlgorithmsAssignment3A.countTiles("BWBWB"));
		//System.out.println(AlgorithmsAssignment3A.countTiles("WWWWBBB"));
	}
	
	public static int countTiles(String str){
		int stepcount = 0, bcount = 0, wcount = 0;
		int bindex = 0, windex = str.length() - 1 ;
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
