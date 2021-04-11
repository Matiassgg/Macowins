import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrendaTests {
  private Prenda prendaPrueba;

  @Before
  public void init() {
    prendaPrueba = new Prenda(new Nueva(), 1200, TipoPrenda.PANTALON);
  }

  @Test
  public void prendaNueva() {
    // El precio debe ser 1200
    Assert.assertEquals(1200, prendaPrueba.precioVenta(), 100);
  }

  @Test
  public void prendaPromo() {
    prendaPrueba.estado(new Promocion(200));
    // El precio debe ser 1200 - 100 = 1000
    Assert.assertEquals(1000, prendaPrueba.precioVenta(), 100);
  }

  @Test
  public void prendaLiquidacion() {
    prendaPrueba.estado(new Liquidacion());
    // El precio debe ser 1200 * 0.5 = 600
    Assert.assertEquals(600, prendaPrueba.precioVenta(), 100);
  }

}
