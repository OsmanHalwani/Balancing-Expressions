package linkedListProject1PartB;

public class Pres {
	
	 public int pres;
     public char c;
     
     Pres(char c){
    	 	this.c=  c;
    	 	if(c == '+' || c == '-') 
    	 		pres = 0;
    	 	else if (c == '/' || c == '*')
    	 		pres = 1;
    	 	else if(c=='(')//keeping pusing till u reach a ) then unload	
    	 		pres = 2;
     }
	
}
/*
if(my.peek()==null)
break;
topOp = my.peek();
while(topOp != '(') {
	if(my.peek()==null)
		break;
	if(my.peek() == '+' || my.peek() == '-' || my.peek() == '/' || my.peek() == '*') {
	postFix.append(topOp);
	try {
    topOp = my.pop();
	}
	
	catch(Exception NullPointerException) {
		break;
	}
	}
	
}
*/