package io.github.alissonlima.testspring;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class TestSpringApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder app = new SpringApplicationBuilder(TestSpringApplication.class)
				.web(WebApplicationType.REACTIVE);
		app.build().addListeners(new ApplicationPidFileWriter("./shutdown.pid"));
		app.run(args);
	}

}

@RestController
@RequestMapping("/")
@Log4j2
class HelloWorldController {

	@GetMapping()
	private Mono<String> index(){
		log.info("Aham, chegou no endpoint");
		return Mono.just("Hello World 127");
	}
}



