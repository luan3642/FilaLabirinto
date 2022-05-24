/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fila;

import java.io.IOException;

/**
 *
 * @author luan
 */
public class Main {
    public static void main(String[] args) throws IOException{
        
        
        ReadMaze readMaze = new ReadMaze();
        String[][] aux = readMaze.RetrivebyArray("/src/labirintos/lab01.txt");
        Labirinto labirinto = new Labirinto(aux);
       
        
        labirinto.comecaJogada();
        
    }
}
