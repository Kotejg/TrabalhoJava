package com.enums;

public enum CaracterCarro {
	 ACELERACAO(15),
	 FRENAGEM(10),
	 AUTONOMIA(8),
	 VELOCIDADE_MAXIMA(290),
     CAPACIDADE_MAXIMA_COMBUSTIVEL(75),
	 VELOCIDADE_INICIAL(67),
	 DISTANCIA_MAXIMA(600);

	public Integer valorCaracterCarro;
	CaracterCarro(int valor){
		valorCaracterCarro = valor;
	}
}


