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
        
        if (hotel.estaHabitacionDisponible(habitacion, inicio, fin)){
            
            Reserva reserva = new Reserva(this, habitacion, inicio, fin);
            hotel.agregarReserva(reserva);
            String notificacion = "Nueva reserva creada por el cliente: " + this.getNombre() + " en la habitacion: " + habitacion.getNumero();
            for (Recepcionista item : hotel.getRecepcionistas()){
                item.agregarNotificacion(notificacion);
            }
        
        
    }
    }
    
    @Override
    public void notificar(String notificacion){
        
        String mensaje = "Mail: " + this.mail + " " + " Señor: " + super.getNombre() + " : " + notificacion;
        super.agregarNotificacion(mensaje);
    }
    
    @Override
    public boolean equals(Object obj){
        
        boolean bandera = false;
        super.equals(obj);
        
        if (!super.equals(obj)){
            return bandera;
        }else{
            
            if (obj instanceof Cliente cliente){
                
                if (cliente.mail == this.mail)
                    bandera = true;
            }
            
        return bandera;
        }
        
        
    }
}
