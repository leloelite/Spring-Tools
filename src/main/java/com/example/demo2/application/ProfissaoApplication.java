package com.example.demo2.application;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo2.application.models.Profissao;
import com.example.demo2.application.repositorio.ProfissaoRepository;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class ProfissaoApplication {
	
	@Autowired
	private ProfissaoRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProfissaoApplication.class, args);
	}
	
	@Bean
	InitializingBean sendDatabase() {
		long id=1;
		Profissao userDefault = new Profissao(id, "Analista de sistemas", "O analista de sistemas atua na área de Tecnologia da Informação (TI) desenvolvendo soluções específicas em sistemas informatizados para empresas. Ele analisa, documenta, projeta, implementa, testa e gerencia os sistemas de informações necessários para os negócios de seus clientes ou empregadores. Seu trabalho envolve o estudo de hardware (componentes físicos do computador), do software (sistemas de processamentos de dados do computador) e da utilização pelo usuário final. O profissional da análise de sistemas realiza um intenso processo de planejamento e possíveis caminhos para um projeto, dividido em concepção, elaboração e implementação. A administração dos dados produzidos por estes sistemas também é de responsabilidade do analista de sistemas.", 
				5000.0, "Pós graduação em arquitetura.");
		Profissao userDefault2 = new Profissao(2L, "Analista de requisitos", "O(a) Analista de Requisitos é responsável pelo levantamento e análise de todas as informações de sistemas, aplicativos e páginas na web, ferramentas ou recursos mobile. Graças a ele, todas as necessidades para a realização de um projeto são requeridas antes do seu início, garantindo que haverá todos os recursos necessários para o desenvolvimento.\n" + 
				"\n" + 
				"Fonte: http://tutano.trampos.co/15197-guia-de-profissoes-analista-de-requisitos/", 5000.0, "Pós graduação em Gerencia de TI");
	    return () -> {
	        userRepository.save(userDefault);
	        userRepository.save(userDefault2);

	      };
	   }

}
