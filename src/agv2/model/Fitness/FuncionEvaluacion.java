package agv2.model.Fitness;

import agv2.model.Cromosoma;

public abstract class FuncionEvaluacion {
    private double interFitnessValue;
    
    public double getFitnessValue(Cromosoma a_subject) {
        double fitnessValue = evaluate(a_subject);
        this.interFitnessValue = fitnessValue;
        return fitnessValue;
    }
    protected abstract double evaluate(Cromosoma a_subject);

  
}
