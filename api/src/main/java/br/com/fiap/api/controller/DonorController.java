package br.com.fiap.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import br.com.fiap.api.dto.DonorUpdateDTO;
import br.com.fiap.api.dto.DonorDTO;
import br.com.fiap.api.service.DonorService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "v1/donors")
public class DonorController {

	private final DonorService donorService;

	public DonorController(DonorService donorService) {
		this.donorService = donorService;
	}

	@GetMapping
	@Operation(description = "Listagem de doadores")
	public List<DonorDTO> listAll(@RequestParam(required = false, value = "name") String name) {
		return donorService.findAll(name);
	}

	@GetMapping("{id}")
	@Operation(description = "Lista um doador a partir de seu id")
	public DonorDTO getById(@PathVariable Long id) {
		return donorService.findById(id);
	}

	@PostMapping
	@Operation(description = "Cria um novo doador")
	@ResponseStatus(HttpStatus.CREATED)
	public DonorDTO create(@RequestBody DonorUpdateDTO donorUpdateDTO) {
		return donorService.create(donorUpdateDTO);
	}

	@PutMapping("{id}")
	@Operation(description = "Atualiza as informações de um doador")
	public DonorDTO update(@RequestBody DonorUpdateDTO donorUpdateDTO, @PathVariable Long id) {
		return donorService.update(donorUpdateDTO, id);
	}

	@DeleteMapping("{id}")
	@Operation(description = "Apaga os dados de um doador")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		donorService.delete(id);
	}

}
