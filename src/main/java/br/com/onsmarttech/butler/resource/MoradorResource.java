package br.com.onsmarttech.butler.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.onsmarttech.butler.models.base.Morador;
import br.com.onsmarttech.butler.repositories.MoradorRepository;
import br.com.onsmarttech.butler.service.MoradorService;

@RestController
@RequestMapping("/morador")
public class MoradorResource {

	@Autowired
	private MoradorRepository repository;

	@Autowired
	private MoradorService service;

	@GetMapping
	public Page<Morador> listaMoradores(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarMoradorPorId(@PathVariable Long id) {
		Morador morador = repository.findOne(id);

		return morador != null ? ResponseEntity.ok(morador) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> salvarMorador(@Valid @RequestBody Morador morador) {
		Morador moradorSalvo = repository.save(morador);

		return ResponseEntity.status(HttpStatus.CREATED).body(moradorSalvo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		repository.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> salvarMorador(@PathVariable Long id, @Valid @RequestBody Morador morador) {
		Morador moradorSalvo = service.atualizar(id, morador);

		return ResponseEntity.ok(moradorSalvo);
	}
}