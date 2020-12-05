package br.com.fiap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.fiap.api.entity.Bank;

import java.util.List;
import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Long> {

  Optional<Bank> findByIdAndActiveIsTrue(Long id);

  @Query("from Bank a where a.name like %:name% and a.active = true")
  List<Bank> findByName(String name);
}

