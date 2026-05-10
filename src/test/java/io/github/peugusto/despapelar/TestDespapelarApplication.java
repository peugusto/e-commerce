package io.github.peugusto.despapelar;

import org.springframework.boot.SpringApplication;

public class TestDespapelarApplication {

	public static void main(String[] args) {
		SpringApplication.from(Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
