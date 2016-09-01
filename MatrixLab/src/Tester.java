import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Tester {

	public static void main(String[] args) {
		
		/*
		 * Test the 2D array implementation
		 */
		
		Result result0 = JUnitCore.runClasses(MatrixTest.class);
		
		for (Failure failure : result0.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result0.wasSuccessful());
	    
	    result0 = JUnitCore.runClasses(MatrixTest2.class);
		
		for (Failure failure : result0.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result0.wasSuccessful());
	    
	    /*
	     * Test the MatrixRM implementation
	     */
	    
	    MatrixTest.useArray2D = false;
	    MatrixTest2.useArray2D = false;
	    
	    Result result1 = JUnitCore.runClasses(MatrixTest.class);
		
		for (Failure failure : result1.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result1.wasSuccessful());
	    
	    result1 = JUnitCore.runClasses(MatrixTest2.class);
		
		for (Failure failure : result1.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result1.wasSuccessful());
	}
}
