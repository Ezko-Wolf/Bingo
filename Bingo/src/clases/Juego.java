package clases;



import clases.Jugador.EstadoJugador;
import java.util.ArrayList;
import interfaces.IFigura;
import observer.ObservableJuego;
import observer.ObserverJuego;



/**
*
* @author Ezko
*/
public class Juego extends ObservableJuego{

    public enum EstadoJuego {
        EsperandoInicio,
        Jugando,
        EsperandoJugadores,
        Finalizado
    }

    private ArrayList<Jugador> jugadores = new ArrayList();
    private Jugador ganador;
    private Bolillero bolillero;
    private Pozo pozo;
    private Config cfg;
    private EstadoJuego estado;
    private int numeroJuego;

    public Juego(Config cfg, int numero){
        this.ganador = null;
        this.cfg = cfg;
        this.estado = EstadoJuego.EsperandoInicio;
        this.pozo = new Pozo();
        this.numeroJuego = numero;
    }



    public ArrayList<IFigura> getFigurasHabilitadas(){
        return this.cfg.getFigurasHabilitadas();
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
        this.estado = EstadoJuego.Finalizado;
        notifyObservers(ObserverJuego.Eventos.HAY_GANADOR);
    }

    public Jugador getGanador(){
        return this.ganador;
    }

    public EstadoJuego getEstado(){
        return this.estado;
    }

    public void addJugador(Jugador unJ) {
        this.jugadores.add(unJ);
    }

    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }

    public int getFilas(){
        return this.cfg.getFilas();
    }

    public int getColumnas(){
        return this.cfg.getColumnas();
    }

    public void iniciar(){
        int cantCartones = this.obtenerCantCartones();
        int cantidadNumeros = this.cantidadNumerosEnJuego(cantCartones, this.cfg.getNumerosPorCarton());
        this.bolillero = new Bolillero(cantidadNumeros);
        this.dispararCreacionDeCartones();
        notifyObservers(ObserverJuego.Eventos.JUEGO_INICIADO);
        this.continuar();
    }

    public void continuar(){
        if(this.estado == EstadoJuego.EsperandoInicio || this.jugadoresListos()){
        this.estado = EstadoJuego.Jugando;
        notifyObservers(ObserverJuego.Eventos.ACTUALIZA_ESTADO_JUEGO);
        Bolilla sorteada = this.bolillero.sortear();
        boolean bolillaMarcada = false;
        this.jugadoresAEspera();
        for(int i = 0; i < jugadores.size() && ganador == null && !bolillaMarcada; i++){
            bolillaMarcada = jugadores.get(i).anotarBolilla(sorteada);
        }
            this.estado = EstadoJuego.EsperandoJugadores;
            notifyObservers(ObserverJuego.Eventos.ACTUALIZA_ESTADO_JUEGO);
        }
    }

    private boolean jugadoresListos() {
        boolean jugar = true;
        for(Jugador j:jugadores){
        jugar = j.getEstado() == EstadoJugador.Continuar;
        if(jugar == false) return false;
        }
        return jugar;
    }



    private int obtenerCantCartones() {
        int cant = 0;
        for(int i = 0; i < jugadores.size(); i++){
        cant += jugadores.get(i).getCantidadCartones();
        }
        return cant;
    }

    private void dispararCreacionDeCartones() {
        ArrayList<Carton> auxCartones = new ArrayList();
        for(Jugador j:jugadores){
        auxCartones.addAll(j.getCartones());
        }
        HelperCrearCartones.llenarCartones(auxCartones, this.bolillero.getBolillas());
    }



    private int cantidadNumerosEnJuego(int cantCartones, int numerosEnCarton) {
        return cantCartones * numerosEnCarton;
    }



    public void setPozo(int cartones) {
        pozo.agregarSaldo(cartones, cfg.getValorCarton());
    }



    public double getPozo() {
        return this.pozo.getMonto();
    }



    public int getNumero() {
        return this.numeroJuego;
    }



    public ArrayList<Bolilla> listaDeBolillasJugadas() {
        return bolillero.getBolillasSoretadas();
    }



    public void abandonar(Jugador unJ) {
        if(jugadores.size() == 2){
            jugadores.remove(unJ);
            unJ.getJuego().setGanador(jugadores.get(0));
        }
        else{
        jugadores.remove(unJ);
        }
        notifyObservers(ObserverJuego.Eventos.JUGADOR_ABANDONO);

    }
    
    
    private void jugadoresAEspera() {
        for(Jugador j:jugadores)
            j.setEstado(EstadoJugador.Esperando);
    }

    @Override
    public String toString(){
        return "N° " + this.numeroJuego + "- Estado: " + this.estado + "- Jugadores: " + this.jugadores.size();
    }
}