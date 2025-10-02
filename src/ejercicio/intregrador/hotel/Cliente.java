package ejercicio.intregrador.hotel;

import java.util.ArrayList;
import java.time.LocalDate;

public class Cliente extends Persona{
    private String mail;
    private ArrayList<Reserva> reservas;
    
    public Cliente(String nombre, String dni, String mail){
        super(nombre, dni);
        this.mail= mail;
        this.reservas = new ArrayList<> ();
        }
    
    public String getMail(){
        return mail;
    }
    
    public ArrayList<Reserva> getReservas(){
        return new ArrayList <Reserva> (this.reservas);
    }
    
    public void realizarReserva(Hotel hotel, Habitacion habitacion, LocalDate inicio, LocalDate fin){
        
    }
    
    @Override
    public void notificar(String notificacion){
        
        String mensaje = "Mail: " + this.mail + " " + " Señor: " + super.getNombre() + " : " + notificacion;
        super.agregarNotificacion(mensaje);
    }
}
