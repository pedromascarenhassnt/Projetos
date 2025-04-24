package br.com.cdb.bancodigitalfinal.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cdb.bancodigitalfinal.entity.Cliente;
import br.com.cdb.bancodigitalfinal.entity.Conta;
import br.com.cdb.bancodigitalfinal.entity.ContaCorrente;
import br.com.cdb.bancodigitalfinal.entity.ContaPoupanca;
import br.com.cdb.bancodigitalfinal.enums.Categoria;
import br.com.cdb.bancodigitalfinal.repository.ContaRepository;

@Service
public class ContaService implements CbService {

	@Autowired
	private ContaRepository cRepository;

	
	
	
	public Conta salvarContaCorrente(Cliente cliente, String tipoDeConta,String categoria) {
		ContaCorrente cc = new ContaCorrente();
		cc.setTipoDeConta(tipoDeConta);
		
		if(categoria.equalsIgnoreCase("Comum")) 
		{
			cc.setCategoria(Categoria.COMUM);
			cc.setSaldo(new BigDecimal("100"));
			cc.setTaxaDeManutencao(new BigDecimal("12.00")); 
		}
		else if(categoria.equalsIgnoreCase("Super")) 
		{
			cc.setCategoria(Categoria.SUPER);
			cc.setSaldo(new BigDecimal("500"));
			cc.setTaxaDeManutencao(new BigDecimal("8.00"));
		}
		else if(categoria.equalsIgnoreCase("Premium")) 
		{
			cc.setCategoria(Categoria.PREMIUM);
			cc.setSaldo(new BigDecimal("1000"));
			cc.setTaxaDeManutencao(new BigDecimal("0.00"));
			
		}
		else {
			throw new RuntimeException("Categoria inesistente!");
		}
		cc.setNumeroDaConta(gerarNumeroConta());
		cc.setCliente(cliente);
		return cRepository.save(cc);
	}
		
		public Conta salvarContaPoupanca(Cliente cliente, String tipoDeConta,String categoria) {
		ContaPoupanca cp = new ContaPoupanca();
		cp.setTipoDeConta(tipoDeConta);
		
		if(categoria.equalsIgnoreCase("Comum")) 
		{
			cp.setCategoria(Categoria.COMUM);
			cp.setSaldo(new BigDecimal("100"));
			cp.setRendimento(new BigDecimal("0.05"));
		}
		else if(categoria.equalsIgnoreCase("Super")) 
		{
			cp.setCategoria(Categoria.SUPER);
			cp.setSaldo(new BigDecimal("500"));
			cp.setRendimento(new BigDecimal("0.07"));
		}
		else if(categoria.equalsIgnoreCase("Premium")) 
		{
			cp.setCategoria(Categoria.PREMIUM);
			cp.setSaldo(new BigDecimal("1000"));
			cp.setRendimento(new BigDecimal("0.09"));
		}
		else {
			throw new RuntimeException("Categoria inesistente!");
		}
		cp.setNumeroDaConta(gerarNumeroConta());
		cp.setCliente(cliente);
		return cRepository.save(cp);

	}
	

	@Override
	public Conta buscarContaPorId(Long idConta) {

		return cRepository.findById(idConta).orElse(null);

	}

	@Override
	public void depositar(BigDecimal valor, Long idConta) {

		for (Conta c : cRepository.findAll()) {

			if (c.getIdConta() == idConta) {
				
				c.setSaldo(c.getSaldo().add(valor));
				cRepository.save(c);
			} else {

			}
		}
	}

	@Override
	public void sacar(BigDecimal valor, Long idConta) {

		for (Conta c : cRepository.findAll()) {
			if (valor.doubleValue() > c.getSaldo().doubleValue()) {
				throw new RuntimeException("Erro! Valor indisponível");
			}
			if (c.getIdConta() == idConta) {

				c.setSaldo(c.getSaldo().subtract(valor));
				cRepository.save(c);
			}
		}

	}


	public String gerarNumeroConta() {

		int numero = (int) (Math.random() * 900000) + 100000;
		int digito = numero % 9;
		return numero + "-" + digito;
	}


		@Override
		public void transfencia(Long idContaOrigem, Long idContaDestino,BigDecimal valor) 
		{
			Optional<Conta> contaOrigem = cRepository.findById(idContaOrigem);
			
			if(!contaOrigem.isPresent()) 
			{
				throw new RuntimeException("Conta origem não encontrada");
			}
			
			Conta co = contaOrigem.get();
			
			if(co.getSaldo().compareTo(valor) < 0 )
			{
				throw new RuntimeException("Saldo insuficiente.");
			}
			
			Optional<Conta> contaDestino = cRepository.findById(idContaDestino);
			
			if(!contaDestino.isPresent()) 
			{
				throw new RuntimeException("Conta destino não encontrada");
			}
			
			Conta cd = contaDestino.get();
			
			co.setSaldo(co.getSaldo().subtract(valor));
			cd.setSaldo(cd.getSaldo().add(valor));
			cRepository.save(co);
			cRepository.save(cd);
		}

		public Optional<Conta> getConta(Long idConta)
		{	
				
			return cRepository.findById(idConta);
		
				
		}

}
