public class Moto extends Vehiculo{

    public Moto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        this.setVelocidad(velocidad);
        this.setAceleracion(aceleracion);
        this.setPatente(patente);
        this.setAnguloDeGiro(anguloDeGiro);
        this.setPeso(300);
        this.setRuedas(2);
    }
}
