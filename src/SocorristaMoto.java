public class SocorristaMoto extends Vehiculo{

    public SocorristaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        this.setVelocidad(velocidad);
        this.setAceleracion(aceleracion);
        this.setPatente(patente);
        this.setAnguloDeGiro(anguloDeGiro);
        this.setPeso(2000);
        this.setRuedas(4);
    }

    public void socorrer(Moto moto){
        System.out.println("Socorriento moto " + moto.getPatente());

    }
}
