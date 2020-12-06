package br.com.fiap.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.fiap.api.dto.DonorUpdateDTO;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "TB_DONOR")
public class Donor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column
  private String name;

  @Column
  private int age;

  @Column
  private String bloodtype;

  @Column
  private String Rg;

  @Column
  private Boolean active = true;

  public Donor(){  
  }

  public Donor(DonorUpdateDTO donorUpdateDTO){
    this.id = 0L;
    this.name = donorUpdateDTO.getName();
    this.age = donorUpdateDTO.getAge();
    this.bloodtype = donorUpdateDTO.getBloodtype();
    this.Rg = donorUpdateDTO.getRg();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getBloodtype() {
    return this.bloodtype;
  }

  public void setBloodtype(String bloodtype) {
    this.bloodtype = bloodtype;
  }

  public String getRg() {
    return this.Rg;
  }

  public void setRg(String Rg) {
    this.Rg = Rg;
  }

  public Boolean isActive() {
    return this.active;
  }

  public Boolean getActive() {
    return this.active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }
  
}
