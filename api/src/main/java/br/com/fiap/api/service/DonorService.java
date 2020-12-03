package br.com.fiap.api.service;

import java.util.List;

import br.com.fiap.api.dto.DonorUpdateDTO;
import br.com.fiap.api.dto.DonorDTO;


public interface DonorService {

  List<DonorDTO> findAll(String search);
  
  DonorDTO findById(Long id);

  DonorDTO create(DonorUpdateDTO donorUpdateDTO);

  DonorDTO update(DonorUpdateDTO donorUpdateDTO, Long id);

  void delete(Long id);
}
