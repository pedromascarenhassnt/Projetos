package br.com.cdb.bancodigitalfinal.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import br.com.cdb.bancodigitalfinal.entity.Cliente;
import br.com.cdb.bancodigitalfinal.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	
	
			   
		public boolean validarCPF( String cpf) {
		    // Considera-se erro CPF's formados por uma sequência de números iguais
		    if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || 
		        cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") ||
		        cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") ||
		        cpf.equals("99999999999") || cpf.length() != 11) {
		        return false;
		    }

		    char dig10, dig11;
		    int sm, i, r, num, peso;

		    // "try" - protege o código para eventuais erros de conversão de tipo (int)
		    try {
		        // Cálculo do 1º dígito verificador
		        sm = 0;
		        peso = 10;
		        for (i = 0; i < 9; i++) {
		            // Converte o i-ésimo caractere do CPF em um número:
		            num = cpf.charAt(i) - '0'; // Converte o caractere para o valor numérico
		            sm += num * peso;
		            peso--;
		        }

		        r = 11 - (sm % 11);
		        if (r == 10 || r == 11) {
		            dig10 = '0';
		        } else {
		            dig10 = (char) (r + '0'); // Converte o valor numérico para caractere
		        }

		        // Cálculo do 2º dígito verificador
		        sm = 0;
		        peso = 11;
		        for (i = 0; i < 10; i++) {
		            num = cpf.charAt(i) - '0'; // Converte o caractere para o valor numérico
		            sm += num * peso;
		            peso--;
		        }

		        r = 11 - (sm % 11);
		        if (r == 10 || r == 11) {
		            dig11 = '0';
		        } else {
		            dig11 = (char) (r + '0'); // Converte o valor numérico para caractere
		        }

		        // Verifica se os dígitos calculados conferem com os dígitos informados
		        return dig10 == cpf.charAt(9) && dig11 == cpf.charAt(10);

		    } catch (Exception e) {
		        // Caso ocorra algum erro durante a execução, retorna false
		        return false;
		  
		   
		    }
		    
		}

		        public static String imprimeCPF(String CPF) {
		            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
		            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
		        }
	public boolean validarData(String dataNascimento) 
	{
		LocalDate hoje = LocalDate.now();
		 DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String dataFormatada = hoje.format(formato);
		LocalDate data = LocalDate.parse(dataNascimento, formato);
    	
    	int idade = Period.between(data, hoje).getYears();
       
    	if(idade >= 18) {
    		return true;
    	}
        if (idade < 18) {
            return false;
        }
		return false;
	}
	
	public Cliente salvarCliente(String nome, String cpf,String dataNascimento ) 
	{
		//VALIDAR OS CAMPOS 
		
		if( validarCPF(cpf) == false) {
			throw new RuntimeException("CPF invalido!");
		}
		validarData(dataNascimento);
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setDataNascimento(dataNascimento);
		return clienteRepository.save(cliente);
	
	}
	
	//MOSTRA TODOS OS CLIENTES NO BANCO DE DADOS
	public List<Cliente> getClientes()
	{	
		return clienteRepository.findAll();	
	}

	
	//DELETA OS CLIENTES POR ID
	public void deleteClientes(Long id){
		
		if(!clienteRepository.existsById(id)) {
			throw new RuntimeException("Cliente não encontrado");
		}
		clienteRepository.deleteById(id);
	}

	//
	public Optional<Cliente> getCliente(Long id)
	{	
			
		return clienteRepository.findById(id);
	
			
	}


}

