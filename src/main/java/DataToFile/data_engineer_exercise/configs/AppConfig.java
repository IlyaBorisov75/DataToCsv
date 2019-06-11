package DataToFile.data_engineer_exercise.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class AppConfig {
    @Bean
    public String fileName(){
        return testDate().toString() + ".csv";
    }

    @Bean
    public Date testDate(){
        return new Date();
    }
}
