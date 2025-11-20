// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6      
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1 ;
		if (x2 == 0) {return x1;}
		if (x2 < 0){
		for (int i = x2; i < 0; i++) {
			sum --;
		}
		}
		else {
		for (int i = x2; i > 0; i--) {
			sum ++;	
		}
	}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int difference = x1 ;
		if (x2 == 0) {return x1;}
		else if (x2 < 0){
		for (int i = x2; i < 0; i++) {
			difference += 1;
		}
		}
		else {
		for (int i = x2; i > 0; i--) {
			difference -- ;	
		}
	}
		return difference;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int multiplication = 0;
		if (x2 == 0 || x1 == 0) {return x2;}

		if (x1 < 0 && x2 < 0) {
			int changeSign = 0;
			for (int i = x2 ; i < 0 ; i++){
			changeSign ++;
			}
			x2 = changeSign;
		}
		if (x1 > 0 && x2 < 0){
			int temp = x1;
			x1 = x2;
			x2 = temp;
		}

		for (int i = x2 / 2; i > 0; i--) {
			multiplication = plus(multiplication, plus(x1, x1));	
		}
		
		if (x2 % 2 == 1){
			multiplication = plus(multiplication, x1);
		}

		return multiplication;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int pow = 1;
		boolean negative = false;
		if (x < 0) 
		{
			negative = true;
			x = times(-1, x);
		}
		for (int i = n / 2; i > 0; i--) {
			pow =times(pow, times(x, x));	
		}

		if (n % 2 == 1){
			pow = times(pow,x);
		}
		if (negative == true){
			pow = times(-1, pow);
		}
		return pow;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int divNumber = 0;
		if (x1 == 0){
			divNumber = 0;
		}
		else{
			for (int i = 1; i <= x1-1; i++) {
				if (x1 >= times(x2,i) && x1 <= times(x2,i+1)){
					divNumber = i;
				}
			}
		}
		return divNumber;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int divNumber = div(x1, x2);
		int modNumber = 0;
		if(x1 == times(x2, divNumber)){
			modNumber = 0;
		}
		else{
			modNumber = x1 - times(x2, divNumber);
		}
		return modNumber;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		double low = 0.0;
		double high = x;
		double epsilon = 0.001;
		int result = 0;
		double midSearchPoint = 0;
		if (x < 0){
			System.out.println("no root sqrt");
		}
		else if (x == 1 || x == 0){
			return x;
		}

		while (high - low > epsilon){
				midSearchPoint = (low + high) / 2;
				double midSqrt = midSearchPoint * midSearchPoint;
				if (midSqrt == x){
					return  (int) midSearchPoint;
				} else if (midSqrt > x){
					high = midSearchPoint;
				} else{
					low = midSearchPoint;
				}		
				} 

		midSearchPoint = (low + high) / 2;
				if ( (int) midSearchPoint * midSearchPoint < x){
					return (int) midSearchPoint + 1;}
				else if ( (int) midSearchPoint * midSearchPoint > x){
					return (int) midSearchPoint + 1;}
				else {
				return (int)midSearchPoint;
			}

	}
}
	  	
	



