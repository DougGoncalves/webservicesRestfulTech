package br.com.fiap.api.controller;

import br.com.fiap.api.dto.BankDTO;
import br.com.fiap.api.dto.BankUpdateDTO;
import br.com.fiap.api.service.BankService;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("v1/banks")
public class BankController {

  private final BankService bankService;

  public BankController(BankService bankService){
    this.bankService = bankService;
  }

  @GetMapping
  @Operation(description = "Relação de Bancos de Sangue cadastrados")
  public List<BankDTO> findAll(@RequestParam(required = false, value= "name") String name){
    return bankService.findAll(name);
  }

  @GetMapping("{id}")
  @Operation(description = "Busca um banco de sangue a partir de seu id")
  public BankDTO findById(@PathVariable Long id){
    return bankService.findById(id);
  }

  @PostMapping
  @Operation(description = "Cria um novo banco de sangue")
  @ResponseStatus(HttpStatus.CREATED)
  public BankDTO create(@RequestBody BankUpdateDTO bankUpdateDTO){
    return bankService.create(bankUpdateDTO);
  }

  @PutMapping("{id}")
  @Operation(description = "Atualiza dados do banco de sangue")
  public BankDTO update(@RequestBody BankUpdateDTO bankUpdateDTO,@PathVariable Long id){
    return bankService.update(bankUpdateDTO, id);
  }

  @DeleteMapping("{id}")
  @Operation(description = "Deleta o banco de sangue")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id){
    bankService.delete(id);
  }
}
