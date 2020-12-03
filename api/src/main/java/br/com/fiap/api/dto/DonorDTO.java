package br.com.fiap.api.dto;

import br.com.fiap.api.entity.Donor;

public class DonorDTO {

  private Long id;

  private String name;

  private int age;

  private String bloodtype;

  private String Rg;

  public DonorDTO(){
  }


  public DonorDTO(Donor donor) {
    this.id = donor.getId();    
    this.name = donor.getName();
    this.age = donor.getAge();
    this.bloodtype = donor.getBloodtype();
    this.Rg = donor.getRg();
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
}
