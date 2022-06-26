package application;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainControllerTest {

	@Test
	public void testForWord() {
		var mainController = new MainController();
				
	}
	@Test
	public void testForWord1() {
		var mainController = new MainController();
				
	}
	@Test
	public void testButton() {
		var mainController = new MainController();
		String run = MainController.reader("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
		assertEquals("the",run);
	}
	
}
