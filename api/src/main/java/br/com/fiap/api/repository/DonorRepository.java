package br.com.fiap.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.api.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {

  Optional<Donor> findFirstByIdAndActiveIsTrue(Long id);

  @Query("from Donor a where a.name like %:name% and a.active = true")
  List<Donor> findByName(@Param(value = "name") String name);
  
}
