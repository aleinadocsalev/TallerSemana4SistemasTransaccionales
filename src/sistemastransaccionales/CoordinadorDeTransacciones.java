
package sistemastransaccionales;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class CoordinadorDeTransacciones {
   
    private List<Transaccion> transacciones;
    private int contadorTransacciones;
    private Mosquitto mosquitto;

    public CoordinadorDeTransacciones() throws MqttException {
        transacciones = new ArrayList<>();
        contadorTransacciones = 0;
        Mosquitto Mosquitto = new Mosquitto("Coordinador");
        Mosquitto.subscribe("transacciones/compra");
        Mosquitto.subscribe("transacciones/venta");
    }

    public Compra registrarCompra(int idSucursal, int idProducto, int cantidad, double precioUnitario) throws MqttException {
        int idTransaccion = ++contadorTransacciones;
        LocalDateTime fechaHora = LocalDateTime.now();
        Compra compra = new Compra(idTransaccion, fechaHora, idSucursal, idProducto, cantidad, precioUnitario);
        
        
        // Publicar en MQTT
        String mensaje = compra.toString();
        mosquitto.publish("transacciones/compra", mensaje);
        
        return compra;
    }

    public Venta registrarVenta(int idSucursal, int idProducto, int cantidad, double precioUnitario) throws MqttException {
        int idTransaccion = ++contadorTransacciones;
        LocalDateTime fechaHora = LocalDateTime.now();
        Venta venta = new Venta(idTransaccion, fechaHora, idSucursal, idProducto, cantidad, precioUnitario);
        transacciones.add(venta);

        // Publicar en MQTT
        String mensaje = venta.toString();
       mosquitto.publish("transacciones/venta", mensaje);

        return venta;
    }

    public void mostrarTransacciones() {
        for (Transaccion transaccion : transacciones) {
            System.out.println(transaccion);
        }
    }

    public void disconnect() throws MqttException {
        mosquitto.disconnect();
    }

    void disconnect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
