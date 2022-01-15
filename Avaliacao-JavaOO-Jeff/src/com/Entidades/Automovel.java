package com.Entidades;

import com.interfaces.AcoesVeiculos;

public abstract class Automovel implements AcoesVeiculos {
	protected Integer distanciaPercorrer;
	protected Integer quantidadeCombustivel;
	protected Integer quantidadeAceleracao;
	
	


	public Automovel(Integer distanciaPercorrer, Integer quantidadeCombustivel, Integer quantidadeAceleracao) {
		super();
		this.distanciaPercorrer = distanciaPercorrer;
		this.quantidadeCombustivel = quantidadeCombustivel;
		this.quantidadeAceleracao = quantidadeAceleracao;
		
	}


	public Integer getDistanciaPercorrer() {
		return distanciaPercorrer;
	}

	public void setDistanciaPercorrer(Integer distanciaPercorrer) {
		this.distanciaPercorrer = distanciaPercorrer;
	}

	public Integer getQuantidadeCombustivel() {
		return quantidadeCombustivel;
	}

	public void setQuantidadeCombustivel(Integer quantidadeCombustivel) {
		this.quantidadeCombustivel = quantidadeCombustivel;
	}

	public Integer getQuantidadeAceleracao() {
		return quantidadeAceleracao;
	}

	public void setQuantidadeAceleracao(Integer quantidadeAceleracao) {
		this.quantidadeAceleracao = quantidadeAceleracao;
	}

	public abstract String Marca();
	
	
	public String toString(String modelo) {
		return "Veiculo [distanciaParaPercorrer=" + distanciaPercorrer + ", quantidadeDeCombustivel="
				+ quantidadeCombustivel + ", qntAceleracao=" + quantidadeAceleracao + "]" + modelo;
	}
	
}
