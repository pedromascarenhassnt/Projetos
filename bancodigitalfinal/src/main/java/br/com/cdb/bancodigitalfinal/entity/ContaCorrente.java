package br.com.cdb.bancodigitalfinal.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class ContaCorrente extends Conta{

	
	private BigDecimal taxaDeManutencao;

	public BigDecimal getTaxaDeManutencao() {
		return taxaDeManutencao;
	}

	public void setTaxaDeManutencao(BigDecimal taxaDeManutencao) {
		this.taxaDeManutencao = taxaDeManutencao;
	}
	
	
	
	
	
	
	
	
	
}
