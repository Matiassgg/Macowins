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
    prendaPrueba.estado(new Liquidacion());
    // El precio debe ser ??
    Assert.assertEquals(1200, prendaPrueba.precioVenta(), 100);
  }


}
