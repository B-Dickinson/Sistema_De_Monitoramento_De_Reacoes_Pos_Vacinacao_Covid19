package bean;

import factory.*;

public class ListaReacao {

    private NodeReacao prim;
    private int quantidade;
    private int idLista;

    public ListaReacao (){
        this.prim = null;
        this.quantidade = 0;
        this.idLista = 1;
    }

    public void add(Reacao info){ // adiciona ordenado
        
        //ConnectionFactory conexao = new ConnectionFactory();
        //conexao.conectar();

        NodeReacao novo = new NodeReacao();
        NodeReacao anterior = null;
        NodeReacao p = prim;

        novo.setInformacao(info);
        novo.getInformacao().setId(this.getIdLista());

        while(p != null && p.getInformacao().getId() < this.getIdLista()){
            anterior = p;
            p = p.getProximo();
        }

        if(anterior == null){
            novo.setProximo(prim);
            prim = novo;
            //conexao.inserirReacao(info);
        } else {
            anterior.setProximo(novo);
            novo.setProximo(p);
            //conexao.inserirReacao(info);
        }
            this.idLista++;
            this.quantidade++;
    }

    public void remove(Reacao i){ // qualquer posicao

        NodeReacao anterior = null;
        NodeReacao p = prim;

        while(p != null && p.getInformacao() != i){
            anterior = p;
            p = p.getProximo();
        }

        if(p == null){ // não encontrou
            return;
        }

        if(anterior == null){ // remove o primeiro
            prim = prim.getProximo();
            this.quantidade--;
        } else { // remove em qualquer posicao
            anterior.setProximo(p.getProximo());
            this.quantidade--;
        }
    }

    public void remove(int id){ // qualquer posicao passando o id

        NodeReacao anterior = null;
        NodeReacao p = prim;

        while(p != null && p.getInformacao().getId() != id){
            anterior = p;
            p = p.getProximo();  
        }   

        if(p == null){ // não encontrou
            return;
        }

        if(anterior == null){ // encontrou no inicio
            prim = prim.getProximo();
            this.quantidade--;
        } else {
            anterior.setProximo(p.getProximo());
            this.quantidade--;
        }
    }

    public boolean isEmpty(){
        if(this.quantidade == 0){
            return true;
        } else {
            return false;
        }
    }

    public void print(){
        if(isEmpty()){
            msgListaVazia();
        } else {
            for(NodeReacao n = prim; n != null; n = n.getProximo()){
                System.out.println(n.getInformacao().toString());
                System.out.println();
            } 
        }
    }

    public Reacao buscarReacao(String reacao){ // passar o nome de uma reacao
            Reacao reacaoRetorno = null;
        for(NodeReacao n = prim; n != null; n = n.getProximo()){
            if(n.getInformacao().getTipo().equalsIgnoreCase(reacao)){
                reacaoRetorno = n.getInformacao();
                break;
            } else {
                continue;
            }
        }   
                return reacaoRetorno;
    }

    public int totalReacoes(){
        int retorno = 0;
    for(NodeReacao n = prim; n != null; n = n.getProximo()){
        retorno += n.getInformacao().getQtdPessoasQueTiveramReacoes();
    }
        return retorno;
}

    public void msgListaVazia(){
        System.out.println();
        System.out.println("A lista está vazia");
        System.out.println();
    }

    public void msgSucesso(){
        System.out.println();
        System.out.println("Ação realizada com sucesso");
        System.out.println();
    }

    public NodeReacao getPrim() {
        return prim;
    }

    public void setPrim(NodeReacao prim) {
        this.prim = prim;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getIdLista() {
        return idLista;
    }

    
}

