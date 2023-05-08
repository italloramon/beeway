package com.italloramon.beeway;

import com.italloramon.beeway.model.Event;
import com.italloramon.beeway.model.User;
import com.italloramon.beeway.repository.EventRepository;
import com.italloramon.beeway.repository.UserRepository;
import com.italloramon.beeway.service.EventService;
import com.italloramon.beeway.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class BeewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeewayApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository, EventRepository eventRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			User u = new User();
			u.setName("Ramon");
			u.setEmail("irvp@ic.ufal.br");
			u.setPassword(passwordEncoder.encode("test"));
			userRepository.save(u);

			Event e = new Event();
			e.setTitle("Prova PAA");
			e.setDescription("A prova de PAA vai ser um evento histórico onde as notas vão parecer bits, apenas 0 e 1");
			e.setMaximumVouchers(10);
			e.setCreatedBy(u);
			e.setCurrentVouchers(new ArrayList<>());
			eventRepository.save(e);
		};
	}

}
