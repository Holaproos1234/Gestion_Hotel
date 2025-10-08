package ejercicio.intregrador.hotel;

import java.time.LocalDate;
import java.time.Month;

public class EjercicioIntregradorHotel {

    public static void main(String[] args) {
        
        Hotel h1 = new Hotel("Bella vista", "Bolivia 77");
        Habitacion hab1 = new Habitacion(200,TipoHabitacion.SIMPLE, 100);
        Habitacion hab2 = new Habitacion(200,TipoHabitacion.DOBLE, 200);
        h1.agregarHabitacion(hab1);
        h1.agregarHabitacion(hab2);
        Recepcionista r1 = new Recepcionista("Agustin", "12345678", "154");
        Recepcionista r2 = new Recepcionista("Pedro", "14785233", "155");
        Cliente c1 = new Cliente("Luis", "88888888", "aaa@gmail.com");
        Cliente c2 = new Cliente("Lopez", "99999999", "bbb@gmail.com");
        Cliente c3 = new Cliente("Perez", "77777777", "ccc@gmail.com");
        
        System.out.println("-------ESCENARIO 1----------");
        
        LocalDate fecha_inicio = LocalDate.of(2025, Month.OCTOBER, 8);
        LocalDate fecha_final = LocalDate.of(2025, Month.OCTOBER, 18);
        c1.realizarReserva(h1, hab1, fecha_inicio, fecha_final);
        r1.confirmarReserva(h1.buscarReservaPorCliente(c1));
        
        System.out.println("-------ESCENARIO 2----------");
        
        LocalDate fecha_inicio_2 = LocalDate.of(2025, Month.OCTOBER, 19);
        LocalDate fecha_final_2 = LocalDate.of(2025, Month.OCTOBER, 23);
        c2.realizarReserva(h1, hab2, fecha_inicio_2, fecha_final_2);
        r1.confirmarReserva(h1.buscarReservaPorCliente(c2));
        
        System.out.println("-------ESCENARIO 3----------");
        
        LocalDate fecha_inicio_3 = LocalDate.of(2025, Month.OCTOBER, 18);
        LocalDate fecha_final_3 = LocalDate.of(2025, Month.OCTOBER, 23);
        c3.realizarReserva(h1, hab1, fecha_inicio_3, fecha_final_3);
        r1.confirmarReserva(h1.buscarReservaPorCliente(c3));
        
        System.out.println("-------NOTIFICACIONES CLIENTE----------");
        
        for (String item : c1.getNotificaciones()){
            System.out.println(item);
        }
        
        System.out.println("-------NOTIFICACIONES RECEPCIONISTA----------");
        for (Recepcionista item : h1.getRecepcionistas()){
            for (String notificacion : item.getNotificaciones())
            {
                System.out.println(notificacion);
            }

        }
        
        System.out.println("-------RESERVAS CONFIRMADAS----------");
        
        for (Reserva item : h1.getReservasConfirmadas()){
            
            System.out.println(item);
        }
    }
    
}
