package agv2.model.Seleccion;

import agv2.model.Configuracion;
import agv2.model.Poblacion;

public interface Seleccion {
    public void execute();
    public void setConfiguracion(Configuracion conf);
    public void setNoSeleccion(int i);
    public void setPoblacion(Poblacion poblacion);
    public Poblacion getSeleccionados();
}
