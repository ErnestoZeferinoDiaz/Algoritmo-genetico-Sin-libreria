package agv2.model;

import java.util.LinkedList;

public class Cromosoma {
    public static int noGenes;
    private Configuracion conf;
    private LinkedList<Gen> genes;
    
    private double fitnessvalue;
    private boolean b_fitnessvalue;
    
    public Cromosoma(Configuracion conf){
        this.genes = new LinkedList();
        this.conf=conf;
        this.fitnessvalue=-1;
        this.b_fitnessvalue=false;
    }
    
    public int size(){
        return this.genes.size();
    }
    
    public void set(int i,Gen val){
        this.genes.set(i, val);
        this.b_fitnessvalue=false;
    }
    
    public Gen get(int i){
        return this.genes.get(i);
    }
    
    public void rand(){
        for(int i=0; i<Cromosoma.noGenes; i++) {
            this.genes.add(new Gen());
        }
        this.b_fitnessvalue=false;
    }
    
    public double getFitnessValue(){
        if(this.b_fitnessvalue){
            return this.fitnessvalue;
        }else{
            this.fitnessvalue = this.conf.getFitness().getFitnessValue(this);
            this.b_fitnessvalue = true;
        }
        return this.fitnessvalue;
        
    }
    

    @Override
    public String toString() {
        String cad="";
        for (int i = 0; i < Cromosoma.noGenes; i++) {
            cad+=this.genes.get(i).toString();
        }
        //cad+=": "+this.getFitnessValue();
        return cad;
    }
    
    
}
