package com.decomle.relearn;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class RelearnApplication {
	public static void main(String[] args) {
		SpringApplication.run(RelearnApplication.class, args);
	}
}
