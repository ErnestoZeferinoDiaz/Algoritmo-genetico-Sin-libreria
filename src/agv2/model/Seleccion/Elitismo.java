package agv2.model.Seleccion;

import agv2.model.Configuracion;
import agv2.model.Cromosoma;
import agv2.model.Poblacion;
import java.util.Collections;
import java.util.Comparator;

public class Elitismo implements Seleccion{
    private Poblacion select;
    private Poblacion poblacion;
    private Configuracion conf;
    private int noSelec;
    
    public Elitismo(){
        this.select = new Poblacion(conf);
    }
    @Override
    public void execute() {
        this.select.clear();
        int margin=this.poblacion.size()/2;
        Collections.sort(this.poblacion.getPoblacion(),new Comparator<Cromosoma>(){
            public int compare(Cromosoma o1, Cromosoma o2) {
                int i=0;
                if(conf.getfComparador().comparar(o1.getFitnessValue(),o2.getFitnessValue())){
                   i=-1; 
                }else if(conf.getfComparador().comparar(o2.getFitnessValue(),o1.getFitnessValue())){
                    i=1;
                }
                return i;
            }
        });
        
        for(int x=0; x<this.noSelec; x++){
            this.select.add(this.poblacion.get(this.conf.randInt(0, margin)));
        }
    }

    @Override
    public void setConfiguracion(Configuracion conf) {
        this.conf=conf;
    }

    @Override
    public void setPoblacion(Poblacion poblacion) {
        this.poblacion=poblacion;
    }

    @Override
    public Poblacion getSeleccionados() {
        return this.select;
    }

    @Override
    public void setNoSeleccion(int i) {
        this.noSelec=i;
    }
    
}
