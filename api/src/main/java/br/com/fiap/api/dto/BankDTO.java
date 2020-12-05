package br.com.fiap.api.dto;

import br.com.fiap.api.entity.Bank;

import java.util.List;

public class BankDTO {

  private Long id;

  private String name;

  private String address;

  private String telephone;

  private List<String> stock;

  public BankDTO() {}

  public BankDTO(Bank bank){
    this.id = bank.getId();
    this.name = bank.getName();
    this.address = bank.getAddress();
    this.telephone = bank.getTelephone();
    this.stock = bank.getStock();
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

}
