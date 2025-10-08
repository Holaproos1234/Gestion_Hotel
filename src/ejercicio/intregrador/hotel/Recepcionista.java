package ejercicio.intregrador.hotel;

//import java.util.ArrayList;

public class Recepcionista extends Persona{
    private String legajo;
    
    public Recepcionista(String nombre, String dni, String legajo){
        super(nombre, dni);
        this.legajo= legajo;
        }

    public String getLegajo() {
        return legajo;
    }
    
    public void confirmarReserva(Reserva reserva){
        
        if (reserva.isConfirmada()){
            
            System.out.println("Reserva confirmada");
        }else{
            
            reserva.confirmar();
            Cliente cliente = reserva.getCliente();
            int numero_habitacion = reserva.getHabitacion().getNumero();
            String notificacion = "Reserva confirmada por el cliente: " + cliente.getNombre()+ " para la habitacion"
                    + numero_habitacion + " con un precio total de: " + reserva.calcularTotal();
            
            System.out.println(notificacion);
        }
        
    }
    
    @Override
    public void notificar(String notificacion){
        
        String mensaje = "Legajo nro: " + this.legajo + " " + " Señor " + super.getNombre() + " : " + notificacion;
        super.agregarNotificacion(mensaje);
    }
}
