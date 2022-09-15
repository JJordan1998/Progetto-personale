package it.corsojava.rest.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.corsojava.spring.rest.model.Computer;
import it.corsojava.spring.rest.repository.ComputerRepository;

@RestController
//@RequestMapping("/pc")
public class ComputerRestController {

	@Autowired
	ComputerRepository repository;

//	@GetMapping("/pc")
//	public String getPc() {
//		String pc = repository.findAll().toString();
//		return pc;
//	}

	// LISTA PER MARCA

	@RequestMapping(path = "/lista")
	public String getByMarca() {
		List<Computer> lista = repository.getComputerByMarca("Asus");
		return lista.toString();
	}

	// RICERCA PER ID

	@GetMapping(path = "/id")
	public Computer selById() {
		Optional<Computer> pc = Optional.of(repository.getById(Long.valueOf(2)));
		Computer computer = pc.get();
		return computer;
	}

	// LISTA DEI PC

	@GetMapping(path = "/lista-pc", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Computer> getListPc() {
		List<Computer> pc = new ArrayList<>();
		Iterator<Computer> ite = repository.findAll().iterator();
		while (ite.hasNext()) {
			pc.add(ite.next());
		}

		System.out.println("Lista: " + pc);

		return pc;
	}

	// INSERIMENTO PC

	@PostMapping(path = "/computer")
	public Computer insert(@RequestBody Computer comp) {
		return repository.save(comp);
	}

	// UPDATE PC

	@PutMapping(path = "/computer")
	public Computer update(@RequestBody Computer comp) {
		return repository.save(comp);
	}

	// DELETE PC

	@DeleteMapping(path = "/computer/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

    // GET BY ID SU POSTMAN
	
	@GetMapping(path = "/find/{id}")
	public Optional<Computer> findById(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

//	@ResponseBody
//	@RequestMapping("/ciao")
//	public String ciao() {
//		return "Ciao, ci sei riuscito";
//		
//	}
	
	@GetMapping(path="/pc/marca/{marca}")
	public List<Computer> getComputerByMarca(@PathVariable ("marca") String marca) {
		List<Computer> listaComp = new ArrayList<>();
		Iterator<Computer> itComp = repository.getComputerByMarca(marca).iterator();
		while(itComp.hasNext()) {
			listaComp.add(itComp.next());
		}
		return listaComp;
	}
	

}
