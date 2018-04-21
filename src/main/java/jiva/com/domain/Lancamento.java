package jiva.com.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Domain/entidade Lançamentos
 * @author Thiago Hernandes de Souza
 * @since 20-04-2018
 * */

@Entity
@Table(schema="public", name="lancamentos")
public class Lancamento {
	
	private Integer id;
	private String descricao;
	private Date vencimento;
	private Double valor;
	private String tipo;
	
	public Lancamento() {
		
	}
	
	public Lancamento(Integer id, String descricao, Date vencimento, Double valor, String tipo) {
		this.id = id;
		this.descricao = descricao;
		this.vencimento = vencimento;
		this.valor = valor;
		this.tipo= tipo;
	}
	
	public Lancamento(String descricao, Date vencimento, Double valor, String tipo) {
		this.descricao = descricao;
		this.vencimento = vencimento;
		this.valor = valor;
		this.tipo= tipo;
	}
	
	public Lancamento(Integer id) {
		this.id = id;
	}
	
	@Id
	@SequenceGenerator(name="seq-gen",allocationSize=1, sequenceName="lancamentos_id_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getVencimento() {
		return vencimento;
	}
	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
