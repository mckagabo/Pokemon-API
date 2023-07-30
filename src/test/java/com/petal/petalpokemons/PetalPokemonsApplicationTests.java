package com.petal.petalpokemons;

import com.petal.petalpokemons.service.SeedingService;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ActiveProfiles("test")
class PetalPokemonsApplicationTests {

	@Autowired
	SeedingService seedingService;
	@PostConstruct
	public void seedDb(){
		seedingService.seedDb();
	}
	@Test
	void contextLoads() {
	}

}
