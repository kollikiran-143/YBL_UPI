package in.fl.los;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class YblUpiApplication implements ApplicationRunner {

	static Logger logger = Logger.getLogger(YblUpiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(YblUpiApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("In application logger servlet");
		try {

			Properties log4jProps = new Properties();

			log4jProps.load(new FileInputStream("/FRNDLN/Config/flupliftlos_log4j.properties"));
			PropertyConfigurator.configure(log4jProps);
			System.out.println("Loaded log4j properties");

		} catch (IOException e) {
			System.out.println("IOException while loading log4j.properties " + e.getMessage());
			logger.error("IOException while loading log4j.properties", e);
		}

	}

}
