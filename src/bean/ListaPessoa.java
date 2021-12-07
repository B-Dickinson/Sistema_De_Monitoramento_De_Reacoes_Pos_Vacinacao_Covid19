package bean;

import factory.*;

public class ListaPessoa {

    private NodePessoa prim;
    private int quantidade;
    private int idLista;

    public ListaPessoa (){
        this.prim = null;
        this.quantidade = 0;
        this.idLista = 1;
    }

    public void add(Pessoa info){ // adiciona ordenado
        
        //ConnectionFactory conexao = new ConnectionFactory();
        //conexao.conectar();
        
        NodePessoa novo = new NodePessoa();
        NodePessoa anterior = null;
        NodePessoa p = prim;

        novo.setInformacao(info);
        novo.getInformacao().setId(this.getIdLista());

        while(p != null && p.getInformacao().getId() < this.getIdLista()){
            anterior = p;
            p = p.getProximo();
        }

        if(anterior == null){
            novo.setProximo(prim);
            prim = novo;
            //conexao.inserirUsuario(info); // inserir ao banco de dados
        } else {
            anterior.setProximo(novo);
            novo.setProximo(p);
            //conexao.inserirUsuario(info); // inserir ao banco
        }
            //conexao.desconectar();
        
            this.idLista++;
            this.quantidade++;
            
            
    }

    public void remove(Pessoa i){ // qualquer posicao

        NodePessoa anterior = null;
        NodePessoa p = prim;

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

    public int qtdPessoasVacinadas(){
            int retorno = 0;
        for(NodePessoa n = prim; n != null; n = n.getProximo()){
            if(n.getInformacao().getVacinado()){
                retorno++;
            }
        }   
                return retorno;
    }

    public void remove(int id){ // qualquer posicao passando o id

        NodePessoa anterior = null;
        NodePessoa p = prim;

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

    public Pessoa buscarPessoa(Pessoa info){
        Pessoa pessoaRetorno = null;

        for(NodePessoa n = prim; n != null; n = n.getProximo()){
            if(n.getInformacao() == info){
                pessoaRetorno = n.getInformacao();
                break;
            } else {
                continue;
            }
        }

            return pessoaRetorno;
    }

    public Pessoa buscarPessoa(String nomeUsuario){ // busca pelo nome
        Pessoa pessoaRetorno = null;
        
        for(NodePessoa n = prim; n != null; n = n.getProximo()){
            if(n.getInformacao().getNome().equalsIgnoreCase(nomeUsuario)){
                pessoaRetorno = n.getInformacao();
                break;
            } else {
                continue;
            }
        }

                return pessoaRetorno;
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
            for(NodePessoa n = prim; n != null; n = n.getProximo()){
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

    public NodePessoa getPrim() {
        return prim;
    }

    public void setPrim(NodePessoa prim) {
        this.prim = prim;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getIdLista() {
        return idLista;
    }

    
}
