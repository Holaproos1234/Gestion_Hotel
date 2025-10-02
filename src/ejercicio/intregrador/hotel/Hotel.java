package ejercicio.intregrador.hotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    
    private String nombre;
    private String direccion;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Recepcionista> recepcionistas;
    private ArrayList<Reserva> reservasTotales;
    
    public Hotel(){
        
        this.habitaciones = new ArrayList <> ();
        this.recepcionistas = new ArrayList <> ();
        this.reservasTotales = new ArrayList <> ();
    }
    
    public Hotel(String nombre, String direccion){
        
        this();
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return new ArrayList (this.habitaciones);
    }

    public ArrayList<Recepcionista> getRecepcionistas() {
        return new ArrayList (this.recepcionistas);
    }

    public ArrayList<Reserva> getReservasTotales() {
        return new ArrayList (this.reservasTotales);
    }

    public void agregarHabitacion(Habitacion habitacion){
        
        this.habitaciones.add(habitacion);
    }
    
    public void agregarRecepcionista(Recepcionista recepcionista){
        
        this.recepcionistas.add(recepcionista);
    }
    
    public void agregarReserva(Reserva reserva){
        
        this.reservasTotales.add(reserva);
    }
    
    public ArrayList <Habitacion> buscarHabitacionesDisponibles(LocalDate inicio, LocalDate fin, TipoHabitacion tipo){
        ArrayList <Habitacion> habitacionesDisponibles = new ArrayList <> ();
        
        for (Habitacion item: this.habitaciones){
            
            if (this.estaHabitacionDisponible(item, inicio, fin)){
                
                habitacionesDisponibles.add(item);
                
            }
        }
        
        return habitacionesDisponibles;
    }
    
    public boolean estaHabitacionDisponible(Habitacion habitacion, LocalDate inicio, LocalDate fin){
        
        boolean disponibilidad = true;
        
        for (Reserva item : reservasTotales){
            
            if(item.getHabitacion().equals(habitacion)){
                
                LocalDate inicioReserva = item.getFechaInicio();
                LocalDate finReserva = item.getFechaFin();
                LocalDate inicioSolicitud = inicio;
                LocalDate finSolicitud = fin;
                boolean solapados = inicioReserva.isBefore(finSolicitud)&& inicioSolicitud.isBefore(finReserva);
                if (solapados){
                    disponibilidad = false;
                }
            }
        }
        return disponibilidad;
    }
}
