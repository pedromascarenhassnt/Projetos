package br.com.cdb.bancodigitalfinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdb.bancodigitalfinal.entity.Cliente;
import br.com.cdb.bancodigitalfinal.entity.ContaCorrente;
import br.com.cdb.bancodigitalfinal.entity.ContaDTO;
import br.com.cdb.bancodigitalfinal.entity.ContaPoupanca;
import br.com.cdb.bancodigitalfinal.service.ClienteService;
import br.com.cdb.bancodigitalfinal.service.ContaService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	

	@Autowired
	private ContaService cService;
	

	//ADICONA O CLIENTE NO BANCO DE DADOS COM UMA CONTA JA CRIADA POR ESCOLHA DELE SENDO CONTA POUPANÇA OU CORRENTE
	@PostMapping("/add")
	@Validated
	public ResponseEntity<String> addCliente(@RequestBody ContaDTO dto){
	try {
		if(dto.getNome() == null || !dto.getNome().matches("[A-Z][a-z]+\\s[A-Z][a-z]+.*"))
		{
			return ResponseEntity.badRequest().body("Erro no nome, digite novamente!");
		}
		if(dto.getCpf() == null || !clienteService.validarCPF(dto.getCpf())) {
			return ResponseEntity.badRequest().body("CPF Invalido!");
			
			
		}
		if(dto.getCpf().equals(dto.getCpf()))
		{
			for(Cliente c : clienteService.getClientes() )
		    {
		    	if(c.getCpf().equals(dto.getCpf()))
		    	{
		    		return ResponseEntity.badRequest().body("Esse cpf já está sendo usado!");
		    	}
		    }
		}
		
		if(dto.getDataNascimento() == null ) {
			
			return ResponseEntity.badRequest().body("Campo data vazio!");
		}
		if (!clienteService.validarData(dto.getDataNascimento())) {
		    return ResponseEntity.badRequest().body("Usuário deve ter 18 anos ou mais.");
		}
		
		if(dto.getCategoria() == null)
		{
			return ResponseEntity.badRequest().body("O tipo de conta não existe!");
		}
		
		//CONTA
		Cliente cliente = clienteService.salvarCliente(dto.getNome(), dto.getCpf(), dto.getDataNascimento());
		cliente.setNome(dto.getNome());
		cliente.setCpf(dto.getCpf());
		if(dto.getTipoDeConta().equalsIgnoreCase("corrente")) 
		{
			cService.salvarContaCorrente(cliente, dto.getTipoDeConta(), dto.getCategoria() );
		}
		else if(dto.getTipoDeConta().equalsIgnoreCase("poupanca")|| dto.getTipoDeConta().equalsIgnoreCase("poupança")) 
		{
			cService.salvarContaPoupanca(cliente, dto.getTipoDeConta(), dto.getCategoria() );
		}
		else {
			 return ResponseEntity.badRequest().body("Tipo de conta inválido. Use 'corrente' ou 'poupança'.");
		}
		return new ResponseEntity<String>("Cliente adicionado com sucesso!", HttpStatus.CREATED);

	}catch(RuntimeException e ) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	  
	}

	
	@DeleteMapping("/delete/{id}")
		
	public ResponseEntity<String> deleteClientes(@PathVariable Long id){
	
		try{
			clienteService.deleteClientes(id);
			return ResponseEntity.accepted().body("Cliente deletado com sucesso!");
			
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		catch(Exception e ){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno ao deletar cliente!");
		}
			
	
	}
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Cliente> detalheCliente(@PathVariable Long id){
		
		
		 return clienteService.getCliente(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		
		
	}
	
	
}
