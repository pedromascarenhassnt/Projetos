package br.com.cdb.bancodigitalfinal.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.cdb.bancodigitalfinal.enums.Categoria;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConta;
	private String tipoDeConta;
	private BigDecimal saldo;
	private String numeroDaConta;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	private LocalDate dataCriacao;
	

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(String numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public String getTipoDeConta() {
		return tipoDeConta;
	}

	public void setTipoDeConta(String tipoDeConta) {
		this.tipoDeConta = tipoDeConta;
	}

	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	@PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDate.now(); 
    }
}
