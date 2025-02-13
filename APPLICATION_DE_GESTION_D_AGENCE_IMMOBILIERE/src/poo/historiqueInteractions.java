package poo;

public class historiqueInteractions {

    private String Date ;
    private String typeInteractions ;
    private String codeAgent;
    private String codeBien;
    
    public historiqueInteractions( String Date , String typeInteraction ,  String codeAgent ,  String codeBien) {
        this.Date=Date;
        this.typeInteractions = typeInteraction;
        this.codeAgent = codeAgent;
        this.codeBien = codeBien;
    }
    
    public String getDate() {
        return Date;
    }
    
    public String setDate(String Date) {
        return this.Date=Date;
    }
    
    public String getTypeInteraction() {
        return typeInteractions;
    }
    
    public String setTypeInteraction(String typeInteraction) {
        return this.typeInteractions = typeInteraction;
    }
    
    public String getCodeAgent() {
        return codeAgent;
    }
    
    public String setCodeAgent(String codeAgent) {
        return this.codeAgent = codeAgent;
    }
    
    public String getCodeBien() {
        return codeBien;
    }
    
    public String setCodeBien(String codeBien) {
        return this.codeBien = codeBien;
    }
    
}