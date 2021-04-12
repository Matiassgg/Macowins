/**
 * <b>Prendas modeladas del negocio</b>
 */
public class Prenda {
  Estado estado;
  double precioBase;
  TipoPrenda tipoPrenda;

  public Prenda(Estado unEstado, double unPrecioBase, TipoPrenda tipo) {
    estado = unEstado;
    precioBase = unPrecioBase;
    tipoPrenda = tipo;
  }

  /**
   * <b>Precio de venta según estado de la prenda</b>
   * @return Precio final de la prenda
   */
  public double precioVenta() {
    return estado.precioFinal(precioBase);
  }

  /**
   * <b>Este método permite el cambio de estado de las prendas</b>
   */
  public void estado(Estado nuevoEstado) {
    estado = nuevoEstado;
  }
}

