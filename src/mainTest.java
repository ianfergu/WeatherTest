import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;


/**
 * 
 * @author iferguson
 * unit test for sample class main
 *
 */
public class mainTest {
	
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	} 
	
	
	@Test
	public void testConstructor() {
		try {
			new main();
		} catch (Exception e1) {
			fail("The construction of the main class failed.");
		}
	}
	
	@Test
	public void testTemp() {
		new main().creater();
		String test = outContent.toString();
		
		try {
			assertFalse(test.isEmpty());
		} catch (AssertionError e2){
			fail("str is empty");
		}
		
		if (Integer.parseInt(test.substring(28, 30)) > 90) {
			fail("It is too hot!!! Over 90 degrees with a temperature of: " + test);
		} else {
			System.out.println("It is a cool: " + test.substring(28, 30));
		}
	}
	
	@After
	public void cleanUp() {
		System.setOut(null);
	}
}
