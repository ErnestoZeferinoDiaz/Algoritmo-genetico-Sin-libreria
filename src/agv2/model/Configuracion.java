package agv2.model;

import agv2.model.Seleccion.Seleccion;
import agv2.model.Fitness.FuncionComparador;
import agv2.model.Fitness.FuncionEvaluacion;
import agv2.model.Operadores.Operator;
import java.util.LinkedList;

public class Configuracion {
    private int noPoblacion;
    private int noGenes;
    private int noIteraciones;
    private double porcentajeMutacion;
    private Seleccion select;
    private FuncionEvaluacion fitness;
    private FuncionComparador fComparador;
    private LinkedList<Operator> operadores;
    
    public Configuracion(){
        this.operadores = new LinkedList();
    }

    public double rand(int min,int max){
        return min+Math.random()*(max-min);
    }
    
    public int randInt(int min,int max){
        return (int) rand(min,max);
    }
    
    public void addOperator(Operator op){
        this.operadores.add(op);
    }
    
    public Operator getOperator(int i){
        return this.operadores.get(i);
    }
    
    public int sizeOperators(){
        return this.operadores.size();
    }
    
    public int getNoPoblacion() {
        return noPoblacion;
    }

    public void setNoPoblacion(int noPoblacion) {
        this.noPoblacion = noPoblacion;
    }

    public int getNoGenes() {
        return noGenes;
    }

    public void setNoGenes(int noGenes) {
        this.noGenes = noGenes;
    }

    public int getNoIteraciones() {
        return noIteraciones;
    }

    public void setNoIteraciones(int noIteraciones) {
        this.noIteraciones = noIteraciones;
    }

    public double getPorcentajeMutacion() {
        return porcentajeMutacion;
    }

    public void setPorcentajeMutacion(double porcentajeMutacion) {
        this.porcentajeMutacion = porcentajeMutacion;
    }

    public Seleccion getSelect() {
        return select;
    }

    public void setSelect(Seleccion select) {
        this.select = select;
    }

    public FuncionEvaluacion getFitness() {
        return fitness;
    }

    public void setFitness(FuncionEvaluacion fitness) {
        this.fitness = fitness;
    }

    public FuncionComparador getfComparador() {
        return fComparador;
    }

    public void setfComparador(FuncionComparador fComparador) {
        this.fComparador = fComparador;
    }
    
    
}
