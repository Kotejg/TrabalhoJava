package com.Entidades;


import com.services.Util;

public class Carro extends Automovel{
	
	private final Integer Aceleracao = 15;
	 private final Integer Frenagem = 10;
	 private final Integer Autonomia = 8;
	 private final Double VelMax = 290.0;
     private final Integer CapacidadeMax = 75;
	 private final Double VelInicial = 67.0;
	 private final Integer DistanciaMax = 600;
	 private Double velocidadeAtual = 0.0;
	
	
	
	
	 
	 public Carro(Integer distanciaPercorrer, Integer quantidadeCombustivel, Integer quantidadeAceleracao) {
		super(distanciaPercorrer, quantidadeCombustivel, quantidadeAceleracao);
		this.velocidadeAtual = velocidadeTotal(quantidadeAceleracao);
	}

	
	 

	@Override
	public double frear(double velocidadeAtual) {
		double freou = 0;
		if (this.velocidadeAtual >= Frenagem ){
			freou  = (this.velocidadeAtual / Frenagem);

		} else {
			this.velocidadeAtual = 0.0;
		}
		return freou ;
	}

	@Override
	public double consumoCombustivel(int distanciaPercorrer, int quantidadeCombustivel) {
		double combustivelTotal = 0;
		if(quantidadeCombustivel >= CapacidadeMax ) {
			quantidadeCombustivel = CapacidadeMax ;
			double consumoUtilizado = distanciaPercorrer / Autonomia; 
			combustivelTotal = quantidadeCombustivel - consumoUtilizado;
			if(combustivelTotal < 0) {
				combustivelTotal = 0;
			}
		} else {
			double consumoUtilizado = distanciaPercorrer / Autonomia + ((Autonomia * 10) / 100); 
			combustivelTotal = quantidadeCombustivel - consumoUtilizado;
			if(combustivelTotal < 0) {
				combustivelTotal = 0;
			}
		}
		return combustivelTotal;
	}

	@Override
	public  double  velocidadeTotal(int quantidadeAceleracao) {
	velocidadeAtual = this.VelInicial; 
		
		if(quantidadeAceleracao < 3) {
			System.out.println();
			System.out.println("Acelaração minina é de 3 vezes, tente novamente");
			Util.StartMenu();
		} else {
			for (int i = 1; i <= quantidadeAceleracao; i++) {			
				if (this.velocidadeAtual >= VelMax) {
					this.velocidadeAtual = VelMax;
				} else {
					this.velocidadeAtual += Aceleracao;
				}
		}
		}
		
		return velocidadeAtual;
	
	}
	
	
	
	@Override
	public double distanciaTotal(int quantidadeCombustivel, int distanciaPercorrer, int quantidadeAceleracao) {
		if(distanciaPercorrer > DistanciaMax || quantidadeCombustivel > CapacidadeMax ) {
			System.out.println();
			System.out.println("valores imcopativeis, tente novamente");
			System.out.printf("distancia maxima percorrida com o tanque cheio é de " + DistanciaMax);
			System.out.printf("quantidade maxima do tanque é de " + CapacidadeMax);
			Util.StartMenu();
		} else {
			double autonomiaTotal;
			if (velocidadeTotal(quantidadeAceleracao) <= VelInicial) {
				autonomiaTotal = Autonomia;
				distanciaPercorrer = (int) (quantidadeCombustivel * autonomiaTotal);
			
			} else {
				autonomiaTotal = Autonomia + (Autonomia * 10)/100;
				distanciaPercorrer = (int) (quantidadeCombustivel * autonomiaTotal);
			}
		}
		
		return distanciaPercorrer;
	}

	@Override
	public String Marca() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString(String modelo) {
		return    "Tipo do Veiculo: Carro " 
				+"\nModelo: " + modelo
				+ "\nVelocidade Máxima: " + VelMax 
				+ "\nCapacidade Maxima de Combustivel: " + CapacidadeMax 
			    + "\nVelocidade Final Alcançada: " + this.velocidadeTotal(quantidadeAceleracao)
			    +  String.format("\nDistancia Total Percorrida: %.2f", distanciaTotal(quantidadeCombustivel, distanciaPercorrer, quantidadeAceleracao))  
			    +  String.format("\nCombustivel Total Gasto: %.2f", consumoCombustivel(distanciaPercorrer,quantidadeCombustivel)) 
			    + String.format("\nFreagem Total: %.2f", frear(this.velocidadeAtual));
		
		}	
	
	
}
