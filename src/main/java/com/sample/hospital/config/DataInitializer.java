package com.sample.hospital.config;

import com.sample.hospital.persistence.model.PersonType;
import com.sample.hospital.persistence.repository.PersonTypeRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public ApplicationRunner initializer(PersonTypeRepository repository) {
        return args -> {
            for (PersonType.Type type : PersonType.Type.values()) {
                if (!repository.existsByType(type)) {
                    repository.save(new PersonType(type));
                }
            }
        };
    }
}
