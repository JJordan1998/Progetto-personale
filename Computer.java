package it.corsojava.spring.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="computer")
public class Computer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	@Column(length= 20, nullable= false)
	private String marca;
	
	@Column(length= 20, nullable= false)
	private String modello;
	
	@Column(length= 20, nullable=false)
	private String processore;
	
	@Column(nullable=false)
	private int ram;
	
	@Column(nullable=false)
	private double prezzo;

	public Computer() {
		super();
	}

	public Computer(Long id, String marca, String modello, String processore, int ram, double prezzo) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.processore = processore;
		this.ram = ram;
		this.prezzo = prezzo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getProcessore() {
		return processore;
	}

	public void setProcessore(String processore) {
		this.processore = processore;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", marca=" + marca + ", modello=" + modello + ", processore=" + processore
				+ ", ram=" + ram + ", prezzo=" + prezzo + "]";
	}

	
	
}