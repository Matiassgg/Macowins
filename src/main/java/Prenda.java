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
   */
  public double precioVenta() {
    return estado.precioFinal(precioBase);
  }

  public void estado(Estado nuevoEstado) {
    estado = nuevoEstado;
  }
}

