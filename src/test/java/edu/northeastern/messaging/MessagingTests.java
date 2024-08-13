package edu.northeastern.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessagingTests {

	@Test
	public void testAssert() throws Exception {
		assertEquals(1, 1);
	}

}
