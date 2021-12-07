package bean;

import factory.*;

public class ListaDoses {

    private NodeDose prim;
    private int quantidade;
    private int idLista;

    public ListaDoses (){
        this.prim = null;
        this.quantidade = 0;
        this.idLista = 1;
    }

    public void add(Dose info){ // adiciona ordenado
        
        //ConnectionFactory conexao = new ConnectionFactory();
        //conexao.conectar();

        NodeDose novo = new NodeDose();
        NodeDose anterior = null;
        NodeDose p = prim;

        novo.setInformacao(info);
        novo.getInformacao().setId(this.getIdLista());

        while(p != null && p.getInformacao().getId() < this.getIdLista()){
            anterior = p;
            p = p.getProximo();
        }

        if(anterior == null){
            novo.setProximo(prim);
            prim = novo;
            //conexao.inserirDoses(info);
        } else {
            anterior.setProximo(novo);
            novo.setProximo(p);
            //conexao.inserirDoses(info);
        }
            this.idLista++;
            this.quantidade++;
    }

    public void remove(Dose i){ // qualquer posicao

        NodeDose anterior = null;
        NodeDose p = prim;

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

    public void remove(String numeroOrdinalPorExtensoDaDose){ // qualquer posicao passando numeroOrdinal por extenso da dose

        NodeDose anterior = null;
        NodeDose p = prim;

        while(p != null && !p.getInformacao().getNumeroOrdinalPorExtensoDaDose().equalsIgnoreCase(numeroOrdinalPorExtensoDaDose)){
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

    public Dose buscarDose(Dose info){
        Dose doseRetorno = null;

        for(NodeDose n = prim; n != null; n = n.getProximo()){
            if(n.getInformacao() == info){
                doseRetorno = n.getInformacao();
                break;
            } else {
                continue;
            }
        }

        return doseRetorno;
    }

    public Dose buscarDose(String numeroOrdinalDaDosePorExtenso){ // buscar pelo numero ordinal por extenso

        Dose doseRetorno = null;

        for(NodeDose n = prim; n != null; n = n.getProximo()){
            if(n.getInformacao().getNumeroOrdinalPorExtensoDaDose().equalsIgnoreCase(numeroOrdinalDaDosePorExtenso)){
                doseRetorno = n.getInformacao();
                break;
            } else {
                continue;
            }
        }
                return doseRetorno;
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
            for(NodeDose n = prim; n != null; n = n.getProximo()){
                System.out.println(n.getInformacao().toString());
                System.out.println();
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

    public NodeDose getPrim() {
        return prim;
    }

    public void setPrim(NodeDose prim) {
        this.prim = prim;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getIdLista() {
        return idLista;
    }

    
}
