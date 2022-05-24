/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fila;

import java.util.LinkedList;
import java.util.Queue;

import java.util.Scanner;

public class Labirinto {
    
    Scanner scan = new Scanner(System.in);
    
    Fila q = new Fila(50);
    Fila moveFila = new Fila(50);
    
    private boolean ganhouJogo = false;
    private String[][] guardaLabirinto;
    private int[] entrada = new int[2];
    
    private int[] saida = new int[2];
    
    private int[] posicaoAtual = new int[2];

//    Queue<String> q, moveFila = new LinkedList();
    public Labirinto(String[][] guardaLabirinto) {
        this.guardaLabirinto = guardaLabirinto;
    }
    
    public void imprimeLabirinto() {
        
        for (int l = 0; l < guardaLabirinto.length; l++) {
            for (int c = 0; c < guardaLabirinto[0].length; c++) {
                System.out.print(guardaLabirinto[l][c] + " "); //imprime caracter a caracter
            }
            System.out.println(" "); //muda de linha
        }
    }
    
    public void prenchePosicao(int linha, int coluna) {
        
        if (!(guardaLabirinto[linha][coluna].equals("#")) && !(guardaLabirinto[linha][coluna].equals("E"))) {
            guardaLabirinto[linha][coluna] = "?";
            imprimeLabirinto();
        } else if (guardaLabirinto[linha][coluna].equals("E")) {
            System.out.println("Movimento inválido, tente novamente");
        } else{
            System.err.println("Movimento invalido, PROGRAMARA ENCERRADO");
        
//            System.out.println("");
//            comecaJogada();
            
        }
    }
    
    public void limpaLabirinto() {
        for (int l = 0; l < guardaLabirinto.length; l++) {
            for (int c = 0; c < guardaLabirinto[0].length; c++) {
                if (guardaLabirinto[l][c].equals("?")) {
                    guardaLabirinto[l][c] = " ";
                }
            }
        }
        
        q.defenfileira();
    }
    
    public void imprimeComandos() {
        
        imprimeLabirinto();
        System.out.println("");
        System.out.println("Programe seus passos ate para chegar ate o 'E' ");
        System.out.println("Comando enfileirados: " + q.tamanho());
        System.out.println("Comandos disponiveis:");
//        System.out.println("Comandos enfilerados" + q.size() == null ? 0 : q.size());

        System.out.println("direita");
        System.out.println("esquerda");
        System.out.println("cima");
        System.out.println("baixo");
        System.out.println("começar");
        System.out.println("reiniciar");
        
    }
    
    public void comecaJogada() {
        
        // linha, posicao 0 é linha
        this.posicaoAtual[0] = 1;
        
        //coluna, posicao 1 é coluna
        this.posicaoAtual[1] = 1;
        while (!ganhouJogo) {
            imprimeComandos();
            System.out.println("");
            String jogada = scan.next();
            movimenta(jogada);
        }
    }
    
    public void movimenta(String jogada) {
        
        switch (jogada) {
            case "direita":
//                if (!(guardaLabirinto[posicaoAtual[0]][posicaoAtual[1] + 1].equals("#"))) {
                posicaoAtual[1] = posicaoAtual[1] + 1;
//                this.posicaoAtual[0] = 1;
//                this.posicaoAtual[1] = 1;
                
                q.enfileira(Integer.toString(posicaoAtual[0]) + Integer.toString(posicaoAtual[1]));
                moveFila.enfileira("direita");
//                imprimeComandos();
//                }
                break;
            case "esquerda":
//                if (!(guardaLabirinto[posicaoAtual[0]][posicaoAtual[1] - 1].equals("#"))) {
                posicaoAtual[1] = posicaoAtual[1] - 1;
                q.enfileira(Integer.toString(posicaoAtual[0]) + "," + Integer.toString(posicaoAtual[1]));
                moveFila.enfileira("esquerda");
//                imprimeComandos();
                break;
            case "cima":
//                if (!(guardaLabirinto[posicaoAtual[0] - 1][posicaoAtual[1]].equals("#"))) {;
                posicaoAtual[0] = posicaoAtual[0] - 1;
                q.enfileira(Integer.toString(posicaoAtual[0]) + "," + Integer.toString(posicaoAtual[1]));
                moveFila.enfileira("cima");
//                imprimeComandos();
//                }
                break;
            case "baixo":
//                if (!(guardaLabirinto[posicaoAtual[0] + 1][posicaoAtual[1]].equals("#"))) {
                posicaoAtual[0] = posicaoAtual[0] + 1;
                q.enfileira(Integer.toString(posicaoAtual[0]) + "," + Integer.toString(posicaoAtual[1]));
                moveFila.enfileira("baixo");
//                imprimeComandos();
//                }
                break;
            
            case "comecar":
                while (!q.empty()) { 
                    String[] auxValores = q.espiar().split(",");
                    int linha = Integer.parseInt(auxValores[0]);
                    int coluna = Integer.parseInt(auxValores[1]);
                    System.out.println("Comando " + q.tamanho() + ": " + moveFila.espiar());
                    prenchePosicao(linha, coluna);
                    moveFila.defenfileira();
                    q.defenfileira();
                    
                }
                this.ganhouJogo = true;
                break;
            case "reiniciar":
//                while (!q.empty()) {
//                    q.remove();
//                }
                
                while (!q.empty()) {                    
                    limpaLabirinto();
                }
                
//                imprimeComandos();
//                imprimeLabirinto();
                break;
            default:
                System.err.println("ERRO");
        }
    }
    
}
