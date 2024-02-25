package com.amanuel.rest.webservices.restapiwebService.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

	private MessageSource messageSource;

	public HelloworldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@GetMapping(path = "/hello-world")
	public String helloworld() {
		return "Hello world";
	}

	@GetMapping(path = "/hello-world-bean")
	public helloworldbean helloworldBean() {

		return new helloworldbean("Hello World");
	}

	@GetMapping(path = "/hello-world/path-variable/{name}")
	public helloworldbean helloworldPathVariable(@PathVariable String name) {

		return new helloworldbean(String.format("Hello ,%s", name));
	}

	@GetMapping(path = "/hello-world-international")
	public String helloworldInternatioanalized() {

		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
//		return "Hello world v2";
	}

}
