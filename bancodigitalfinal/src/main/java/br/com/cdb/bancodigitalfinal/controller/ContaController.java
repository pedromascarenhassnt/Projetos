package br.com.cdb.bancodigitalfinal.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdb.bancodigitalfinal.entity.Cliente;
import br.com.cdb.bancodigitalfinal.entity.Conta;
import br.com.cdb.bancodigitalfinal.entity.ContaCorrente;
import br.com.cdb.bancodigitalfinal.entity.ContaDTO;
import br.com.cdb.bancodigitalfinal.entity.ContaPoupanca;
import br.com.cdb.bancodigitalfinal.entity.TransferenciaDTO;
import br.com.cdb.bancodigitalfinal.entity.saqueEdepositoDTO;
import br.com.cdb.bancodigitalfinal.service.ClienteService;

import br.com.cdb.bancodigitalfinal.service.ContaService;


@RestController
@RequestMapping	("/conta")
public class ContaController {

	@Autowired
	private ContaService cService;
	private ClienteService clienteService;
	
	
		//FAZER METODO DE TRANSFERENCIA NO CONTROLLER
		
	
	
	
	@GetMapping("/{id}/saldo")
	public ResponseEntity<String> verSaldo(@PathVariable Long id) {

		var conta = cService.buscarContaPorId(id);
		if (conta != null) {
			return ResponseEntity.ok("O seu saldo é de: " + conta.getSaldo());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada.");
		}
	}

	@PostMapping("/{idConta}/deposito") 
	public ResponseEntity<String> deposito(@PathVariable Long idConta, @RequestBody saqueEdepositoDTO dto)
	{
		try {
			  cService.depositar(dto.getValor(), idConta);
			  
			return ResponseEntity.ok("Depósito realizado com sucesso!"+"\n\nNovo saldo: "+ cService.buscarContaPorId(idConta).getSaldo());
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao realizar deposito: "+ e.getMessage());
		}
	}	
		@PostMapping("/{idConta}/saque") 
		public ResponseEntity<String> saque(@PathVariable Long idConta, @RequestBody saqueEdepositoDTO dto)
		{
			try {
				  cService.sacar(dto.getValor(), idConta);
				  
				return ResponseEntity.ok("Saque realizado com sucesso!");
			}
			catch(Exception e){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao realizar saque! ");
			}
	}
			

		
		
		@PostMapping("/transferencia")
		public ResponseEntity<String> transferencia( @RequestBody TransferenciaDTO dto)
		{
			
			try {
				cService.transfencia(dto.getIdContaOrigem(), dto.getIdContaDestino(), dto.getValor());
				
				return ResponseEntity.ok("Transferência realizada com sucesso!");
			}
			catch(Exception e){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao realizar a transferência! "+ e.getMessage());
			}
			
			
			
			
		}
	
		@GetMapping("/detalhes/{idConta}")
		public ResponseEntity<Conta> detalheCliente(@PathVariable Long idConta){
			
			
			 return cService.getConta(idConta).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
			
			
		}
	
	
	
	
	
	
	
		
	
}
