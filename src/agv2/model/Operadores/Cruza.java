package agv2.model.Operadores;

import agv2.model.Configuracion;
import agv2.model.Cromosoma;
import agv2.model.Poblacion;

public class Cruza implements Operator{
    private Configuracion conf;
    private Poblacion pob;
    private Poblacion pob_resul;
    
    public Cruza(){
        this.pob_resul = new Poblacion(this.conf);
    }
    
    @Override
    public void execute() {
        int s=pob.size();
        Cromosoma a,b;
        this.pob_resul.clear();
        for(int x=0; x<s; x=x+2){
            a=this.pob.get(x);
            b=this.pob.get(x+1);
            cruza(a,b);
        }
        this.pob.setPoblacion(pob_resul);
    }
    
    
    private void cruza(Cromosoma a,Cromosoma b){
        int siz=a.size();
        int i=this.conf.randInt(0, siz);
        Cromosoma r1,r2;
        r1 = new Cromosoma(this.conf);
        r2 = new Cromosoma(this.conf);
        r1.rand();
        r2.rand();
        for(int x=0; x<siz; x++){
            if(x<i){
                r1.set(x, a.get(x));
                r2.set(x, b.get(x));
            }else{
                r1.set(x, b.get(x));
                r2.set(x, a.get(x));
            }
        }
        this.pob_resul.add(r1);
        this.pob_resul.add(r2);
        
    }

    @Override
    public void setPoblacion(Poblacion p) {
        this.pob=p;
    }

    @Override
    public Poblacion getPoblacionResultante() {
        return this.pob_resul;
    }

    @Override
    public void setConfiguracion(Configuracion conf) {
        this.conf=conf;
    }
    
}
