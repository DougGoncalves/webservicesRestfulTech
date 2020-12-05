package br.com.fiap.api.dto;

import java.util.List;

public class BankUpdateDTO {

  private String name;

  private String address;

  private String telephone;

  private List<String> stock;


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
