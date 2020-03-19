package linkedListProject1PartB;
import java.util.Scanner;

public class Driver4LinkedListImpPartB {

	public static void main(String[] args) {
		System.out.println("welcome to the LinkedListImplementation of the project for the infix ");
	    LinkedListImplementation<Character> you = new LinkedListImplementation<>();
		String build;
	    Scanner input = new Scanner(System.in);
		System.out.println("Enter an infix expression: ");
		
		String infix = input.nextLine();
		
		infix = infix.toLowerCase();
		if(BalanceCheckerForLinkedImp.checkBalance(infix)) {
			build = BalanceCheckerForLinkedImp.convertToPostFix(infix);
			System.out.println("PostFix: " + build);
			//StringBuilder buildMe = new StringBuilder();
			build = BalanceCheckerForLinkedImp.postFixToPreFix(build,build.charAt(0));
			System.out.println("PreFix: " + build);
		   
		}
	
		else
			System.out.println("expresion is not balanced");
	}

}
