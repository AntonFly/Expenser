package net.sytes.fly.Expenser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
		//(exclude = {DataSourceAutoConfiguration.class})
public class ExpenserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenserApplication.class, args);
	}

}
