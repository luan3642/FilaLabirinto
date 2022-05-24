/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fila;

public class Fila {

    private String[] elementos;
    private int tamanho;
    private int base = 0;

    public String[] getElementos() {
        return elementos;
    }

    public void setElementos(String[] elementos) {
        this.elementos = elementos;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }
    
   

    public Fila(int value) {
        this.elementos = new String[value];
    }

    public void enfileira(String elemento) {
        if (!(this.tamanho < this.elementos.length)) {
            this.elementos[tamanho] = elemento;
            this.tamanho++;
        }
        this.elementos[tamanho] = elemento;
        this.tamanho++;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public boolean empty() {
        return this.tamanho == 0;
    }

//    public String defenfileira(){
////        String elemento = this.elementos[this.base];
////        this.elementos[base] -= this.elementos[base]; 
////        this.base++;
////        
////        return elemento;
//        
//        if(this.empty()){
//            return null;
//        }
//
//        
//    }
//    
    public void defenfileira() {

        if (this.empty()) {
            throw new IllegalArgumentException("Está vazia");
        }

        for (int i = 0; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
            //1
        }

        --tamanho;
    }

    public String espiar() {
        return this.elementos[this.base];
    }

//    public String toString(){
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("[");
//        
//        for (int i = 0; i <this.tamanho-1; i++) {
//            stringBuilder.append(this.elementos[i]);
//            stringBuilder.append(",");
//        }
//        
//        if(this.tamanho > 0){
//            stringBuilder.append(this.elementos[this.tamanho-1]);
//        }
//        
//        stringBuilder.append("]");
//        return stringBuilder.toString();
//    }
//    
}
