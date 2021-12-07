package bean;

public class Dose {

    private String numeroOrdinalPorExtensoDaDose;
    private int qtdDosesAplicadas;
    private int qtdReacoesSomenteNestaDose;
    private int quantidadeDeUsuariosQueSofreramReacao;
    //private int quantidadeDeReacoesGeradas;
    private int id;
    
    public Dose(String ordinal){
        this.numeroOrdinalPorExtensoDaDose = ordinal;
    //    this.quantidadeDeReacoesGeradas = 0;
        this.quantidadeDeUsuariosQueSofreramReacao = 0;
        this.qtdDosesAplicadas = 0;
        this.qtdReacoesSomenteNestaDose = 0;
    }

    public Dose(){

    }

    public String getNumeroOrdinalPorExtensoDaDose() {
        return numeroOrdinalPorExtensoDaDose;
    }

    public void setNumeroOrdinalPorExtensoDaDose(String numeroOrdinalPorExtensoDaDose) {
        this.numeroOrdinalPorExtensoDaDose = numeroOrdinalPorExtensoDaDose;
    }

    public int getQuantidadeDeUsuariosQueSofreramReacao() {
        return quantidadeDeUsuariosQueSofreramReacao;
    }

    public void setQuantidadeDeUsuariosQueSofreramReacao(int quantidadeDeUsuariosQueTomaram) {
        this.quantidadeDeUsuariosQueSofreramReacao = quantidadeDeUsuariosQueTomaram;
    }

    //public int getQuantidadeDeReacoesGeradas() {
       // return quantidadeDeReacoesGeradas;
    //}

    //public void setQuantidadeDeReacoesGeradas(int quantidadeDeReacoesSofridas) {
    //    this.quantidadeDeReacoesGeradas = quantidadeDeReacoesSofridas;
    //}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdDosesAplicadas() {
        return qtdDosesAplicadas;
    }

    public void setQtdDosesAplicadas(int qtdDosesAplicadas) {
        this.qtdDosesAplicadas = qtdDosesAplicadas;
    }

    public int getQtdReacoesSomenteNestaDose() {
        return qtdReacoesSomenteNestaDose;
    }

    public void setQtdReacoesSomenteNestaDose(int qtdReacoesSomenteNestaDose) {
        this.qtdReacoesSomenteNestaDose = qtdReacoesSomenteNestaDose;
    }
    

    @Override
    public String toString(){
        return "Dose: "+this.getNumeroOrdinalPorExtensoDaDose()
        +"\nQuantidade de doses aplicadas: "+this.getQtdDosesAplicadas()
        +"\nQuantidade de reacoes nesta dose: "+this.getQtdReacoesSomenteNestaDose()
        +"\nQuantidade de pessoas que tomaram: "+this.getQuantidadeDeUsuariosQueSofreramReacao();
        //+"\nQuantidade de reações que causou: "+this.getQuantidadeDeReacoesGeradas();
    }
    
}
