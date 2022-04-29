package com.yandc.nightcityportalside;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * The Class NightCityPortalSideApplication.
 */
@SpringBootApplication
public class NightCityPortalSideApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEnconder;
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(NightCityPortalSideApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		String password = "12345";
		
		for (int i = 0; i < 4; i++) {
			String passwordBCrpyt = passwordEnconder.encode(password);
			System.out.println(passwordBCrpyt);
			
		}
	}

}
