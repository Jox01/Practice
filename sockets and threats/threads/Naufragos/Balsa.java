/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Naufragos;

public class Balsa extends Thread {
  private int numPlazas;

  public Balsa() {
    this.numPlazas = 0;
  }

  public Balsa(Runnable runnable, int numPlazas) {
    super(runnable);
    this.numPlazas = numPlazas;
  }

  public int getNumPlazas() {
    return numPlazas;
  }

  public void setNumPlazas(int numPlazas) {
    this.numPlazas = numPlazas;
  }
}