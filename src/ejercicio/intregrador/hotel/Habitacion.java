package ejercicio.intregrador.hotel;

public class Habitacion {
    private int numero;
    private TipoHabitacion tipo;
    private double precioPorNoche;
    
    public Habitacion(int numero, TipoHabitacion tipo, double precioPorNOche){
    
    this.numero = numero;
    this.tipo = tipo;
    this.precioPorNoche = precioPorNoche;
}

    public int getNumero() {
        return this.numero;
    }

    public TipoHabitacion getTipo() {
        return this.tipo;
    }

    public double getPrecioPorNoche() {
        return this.precioPorNoche;
    }
    
    @Override
    public boolean equals(Object obj){
        
        if (this == obj){//comparo YO con YO
            
            return true;
        }
        else if (obj == null || this.getClass() != obj.getClass()){
            
            return false;
        }
        
        Habitacion habitacion = (Habitacion)obj;//casteo para ver tipo y numero de obj
        
        return this.tipo == habitacion.tipo && this.numero == habitacion.numero;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Habitacion{");
        sb.append("numero=").append(numero);
        sb.append(", tipo=").append(tipo);
        sb.append(", precioPorNoche=").append(precioPorNoche);
        sb.append('}');
        return sb.toString();
    }
    
    
}
