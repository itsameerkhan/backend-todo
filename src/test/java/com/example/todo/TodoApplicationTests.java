package com.example.todo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class TodoApplicationTests {

	@Test
	void contextLoads() {
		// This test will verify that the Spring context loads successfully
		// with the test configuration (H2 in-memory database)
	}

}
