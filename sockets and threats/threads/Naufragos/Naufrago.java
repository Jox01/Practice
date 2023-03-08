package Naufragos;
//http://jmoral.es/blog/thread-java-2
/*
 * esta clase contiene el atributo que guarda el número actual de náufragos y
 * el método para actualizarlo.
 */

public class Naufrago {
  private int cantidadNaufragos = 0;

  public int getCantidadNaufragos() {
    return cantidadNaufragos;
  }

  public void setCantidadNaufragos(int cantidadNaufragos) {
    this.cantidadNaufragos = cantidadNaufragos;
  }

  public Naufrago(){

  }

  public Naufrago(int cantidadNaufragos){ //constructor
    this.cantidadNaufragos = cantidadNaufragos;
  }

  // método para actualizar el número de náufragos
  public void rescatesRestantes(int rescatados){
    cantidadNaufragos -= rescatados;
  }
}