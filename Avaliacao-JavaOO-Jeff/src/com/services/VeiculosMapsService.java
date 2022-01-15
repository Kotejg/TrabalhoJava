package com.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class VeiculosMapsService {
	private Map<Integer, String> veiculoMaps = new HashMap<>();

// construtor
	public VeiculosMapsService() {
		veiculoMaps.put(1, " Ferrari 812");
		veiculoMaps.put(2, " Bentley Flying Spur");
		veiculoMaps.put(3, " Aston Martin Dbs Superlegera");
		veiculoMaps.put(4, " Ducati 1198 S");
		veiculoMaps.put(5, " Ducati 620 Sport");
		veiculoMaps.put(6, " Indian Chief Dark Horse");
		veiculoMaps.put(7, " Volvo FH 540");
		veiculoMaps.put(8, " Scania R450"); 
		veiculoMaps.put(9, " Scania R500");
	}
	 
	
	
	
	
	
	public VeiculosMapsService(Map<Integer, String> veiculoMaps) {
		this.veiculoMaps = veiculoMaps;
	}
	
	public void MenuOpcoes() {
		for(Entry<Integer, String> registro :veiculoMaps.entrySet()) {
		    System.out.printf("%s - %s%n", registro.getKey(), registro.getValue());
		}
	}
	
	public String nomeVeiculo(Integer escolha) {	
		return veiculoMaps.get(escolha);
	}






	@Override
	public int hashCode() {
		return Objects.hash(veiculoMaps);
	}






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeiculosMapsService other = (VeiculosMapsService) obj;
		return Objects.equals(veiculoMaps, other.veiculoMaps);
	}
	

}
