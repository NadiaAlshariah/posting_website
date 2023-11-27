package posting_website.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class AppUserConfig {
    @Bean
    CommandLineRunner commandLineRunner(AppUserRepository appUserRepository){
        return args -> {
            AppUser nadia = new AppUser(
                     "3232323", "Nadia", "nadiakalid@gmail.com", "0110010101", new Date()
            );
            appUserRepository.saveAll(
                    List.of(nadia)
            );
        };
    }
}
