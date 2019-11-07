package agv2.model;

public class Gen {
    private static String abc="qwertyuiopasdfghjklzxcvbnm QWERTYUIOPASDFGHJKLZXCVBNM";
    private String val;
    
    public Gen(){
        this.rand();
    }
    
    public void setVal(String val){
        this.val=val;
    }
    
    public String getVal(){
        return this.val;
    }
    
    public void rand(){
        int min=0,max=this.abc.length();
        int i=(int) (min+Math.random()*(max-min));
        this.val=abc.charAt(i)+"";
    }

    @Override
    public String toString() {
        return this.getVal();
    }
    
    
    
    
    
}
