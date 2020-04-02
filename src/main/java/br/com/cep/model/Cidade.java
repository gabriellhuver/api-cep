package br.com.cep.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "TCidade")
public class Cidade {


  @Id
  @Column(length = 20, nullable = false, unique = true)
  private String ibge;

  @Column(length = 2, nullable = false)
  private String uf;

  @Column(length = 100, nullable = false)
  private String localidade;

}
