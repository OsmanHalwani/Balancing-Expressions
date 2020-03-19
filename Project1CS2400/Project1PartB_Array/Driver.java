package ArrayListImpForProjectB;
import java.util.Scanner;



public class Driver {

	public static void main(String[] args) {
		System.out.println("welcome to the Array implementation of the project for the infix ");
	    ArrayImplementation<Character> you = new ArrayImplementation<>();
		String build;
	    Scanner input = new Scanner(System.in);
		System.out.println("Enter an infix expression: ");
		
		String infix = input.nextLine();
		
		infix = infix.toLowerCase();
		if(BalanceChecker.checkBalance(infix)) {
			build = BalanceChecker.convertToPostFix(infix);
			System.out.println("PostFix: " + build);
			//StringBuilder buildMe = new StringBuilder();
			build = BalanceChecker.postFixToPreFix(build,build.charAt(0));
			System.out.print("PreFix: " + build);
		   
		}
	
		else
			System.out.print("expresion is not balanced");
	}

}
