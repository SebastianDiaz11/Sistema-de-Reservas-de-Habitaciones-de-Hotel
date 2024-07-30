package hotel;

public class Suite extends Habitacion {
    private Double tamano;
    private Boolean tieneJacuzzi;
    private Boolean servicioDeMayordomo;
    private String zonaDeEstar;
    private Integer numeroDeHabitaciones;

    public Suite(Integer numero, Integer capacidad, Double precioPorNoche, Double tamano,
                 Boolean tieneJacuzzi, Boolean servicioDeMayordomo, String zonaDeEstar, Integer numeroDeHabitaciones) {
        super(numero, capacidad, precioPorNoche);
        this.tamano = tamano;
        this.tieneJacuzzi = tieneJacuzzi;
        this.servicioDeMayordomo = servicioDeMayordomo;
        this.zonaDeEstar = zonaDeEstar;
        this.numeroDeHabitaciones = numeroDeHabitaciones;
    }

    public Double getTamano() {
        return tamano;
    }

    public void setTamano(Double tamano) {
        this.tamano = tamano;
    }

    public Boolean TieneJacuzzi() {
        return tieneJacuzzi;
    }

    public void setTieneJacuzzi(Boolean tieneJacuzzi) {
        this.tieneJacuzzi = tieneJacuzzi;
    }

    public Boolean ServicioDeMayordomo() {
        return servicioDeMayordomo;
    }

    public void setServicioDeMayordomo(Boolean servicioDeMayordomo) {
        this.servicioDeMayordomo = servicioDeMayordomo;
    }

    public String getZonaDeEstar() {
        return zonaDeEstar;
    }

    public void setZonaDeEstar(String zonaDeEstar) {
        this.zonaDeEstar = zonaDeEstar;
    }

    public int getNumeroDeHabitaciones() {
        return numeroDeHabitaciones;
    }

    public void setNumeroDeHabitaciones(Integer numeroDeHabitaciones) {
        this.numeroDeHabitaciones = numeroDeHabitaciones;
    }
}
