package br.com.cdb.bancodigitalfinal.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cdb.bancodigitalfinal.entity.Conta;
import br.com.cdb.bancodigitalfinal.enums.Categoria;

import br.com.cdb.bancodigitalfinal.repository.ContaPoupancaRepository;
import br.com.cdb.bancodigitalfinal.repository.ContaRepository;

@Service
public class ContaPoupancaService {

	@Autowired
	private ContaPoupancaRepository cpRepository;
	private ContaRepository cRepository;
	
	public void taxaRendimento() {
		
	LocalDate hoje = LocalDate.now();
	
	
	for(Conta c : cRepository.findAll() )	{
		
	
	if(LocalDate.now().getYear() ==  c.getDataCriacao().getYear() && LocalDate.now().isAfter( c.getDataCriacao())) {
		
		c.getCategoria();
		if(c.getCategoria() == Categoria.COMUM) {
			c.setSaldo(c.getSaldo().add(c.getSaldo().multiply(new BigDecimal ("0.05")))); ;
		}
		if(c.getCategoria() == Categoria.SUPER) {
			c.setSaldo(c.getSaldo().add(c.getSaldo().multiply(new BigDecimal ("0.07"))));
		}
		if(c.getCategoria() == Categoria.PREMIUM) {
			c.setSaldo(c.getSaldo().add(c.getSaldo().multiply(new BigDecimal ("0.09"))));
		}
	}
	}	
	
	}	
}
