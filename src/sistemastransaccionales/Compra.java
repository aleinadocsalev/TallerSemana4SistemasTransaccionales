
package sistemastransaccionales;

import java.time.LocalDateTime;


public class Compra {
    
    private int idProducto;
    private int cantidad;
    private double precioUnitario;

    public Compra(int idTransaccion, LocalDateTime fechaHora, int idSucursal, 
                  int idProducto, int cantidad, double precioUnitario) {
       
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
        return "Compra{" +
                "idProducto=" + idProducto +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", " + super.toString() +
                '}';
    }
}
