package bean;

public class NodeVacina {
    private Vacina informacao;
    private NodeVacina proximo;

    public Vacina getInformacao() {
        return informacao;
    }

    public void setInformacao(Vacina informacao) {
        this.informacao = informacao;
    }
    
    public NodeVacina getProximo() {
        return proximo;
    }

    public void setProximo(NodeVacina proximo) {
        this.proximo = proximo;
    }
    
    
}
