package agv2.controller;

import agv2.model.Configuracion;
import agv2.model.Cromosoma;
import agv2.model.Fitness.MyComparador;
import agv2.model.Fitness.MyFunction;
import agv2.model.Genotipo;
import agv2.model.Operadores.Cruza;
import agv2.model.Operadores.Mutacion;
import agv2.model.Seleccion.Elitismo;
import agv2.model.Tabla.AGTable;
import agv2.view.VPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPrincipal implements ActionListener{
    private VPrincipal vp;
    
    private Configuracion conf;
    private Genotipo g;
    private MyFunction f;
    private MyComparador com;
    private Elitismo e;
    
    private AGTable agtbl_poblacion;
    private AGTable agtbl_mejores;
    
    private boolean isRun;
    public CPrincipal(){
        this.vp = new VPrincipal();
        this.vp.setVisible(true);
        this.conf = new Configuracion();
        this.e = new Elitismo();
        this.f = new MyFunction();
        this.com = new MyComparador();
        this.conf.setFitness(this.f);
        this.conf.setfComparador(this.com);
        this.conf.addOperator(new Cruza());
        this.conf.addOperator(new Mutacion());
        this.conf.setSelect(this.e);
        
        this.g = new Genotipo(this.conf);
        
        this.agtbl_mejores = new AGTable(0);
        this.agtbl_poblacion = new AGTable(1);
        this.vp.tbl_mejor.setModel(agtbl_mejores);
        this.vp.tbl_poblacion.setModel(agtbl_poblacion);
        this.vp.btn_back.addActionListener(this);
        this.vp.btn_ejecutar.addActionListener(this);
        this.vp.btn_next.addActionListener(this);
        this.vp.btn_unavez.addActionListener(this);
        this.isRun=false;
    }
    
    public void getDataView(){
        String tmp;
        
        tmp=this.vp.txt_input.getText();
        this.f.setObj(tmp);
        Cromosoma.noGenes=tmp.length();
        this.conf.setNoGenes(Cromosoma.noGenes);
        this.conf.setNoPoblacion(Integer.parseInt(this.vp.txt_noPoblacion.getText()));
        this.conf.setPorcentajeMutacion(Double.parseDouble(this.vp.txt_porcentaje.getText()));
        
        this.agtbl_mejores.clear();
        this.agtbl_poblacion.clear();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x=0;
        int aux;
        
        if(e.getSource().equals(this.vp.btn_unavez) || e.getSource().equals(this.vp.btn_ejecutar)){
            if(!this.isRun){
                this.isRun=true;
                this.getDataView();
                this.g.init();
            }
            if(e.getSource().equals(this.vp.btn_unavez)){
                this.g.evolucion();
                System.out.println(x+" Mejor: "+this.g.getPoblacionActual().getMejor());
                x++;
                this.agtbl_mejores.addMejorCromosoma(this.g.getPoblacionActual().getMejor());
                this.agtbl_poblacion.addPoblacion(this.g.getPoblacionActual());
            }else{
                do{
                    this.g.evolucion();
                    System.out.println(x+" Mejor: "+this.g.getPoblacionActual().getMejor());
                    x++;
                    this.agtbl_mejores.addMejorCromosoma(this.g.getPoblacionActual().getMejor());
                    this.agtbl_poblacion.addPoblacion(this.g.getPoblacionActual());
                }while(this.g.getPoblacionActual().getMejor().getFitnessValue()!=0);
            }
            aux=this.agtbl_poblacion.getTabIndex()+1;
            this.vp.lb_pob.setText("Poblacion No "+aux);
        }else if(e.getSource().equals(this.vp.btn_back)){
            this.agtbl_poblacion.back();
            aux=this.agtbl_poblacion.getTabIndex()+1;
            this.vp.lb_pob.setText("Poblacion No "+aux);
        }else if(e.getSource().equals(this.vp.btn_next)){
            this.agtbl_poblacion.next();
            aux=this.agtbl_poblacion.getTabIndex()+1;
            this.vp.lb_pob.setText("Poblacion No "+aux);
        }
    }
    
}
