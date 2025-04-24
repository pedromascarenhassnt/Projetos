package br.com.cdb.bancodigitalfinal.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class ContaPoupanca extends Conta{

	private BigDecimal rendimento;

	
	public BigDecimal getRendimento() {
		return rendimento;
	}

	public void setRendimento(BigDecimal rendimento) {
		this.rendimento = rendimento;
	}
	
	
	
	
	
	
	
	
}
