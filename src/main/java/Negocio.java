import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Negocio {
  List<Venta> ventas = new ArrayList<>();

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
