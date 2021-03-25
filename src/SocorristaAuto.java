public class SocorristaAuto extends Vehiculo{

    public SocorristaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        this.setVelocidad(velocidad);
        this.setAceleracion(aceleracion);
        this.setPatente(patente);
        this.setAnguloDeGiro(anguloDeGiro);
        this.setPeso(2000);
        this.setRuedas(4);
    }

    public void socorrer(Auto auto){
        System.out.println("Socorriento auto " + auto.getPatente());

    }

}
