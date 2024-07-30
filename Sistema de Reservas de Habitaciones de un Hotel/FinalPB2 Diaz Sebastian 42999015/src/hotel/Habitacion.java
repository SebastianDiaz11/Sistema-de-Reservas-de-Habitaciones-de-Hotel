package hotel;

public abstract class Habitacion {
    private Integer numero;
    private Integer capacidad;
    private Double precioPorNoche;

    public Habitacion(Integer numero, Integer capacidad, Double precioPorNoche) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.precioPorNoche = precioPorNoche;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(Double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

}

