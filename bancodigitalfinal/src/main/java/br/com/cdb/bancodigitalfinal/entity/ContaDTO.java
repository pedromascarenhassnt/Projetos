package br.com.cdb.bancodigitalfinal.entity;

public class ContaDTO {

	private String tipoDeConta;
	private Long idCliente;
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String categoria;
	
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTipoDeConta() {
		return tipoDeConta;
	}
	public void setTipoDeConta(String tipoDeConta) {
		this.tipoDeConta = tipoDeConta;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
}
