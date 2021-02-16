// Demonstrate static variables, methods, and blocks.

class StaticDemo1 
{
	static int a = 3;
	static int b;

	static void meth(int x) 
	{
	System.out.println("x = " + x);
	System.out.println("a = " + a);
	System.out.println("b = " + b);
	}

	static 
	{
		System.out.println("Static block initialized.");
		b = a * 4;
		//System.out.println("Static block initialized. " +b);
	}

	public static void main(String args[]) 
	{
	meth(42);
	}
}