package br.com.cdb.bancodigitalfinal.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cdb.bancodigitalfinal.entity.Conta;
import br.com.cdb.bancodigitalfinal.enums.Categoria;
import br.com.cdb.bancodigitalfinal.repository.ContaCorrenteRepository;
import br.com.cdb.bancodigitalfinal.repository.ContaRepository;
@Service
public class ContaCorrenteService {

	@Autowired
	private ContaCorrenteRepository contaCrepository;
	private ContaRepository cRepository;
	
	
	
	
	public void taxaMensal(BigDecimal valor) {
		
	LocalDate hoje = LocalDate.now();
	
	
		
	for(Conta c: cRepository.findAll()) 
	{
	if(LocalDate.now().getDayOfMonth() ==  c.getDataCriacao().getDayOfMonth() && LocalDate.now().isAfter( c.getDataCriacao()));
	
	{
		
		c.getCategoria();
		
													
		if(c.getCategoria() == Categoria.COMUM) 
		{
			c.setSaldo(c.getSaldo().subtract(new BigDecimal ("12.00")));
		}
		
		if(c.getCategoria() == Categoria.SUPER)
		{
			c.setSaldo(c.getSaldo().subtract(new BigDecimal ("8.00")));
		}
		
		if(c.getCategoria() == Categoria.PREMIUM) 
		{
			c.setSaldo(c.getSaldo().subtract(new BigDecimal ("0")));
		}
	}
	
	}	
	
	
	
}
}
	
	

