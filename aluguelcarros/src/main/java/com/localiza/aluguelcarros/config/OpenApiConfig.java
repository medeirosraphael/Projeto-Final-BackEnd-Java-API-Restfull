package com.localiza.aluguelcarros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI myOpenAPI() {
	   
		Contact contact = new Contact();		
	    contact.setEmail("medeiros.ph@gmail.com");
	    contact.setName("Raphael Medeiros");
	    contact.setUrl("https://www.mundomacintosh.com");


	    Info info = new Info()
	        .title("Localiza Aluguel de Carros API")
	        .version("1.0")
	        .contact(contact)
	        .description("Projeto Localiza Aluguel de Carros API.");

	    return new OpenAPI().info(info);
	  }

}
