package br.com.cdb.bancodigitalfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoBancoDigialFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBancoDigialFinalApplication.class, args);
	}

	
	//- **POST /contas/{id}/transferencia** - Realizar uma transferência entre contas
	
	
	//- **POST /contas/{id}/pix** - Realizar um pagamento via Pix
	
	
	// - **PUT /contas/{id}/manutencao** - Aplicar taxa de manutenção mensal (para conta corrente)
	
	
	//- **PUT /contas/{id}/rendimentos** - Aplicar rendimentos (para conta poupança)
}
