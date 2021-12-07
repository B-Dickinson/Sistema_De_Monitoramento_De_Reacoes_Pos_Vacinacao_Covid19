package bean;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private char sexo;
    private String bairro;
    private Vacina vacinaTomada;
    private int qtdDosesTomadas;
    private String reacoesSofridas;
    private int qtdReacoesSofridas;
    private String qualDoseSofreuReacao;
    private boolean vacinado;


    public Pessoa(){ // utilizado em cadastro de Usuario
        this.qtdDosesTomadas = 0;
        this.reacoesSofridas = "Nenhuma";
        this.qualDoseSofreuReacao = "Nenhuma";
        this.qtdReacoesSofridas = 0;
    }

    public Pessoa(String nome, int idade, char sexo, String bairro, Vacina vacinaTomada, int qtdDosesTomadas){
            this.nome = nome;
            this.idade = idade;
        if(sexo == 'M' || sexo == 'F'){
            this.sexo = sexo;
        } else {
            this.sexo = 0;
        }
            this.vacinaTomada = vacinaTomada;
            this.bairro = bairro;
            this.qtdDosesTomadas = qtdDosesTomadas;
            this.qualDoseSofreuReacao = "Nenhuma";
            this.qtdReacoesSofridas = 0;
            //this.vacinaTomada.setQtdPessoasQueSeVacinou(vacinaTomada.getQtdPessoasQueSeVacinou()+1);
    }

    public Pessoa(String nome, int idade, char sexo, String bairro){
            this.nome = nome;
            this.idade = idade;
            this.qtdDosesTomadas = 0;
            this.reacoesSofridas = "Nenhuma";
            this.qualDoseSofreuReacao = "Nenhuma";
            this.qtdReacoesSofridas = 0;
        if(sexo == 'M' || sexo == 'F'){
            this.sexo = sexo;
        } else {
            this.sexo = 0;
        }
            this.bairro = bairro;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public void setSexo(int sexo) {
        if(sexo == 1){
            this.sexo = 'M';
        } else if(sexo == 2){
            this.sexo = 'F';
        } else {
            this.sexo = 0;
        }

    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getQtdDosesTomadas() {
        return qtdDosesTomadas;
    }

    public void setQtdDosesTomadas(int qtdVacinasTomadas) {
        if(qtdVacinasTomadas < 0 || qtdVacinasTomadas >= 3){
            this.qtdDosesTomadas = 0;
        } else if(qtdVacinasTomadas == 1){
            this.qtdDosesTomadas = 1;
        } else if(qtdVacinasTomadas == 2) {
            this.qtdDosesTomadas = 2;
        } else { // em ultimo caso, é zero
            qtdVacinasTomadas = 0;
        } 
    }

    public boolean getVacinado() {
        return vacinado;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }

    public String getReacoesSofridas() {
        return reacoesSofridas;
    }

    public void setReacoesSofridas(String reacoesSofridas) {
        this.reacoesSofridas = reacoesSofridas;
    }

    public String getQualDoseSofreuReacao() {
        return qualDoseSofreuReacao;
    }

    public void setQualDoseSofreuReacao(String qualDoseSofreuReacao) {
        this.qualDoseSofreuReacao = qualDoseSofreuReacao;
    }

    public Vacina getVacinaTomada() {
        return vacinaTomada;
    }

    public void setVacinaTomada(Vacina vacinaTomada) {
        this.vacinaTomada = vacinaTomada;
    }

    

    public int getQtdReacoesSofridas() {
        return qtdReacoesSofridas;
    }

    public void setQtdReacoesSofridas(int qtdReacoesSofridas) {
        this.qtdReacoesSofridas = qtdReacoesSofridas;
    }

    @Override
    public String toString(){
        if(this.vacinaTomada == null){
            return "Id: "+this.getId() 
            +"\nNome: "+this.getNome()
            +"\nIdade: "+this.getIdade()
            +"\nSexo: "+this.getSexo()
            +"\nBairro: "+this.getBairro()
            +"\nVacina Tomada: Nenhuma"
            +"\nQuantidade de doses tomadas: "+this.getQtdDosesTomadas()
            +"\nEm Qual Dose(s) sofreu reação: "+this.getQualDoseSofreuReacao()
            +"\nQtd reações sofridas: "+this.getQtdReacoesSofridas()
            +"\nReações Sofridas: "+this.getReacoesSofridas();

        } else {

        return "Id: "+this.getId() 
        +"\nNome: "+this.getNome()
        +"\nIdade: "+this.getIdade()
        +"\nSexo: "+this.getSexo()
        +"\nBairro: "+this.getBairro()
        +"\nVacina Tomada: "+this.getVacinaTomada().getNome()
        +"\nQuantidade de doses tomadas: "+this.getQtdDosesTomadas()
        +"\nEm Qual Dose(s) sofreu reação: "+this.getQualDoseSofreuReacao()
        +"\nQtd reações sofridas: "+this.getQtdReacoesSofridas()
        +"\nReações Sofridas: "+this.getReacoesSofridas();

        }
    }
}
