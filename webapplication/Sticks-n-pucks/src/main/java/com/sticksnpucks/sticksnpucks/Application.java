package com.sticksnpucks.sticksnpucks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.web.servlet.error.*;

/**
 * Class for starting the application
 */
@SpringBootApplication
public class Application {

	/**
	 * Start the application
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
