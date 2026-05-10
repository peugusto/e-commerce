package io.github.peugusto.despapelar;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class DespapelarApplicationTests {

	@Test
	void contextLoads() {
	}

}
