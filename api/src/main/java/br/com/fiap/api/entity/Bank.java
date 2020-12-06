package br.com.fiap.api.entity;

import br.com.fiap.api.dto.BankUpdateDTO;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "TB_BANK")
public class Bank {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column
  private String name;

  @Column
  private String address;

  @Column
  private String telephone;

  @ElementCollection
  private List<String> stock;

  @Column
  private Boolean active = true;

  public Bank() {}


  public Bank(BankUpdateDTO bankUpdateDTO){
    this.id = 0L;
    this.name = bankUpdateDTO.getName();
    this.address = bankUpdateDTO.getAddress();
    this.telephone = bankUpdateDTO.getTelephone();
    this.stock = bankUpdateDTO.getStock();
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

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getTelephone() {
    return this.telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public List<String> getStock() {
    return this.stock;
  }

  public void setStock(List<String> stock) {
    this.stock = stock;
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
