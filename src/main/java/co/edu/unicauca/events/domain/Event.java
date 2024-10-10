package co.edu.unicauca.events.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author FABIAN G
 */
@Entity
@Table(name = "events")
public class Event implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToOne(targetEntity = Person.class, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "chair_id", updatable = false)
  private Person chair;

  @OneToMany(targetEntity = Person.class, fetch = FetchType.LAZY)
  private List<Person> committee;

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

  public Person getChair() {
    return chair;
  }

  public void setChair(Person chair) {
    this.chair = chair;
  }

  public List<Person> getCommittee() {
    return committee;
  }

  public void setCommittee(List<Person> committee) {
    this.committee = committee;
  }

}