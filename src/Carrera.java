import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(auto);
        }else
            System.out.println("No hay mas lugar en la carrera");

    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(moto);
        }else
            System.out.println("No hay mas lugar en la carrera");
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(listaDeVehiculos.contains(vehiculo))
            listaDeVehiculos.remove(vehiculo);
        else
            System.out.println("No existe el vehiculo");

    }
    public void eliminarVehiculoConPatente(String patente){
        for(int i=0; i<listaDeVehiculos.size(); i++){
            if(listaDeVehiculos.get(i).getPatente().equals(patente)){
                listaDeVehiculos.remove(i);
                break;
            }

        }
    }

    public Vehiculo determinarGanador(){
        double valorMayor = 0, temp;
        int posMayor = 0;
        Vehiculo v;
        for(int i=0; i<listaDeVehiculos.size(); i++){
            v = listaDeVehiculos.get(i);
            temp = (v.getVelocidad() * 0.5 * v.getAceleracion()) / (v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas()*100));
            if(temp > valorMayor) {
                valorMayor = temp;
                posMayor = i;
            }
        }
        return listaDeVehiculos.get(posMayor);
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public void socorrerAuto(String patente){

        for(int i=0; i<listaDeVehiculos.size(); i++) {
            if (listaDeVehiculos.get(i).getPatente().equals(patente)) {
                socorristaAuto.socorrer((Auto) listaDeVehiculos.get(i));
                break;
            }
        }
    }

    public void socorrerMoto(String patente){
        for(int i=0; i<listaDeVehiculos.size(); i++) {
            if (listaDeVehiculos.get(i).getPatente().equals(patente)) {
                socorristaMoto.socorrer((Moto) listaDeVehiculos.get(i));
                break;
            }
        }
    }



}
