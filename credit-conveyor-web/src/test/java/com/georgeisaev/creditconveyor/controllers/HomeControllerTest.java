package com.georgeisaev.creditconveyor.controllers;

import com.georgeisaev.creditconveyor.configurations.WebConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WebConfig.class)
class HomeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	void testHomePage() {
		assertDoesNotThrow(() -> {
					mockMvc.perform(get("/"))
							.andExpect(status().isOk())
							.andExpect(view().name("home"))
							.andExpect(content().string(containsString("Welcome to ...")));
				}
		);

	}

}