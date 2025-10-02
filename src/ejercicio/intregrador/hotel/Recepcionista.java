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
    
    public void confirmarReserva(Reserva reserva, Hotel gotel){
        
    }
    
    @Override
    public void notificar(String notificacion){
        
        String mensaje = "Legajo nro: " + this.legajo + " " + " Señor " + super.getNombre() + " : " + notificacion;
        super.agregarNotificacion(mensaje);
    }
}
