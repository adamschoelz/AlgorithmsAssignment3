import java.util.ArrayList;


public class AlgorithmsAssignment3B {
	public static int numStep(int[] int_array){
		int count = 0, left = 0, right = 0, baseline = -1;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		if(checkPalindrome(int_array)){
			return 0;
		}
		
		//Copy array and determine baseline score
		for(int i = 0; i < int_array.length; i++){
			arr.add(int_array[i]);
			baseline++;
		}
		
		for(int i = 0; i < arr.size(); i++){
			
		}
		
		System.out.println(baseline);
		
		return count;
	}
	
	public static boolean checkPalindrome(int[] arr){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != arr[arr.length - i - 1]){
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean checkPalindrome(ArrayList<Integer> arr){
		for(int i = 0; i < arr.size(); i++){
			if(arr.get(i) != arr.get(arr.size() - i - 1)){
				return false;
			}
		}
		
		return true;
	}
}
