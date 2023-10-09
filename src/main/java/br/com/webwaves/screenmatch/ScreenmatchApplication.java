package br.com.webwaves.screenmatch;

import br.com.webwaves.screenmatch.model.DadosSerie;
import br.com.webwaves.screenmatch.service.ConsumoApi;
import br.com.webwaves.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obeterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=ec8241d7");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.converteDados(json,DadosSerie.class);
		System.out.println(dados);
	}
}
