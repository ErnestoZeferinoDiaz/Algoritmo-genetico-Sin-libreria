package agv2;

import agv2.controller.CPrincipal;

public class Main {

    public static void main(String[] args) {
        /*String obj="best friends";
        VPrincipal vp = new VPrincipal();
        vp.setVisible(true);
        Cromosoma.noGenes=obj.length();
        Configuracion conf;
        Genotipo g;
        MyFunction f;
        MyComparador com;
        Elitismo e;
        
        e = new Elitismo();
        f = new MyFunction();
        f.setObj(obj);        
        com = new MyComparador();
        
        conf = new Configuracion();
        conf.setNoGenes(Cromosoma.noGenes);
        conf.setNoPoblacion(200);
        conf.setPorcentajeMutacion(0.2);
        conf.setFitness(f);
        conf.setfComparador(com);
        conf.addOperator(new Cruza());
        conf.addOperator(new Mutacion());
        conf.setSelect(e);
        
        g = new Genotipo(conf);
        g.init();
        int x=0;
        do{
            g.evolucion();
            System.out.println(x+" Mejor: "+g.getPoblacionActual().getMejor());
            x++;
        }while(g.getPoblacionActual().getMejor().getFitnessValue()!=0);
        */
        CPrincipal cp = new CPrincipal();
        
        
    }
    
}
