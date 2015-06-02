package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.google.common.base.Objects;

@Entity(name = "Anuncio")
public class Anuncio {

	// Todo Id tem que ter o GeneratedValue a não ser que ele seja setado
		// Usar Id sempre Long
		@Id
		@GeneratedValue
		private Long id;
		
		@ManyToMany(cascade = CascadeType.ALL)
		private List<Instrumento> instrumentos;
	    
	    @ManyToMany(cascade  = CascadeType.ALL)
	    private List<Estilo> estilos;

		@Column
		private String titulo;
		
		private String descricao;
		
		private String cidade;
		
		private String bairro;
		
		private String contato;

		// Construtor vazio para o Hibernate criar os objetos
		public Anuncio() {
			this.instrumentos = new ArrayList<Instrumento>();
			this.estilos = new ArrayList<Estilo>();
		}

	    public Anuncio(String titulo, String descricao, String cidade, String bairro, String contato, Instrumento... instrumentos) {
	        this();
	        this.titulo = titulo;
	        this.descricao = descricao;
	        this.cidade = cidade;
	        this.bairro = bairro;
	        this.contato = contato;
	        this.instrumentos = Arrays.asList(instrumentos);
	    }

	    public Anuncio(String titulo, Instrumento... instrumentos) {
	        this.instrumentos = Arrays.asList(instrumentos);
	        this.titulo = titulo;
	    }

	    public String getTitulo() {
			return titulo;
		}

	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }
	    
	    public String getDescricao() {
			return descricao;
		}
	    
	    public String getCidade() {
			return cidade;
		}

	   public void setCidade(String cidade) {
	        this.cidade = cidade;
	    }
	    
	    public String getBairro() {
			return bairro;
		}

	    public void setBairro(String bairro) {
	        this.bairro = bairro;
	    }

	    public void setDescricao(String descricao) {
	        this.descricao = descricao;
	    }
	    
	    public String getContato() {
	       return contato;
	    }

	    public void setContato(String contato) {
	        this.contato = contato;
	    }

	    public Long getId() {
			return id;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof Anuncio)) {
				return false;
			}
			Anuncio outroLivro = (Anuncio) obj;
			return Objects.equal(outroLivro.getTitulo(), this.getTitulo());
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(this.getTitulo());
		}

	    public List<Instrumento> getInstrumentos() {
	        return Collections.unmodifiableList(instrumentos);
	    }
	    
	    public List<Estilo> getEstilos() {
	        return Collections.unmodifiableList(estilos);
	    }

	    public void addEstilo(List<Estilo> estilo) {
	        estilos = estilo;
	    }
	    
	    public void addInstrumento(List<Instrumento> instrumento) {
	        instrumentos = instrumento;
	    }
	    
	    //REMOVER
	    public void addInstrumento(Instrumento instrumento) {
	        instrumentos.add(instrumento);
	    }

	    public void setId(long id) {
	        this.id = id;
	    }
	
}
