package bean;

public class NodeReacao {
    private Reacao informacao;
    private NodeReacao proximo;

    public Reacao getInformacao() {
        return informacao;
    }

    public void setInformacao(Reacao informacao) {
        this.informacao = informacao;
    }

    public NodeReacao getProximo() {
        return this.proximo;
    }

    public void setProximo(NodeReacao getProximo) {
        this.proximo = getProximo;
    }

    
}
