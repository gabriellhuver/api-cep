package br.com.cep.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "TCep")
public class Cep {

	@Id
	@Column(unique = true, nullable = false, length = 10)
	private String cep;

	@Column(nullable = false, length = 255)
	private String logradouro;

	@Column(nullable = true, length = 255)
	private String complemento;

	@Column(nullable = true, length = 50)
	private String bairro;

	@OneToOne(targetEntity = Cidade.class, cascade = CascadeType.ALL)
	private Cidade cidade;

}
