import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <b>Representa un venta en efectivo de alguna prenda de cualquier tipo</b>.
*/
public abstract class Venta {
  List<Prenda> prendasVendidas = new ArrayList<>();
  Date fecha;

  public Venta(Date unaFecha) {
    fecha = unaFecha;
  }

  /**
   * <b>Ganancia total de una venta</b>
   * @return La ganancia total de la venta, para una cierta cantidad de prendas vendidas
   */
  public double total() {
    return prendasVendidas
        .stream()
        .map(Prenda::precioVenta)
        .collect(Collectors.toList())
        .stream()
        .mapToDouble(Double::doubleValue)
        .sum();
  }

  public Boolean esDe(Date unaFecha) {
    return fecha == unaFecha;
  }

  public int cantidad() {
    return prendasVendidas.size();
  }

  void nuevaVenta(Prenda unaPrenda) {
    prendasVendidas.add(unaPrenda);
  }
}

/**
 * <b>Representa un venta con tarjeta</b>.
 */
class VentaPorTarjeta extends Venta {
  int cantidadCuotas;
  double coeficienteTarjeta;

  /**
   * <b>Mismo comportamiento que en efectivo , salvo que
   * se le aplica un recargo según cuotas y coeficiente</b>
   */
  public VentaPorTarjeta(int cuotas, int coeficiente, Date fecha) {
    super(fecha);
    cantidadCuotas = cuotas;
    coeficienteTarjeta = coeficiente;
  }
/**
 * El total de la venta se base en un recargo extra
 * @return La ganancia de la venta
 * */
  @Override
  public double total() {
    return cantidadCuotas * coeficienteTarjeta + 0.01 * super.total() + super.total();
  }
}
