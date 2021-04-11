import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class VentaTests {
  private Prenda prendaPrueba1, prendaPrueba2, prendaPrueba3;
  private Venta venta;

  @Before
  public void init() {
    prendaPrueba1 = new Prenda(new Nueva(), 8000, TipoPrenda.PANTALON);
    prendaPrueba2 = new Prenda(new Nueva(), 2000, TipoPrenda.CAMISA);
    prendaPrueba3 = new Prenda(new Promocion(100), 5100, TipoPrenda.SACO);
  }

  // Agrego las prendas a la venta
  public void agregarVentaDePrendas() {
    venta.nuevaVenta(prendaPrueba1);
    venta.nuevaVenta(prendaPrueba2);
    venta.nuevaVenta(prendaPrueba3);
  }

  @Test
  public void ventaEfectivo() {
    // Precondiciones
    venta = new Venta(new GregorianCalendar(2010, Calendar.MAY, 20).getTime());

    agregarVentaDePrendas();

    // Postcondiciones
    Assert.assertEquals(15000, venta.total(), 100);
  }

  @Test
  public void ventaConTarjeta() {
    venta = new VentaPorTarjeta(
        3,
        5,
        new GregorianCalendar(2020, Calendar.MAY, 12).getTime()
    );

    agregarVentaDePrendas();

    Assert.assertEquals(165, venta.total(), 100);
  }

}
