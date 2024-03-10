import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	GradeBook gb1 = new GradeBook(5);
	GradeBook gb2 = new GradeBook(5);
	
	@BeforeEach
	void setUp() throws Exception {
		gb1.addScore(100);
		gb1.addScore(90);
		gb1.addScore(30);
		gb1.addScore(40);
		gb2.addScore(60);
		gb2.addScore(75);
	}

	@AfterEach
	void tearDown() throws Exception {
		gb1 = null;
		gb2 = null;
	}

	@Test
	void testAddScore() {
		gb1.addScore(70);
		assertTrue(gb1.toString().equals("100.0 90.0 30.0 40.0 70.0 "));
		assertEquals(gb1.getScoreSize(), 5);
		
		gb2.addScore(35);
		assertTrue(gb2.toString().equals("60.0 75.0 35.0 "));
		assertEquals(gb2.getScoreSize(), 3);
	}

	@Test
	void testSum() {
		assertEquals(gb1.sum(), 260);
		assertEquals(gb2.sum(), 135);
	}

	@Test
	void testMinimum() {
		assertEquals(gb1.minimum(), 30);
		assertEquals(gb2.minimum(), 60);
	}

	@Test
	void testFinalScore() {
		assertEquals(gb1.finalScore(), 230);
		assertEquals(gb2.finalScore(), 75);
	}

}
