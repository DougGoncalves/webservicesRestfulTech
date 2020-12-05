package br.com.fiap.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.api.dto.DonorUpdateDTO;
import br.com.fiap.api.dto.DonorDTO;
import br.com.fiap.api.entity.Donor;
import br.com.fiap.api.repository.DonorRepository;

public class DonorServiceImpl implements DonorService{

  private DonorRepository donorRepository;

  public DonorServiceImpl(DonorRepository donorRepository){
    this.donorRepository = donorRepository;
  }

  @Override
  public List<DonorDTO> findAll(String search){
    String searchTerm = search == null ? "" : search;
    List<DonorDTO> donorList = donorRepository.findByName(searchTerm).stream()
      .map(donor -> new DonorDTO(donor)).collect(Collectors.toList());

    return donorList;
  }

  @Override
  public DonorDTO findById(Long id){
    Donor donor = getDonorById(id);

    return new DonorDTO(donor);
  }

  @Override
  public DonorDTO create(DonorUpdateDTO donorUpdateDTO){
    Donor donor = new Donor(donorUpdateDTO);
    Donor savedDonor = donorRepository.save(donor);

    return new DonorDTO(savedDonor);
  }

  @Override
  public DonorDTO update(DonorUpdateDTO donorUpdateDTO, Long id){
    Donor donor = getDonorById(id);
    donor.setName(donorUpdateDTO.getName());
    donor.setAge(donorUpdateDTO.getAge());
    donor.setBloodtype(donorUpdateDTO.getBloodtype());
    donor.setRg(donorUpdateDTO.getRg());

    Donor donorSaved = donorRepository.save(donor);

    return new DonorDTO(donorSaved);
  }

  @Override
  public void delete(Long id){
    Donor donor = getDonorById(id);
    donor.setActive(false);
    donorRepository.save(donor);
  }

  private Donor getDonorById(Long id){
    return donorRepository.findByIdAndActiveIstrue(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }
  
}
