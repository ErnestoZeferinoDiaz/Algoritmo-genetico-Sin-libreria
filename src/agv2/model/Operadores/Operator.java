package agv2.model.Operadores;

import agv2.model.Configuracion;
import agv2.model.Poblacion;

public interface Operator {
    public void execute();
    public void setConfiguracion(Configuracion conf);
    public void setPoblacion(Poblacion p);
    public Poblacion getPoblacionResultante();
}
