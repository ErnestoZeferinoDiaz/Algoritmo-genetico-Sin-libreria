package agv2.model.Operadores;

import agv2.model.Configuracion;
import agv2.model.Gen;
import agv2.model.Poblacion;

public class Mutacion implements Operator{
    private Configuracion conf;
    private Poblacion pob;
    
    @Override
    public void execute() {
        int s=this.pob.size();
        int n=(int) (this.conf.getPorcentajeMutacion()*s);
        int index;
        int genIndex;
        for(int x=0; x<n; x++){
            index=this.conf.randInt(0, s);
            genIndex=this.conf.randInt(0, this.conf.getNoGenes());
            //this.pob.get(index).get(genIndex).rand();
            this.pob.get(index).set(genIndex,new Gen());
        }
    }

    @Override
    public void setPoblacion(Poblacion p) {
        this.pob=p;
    }

    @Override
    public Poblacion getPoblacionResultante() {
        return this.pob;
    }

    @Override
    public void setConfiguracion(Configuracion conf) {
        this.conf=conf;
    }
    
}
