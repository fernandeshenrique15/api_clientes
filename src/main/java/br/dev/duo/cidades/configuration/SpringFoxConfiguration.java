package br.dev.duo.cidades.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfiguration {
	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("br.dev.duo.cidades.resources"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(apiInfo());
		}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
		.title("API para persistencia de cidades e clientes")
		.description("Um exemplo de aplicação Spring Boot REST API")
		.version("1.0.0")
		.license("Apache License Version 2.0")
		.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
		.contact(new Contact("Henrique Fernandes Neto", "https://www.linkedin.com/in/henrique-fernandes-neto/","henrique@fernandes.dev.br"))
		.build();
		}

}
