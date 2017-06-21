package com.tkr.brewer.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.tkr.brewer.validation.SKU;

@Entity
@Table(name = "cerveja")
public class Cerveja implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@SKU
	@NotBlank(message = "O SKU é obrigatório")
	private String sku;
	
	@NotBlank(message = "O Nome é obriagatório")
	private String nome;
	
	@NotBlank(message = "A descricao é obriagatória ")
	@Size(min = 2, max = 50, message = "A descrição tem que estar entre 2 e 50")
	private String descricao;
	
	//@NotEmpty(message = "O Valor é obriagatório")
	@DecimalMin(value = "0.01", message = "O valor de uma cerveja nao deve ser inferior a R$0,01")
	@DecimalMax(value = "9999999.99", message = "O valor  da cerveja deve ser menor que R$9.999.999,99")
	private BigDecimal valor;
	
	//@NotEmpty(message = "O teor alcoolico é obriagatório")
	@Column(name = "teor_alcoolico")
	private BigDecimal teorAlcoolico;
	
	//@NotEmpty(message = "A comissao é obriagatória")
	@DecimalMax(value = "100" , message = "A comissao nao deve passar de 100%")
	private BigDecimal comissao;
	
	//@NotEmpty(message = "O estoque é obriagatório ")
	@Max(value = 9999 , message = "O valor nao deve ser maio que 9999"  )
	@Min(value = 2 , message = "O valor de estoque deve ser maior que 1")
	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;
	
	//@NotEmpty(message = "A origem é obriagatória ")
	@Enumerated(EnumType.STRING)
	private Origem origem;
	
	//@NotEmpty(message = "O sabpor é obriagatória ")
	@Enumerated(EnumType.STRING)
	private Sabor sabor;
	
	//@NotEmpty(message = "O estilo é obriagatória ")
	@ManyToOne
	@JoinColumn(name = "codigo_estilo")
	private Estilo estilo;
	
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}