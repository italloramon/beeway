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
			e.setTitle("Beeway Team");
			e.setDescription("Java with Spring is way better than Python with Django");
			e.setMaximumVouchers(10);
			e.setImageUrl("https://images.unsplash.com/photo-1551884831-bbf3cdc6469e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHx8&w=1000&q=80");
			e.setCreatedBy(u);
			e.setCurrentVouchers(new ArrayList<>());
			eventRepository.save(e);

			Event e2 = new Event();
			e2.setTitle("Tech Conference");
			e2.setDescription("Join us for the biggest tech conference of the year! Learn from industry experts and network with fellow tech enthusiasts.");
			e2.setMaximumVouchers(500);
			e2.setImageUrl("https://images.radio.com/aiu-media/GettyImages1192159893-89a9a812-aac7-48b1-a6db-ab5c3156efa0.jpg");
			e2.setCreatedBy(u);
			e2.setCurrentVouchers(new ArrayList<>());
			eventRepository.save(e2);

			Event e3 = new Event();
			e3.setTitle("Charity Run");
			e3.setDescription("Participate in our charity run and help raise money for a good cause! Choose from different distances and enjoy a fun-filled day with family and friends.");
			e3.setMaximumVouchers(1000);
			e3.setImageUrl("https://media.istockphoto.com/id/518360318/fr/photo/crazy-horse.jpg?s=612x612&w=0&k=20&c=jyMSljBQcNYzZQ13qXg813O63436_ah9WO0TD2Y1mms=");
			e3.setCreatedBy(u);
			e3.setCurrentVouchers(new ArrayList<>());
			eventRepository.save(e3);

			Event e4 = new Event();
			e4.setTitle("Wine Tasting");
			e4.setDescription("Sample some of the finest wines from around the world at our exclusive wine tasting event. Learn about the different varieties and enjoy an evening of sophistication and culture.");
			e4.setMaximumVouchers(50);
			e4.setImageUrl("https://www.doubledtrailers.com/assets/images/random%20horse%20facts%20shareable.png");
			e4.setCreatedBy(u);
			e4.setCurrentVouchers(new ArrayList<>());
			eventRepository.save(e4);



		};
	}

}
