package agv2.model.Fitness;

import agv2.model.Cromosoma;

public class MyFunction extends FuncionEvaluacion{
    private String obj;
    
    protected double evaluate(Cromosoma cromo) {
        double r=0;
        int size=cromo.size();
        for(int x=0; x<size; x++){
            r=r+Math.pow(cromo.get(x).getVal().codePointAt(0)-obj.codePointAt(x),2);
        }
        r=Math.sqrt(r);
        return r;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }
    
    
    
}
