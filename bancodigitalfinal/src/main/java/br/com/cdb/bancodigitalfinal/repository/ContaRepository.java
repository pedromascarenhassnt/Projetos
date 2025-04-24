package br.com.cdb.bancodigitalfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cdb.bancodigitalfinal.entity.Conta;
import br.com.cdb.bancodigitalfinal.entity.ContaPoupanca;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
}