package co.edu.unicauca.events.domain;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 *
 * @author FABIAN G
 */
@Entity
@Table(name = "person")
public class Person implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
