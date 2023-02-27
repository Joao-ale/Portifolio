/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jogo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joaoa
 */
public class Jogo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        
        //Variaveis do jogo
        String[] inimigos = {"Esqueleto","Zombie", "Mago das trevas", "Assasino", "Dragão"};
        int vidaMaxInimigos = 75;
        int danoAtackInimigo = 25;
        String[] mercanteItens = {"Poção de vida", "Espada de ferro", "Escudo de madeira refoçada", "Capa mágica de youngmorth"};
        
        //Variaveis do player
        
        String nome;
        
        int vida = 100;
        int dano = 50;
        int numPocaoVida = 3;
        int curaPocao = 30;
        int chancePocao = 50;
        int moedas = 5;
        
        boolean correndo = true;
        
        System.out.println("Bem vindo a Masmorra aventureiro!");
        System.out.println("Qual o seu nome? ");
        nome = in.nextLine();
        System.out.println("SEJA MUITO BEM VINDO " + nome + " A SUA AVENTURA!");
        GAME:
        while(correndo){
            System.out.println("-------------------------------------------");
            
            System.out.println("\t# O que deseja fazer?");
            
            System.out.println("\t1.Entrar no corredor da esquerda");
            System.out.println("\t2. Entrar no corredor da direita");
            System.out.println("\t3. Seguir no corredor reto");
            
            String caminho = in.nextLine();
           
            while(!caminho.equals("1") && !caminho.equals("2") && !caminho.equals("3")){
                System.out.println("Mal entrou na masmorra e ela já está mexendo com você! OPÇÃO INVÁLIDA");
                caminho = in.nextLine();
            }
            
            if(rand.nextInt(100)<= 15){
                System.out.println("Você encontrou mais corredores!");
            }
            else if(rand.nextInt(100)>15 && rand.nextInt(100)<=30){
                System.out.println("\t Olá caro viajante, eu sou o Mercante venha e compre comigo!");
                System.out.println("\t# Escolha o que quiser");
                System.out.println("\t# 1. Poção de vida");
                System.out.println("\t# 2. Espada de ferro");
                System.out.println("\t# 3. Escudo de madeira reforçada");
                System.out.println("\t# 4. Capa mágica de youngmorth");
                
                String opcao = in.nextLine();
                if(opcao.equals("1") && moedas == 2){
                    numPocaoVida ++;
                    System.out.println("Parabéns você adiquiriu " + mercanteItens[1]);
                    moedas -= 2;
                }
                else if(opcao.equals("2") && moedas == 10){
                    dano = 70;
                    System.out.println("Parabéns você adiquiriu " + mercanteItens[2]);
                    moedas -= 10;
                }
                else if(opcao.equals("3") && moedas == 8){
                    danoAtackInimigo = 15;
                    System.out.println("Parabéns você adiquiriu " + mercanteItens[3]);
                    moedas -= 8;
                }
                else if(opcao.equals("4") && moedas == 8){
                    vida = 130;
                    System.out.println("Parabéns você adiquiriu " + mercanteItens[4]);
                    moedas -= 8;
                }
                else if (opcao.equals("5")){
                    System.out.println("Até a próxima querido aventureiro");
                }
            }
            else if(rand.nextInt(100) > 31 && rand.nextInt(100) <= 50){
                int moedasGanhas = rand.nextInt(5);
                moedas += moedasGanhas;
                System.out.println("Hoje é seu dia de sorte você conseguiu " + moedasGanhas + " moedas \n"
                        + " Agora você tem " + moedas);
            }
            else if(rand.nextInt(100) >= 51){
                int vidaInimigo = rand.nextInt(vidaMaxInimigos);
                String inimigo = inimigos[rand.nextInt(inimigos.length)];
                System.out.println("\t# " + inimigo + " te encontrou! #\n");

                while(vidaInimigo > 0){
                    System.out.println("\t"+ nome + " HP: " + vida);
                    System.out.println("\t" + inimigo +" HP: " + vidaInimigo);
                    System.out.println("\n\tO que " + nome + " ira fazer? ");
                    System.out.println("\t1. Atacar");
                    System.out.println("\t2. Beber Poção");
                    System.out.println("\t3. Fugir");

                    String input = in.nextLine();
                    if (input.equals("1")){
                        int danoDado = rand.nextInt(dano);
                        int danoSofrido = rand.nextInt(danoAtackInimigo);

                        vidaInimigo -= danoDado;
                        vida -= danoSofrido;

                        System.out.println("\t->Você acertou o " + inimigo + " e deu " + danoDado + " de dano");
                        System.out.println("\t->Você recebeu " + danoSofrido + " na luta\n");

                        if (vida < 1){
                            System.out.println("\tVocê tomou muito dano, melhor fugir!");
                            break;
                        }
                    }
                    else if(input.equals("2")){
                        if (numPocaoVida > 0){
                            vida += curaPocao;
                            numPocaoVida --;
                            System.out.println("\tVocê bebeu a poção e curou: " + curaPocao + 
                                    "\n\tAgora você tem " + vida + "HP" +
                                    "\n\t Agora você tem " + numPocaoVida+ " poções");
                        }
                        else{
                            System.out.println("\tVocê não tem pocoes! Derrote o inimigo para conseguir!");
                        }
                    }
                    else if(input.equals("3")){
                        System.out.println("\t Você fugiu do " + inimigo);
                        continue GAME;
                    }
                    else{
                        System.out.println("Os deuses não permitiram usar esse comando estranho!");
                    }
                }
                if(vida < 1){
                    System.out.println("Você sofreu muitos danos, vá para casa e descanse");
                    break;
                }

                System.out.println("-------------------------------------------");
                System.out.println(" # " + inimigo + " foi derrotado!");
                System.out.println(" # Você tem " + vida + "HP sobrando!");
                if (rand.nextInt(100) < chancePocao){
                    numPocaoVida ++;
                    System.out.println(" # Você conseguiu encontrar uma poção de vida no corpo do " + inimigo);
                    System.out.println(" # Agora voce tem " + numPocaoVida + " poções");
                }
                if (rand.nextInt(100) < 50){
                    moedas += 2;
                    System.out.println(" # Você conseguiu encontrar duas moedas no corpo do " + inimigo);
                    System.out.println(" # Agora você tem " + moedas + " moedas");
                }

                System.out.println("O que voce quer fazer agora? ");
                System.out.println("1. Continuar explorando");
                System.out.println("2. Sair da Masmorra");

                String input = in.nextLine();

                while(!input.equals("1") && !input.equals("2")){
                    System.out.println("A masmorra mexeu com sua cabeca? Opcao invalida");
                    input = in.nextLine();
                }

                if (input.equals("1")){
                    System.out.println("Voce e corajoso seguira a sua aventura");
                }
                else if(input.equals("2")){
                    System.out.println("Voce se aventurou e conquistou sua gloria! Hora de ir pra casa");
                    break;
                }
            }
                   
            
        }
        
        System.out.println("######################");
        System.out.println("# Obrigado por jogar #");
        System.out.println("######################");
    }
}
