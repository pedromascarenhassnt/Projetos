package br.com.cdb.bancodigitalfinal.service;

import java.math.BigDecimal;

import br.com.cdb.bancodigitalfinal.entity.Conta;

public interface CbService {


	
	Conta buscarContaPorId(Long idConta);

	void sacar(BigDecimal valor, Long idConta);

	void depositar(BigDecimal valor, Long idConta);

	void transfencia(Long idContaOrigem, Long idContaDestino, BigDecimal valor);
	
}
