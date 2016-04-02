/* Team Psychic_Pancake_Stacks - Ruochong Wu, Zicheng Zhen
   APCS2 pd10
   HW24 -- Schemin' / I can't work with all this racket
   2016-04-02 */

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
      1. Create 2 stacks, one to hold the parsed string, the other for the operations
      2. Parse the string into one stack with parentheses, the other with operations
      3. If the first stack encounters an operation, evaluate the stack until it reaches the 
         end parenthesis, and then pop back to the front parenthesis
      4. Repeat until the stack size is 1
      5. Profit!
 *
 * STACK OF CHOICE: Latkes by Zicheng Zhen
 * There is no need to use an LLStack, because we are not jumping from one end of the stack
   to another. Also, an ALStack is less efficient, and we can create the interpretor by 
   implementing the methods in Latkes. 
 ******************************************************/
import java.util.ArrayList;

public class Scheme {

    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr ) 
    {
	// Length variable
	int length = expr.length();

	// Track location of spaces
	ArrayList<Integer> spaces = new ArrayList<Integer>(length);
	for (int i = 0; i < length; i++)
	    if (expr.substring(i,i+1).equals(" "))
		spaces.add(i);
	spaces.add(length); // Last parsing location

	// Add parsing indices
	int[][] locations = new int[spaces.size()][2];
	int lastStart = 0; // Previous parse
	for (int i = 0; i < spaces.size(); i++) {
	    locations[i][0] = lastStart;
	    locations[i][1] = spaces.get(i);
	    lastStart = spaces.get(i);
	    lastStart++;
	}

	/** Printing Utility - Debugging
	for (int i = 0; i < locations.length; i++) {
	    for (int j = 0; j < locations[0].length; j++)
		System.out.print(locations[i][j] + " ");
	    System.out.println();
	}
	**/

	Latkes<String> expressions = new Latkes<String>(length);
	Latkes<String> operations  = new Latkes<String>(length);
	Latkes<String> evaluation  = new Latkes<String>(length);
	int i   = 0; // Parsing Index
	String initial = null; // Initial number

	// Run through the atoms
	while (i < locations.length) {
	    expressions.push(expr.substring(locations[i][0], locations[i][1]));
	    // System.out.print(operations.peek() + "\t"); // Debugging
	    // System.out.println(expressions.peek()); // Debugging
	    
	    if (expressions.peek().equals("(")) {
		i++;
		operations.push(expr.substring(locations[i][0], locations[i][1]));
	    } else if (expressions.peek().equals(")")) {
		expressions.pop(); // Removes )
		while (!expressions.peek().equals("("))
		    evaluation.push(expressions.pop());
		expressions.pop(); // Removes (
		int tmp = Integer.parseInt(evaluation.pop());
		while (!evaluation.isEmpty()){
		    int number = Integer.parseInt(evaluation.pop());
		    if (operations.peek().equals("+"))
			tmp += number;
		    if (operations.peek().equals("*"))
			tmp *= number;
		    if (operations.peek().equals("-"))
			tmp -= number;
		}
		expressions.push("" + tmp);
		operations.pop();
	    }
	    i++;
	}
	return expressions.pop();
    }//end evaluate()

    //main method for testing
    public static void main( String[] args ) {

	String zoo1 = "( + 4 3 )";
	System.out.println(zoo1);
	System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	//...7

	String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	System.out.println(zoo2);
	System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	//...17

	String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	System.out.println(zoo3);
	System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	//...29
	
	String zoo4 = "( - 1 2 3 )";
	System.out.println(zoo4);
	System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	//...-4

	String zoo5 = "( * 3 ( + ( - 7 4 ) 8 ) 2 )";
	System.out.println(zoo5);
	System.out.println("zoo5 eval'd: " + evaluate(zoo5) );
	//...66
	
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
          ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }//main

}//end class Scheme
