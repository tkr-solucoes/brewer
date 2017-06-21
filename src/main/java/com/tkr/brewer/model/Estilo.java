package com.tkr.brewer.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "estilo")
	public class Estilo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
		
		
		

		@NotBlank(message="O nome é obrigatório")
		private String nome;
		
		@OneToMany(mappedBy = "estilo")
		private List<Cerveja> cerveja;
		
		

		public Estilo(){
			
		}
		
		public Estilo(Long codigo, String nome, List<Cerveja> cerveja) {
		
			this.codigo = codigo;
			this.nome = nome;
			this.cerveja = cerveja;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public Long getCodigo() {
			return codigo;
		}


		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}


		public List<Cerveja> getCerveja() {
			return cerveja;
		}


		public void setCerveja(List<Cerveja> cerveja) {
			this.cerveja = cerveja;
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
			Estilo other = (Estilo) obj;
			if (codigo == null) {
				if (other.codigo != null)
					return false;
			} else if (!codigo.equals(other.codigo))
				return false;
			return true;
		}

		
		

	}
