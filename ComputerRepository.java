package it.corsojava.spring.rest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.corsojava.spring.rest.model.Computer;

public interface ComputerRepository extends CrudRepository<Computer, Long> {
	
	public Computer getById(Long id);
	
//	public Computer deleteById(Long id);
	
	public List<Computer> getComputerByMarca(String marca);

}
