package agv2.model;

public class Genotipo {
    private Configuracion conf;
    private Poblacion inicial;
    private Poblacion tmp;
    
    public Genotipo(Configuracion conf){
        this.conf=conf;
        this.inicial = new Poblacion(conf);
        
    }
    
    public void init(){
        this.inicial.init();
        for(int x=0; x<this.conf.sizeOperators(); x++){
            this.conf.getOperator(x).setConfiguracion(this.conf);
            this.conf.getOperator(x).setPoblacion(this.inicial);
        }
        this.conf.getSelect().setConfiguracion(this.conf);
        this.conf.getSelect().setPoblacion(this.inicial);
        this.conf.getSelect().setNoSeleccion(this.conf.getNoPoblacion());
    }
    
    public void evolucion(){
        
        for(int x=0; x<this.conf.sizeOperators(); x++){
            this.conf.getOperator(x).execute();
        }
        this.conf.getSelect().execute();
        this.inicial.setPoblacion(this.conf.getSelect().getSeleccionados());
        
    }

    public Configuracion getConf() {
        return conf;
    }

    public void setConf(Configuracion conf) {
        this.conf = conf;
    }

    public Poblacion getPoblacionActual() {
        return inicial;
    }

    public void setInicial(Poblacion inicial) {
        this.inicial = inicial;
    }

    public Poblacion getTmp() {
        return tmp;
    }

    public void setTmp(Poblacion tmp) {
        this.tmp = tmp;
    }
    
    
    
}
