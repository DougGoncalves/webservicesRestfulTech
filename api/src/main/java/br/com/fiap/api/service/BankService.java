package br.com.fiap.api.service;

import java.util.List;
import br.com.fiap.api.dto.BankUpdateDTO;
import br.com.fiap.api.dto.BankDTO;

public interface BankService {
  
  List<BankDTO> findAll(String search);

  BankDTO findById(Long id);

  BankDTO create (BankUpdateDTO bankUpdateDTO);

  BankDTO update (BankUpdateDTO bankUpdateDTO, Long id);

  void delete(Long id);

}
