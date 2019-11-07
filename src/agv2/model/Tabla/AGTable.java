package agv2.model.Tabla;

import agv2.model.Cromosoma;
import agv2.model.Poblacion;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class AGTable extends AbstractTableModel{
    private LinkedList<Poblacion> poblaciones;
    private LinkedList<Cromosoma> mejores;
    private int observe;
    private int index;
    
    public AGTable(int observe){
        this.index=0;
        this.observe=observe;
        this.poblaciones = new LinkedList();
        this.mejores = new LinkedList();
    }
    
    public void addMejorCromosoma(Cromosoma mejor){
        this.mejores.add(mejor);
        this.fireTableRowsInserted(this.mejores.size()-1,this.mejores.size()-1);
    }
    
    public void addPoblacion(Poblacion pob){
        Poblacion tmp = new Poblacion(pob.getConf());
        tmp.addAll(pob);
        Collections.sort(tmp.getPoblacion(),new Comparator<Cromosoma>(){
            public int compare(Cromosoma o1, Cromosoma o2) {
                int i=0;
                if(tmp.getConf().getfComparador().comparar(o1.getFitnessValue(),o2.getFitnessValue())){
                   i=-1; 
                }else if(tmp.getConf().getfComparador().comparar(o2.getFitnessValue(),o1.getFitnessValue())){
                    i=1;
                }
                return i;
            }
        });
        this.poblaciones.add(tmp);
        this.fireTableDataChanged();
    }
    
    public void clear(){
        this.mejores.clear();
        this.poblaciones.clear();
    }
    
    public void back(){
        if(this.index>0){
            this.index--;
            this.fireTableDataChanged();
        }
    }
    
    public void next(){
        if(this.index<this.poblaciones.size()-1){
            this.index++;
            this.fireTableDataChanged();
        }
    }
    
    public int getTabIndex(){
        return this.index;
    }
    
    public LinkedList<Cromosoma> getTabla(){
        if(this.observe==0){
            return this.mejores;
        }else{
            if(this.poblaciones.isEmpty()){
                return this.mejores;
            }else{
                return this.poblaciones.get(this.getTabIndex()).getPoblacion();
            }
            
        }
    }
    
    @Override
    public int getRowCount() {
        return this.getTabla().size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex==0){
            return new Integer(rowIndex+1);
        }else if(columnIndex==1){
            return this.getTabla().get(rowIndex).toString();
        }else{
            return new Double(this.getTabla().get(rowIndex).getFitnessValue());
        }
    }

    @Override
    public String getColumnName(int column) {
        if(column==0){
            return "No";
        }else if(column==1){
            return "Texto";
        }else{
            return "Fitness";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==0){
            return Integer.class;
        }else if(columnIndex==1){
            return String.class;
        }else{
            return Double.class;
        }
    }
    
}
