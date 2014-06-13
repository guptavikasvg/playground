package adaptvprogrammingtest;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ComputeDistanceTest {

	@Test
	public void test1() {
		final String newLine = System.getProperty("line.separator");
		String[] input = new String[]{
						"apple,H,0", 
						"apple,H,0" + newLine + "apple,S,0", 
						"apple,H,0.5", 
						"apple,H,1", 
						"apple,H,2", 
						"apple,H,1"+newLine+"apple way,H,2", 
				 		"apple way,S,30",
				 		"apple way,H,65" + newLine + "apple way,S,30"
				};
		String[] expectedOutput =  new String[]{
				"Total distance: [0.0 MILES]"  + newLine + "Total time: [0.0 HOUR]" + newLine,
				"Total distance: [0.0 MILES]"  + newLine + "Total time: [0.0 HOUR]" + newLine,
				"Total distance: [0.5 MILES]"  + newLine + "Total time: [0.016666668 HOUR]" + newLine,
				"Total distance: [1.0 MILES]"  + newLine + "Total time: [0.016666668 HOUR]" + newLine,
				"Total distance: [2.0 MILES]"  + newLine + "Total time: [0.03076923 HOUR]" + newLine,
				"Total distance: [3.0 MILES]"  + newLine + "Total time: [0.0474359 HOUR]" + newLine,
				"Total distance: [30.0 MILES]" + newLine + "Total time: [1.0 HOUR]" + newLine,
				"Total distance: [95.0 MILES]" + newLine + "Total time: [2.0 HOUR]" + newLine,
		};
		for (int i = 0; i < input.length; i++){
			verify(input[i], expectedOutput[i]);
		}
	}
	
	@Test
	public void test2() {
		final String newLine = System.getProperty("line.separator");
		String[] input = new String[]{
						"apple,H,-0.1", 
						"apple,H ,0.1", 
						"apple,T,0.1", 
						"apple,T,"+newLine+"apple,H,-0.1", 
				};
		String[] expectedOutput =  new String[]{
				"Exception",
				"Exception",
				"Exception",
				"Exception",
		};
		for (int i = 0; i < input.length; i++){
			verifyException(input[i], expectedOutput[i]);
		}
	}
	
	private void verifyException(String input, String output) {
		String charSet = "UTF8";
		try {
			InputStream is = new ByteArrayInputStream(input.getBytes(charSet));
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(baos);
	        
	        ComputeDistance.computeDist(is, ps);
			assertTrue(false);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e){
			assertTrue(true);
		} catch (NoSuchElementException e){
			assertTrue(true);
		}
	}
	
	private void verify(String input, String output) {
		String charSet = "UTF8";
		try {
			InputStream is = new ByteArrayInputStream(input.getBytes(charSet));
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(baos);
	        
	        ComputeDistance.computeDist(is, ps);
	        
	        System.out.println(baos.toString(charSet));
	        assertEquals(output, baos.toString(charSet));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
