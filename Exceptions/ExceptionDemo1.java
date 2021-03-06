/*This program tries to handle the error gracefully without
  abnormally terminating the program. This also tells about the
 ClassNotFoundException,IllegalAccessException,InstantiationException.
*/

class ExceptionDemo1  { 
	// If the class file is not found then handle the error 
	// by displaying error message and returning 0
	public int Error(){
		int status = 0;
		try{
			Object o = Class.forName("xyz").newInstance();
			status = 1;
		}catch (ClassNotFoundException e){
			System.out.println("Please check the config files" + e);
		}
		catch (IllegalAccessException e){
			System.out.println("Please check the config files" + e);
		}
		catch (InstantiationException e){
			System.out.println("Please check the config files"+ e);
		}
		
		return status;
	}
	
	public static void main(String args[]){
		
		ExceptionDemo1 e = new ExceptionDemo1();
		// we are not handling the error here
		System.out.println(" before method call");
		System.out.println(" after method call  " + e.Error());
	}
}
 