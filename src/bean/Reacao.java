package bean;

public class Reacao {
    private String tipo;
    private int qtdPessoasQueTiveramReacoes;
    private int id;
    
    public Reacao(){
        
    }

    public Reacao(String tipo){
        this.tipo = tipo;
        this.qtdPessoasQueTiveramReacoes = 0;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQtdPessoasQueTiveramReacoes() {
        return qtdPessoasQueTiveramReacoes;
    }

    public void setQtdPessoasQueTiveramReacoes(int qtdPessoasQueTiveramReacoes) {
        this.qtdPessoasQueTiveramReacoes = qtdPessoasQueTiveramReacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Id: "+this.getId()
        +"\nTipo: "+this.getTipo()
        +"\nQuantidade de Pessoas que tiveram reacao: "+this.getQtdPessoasQueTiveramReacoes();
    }

    
}
