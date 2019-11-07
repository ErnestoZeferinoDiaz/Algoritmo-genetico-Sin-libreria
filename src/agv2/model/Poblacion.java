package agv2.model;

import java.util.LinkedList;
import java.util.List;

public class Poblacion {
    private Configuracion conf;
    private LinkedList<Cromosoma> poblacion;
    private int indexMejor;
    public Poblacion(Configuracion conf){
        this.conf=conf;
        this.poblacion = new LinkedList();
        this.indexMejor=-1;
    }

    
    public void init(){
        this.poblacion.clear();
        this.indexMejor=-1;
        for(int x=0; x<this.conf.getNoPoblacion(); x++){
            this.poblacion.add(new Cromosoma(this.conf));
            this.poblacion.get(x).rand();
        }
    }
    
    public void add(Cromosoma c){
        this.poblacion.add(c);
        this.indexMejor=-1;
    }
    
    public void addAll(LinkedList<Cromosoma> c){
        this.poblacion.addAll(c);
        this.indexMejor=-1;
    }
    
    public void addAll(Poblacion p){
        this.addAll(p.getPoblacion());
    }
    
    public void clear(){
        this.poblacion.clear();
        this.indexMejor=-1;
    }
    
    public int size(){
        return this.poblacion.size();
    }
    
    public Cromosoma get(int i){
        return this.poblacion.get(i);
    }
    
    public void set(int i,Cromosoma value){
        this.poblacion.set(i,value);
        this.indexMejor=-1;
    }
    
    public Cromosoma getMejor(){
        int i=0;
        if(this.indexMejor==-1){
            for(int x=1; x<this.poblacion.size(); x++){
                if(this.conf.getfComparador().comparar(this.poblacion.get(x).getFitnessValue(),this.poblacion.get(i).getFitnessValue())){
                    i=x;
                }
            }
        }else{
            i=this.indexMejor;
        }
        
        return this.poblacion.get(i);
    }

    @Override
    public String toString() {
        String cad="\n";
        for(int x=0; x<this.poblacion.size(); x++){
            cad+="\n"+this.poblacion.get(x).toString();
        }
        return cad;
    }

    public Configuracion getConf() {
        return conf;
    }

    public void setConf(Configuracion conf) {
        this.conf = conf;
    }

    public LinkedList<Cromosoma> getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(LinkedList<Cromosoma> poblacion) {
        this.poblacion.clear();
        this.poblacion.addAll(poblacion);
        this.indexMejor=-1;
    }
    
    public void setPoblacion(Poblacion poblacion) {
        this.setPoblacion(poblacion.getPoblacion());
    }
    
    
}
