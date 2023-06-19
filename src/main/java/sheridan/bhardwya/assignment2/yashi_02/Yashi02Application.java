package sheridan.bhardwya.assignment2.yashi_02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Arrays;
import java.util.List;
@SpringBootApplication
public class Yashi02Application {

    public static void main(String[] args) {
        SpringApplication.run(Yashi02Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(PetDataService petService) {
        return (args) -> {
            List<PetData> pets = Arrays.asList(
                    new PetData("Minnie", "Dog", "Female", true),
                    new PetData("Bruno", "Dog", "Male", true),
                    new PetData("Chinki", "Rabbit", "Female", false),
                    new PetData("Minki", "Dog", "Male", false)
            );

            pets.forEach(petService::addPetData);
        };
    }
}