package bean;

public class NodePessoa  { // servirá para qualquer tipo de dado

    private Pessoa informacao;
    private NodePessoa proximo;
    
    public Pessoa getInformacao(){
        return this.informacao;
    }

    public void setInformacao(Pessoa info){
        this.informacao = info;
    }

    public NodePessoa getProximo() {
        return this.proximo;
    }

    public void setProximo(NodePessoa proximo) {
        this.proximo = proximo;
    }  
     
}
