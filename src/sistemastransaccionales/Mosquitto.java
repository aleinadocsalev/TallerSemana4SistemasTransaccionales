
package sistemastransaccionales;


public class Mosquitto {
    
    private String brokerUrl = "tcp://localhost:1883"; 
    private Mosquitto client;

    public Mosquitto(String clientId, String clientId1) throws MqttException {
        client = new Mosquitto(brokerUrl, clientId);
        client.connect();
    }


    public void publish(String topic, String content) throws MqttException {
        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(2); 
        client.publish(topic, message);
    }

    public void subscribe(String topic) throws MqttException {
        client.subscribe(topic, (t, msg) -> {
            System.out.println("Mensaje recibido de " + t + ": " + new String(msg.getPayload()));
        });
    }

    public void disconnect() throws MqttException {
        client.disconnect();
    } 

    private void connect() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private void publish(String topic, MqttMessage message) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
