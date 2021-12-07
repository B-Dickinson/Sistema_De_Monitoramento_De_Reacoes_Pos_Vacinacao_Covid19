package bean;

public class Vacina {
    private String nome;
    private String fabricante;
    private Double eficacia;
    private String reacoesAdversas;
    private int id;
    private int qtdPessoasQueSeVacinou;
    private int maximoReacoesGeradas;

    public Vacina(){

    }

    public Vacina(String nome, String fabricante, Double eficacia, String reacoesAdversas){
        this.nome = nome;
        this.fabricante = fabricante;
        this.eficacia = eficacia;
        this.reacoesAdversas = reacoesAdversas;
        this.qtdPessoasQueSeVacinou = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Double getEficacia() {
        return eficacia;
    }

    public void setEficacia(Double eficacia) {
        this.eficacia = eficacia;
    }

    public String getReacoesAdversas() {
        return reacoesAdversas;
    }

    public void setReacoesAdversas(String reacoesAdversas) {
        this.reacoesAdversas = reacoesAdversas;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getQtdPessoasQueSeVacinou() {
        return qtdPessoasQueSeVacinou;
    }

    public void setQtdPessoasQueSeVacinou(int qtdPessoasQueSeVacinou) {
        this.qtdPessoasQueSeVacinou = qtdPessoasQueSeVacinou;
    }

    public int totalPessoasQueTomouEssaVacina(){ // quantas pessoas se vacinaram com uma determinada vacina
        return this.getQtdPessoasQueSeVacinou();
    }

    public int getMaximoReacoesGeradas() {
        return maximoReacoesGeradas;
    }

    public void setMaximoReacoesGeradas(int maximoReacoesGeradas) {
        this.maximoReacoesGeradas = maximoReacoesGeradas;
    }

    @Override
    public String toString(){
        return "Id: "+this.getId() 
        +"\nNome: "+this.getNome()
        +"\nFabricante: "+this.getFabricante()
        +"\nEficácia: "+this.getEficacia()
        +"\nReacões Adversas: "+this.getReacoesAdversas()
        +"\nQtd Pessoas que se vacinou: "+this.getQtdPessoasQueSeVacinou()
        +"\nMáximo de reações geradas: "+this.getMaximoReacoesGeradas();
    }
}
