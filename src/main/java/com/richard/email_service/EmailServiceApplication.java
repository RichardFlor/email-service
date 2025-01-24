package com.richard.email_service;


import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
		// Inicializando o cliente do Resend com a chave de API
		Resend resend = new Resend("re_GcS9bnUT_FX7cdubFP244U3ZaCtFYYg7Y");

		// Definindo os parâmetros do e-mail
		CreateEmailOptions params = CreateEmailOptions.builder()
				.from("Acme <onboarding@resend.dev>")
				.to("duckieanki@gmail.com")
				.subject("aws lixo!")
				.html("<strong>Deu bom </strong>")
				.build();

		try {
			// Enviando o e-mail
			CreateEmailResponse data = resend.emails().send(params);
			System.out.println("E-mail enviado com ID: " + data.getId());
		} catch (ResendException e) {
			// Tratamento de exceções
			e.printStackTrace();
		}
	}
}
