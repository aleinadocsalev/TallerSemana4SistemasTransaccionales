
package sistemastransaccionales;

import java.time.LocalDateTime;


public class Venta extends Transaccion {

    private final int idProducto;
    private final int cantidad;
    private final double precioUnitario;
    
    public Venta(int idTransaccion, LocalDateTime fechaHora, int idSucursal, 
                 int idProducto, int cantidad, double precioUnitario) {
        super(idTransaccion, fechaHora, idSucursal);
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int IdProducto() {
        return idProducto;
    }

    public int Cantidad() {
        return cantidad;
    }

    public double PrecioUnitario() {
        return precioUnitario;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idProducto=" + idProducto +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", " + super.toString() +
                '}';
    }
}
