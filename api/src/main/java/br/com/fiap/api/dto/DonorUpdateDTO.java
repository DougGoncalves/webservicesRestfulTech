package br.com.fiap.api.dto;

public class DonorUpdateDTO {

  private String name;

  private int age;

  private String bloodtype;

  private String Rg;


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

  
}
