package br.com.fiap.api.service;

import br.com.fiap.api.dto.BankUpdateDTO;
import br.com.fiap.api.dto.BankDTO;
import br.com.fiap.api.entity.Bank;
import br.com.fiap.api.repository.BankRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService{

  private BankRepository bankRepository;

  public BankServiceImpl(BankRepository bankRepository){
    this.bankRepository = bankRepository;
  }

  @Override
  public List<BankDTO> findAll(String search){
    String searchTerm = search == null ? "" : search;
    List<BankDTO> bankList = bankRepository.findByName(searchTerm)
      .stream()
      .map(bank -> new BankDTO(bank))
      .collect(Collectors.toList());

      return bankList;
  }

  @Override
  public BankDTO findById(Long id){
    Bank bank = getBankById(id);
    return new BankDTO(bank);
  }

  @Override
  public BankDTO create(BankUpdateDTO bankUpdateDTO){
    Bank bank = new Bank(bankUpdateDTO);
    Bank savedBank = bankRepository.save(bank);

    return new BankDTO(savedBank);
  }

  @Override
  public BankDTO update(BankUpdateDTO bankUpdateDTO, Long id){
    Bank bank = getBankById(id);
    bank.setName(bankUpdateDTO.getName());
    bank.setAddress(bankUpdateDTO.getAddress());
    bank.setTelephone(bankUpdateDTO.getTelephone());
    bank.setStock(bankUpdateDTO.getStock());

    Bank bankSaved = bankRepository.save(bank);
    return new BankDTO(bankSaved);
  }

  @Override
  public void delete(Long id){
    Bank bank = getBankById(id);
    bank.setActive(false);
    bankRepository.save(bank);
  }

  private Bank getBankById(Long id){
    return bankRepository.findFirstByIdAndActiveIsTrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }
  
}
