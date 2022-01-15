package com.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.Entidades.Automovel;
import com.Entidades.Carro;
import com.Entidades.Caminhao;
import com.Entidades.Moto;
import com.services.Util;

public class Util {
	 static Scanner sc = new Scanner(System.in);
	 static int opcao = 0;
	 static VeiculosMapsService mapsVeiculo; 
	 
	 
	 
	public static void StartMenu() {
//		menu de opção do ussuario
		mapsVeiculo = new VeiculosMapsService();	
			for(int i = 1 ; i <= 3; i++ ) {
				System.out.println();
				System.out.println("Escolha nº:" + i );
				System.out.println("Selecione uma opção abaixo:");
				mapsVeiculo.MenuOpcoes();
				System.out.println("4- Sair");
				System.out.printf("Digite sua Escolha: ") ; 
				try {
					opcao = Integer.parseInt(Util.sc.nextLine());
					inicioTeste();
				}catch(NumberFormatException e) {
					System.out.println("Por favor, informe uma op��o v�lida.");
				opcao = sc.nextInt();
				if(opcao == 4) {
					i = 4;
				} else if(opcao <= 0 || opcao >= 5) {
					System.out.println("Selecione uma Opção Valida");
					 i--;
				} 
				else {
					inicioTeste();
				}
				}
				}

			}
	 public static void inicioTeste() {
		 try {
			int combustivel,acelerar,escolha,distancia;
			mapsVeiculo = new VeiculosMapsService();
				System.out.println("Para começar: ");
				System.out.println("Informe 1- para Iniciar / 2- para cancelar");
				escolha = sc.nextInt();
				if(escolha == 1) {
					System.out.print("Informe a distância que deseja percorrer: ");
					distancia = Util.sc.nextInt();
					
					System.out.print("Informe a quantidade de combustível atual: ");
					combustivel = Util.sc.nextInt();
					
					System.out.print("Informe quantas vezes deseja acelerar: ");
					acelerar = Util.sc.nextInt();
				
					if(opcao == 1 || opcao == 2 || opcao == 3) {
						Automovel carro = new Carro(distancia, combustivel, acelerar);
						System.out.println(carro.toString(mapsVeiculo.nomeVeiculo(opcao)));
						relatorioMontadora(carro.toString(mapsVeiculo.nomeVeiculo(opcao)));
					} 
					else if (opcao == 4 || opcao == 5 || opcao == 6) {
						Automovel moto = new Moto(distancia, combustivel, acelerar);
						System.out.println("Tipo do Veiculo: Carro");
						System.out.println("Modelo: " + mapsVeiculo.nomeVeiculo(opcao));
						System.out.println(moto.toString());
					}
					else if (opcao == 7 || opcao == 8 || opcao == 9) {
						Automovel caminhao = new Caminhao(distancia, combustivel, acelerar);
					System.out.println("Tipo do Veiculo: Carro");
					System.out.println("Modelo: " + mapsVeiculo.nomeVeiculo(opcao));
					System.out.println(caminhao.toString());
			
					} else {
						System.out.println("Opção Invalida, tente novamente!");
						inicioTeste();
					}
					
					
					} else {
						StartMenu();
					}
				}

				catch(Exception ioE) {
					System.out.println("Erro : " + ioE.getMessage());
				}
				
				
	
	 } 
	 
	 
	 
	 public static void relatorioMontadora(String args) {
		 String[] linhas = new String[3] ;
		 linhas[0] = args;
			String path = "C:\\Users\\jbljesus\\OneDrive - rd.com.br\\Downloads\\relatorio.txt";
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
				
				for(String linha : linhas) {
					bw.write(linha);
					bw.newLine();
				}
			}
			catch(IOException ioE) {
				System.out.println("Erro : " + ioE.getMessage());
			}
	 }
	 
	 
	 }
	 


