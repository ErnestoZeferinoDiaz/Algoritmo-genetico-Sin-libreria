package agv2.model.Fitness;

public class MyComparador implements FuncionComparador{

    @Override
    public boolean comparar(double fitCromo1, double fitCromo2) {
        return fitCromo1<fitCromo2;
    }
    
}
