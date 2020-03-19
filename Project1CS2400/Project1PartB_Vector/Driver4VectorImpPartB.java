package VectorImplementation;
import java.util.Scanner;

public class Driver4VectorImpPartB {

	public static void main(String[] args) {
		System.out.println("welcome to the Vector Implementation of the project for the infix ");
	    VectorImplementation<Character> you = new VectorImplementation<>();
	   
		String build;
	    Scanner input = new Scanner(System.in);
		System.out.println("Enter an infix expression: ");
		
		String infix = input.nextLine();
		
		infix = infix.toLowerCase();
		if(BalanceCheckerVector.checkBalance(infix)) {
			build = BalanceCheckerVector.convertToPostFix(infix);
			System.out.println("PostFix: " + build);
			//StringBuilder buildMe = new StringBuilder();
			build = BalanceCheckerVector.postFixToPreFix(build,build.charAt(0));
			System.out.print("PreFix: " + build);
		   
		}
	
		else
			System.out.print("expresion is not balanced");
	}

}
