import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
/**
 * El negocio se encarga de las ventas.
 * Como se pedia ganancia para un dia particular,
 * se decidió tomar esa fecha de la fecha de venta.
 */
public class Negocio {
  List<Venta> ventas = new ArrayList<>();

  /**
   * <b>Es la ganancia del negocio para una cierta fecha</b>
   */
  public double ganancias(Date fecha) {
    return ventas
        .stream()
        .filter(Venta -> Venta.esDe(fecha))
        .collect(Collectors.toList())
        .stream()
        .mapToDouble(Venta -> Venta.total())
        .sum();
    }
    public void agregarVenta(Venta unaVenta){
      ventas.add(unaVenta);
    }
}
