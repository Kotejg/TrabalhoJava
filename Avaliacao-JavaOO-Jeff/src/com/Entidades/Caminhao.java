package com.Entidades;

import com.services.Util;

public class Caminhao extends Automovel {
	 private final Integer aceleracao = 10;
	 private final Integer frenagem = 2;
	 private final Integer autonomia = 22;
	 private final Double velMax = 180.0;
    private final Integer capacidadeMax = 250;
	 private final Double velInicial = 67.0;
	 private final Integer distanciaMax = 5500;
	 private Double velocidadeAtual = 0.0;
	
	 
	
	public Caminhao(Integer distanciaPercorrer, Integer quantidadeCombustivel, Integer quantidadeAceleracao) {
		super(distanciaPercorrer, quantidadeCombustivel, quantidadeAceleracao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double frear(double velocidadeAtual) {
		double freou = 0;
		if (this.velocidadeAtual >= frenagem ){
			freou  = (this.velocidadeAtual / frenagem);

		} else {
			this.velocidadeAtual = 0.0;
		}
		return freou ;
	}

	@Override
	public double consumoCombustivel(int distanciaPercorrer, int quantidadeCombustivel) {
		double combustivelTotal = 0;
		if(quantidadeCombustivel >= capacidadeMax ) {
			quantidadeCombustivel = capacidadeMax ;
			double consumoUtilizado = distanciaPercorrer / autonomia; 
			combustivelTotal = quantidadeCombustivel - consumoUtilizado;
			if(combustivelTotal < 0) {
				combustivelTotal = 0;
			}
		} else {
			double consumoUtilizado = distanciaPercorrer / autonomia + ((autonomia * 20) / 100); 
			combustivelTotal = quantidadeCombustivel - consumoUtilizado;
			if(combustivelTotal < 0) {
				combustivelTotal = 0;
			}
		}
		return combustivelTotal;
	}

	@Override
	public double velocidadeTotal(int quantidadeAceleracao) {
	velocidadeAtual = this.velInicial; 
		
		if(quantidadeAceleracao < 3) {
			System.out.println();
			System.out.println("Acelaração minina é de 3 vezes, tente novamente");
			Util.StartMenu();
		} else {
			for (int i = 1; i <= quantidadeAceleracao; i++) {			
				if (this.velocidadeAtual >= velMax) {
					this.velocidadeAtual = velMax;
				} else {
					this.velocidadeAtual += aceleracao;
				}
		}
		}
		
		return velocidadeAtual;
	}

	@Override
	public double distanciaTotal(int quantidadeCombustivel, int distanciaPercorrer, int quantidadeAceleracao) {
		if(distanciaPercorrer > distanciaMax && quantidadeCombustivel > capacidadeMax ) {
			System.out.println();
			System.out.println("valores imcopativeis, tente novamente");
			System.out.printf("distancia maxima percorrida com o tanque cheio é de " + distanciaMax);
			System.out.printf("quantidade maxima do tanque é de " + capacidadeMax);
			Util.StartMenu();
		} else {
			int autonomiaTotal;
			if (velocidadeTotal(quantidadeAceleracao) <= velInicial) {
				autonomiaTotal = autonomia;
				distanciaPercorrer = quantidadeCombustivel * autonomiaTotal;
			
			} else {
				autonomiaTotal = autonomia +((autonomia * 20) / 100);
				distanciaPercorrer = quantidadeCombustivel * autonomiaTotal;
			}
		}
		
		return 0.0;
	}

	@Override
	public String Marca() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString(String modelo) {
		return  "Tipo do Veiculo: Caminhão " 
				+"Modelo: " + modelo
				+ "\nVelocidade Máxima: " + velMax 
				+ "\nCapacidade Maxima de Combustivel: " + capacidadeMax 
			    + "\nVelocidade Final Alcançada: " + this.velocidadeTotal(quantidadeAceleracao)
			    +  String.format("\nDistancia Total Percorrida: %.2f", distanciaTotal(quantidadeCombustivel, distanciaPercorrer, quantidadeAceleracao))  
			    +  String.format("\nCombustivel Total Gasto: %.2f", consumoCombustivel(distanciaPercorrer,quantidadeCombustivel)) 
			    + String.format("\nFreagem Total: %.2f", frear(this.velocidadeAtual));
		
		}	

}
