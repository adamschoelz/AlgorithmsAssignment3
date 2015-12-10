import java.util.ArrayList;


public class Assignment3B {
	public static int numStep(int[] int_array){
		//Base count is 50 as that is the maximum baseline
		int count = 50, tempCount = 0, baseline = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		if(checkPalindrome(int_array)){
			return 0;
		}
		
		//Copy array and determine baseline score
		for(int i = 0; i < int_array.length; i++){
			arr.add(int_array[i]);
			baseline++;
		}
		
		//Find palindrome with shortest steps
		for(int i = 0; i < arr.size() - 2; i++){
			//Call with both i-centered palindrome
			tempCount = makePalindrome(new ArrayList<Integer>(arr.subList(0, i)), new ArrayList<Integer>(arr.subList(i + 1, arr.size())));
			if(tempCount != -1 && tempCount < count){
				count = tempCount;
			}
			//And even-centered palindrome
			tempCount = makePalindrome(new ArrayList<Integer>(arr.subList(0, i+2)), new ArrayList<Integer>(arr.subList(i + 2, arr.size())));
			if(tempCount != -1 && tempCount < count){
				count = tempCount;
			}
		}
		//System.out.println(count + " " + baseline);
		return Math.min(count, baseline);
	}
	
	public static int makePalindrome(ArrayList<Integer> left, ArrayList<Integer> right){
		
		int i = 0, j = 0, stepcount;
		ArrayList<Integer> candidate = new ArrayList<Integer>();
		
		while(i < left.size() && j < right.size()){
			left = new ArrayList<Integer>(left.subList(0+i, left.size()));
			right =  new ArrayList<Integer>(right.subList(0, right.size() - j));
			//System.out.println("1. Left: " + left + " Right: " + right + " Candy: " + candidate);
			stepcount = makeOutsideEqual(left, right);
			if(stepcount != -1){
				candidate.clear();
				candidate.addAll(left);
				candidate.addAll(right);
				if(checkPalindrome(candidate)){
					return stepcount;
				}
			}
			
			i++;
			j++;
		}
		
		return -1;
	}
	
	//This function assumes outermost elements (first of left and last of right) are not equal and 
	//attempts to make them equal by summing adjacent elements
	public static int makeOutsideEqual(ArrayList<Integer> left, ArrayList<Integer> right){
		
		int leftStep = -1, rightStep = -1;
		
		//Make two outmost elements equal
		for(int i = 0; i < left.size(); i++){
			if(i > 0){
				left.set(i, left.get(i) + left.get(i-1));
				left.remove(i-1);
				i--;
			}
			leftStep++;
			
			rightStep = 0;
			for(int j = right.size() - 1; j >= 0; j--){
				if(j < right.size() - 1){
					right.set(j, right.get(j) + right.get(j+1));
					right.remove(j+1);
					//System.out.println(j);
				}
				rightStep++;
				//System.out.println("Right: " + rightStep + " Left: " + leftStep);
				//System.out.println("I: " + i + " " + left.size());
				//System.out.println("J: " + j + " " + right.size());
				if(right.get(j) == left.get(i)){
					return rightStep+leftStep;
				}
			}
		}
		return -1;
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
				System.out.println("Failed: " + arr.get(i) + " does not equal " + arr.get(arr.size() - i - 1));
				return false;
			}
		}
		
		return true;
	}
}
