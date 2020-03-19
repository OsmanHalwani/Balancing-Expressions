package linkedListProject1PartB;

public class BalanceCheckerForLinkedImp {
	public static boolean checkBalance(String expression) {
		LinkedListImplementation<Character> my = new LinkedListImplementation<>();
		int index = 0;
		
		boolean isBalanced = true;
		while ((isBalanced == true && index < expression.length())) {
			switch (expression.charAt(index)) {
// checking cases
			case '(':
			case '[':
			case '{':
				my.push(expression.charAt(index));// is case is true push in stack
				break;

			case ')':
			case ']':
			case '}':
				if (my.isEmpty()) // if my stack is empty then isBalanced is false
					isBalanced = false;
				else {
					char open = my.peek(); // peeking at my first element
					my.pop(); // poping first element
					if (isPaired(open, expression.charAt(index))) // if open aka top of stack is paried with the expression at the char index given
						isBalanced= true; // keep true
					else
						isBalanced = false; // if not balanced make false

				}
				break;
			}
			index++;
		}
		
		if(!my.isEmpty())
			isBalanced = false;

		return isBalanced;
	}

	public static boolean isPaired(char open, char close) {
		return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
	} // returning boolean of pairs either true or false 
	
	
	
	
	
	public static String convertToPostFix(String infix) {
		LinkedListImplementation<Character> my = new LinkedListImplementation<>();
		StringBuilder postFix = new StringBuilder();
		int index = 0;
		char nextChar;
		Pres first=null;
		Pres second = null;
		char topOp;		
		
		while (index < infix.length() ) {
			if (infix.charAt(index) != ' ') {// only do these actions if it is not a blank space
				nextChar = infix.charAt(index);
				 first = new Pres (nextChar);
				if(!my.isEmpty()) 
				  second = new Pres(my.peek());
				
		
			
			switch(nextChar)	{
			//checking to see if case is a variable 
				case 'q': case 'w': case 'e':case'r' : 
				case 't': case 'y': case 'u': case 'i':
				case 'o': case 'p' : case 'a' : case 's':
				case 'd': case 'f' : case 'g' : case 'h':
				case 'j': case'k': case 'l': case 'z':
				case 'x' : case 'c': case 'v': case'b':
				case 'n': case 'm':
				postFix.append(nextChar);
			break;
			// checking case 
				case '^':
					my.push(nextChar); // adding to stack
					break;
				case '+': case '-' : case '/':  case'*' :
					captureOp(first,my,postFix);
					
					
					
					
					
				
				case '(':
					my.push(nextChar);
					break;
				
				case ')' :
					while(!my.isEmpty()) {
						char para = my.pop(); // getting top
						if(para=='(') // if open quote then break
							break;
						else postFix.append(para); // adding it 
					}
					
						break;
						default  : break;
			
						
			   }	
			
		
			}
			
		
			index++;
		}
		
		while(!my.isEmpty()) {
			
			topOp = my.pop();
			postFix.append(topOp);
		}
		//for some reason my methods doubles all the operators so i am doing string replacement
		String answer = postFix.toString().replace("++", "+");
		answer = answer.replace("//", "/");
		answer = answer.replace("--", "-");
		answer = answer.replace("**", "*");
		return answer;
		

	}

	@SuppressWarnings("unchecked")
	public static void captureOp(Pres firstOp,LinkedListImplementation my,StringBuilder postFix) {
		while (!my.isEmpty()) {
	         char topOp = (char) my.pop();//setting my top Operator
	        Pres secondOp = new Pres(topOp); // getting my object to check precedence
	         
	         if (topOp == '(') {
	            my.push(topOp); // keep pushing till we get to an open parenthesis
	            break;
	         }
	         else if (firstOp.pres > secondOp.pres) { //compare operator precedence
	               my.push(topOp);
	               break;
	            } 
	            else 
	            		postFix.append(topOp); // if none of these are true then append the topOp
	         
	      }
	      my.push(firstOp.c); // push my firstOperators character
	}
	static LinkedListImplementation<String> preFix = new LinkedListImplementation<>();
	static int global = 0;
	
	public static String postFixToPreFix(String postFix,char h) {
	//ArrayImplementation<Character> you = new ArrayImplementation<>();
	//TODO	
		//System.out.println(h);
		h = postFix.charAt(global); // setting my h to be a char at the index of my global
		if(h == postFix.charAt(postFix.length()-1)) {
			 if(h == '+' || h == '-' || h == '/' || h == '*' ||
						h == '^' ) {
				String first = preFix.pop();  // getting first element in my stack
				String second = preFix.pop(); // getting second element in stack
				
				
				String temp = postFix.charAt(global) + second + first; // adding elements to string 
				preFix.push(temp); // pushing whole string
			 }
			 
			 else  
				 preFix.push(postFix.charAt(global)+""); // if not an operator then push
			global = 0;
			return preFix.peek();
			
		}
		 if(h == '+' || h == '-' || h == '/' || h == '*' ||
					h == '^' ) {
			String first = preFix.pop(); // getting first element in my stack
			String second = preFix.pop(); // getting second element in stack
			
			
			String temp = postFix.charAt(global) + second + first;  // adding elements to string
			preFix.push(temp); // pushing whole string that was formed
		 }
		 
		 else 
			 preFix.push(postFix.charAt(global)+""); // if not an operator then push
		
		 global++; // increase index
		 return postFixToPreFix(postFix,postFix.charAt(global));// return the function again 
	} 

}
