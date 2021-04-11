/**
 * Los estados de las prendas son dinámicos ya que pueden cambiar.
 * Por esto último, las prendas pueden tener <b>varios estados</b>
 * a lo largo del tiempo.
 *
 * <b>Se decidió usar composición</b>
 */
public interface Estado {
  double precioFinal(double precioPrenda);
}

class Nueva implements Estado {
  public double precioFinal(double precioPrenda) {
    return precioPrenda;
  }
}

class Promocion implements Estado {
  Double descuento;
  public double precioFinal(double precioPrenda) { return precioPrenda - descuento; }
}

class Liquidacion implements Estado {
  public double precioFinal(double precioPrenda) {
    return precioPrenda * 0.5;
  }
}