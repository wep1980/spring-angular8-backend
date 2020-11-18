package br.com.waldirep.springangular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackages="br.com.waldirep.springangular.model") // Indica o pacote onde se localiza as classes para criação das tabelas 
@ComponentScan(basePackages = {"br.*"}) // para o spring controlar a parte de injeção de dependencia
@EnableJpaRepositories(basePackages = {"br.com.waldirep.springangular.repository"}) // Indica onde fica a pasta de REPOSITORY 
@EnableTransactionManagement // Gerencia as transações
@EnableWebMvc // Habilita os recursos de MVC (Arquitetura) -- Não esta sendo USADO
@RestController // Habilita o REST
@EnableAutoConfiguration // Configura todo o projeto
public class SpringAngular8BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngular8BackendApplication.class, args);
	}

}
