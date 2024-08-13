
package sistemastransaccionales;


public class SistemasTransaccionales {

    
    public static void main(String[] args) {
        
         try {
            CoordinadorDeTransacciones coordinador = new CoordinadorDeTransacciones();

            Compra compra1 = coordinador.registrarCompra(1, 101, 50, 15.99);
            System.out.println("Compra registrada y publicada: " + compra1);

          
            Venta venta1 = coordinador.registrarVenta(2, 202, 30, 20.99);
            System.out.println("Venta registrada y publicada: " + venta1);

            System.out.println("\nTransacciones registradas:");
            coordinador.mostrarTransacciones();

           
            coordinador.disconnect();

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
        
    }
    

