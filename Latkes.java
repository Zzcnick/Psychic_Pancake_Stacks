/* Zicheng Zhen
   APCS2 pd10
   HW23 -- Standardization / Generic Stacks
   2016-03-31 */

/*****************************************************
 * skeleton for class Latkes
 * Implements a stack of objects using an array as underlying container.
 *****************************************************/

public class Latkes<T> implements Stack<T> {

    private T[] _stack;
    private int _stackSize;
    private int _index; // Tracks Location of Stack


    //constructor
    public Latkes( int size ) 
    { 
	_index = 0;
	_stackSize = size;
	_stack = (T[]) new Object[_stackSize];
    }

    //means of insertion
    public void push( T s ) // To Change
    { 
	if (isFull()) {
	    expand();
	}
	_stack[_index] = s;
	_index++;
    }

    //means of removal
    public T pop( ) 
    { 
	if (isEmpty()) {
	    return null;
	}
	_index--;
	T ret = _stack[_index];
	_stack[_index] = null;
	return ret;
    }

    //means of checking top element
    public T peek()
    {
	if (_index == 0)
	    return null;
	return _stack[_index-1];
    }
    
    //chk for emptiness
    public boolean isEmpty() 
    { 
	return _index == 0;
    }

    //chk for fullness
    public boolean isFull() 
    {
	return _index == _stackSize;
    }

    //expand the stack size if over capacity
    public boolean expand()
    {
	T[] newStack = (T[]) new Object[_stackSize * 2];
	for (int i = 0; i < _stackSize; i++)
	    newStack[i] = _stack[i];
	_stack = newStack;
	_stackSize *= 2;
	return true;
    }

    //main method for testing
    public static void main( String[] args ) {

	/* boop
	  Latkes<String> tastyStack = new Latkes<String>(10);
	  tastyStack.push("aoo");
	  tastyStack.push("boo");
	  tastyStack.push("coo");
	  tastyStack.push("doo");
	  tastyStack.push("eoo");
	  tastyStack.push("foo");
	  tastyStack.push("goo");
	  tastyStack.push("hoo");
	  tastyStack.push("ioo");
	  tastyStack.push("joo");
	  tastyStack.push("coocoo");
	  tastyStack.push("cachoo");
	  //cachoo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //coocoo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //joo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //ioo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //hoo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //goo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //foo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //eoo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //doo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //coo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //boo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //aoo
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  //stack empty by now; SOP(null)
	  System.out.println( "peek: " + tastyStack.peek() );
	  System.out.println( "pop: " + tastyStack.pop() );
	  System.out.println( tastyStack.pop() );
	  //v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
          ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

	Latkes<Integer> stack = new Latkes<Integer>(20);
	for (int i = 0; i < 20; i++)
	    stack.push((int)(1000*Math.random()));
	for (int i = 0; i < 21; i++) {
	    System.out.println( "peek: " + stack.peek() );
	    System.out.println( "pop: " + stack.pop() );
	}
	    
	  /*v~~~~~~~~~~~~MORE~~~~~~~~~~~~v
	    ^~~~~~~~~~~AWESOME~~~~~~~~~~~^*/
    }//end main()

}//end class Latkes
