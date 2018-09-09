package _02_Integer_Stack;

public class IntegerStack {
	//1. create a private array of integers
		private int [] array; 
	//2. complete the constructor by initializing the member array
	//   to a new array of length 0. This prevents null pointer exceptions.
	public IntegerStack() {
		array = new int[0];
	}
	
	//3. Complete the steps in the push method.
	public void push(int v) {
		//A. create a new array that is one element larger than the member array
		int [] array2 = new int[array.length + 1];
		//B. set the last element of the new array equal to the integer passed into the method
		array2[array2.length -1] = v;
		//C. iterate through the member array and copy all the elements into the new array
		for (int i = 0; i < array.length; i++) {
			array[i] = array2[i];
		}
		//D. set the member array equal to the new array.
		array = array2;
	}
	
	//4. Complete the steps in the pop method.
	public int pop() {
		//A. create an integer variable and initialize it to the
		//   last element of the member array.
		int q = array[array.length -1];
		
		//B. create a new array that is one element smaller than the member array
		int [] array3 = new int [array.length-1];
		//C. iterate through the new array and copy every element from the
		//   member array to the new array
		for (int i = 0; i < array3.length; i++) {
			array3[i] = array[i];
		}
		
		//D. set the member array equal to the new array
		array = array3;
		//E. return the variable you created in step A
		return q;
	}
	
	//5. Complete the clear method to set the
	//   member array to a new array of length 0
	public void clear() {
		int [] clear = new int [0];
		array = clear;
		
	}
	
	//6. Complete the size array to return 
	//   the length of the member array
	public int size() {
		return array.length;
	}
}
