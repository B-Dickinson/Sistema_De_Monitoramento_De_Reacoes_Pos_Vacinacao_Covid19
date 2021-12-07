package bean;

import factory.*;

public class ListaVacina {

    private NodeVacina prim;
    private int quantidade;
    private int idLista;

    public ListaVacina (){
        this.prim = null;
        this.quantidade = 0;
        this.idLista = 1;
    }

    public void add(Vacina info){ // adiciona ordenado
        
        //ConnectionFactory conexao = new ConnectionFactory();
        //conexao.conectar();

        NodeVacina novo = new NodeVacina();
        NodeVacina anterior = null;
        NodeVacina p = prim;

        novo.setInformacao(info);
        novo.getInformacao().setId(this.getIdLista());

        while(p != null && p.getInformacao().getId() < this.getIdLista()){
            anterior = p;
            p = p.getProximo();
        }

        if(anterior == null){
            novo.setProximo(prim);
            prim = novo;
            //conexao.inserirVacina(info);
        } else {
            anterior.setProximo(novo);
            novo.setProximo(p);
            //conexao.inserirVacina(info);
        }
            this.idLista++;
            this.quantidade++;
    }

    public void remove(Vacina i){ // qualquer posicao

        NodeVacina anterior = null;
        NodeVacina p = prim;

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

        NodeVacina anterior = null;
        NodeVacina p = prim;

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

    public Vacina buscaVacina(int id){
        Vacina vacinaRetorno = null;

        for(NodeVacina n = prim; n != null; n = n.getProximo()){
            if(n.getInformacao().getId() == id){
                vacinaRetorno = n.getInformacao();
            } else {
                continue;
            }
        }
                return vacinaRetorno;
    }

    public boolean isEmpty(){
        if(this.quantidade == 0){
            return true;
        } else {
            return false;
        }
    }

    public void print(){ // mostra todas as informacoes
        if(isEmpty()){
            msgListaVazia();
        } else {
            for(NodeVacina n = prim; n != null; n = n.getProximo()){
                System.out.println(n.getInformacao().toString());
                System.out.println();
            } 
        }
    }

    public int totalDeReacaoGerada(){ // soma de todas as maximas de reacoes
        int retorno = 0;
        for(NodeVacina n = prim; n != null; n = n.getProximo()){
            retorno += n.getInformacao().getMaximoReacoesGeradas();
        }
            return retorno;
    }

    public void printNomeVacina(){ // mostra apenas os nomes e id
        if(isEmpty()){
            msgListaVazia();
        } else {
            for(NodeVacina n = prim; n != null; n = n.getProximo()){
                System.out.println("["+n.getInformacao().getId()+"] - "+n.getInformacao().getNome());
            }
        }
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

    public NodeVacina getPrim() {
        return prim;
    }

    public void setPrim(NodeVacina prim) {
        this.prim = prim;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getIdLista() {
        return idLista;
    }

    
}
