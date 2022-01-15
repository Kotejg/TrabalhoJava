package com.interfaces;

public interface AcoesVeiculos {
	
	double frear (double velocidadeAtual);
	double consumoCombustivel(int distanciaPercorrer, int quantidadeCombustivel);
	double velocidadeTotal (int QuantidadeAceleracao);
	double distanciaTotal(int quantidadeCombustivel, int distanciaPercorrer, int quantidadeAceleracao);
	
	
}
