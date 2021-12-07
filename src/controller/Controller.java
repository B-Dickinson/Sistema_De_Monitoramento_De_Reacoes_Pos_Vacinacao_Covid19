package controller;

import bean.*;
import factory.*;
import java.util.Scanner;

public class Controller {
    
    public static Scanner sc = new Scanner(System.in);
    public static ListaPessoa users = new ListaPessoa();
    public static ListaReacao reactions = new ListaReacao();
    public static ListaVacina vacines = new ListaVacina();
    public static ListaDoses doses = new ListaDoses();
    
    public static void main(String[] args) {
          //prePreencherListas();    // apenas uma vez para pre preenchimento no banco
         //preencherComUsuarios(); // apenas uma vez para pre preenchimento no banco de dados
    }
    
    public static void prePreencherListas(){ // preenche as listas com alguns dados ao iniciar o programa
        
        ConnectionFactory conexao = new ConnectionFactory();
        conexao.conectar();
        
        //Vacinas
        Vacina v1 = new Vacina("Coronavac","Sinovac", 50.7,"Febre, cansaço, diarreia e náusea");
        Vacina v2 = new Vacina("Astrazeneca","Oxford", 90.0,"Febre, dor no corpo, mal-estar e cansaço");
        Vacina v3 = new Vacina("Pfizer","BioNTech", 88.0,"Febre, cansaço, diarreia e náusea");
        Vacina v4 = new Vacina("Sputnik","Instituto de Pesquisa Gamaleya", 94.3,"dor de cabeça; fadiga; reações no local da injeção");
        Vacina v5 = new Vacina("Janssen","Janssen Farmacêutica", 66.0," dor local da injeção, cefaleia, fadiga, mialgia e náuseas");
        Vacina v6 = new Vacina("Moderna","Moderna", 90.0,"prurido, urticária, sensação de coceira na garganta, vermelhidão e alterações respiratórias");

        //Reacoes 
        Reacao r1 = new Reacao("Febre");
        Reacao r2 = new Reacao("Calafrios");
        Reacao r3 = new Reacao("Dores no Corpo");
        Reacao r4 = new Reacao("Náuseas ou dores de cabeça");
        Reacao r5 = new Reacao("Fadiga");
        Reacao r6 = new Reacao("Falta de ar");

        // Doses
        Dose d1 = new Dose("Primeira");
        Dose d2 = new Dose("Segunda");

        // preencher reactions
        reactions.add(r1);
        reactions.add(r2);
        reactions.add(r3);
        reactions.add(r4);
        reactions.add(r5);
        reactions.add(r6);

        // preencher vacines
        vacines.add(v1);
        vacines.add(v2);
        vacines.add(v3);
        vacines.add(v4);
        vacines.add(v5);
        vacines.add(v6);

      // preencher doses
        doses.add(d1);
        doses.add(d2);
        
        // inserindo no banco de dados
        
        conexao.inserirDoses(d1);
        conexao.inserirDoses(d2);
        
        conexao.inserirVacina(v1);
        conexao.inserirVacina(v2);
        conexao.inserirVacina(v3);
        conexao.inserirVacina(v4);
        conexao.inserirVacina(v5);
        conexao.inserirVacina(v6);
        
        conexao.inserirReacao(r1);
        conexao.inserirReacao(r2);
        conexao.inserirReacao(r3);
        conexao.inserirReacao(r4);
        conexao.inserirReacao(r5);
        conexao.inserirReacao(r6);
        
        conexao.desconectar();
        
    }
    
    public static void preencherComUsuarios(){
                
                ConnectionFactory conexao = new ConnectionFactory();
                conexao.conectar();
        
                //Usuarios
                Pessoa p1 = new Pessoa("Bruce",21,'M',"Anjo da Guarda",vacines.buscaVacina(2),2);
                Pessoa p2 = new Pessoa("Anakin SkyWalker",40,'M',"Cohatrac I",vacines.buscaVacina(1),2);
                Pessoa p3 = new Pessoa("James Bond", 35,'M',"Calhau",vacines.buscaVacina(3),1);
                Pessoa p4 = new Pessoa("Michelle Pfeiffer", 30,'F',"Gancharia",vacines.buscaVacina(5),2);
                Pessoa p5 = new Pessoa("Obi Wan", 40,'M',"Calhau",vacines.buscaVacina(6),2);
                Pessoa p6 = new Pessoa("Slash", 35,'M',"São Cristovão",vacines.buscaVacina(2),2);
                Pessoa p7 = new Pessoa("Peter Quill", 46,'M',"Coroadinho",vacines.buscaVacina(2),2);
                Pessoa p8 = new Pessoa("Eddie Van Halen", 86,'M',"Barreto",vacines.buscaVacina(1),2);
    
                //completar informacoes de usuarios
                prePreenchimentoAutomatico(p1,"sim",p1.getQtdDosesTomadas(),"Primeira","Febre","Calafrio");    
                prePreenchimentoAutomatico(p2,"Não",p2.getQtdDosesTomadas(),"Primeira e Segunda","Febre","Calafrio");    
                prePreenchimentoAutomatico(p3,"sim",p3.getQtdDosesTomadas(),"Nenhuma","Febre","Calafrio","Fadiga");    
                prePreenchimentoAutomatico(p4,"sim",p4.getQtdDosesTomadas(),"Primeira","Calafrio");    
                prePreenchimentoAutomatico(p5,"sim",p5.getQtdDosesTomadas(),"Primeira","Febre","Calafrio","Falta de ar");    
                prePreenchimentoAutomatico(p6,"sim",p6.getQtdDosesTomadas(),"Primeira","Febre","Calafrio");
                prePreenchimentoAutomatico(p7,"sim",p6.getQtdDosesTomadas(),"Primeira","Febre","Calafrio","Fadiga");
                prePreenchimentoAutomatico(p8,"sim",p6.getQtdDosesTomadas(),"Segunda","Falta de Ar");

                // preencher users
                users.add(p1);
                users.add(p2);
                users.add(p3);
                users.add(p4);
                users.add(p5);
                users.add(p6); 
                users.add(p7); 
                users.add(p8); 
                
                // inserindo no db
                
                conexao.inserirUsuario(p1);
                conexao.inserirUsuario(p2);
                conexao.inserirUsuario(p3);
                conexao.inserirUsuario(p4);
                conexao.inserirUsuario(p5);
                conexao.inserirUsuario(p6);
                conexao.inserirUsuario(p7);
                conexao.inserirUsuario(p8);
    }

    public static int menuDeOpcoes(){
        int escolha;
        
        System.out.println();    
        System.out.println("   Sistema de Monitoramento de Reações Adversas");    
        System.out.println();    
        System.out.println("\t\tMenu Principal");    
        System.out.println();    
        System.out.println("[1] - Cadastro de Informações");    
        System.out.println();    
        System.out.println("[2] - Reações Adversas");    
        System.out.println();    
        System.out.println("[3] - Tipos de Vacinas");    
        System.out.println();    
        System.out.println("[4] - Porcentagem de Vacinados");    
        System.out.println();    
        System.out.println("[5] - Doses da Vacina");    
        System.out.println();    
        System.out.println("[6] - Faixa Etária");    
        System.out.println();    
        System.out.println("[7] - Vacinas que mais causaram reações");    
        System.out.println();  
        System.out.println("[8] - Fim do Programa");  
        System.out.println();  
        System.out.println();  

        System.out.print("Escolha uma opção: "); 
        escolha = sc.nextInt();
        sc.nextLine();

        System.out.println();    
        System.out.println();    

        return escolha;
    }

    public static Pessoa cadastroDeUsuario(){ // terminado(por enquanto)

            int qtdDosesTomadas;
            Pessoa usuario = new Pessoa();
            boolean teveOuNaoReacao = false; // variavel para permitir ou n chamada do metodo em qual dose sofreu reacao 
            int escolhaVacinaQueTomou; // referente ao numero
            Vacina vacinaBuscada = null; // vacina que será escolhida e manipulada
            boolean vacinaInexistente = false; // responsável pelo do while da escolha de vacinas
            int respostaSeVacinouOuNao;
            boolean repeteParteDeDizerQtsDosesTomou = false;

            System.out.println();
            System.out.println("\t\tCadastro de informações acerca da vacinação");
            System.out.println();

            System.out.print("Nome: ");
            usuario.setNome(sc.nextLine());
            //sc.nextLine();
            

            System.out.println();

            System.out.print("Idade: ");
            usuario.setIdade(sc.nextInt());
            sc.nextLine();

            System.out.println();

            System.out.println("Sexo: (1 - Masc  ;  2 - Fem)");
            System.out.println();
            System.out.print("R: ");
            usuario.setSexo(sc.nextInt());
            sc.nextLine();

            System.out.println();

            System.out.print("Bairro: ");
            usuario.setBairro(sc.nextLine());


            System.out.println();
            System.out.println("Você já foi vacinado contra a COVID-19? 1 - Sim\t2 - Não");
            System.out.print("R: ");
            respostaSeVacinouOuNao = sc.nextInt();
            sc.nextLine();

            System.out.println();

            if(respostaSeVacinouOuNao == 2){ // caso não seja vacinado ainda
                System.out.println("Cadastro concluído!");
                System.out.println();
                usuario.setVacinaTomada(null); // nao tomou nenhuma
                usuario.setQtdDosesTomadas(0);
                usuario.setQualDoseSofreuReacao("Nenhuma");
                usuario.setReacoesSofridas("Nenhuma");
                usuario.setQtdReacoesSofridas(0);
                return usuario;
            }

            // daqui pra baixo somente quem foi vacinado entra

            usuario.setVacinado(true);// significa que ele está vacinado

            System.out.println();

            System.out.println();
            System.out.println("Vacinas Disponíveis no Brasil:");
            System.out.println();

            do{

                vacines.printNomeVacina();
                vacinaInexistente = false;   
            
            System.out.println();
            System.out.println("Qual destas vacinas foi aplicada em você ?");
            System.out.print("R: ");
            escolhaVacinaQueTomou = sc.nextInt();
            sc.nextLine();

            if(escolhaVacinaQueTomou <= 0 || escolhaVacinaQueTomou >= vacines.getIdLista()){
            // se a resposta for maior que o id da lista, significa que a vacina n existe                
                vacinaInexistente = true;
                System.out.println();
                System.out.println("[ERRO] Vacina inexistente ou não disponível, escolha novamente.");
                System.out.println();

            } else {
                
                ConnectionFactory conexao = new ConnectionFactory();
                conexao.conectar();

                vacinaBuscada = vacines.buscaVacina(escolhaVacinaQueTomou); // pesquisa a vacina tomada pelo id
                System.out.println(vacinaBuscada.getNome());
                usuario.setVacinaTomada(vacinaBuscada); //seta a vacina tomada pelo usuario
                usuario.getVacinaTomada().setQtdPessoasQueSeVacinou(usuario.getVacinaTomada().getQtdPessoasQueSeVacinou()+1); // incrementa a qtd de pessoas que se vacinou em uma determinada vacina
            
                // atualiza os dados de qtdDosesAplicadas da tabela vacina
                conexao.atualizarDados("update vacina set qtdDosesAplicadas = '"
                        +usuario.getVacinaTomada().getQtdPessoasQueSeVacinou()+"' where id = '"+
                                usuario.getVacinaTomada().getId()+"'");
            
            
                conexao.desconectar();
            }    

            } while(vacinaInexistente == true);


            do{ // repete caso o user escolha uma opcao invalida

                repeteParteDeDizerQtsDosesTomou = false;                

            System.out.println();
            System.out.println("[1] - Apenas a primeira dose");
            System.out.println();
            System.out.println("[2] - Primeira e Segunda dose");
            System.out.println();
/*      
            System.out.println("[0] - Nenhuma dose");
            System.out.println(); */

            System.out.print("Quantidade de doses tomadas: ");
            usuario.setQtdDosesTomadas(sc.nextInt());
            sc.nextLine();

            qtdDosesTomadas = usuario.getQtdDosesTomadas(); // responsavel pelas condicoes abaixo

            if(qtdDosesTomadas == 1){

                usuario.setQtdDosesTomadas(qtdDosesTomadas);
                teveOuNaoReacao = reacoesSofridas(usuario); // qual reacao teve

            } else if(qtdDosesTomadas == 2){

                usuario.setQtdDosesTomadas(qtdDosesTomadas);
                teveOuNaoReacao = reacoesSofridas(usuario); // qual reacao teve

            } else {

                repeteParteDeDizerQtsDosesTomou = true;
                System.out.println();
                System.out.println("[ERRO], opção inválida, tente novamente");
                System.out.println();

                
            }

            } while(repeteParteDeDizerQtsDosesTomou);// enquanto for true, essa parte repete

            if(teveOuNaoReacao){ // so chama o metodo se a variavel for true
                dosesQueCausaramReacoes(usuario, qtdDosesTomadas); // em qual dose teve reacoes
                /*o metodo acima tb chama o incrementarQtdDoses*/
            } else {
                /*
                  mesmo nao tendo reacoes, incrementaremos a qtd de doses aplicadas
                  em cada dose
                */
                incrementaQuantidadeDeDosesTomadasPeloUsuario(usuario);
            }
            

                System.out.println();
                System.out.println("Cadastro realizado com sucesso!");
                System.out.println();

                ConnectionFactory conexao = new ConnectionFactory();
                conexao.conectar();

                usuario.getVacinaTomada().setMaximoReacoesGeradas(usuario.getVacinaTomada().getMaximoReacoesGeradas()+usuario.getQtdReacoesSofridas()); // seta o maximo de reacoes da vacina 
            
                //atualiza o maximoDeReacoesGeradas na tabela vacina
                
                conexao.atualizarDados("update vacina set maximoReacoesGeradas = '"+
                        usuario.getVacinaTomada().getMaximoReacoesGeradas()+"' where id = '"
                                +usuario.getVacinaTomada().getId()+"'");
                
                conexao.desconectar();
                
                return usuario;
    }
    
    public static boolean reacoesSofridas(Pessoa userAtual){ // coleta as reacoes e as popula(INACABADO)

        int reacaoEscolhida;
        int naoTeveOutraReacao = 1; // responsavel por parar o laco caso n tiver outra reacao
        int resposta;  
        boolean teveReacao = false; // variavel que sera retornada
        String todasAsReacoesSofridas = ""; 

        // variaveis que não permitirão que o usuario escolha a mesma opcao duas vezes
        boolean escolheuFebre = false;       
        boolean escolheuCalafrio = false;       
        boolean escolheuDorNoCorpo = false;       
        boolean escolheuNausea = false;       
        boolean escolheuFadiga = false;       
        boolean escolheuFaltaDeAr = false;    
        
        
        do {

                System.out.println();
                System.out.println("Você sofreu alguma reação pós vacina? 1 - Sim\t2 - Não");
                System.out.print("R: ");
                resposta = sc.nextInt();
                sc.nextLine();

            if(resposta == 2){ // nao teve 
                break;
            } else if(resposta <= 0 || resposta > 2){ // escolha invalida

                System.out.println();
                System.out.println("[ERRO], opção "+resposta+" inválida, tente novamente.");
                resposta = 1;
                System.out.println();

            } else {

                int teveOuNaoOutraReacao = 0;   
                teveReacao = true;                    
                do {    

                teveOuNaoOutraReacao = 0; // sempre zerar a cada repeticao    

                System.out.println("[1] - Febre");
                System.out.println();
                System.out.println("[2] - Calafrios");
                System.out.println();
                System.out.println("[3] - Dores no corpo");
                System.out.println();
                System.out.println("[4] - Náuseas ou Dores de Cabeça");
                System.out.println();
                System.out.println("[5] - Fadiga");
                System.out.println();
                System.out.println("[6] - Falta de ar");
                System.out.println();
                System.out.println("[7] - Nenhuma");
                System.out.println();            
                System.out.println();           

                System.out.println("Qual reação você teve? (Escolha um número correspondente)");  
                System.out.print("R: ");
                reacaoEscolhida = sc.nextInt();
                sc.nextLine();

                if(reacaoEscolhida == 7){
                    break;
                } else if(reacaoEscolhida <= 0 || reacaoEscolhida > 7){

                    System.out.println();
                    System.out.println("[ERRO], opção "+reacaoEscolhida+" inválida, tente novamente");
                    teveOuNaoOutraReacao = 1;
                    System.out.println();

                } else {


                /* 
                   essas condições abaixo não permite a incrementacao
                   repetida de uma reacao, porque um usuario pode até escolher
                   a mesma reacao mais de uma vez, porém, essa reacao só será
                   incrementada uma única vez por usuario 
                */    
                if(reacaoEscolhida == 1 && !escolheuFebre){ // tornar verdadeiro minhas variaveis booleanas

                    escolheuFebre = true;
                    todasAsReacoesSofridas += "| Febre ";
                    incrementarQuantidadeReacoes(reacaoEscolhida); // incrementaAQtdReacoes
                    
                    // incrementa a qtd de reacoes que o user teve (NOVO)
                    if(userAtual.getQtdReacoesSofridas() <= reactions.getQuantidade()){
                        userAtual.setQtdReacoesSofridas(userAtual.getQtdReacoesSofridas()+1);
                    }
                    
                } else if(reacaoEscolhida == 2 && !escolheuCalafrio){

                    escolheuCalafrio = true;
                    todasAsReacoesSofridas += "| Calafrios ";
                    incrementarQuantidadeReacoes(reacaoEscolhida); // incrementaAQtdReacoes

                    // incrementa a qtd de reacoes que o user teve
                    if(userAtual.getQtdReacoesSofridas() <= reactions.getQuantidade()){
                        userAtual.setQtdReacoesSofridas(userAtual.getQtdReacoesSofridas()+1);
                    }                    

                } else if(reacaoEscolhida == 3 && !escolheuDorNoCorpo){

                    escolheuDorNoCorpo = true;
                    todasAsReacoesSofridas += "| Dor no Corpo ";
                    incrementarQuantidadeReacoes(reacaoEscolhida); // incrementaAQtdReacoes

                    // incrementa a qtd de reacoes que o user teve
                    if(userAtual.getQtdReacoesSofridas() <= reactions.getQuantidade()){
                        userAtual.setQtdReacoesSofridas(userAtual.getQtdReacoesSofridas()+1);
                    }                    

                } else if(reacaoEscolhida == 4 && !escolheuNausea){ 

                    escolheuNausea = true;
                    todasAsReacoesSofridas += "| Náuseas ou Dores de Cabeça ";
                    incrementarQuantidadeReacoes(reacaoEscolhida); // incrementaAQtdReacoes

                    // incrementa a qtd de reacoes que o user teve
                    if(userAtual.getQtdReacoesSofridas() <= reactions.getQuantidade()){
                        userAtual.setQtdReacoesSofridas(userAtual.getQtdReacoesSofridas()+1);
                    }                    

                } else if(reacaoEscolhida == 5 && !escolheuFadiga){

                    escolheuFadiga = true;
                    todasAsReacoesSofridas += "| Fadiga ";
                    incrementarQuantidadeReacoes(reacaoEscolhida); // incrementaAQtdReacoes

                    // incrementa a qtd de reacoes que o user teve
                    if(userAtual.getQtdReacoesSofridas() <= reactions.getQuantidade()){
                        userAtual.setQtdReacoesSofridas(userAtual.getQtdReacoesSofridas()+1);
                    }

                } else if(reacaoEscolhida == 6 && !escolheuFaltaDeAr){
                    
                    escolheuFaltaDeAr = true;
                    todasAsReacoesSofridas += "| Falta de Ar ";
                    incrementarQuantidadeReacoes(reacaoEscolhida); // incrementaAQtdReacoes


                    // incrementa a qtd de reacoes que o user teve
                    if(userAtual.getQtdReacoesSofridas() <= reactions.getQuantidade()){
                        userAtual.setQtdReacoesSofridas(userAtual.getQtdReacoesSofridas()+1);
                    }     

                }  

                System.out.println();            
                System.out.println("Você teve mais alguma reação?  1 - Sim \t 0 - Não");  
                System.out.print("R: ");
                teveOuNaoOutraReacao = sc.nextInt();
                sc.nextLine();  

                //verifica a resposta do usuario se teve mais alguma reacao 
                if(teveOuNaoOutraReacao < 0 || teveOuNaoOutraReacao > 1){

                    System.out.println("Erro, opção "+teveOuNaoOutraReacao+" inválida.");
                    teveOuNaoOutraReacao = 0;

                } else if(teveOuNaoOutraReacao == 0){
                    break;
                }

                }

                } while(teveOuNaoOutraReacao == 1);
                
                if(teveOuNaoOutraReacao == 0){
                    naoTeveOutraReacao = 0; // variavel usada para parar o for principal
                    break;
                } 
            } 

                if(naoTeveOutraReacao == 0){
                    break;
                }
        } while(resposta == 1);       
        
                if(todasAsReacoesSofridas.length() == 0){
                    todasAsReacoesSofridas = "Nenhuma";
                }
        
                userAtual.setReacoesSofridas(todasAsReacoesSofridas);
                return teveReacao;
    }
    
    // Aparentemente tudo ok
    public static boolean prePreenchimentoAutomatico(Pessoa userAtual, String sofreuReacaoSimOuNao, int qtdDosesTomadas, String emQualDoseSofreuReacaoNumeroOrdinalPorExtenso,String...qualReacaoTeve){ // para pré-preenchimento da lista de forma facil ; nome até qtd de vacinas que tomou

        ConnectionFactory conexao = new ConnectionFactory();
        conexao.conectar();
        
        int reacaoEscolhida;
        int respostaSeSofreuReacao;  
        boolean teveReacao = false; // variavel que sera retornada
        String todasAsReacoesSofridas = "";

        userAtual.setVacinado(true);
        

        // variaveis que não permitirão que o usuario escolha a mesma opcao duas vezes
        boolean escolheuFebre = false;       
        boolean escolheuCalafrio = false;       
        boolean escolheuDorNoCorpo = false;       
        boolean escolheuNausea = false;       
        boolean escolheuFadiga = false;       
        boolean escolheuFaltaDeAr = false;   
        
        if(sofreuReacaoSimOuNao.equalsIgnoreCase("sim")){

            respostaSeSofreuReacao = 1;

        } else if(sofreuReacaoSimOuNao.equalsIgnoreCase("nao") || sofreuReacaoSimOuNao.equalsIgnoreCase("não")){
            
            respostaSeSofreuReacao = 2;

        } else {
            
            respostaSeSofreuReacao = 0;

        }


            if(respostaSeSofreuReacao == 2){ // nao teve 

                todasAsReacoesSofridas = "Nenhuma";

            } else if(respostaSeSofreuReacao <= 0 || respostaSeSofreuReacao > 2){ // escolha invalida

                todasAsReacoesSofridas = "Nenhuma";

            } else if(sofreuReacaoSimOuNao.equalsIgnoreCase("sim") && emQualDoseSofreuReacaoNumeroOrdinalPorExtenso.equalsIgnoreCase("nenhuma")){ // se sofreu for sim, mas em qual dose sofreu for nenhuma

                todasAsReacoesSofridas = "Nenhuma";

            } else {

                // entrou aqui...
                teveReacao = true;  

                for(int i = 0; i < qualReacaoTeve.length; i++){ // de acordo com o varargs
                        
                    if(i == qualReacaoTeve.length){
                        break;
                    } else { // maior

                    if(qualReacaoTeve[i].equalsIgnoreCase("Febre") && !escolheuFebre){

                        reacaoEscolhida = 1;
                        escolheuFebre = true;
                        todasAsReacoesSofridas += "| Febre ";
                        
                        incrementarQuantidadeReacoes(reacaoEscolhida); // incrementaAQtdReacoes

                    // incrementa a qtd de reacoes que o user teve (NOVO)
                        if(userAtual.getQtdReacoesSofridas() <= reactions.getQuantidade()){
                            userAtual.setQtdReacoesSofridas(userAtual.getQtdReacoesSofridas()+1);
                        }                        


                    } else if(qualReacaoTeve[i].equalsIgnoreCase("Calafrio") && !escolheuCalafrio){

                        reacaoEscolhida = 2;
                        escolheuCalafrio = true;
                        todasAsReacoesSofridas += "| Calafrios ";
                        incrementarQuantidadeReacoes(reacaoEscolhida); // incrementaAQtdReacoes

                        // incrementa a qtd de reacoes que o user teve (NOVO)
                        if(userAtual.getQtdReacoesSofridas() <= reactions.getQuantidade()){
                            userAtual.setQtdReacoesSofridas(userAtual.getQtdReacoesSofridas()+1);
                        }
                    
                    
                    } else if(qualReacaoTeve[i].equalsIgnoreCase("Dor no corpo") && !escolheuDorNoCorpo){

                        reacaoEscolhida = 3;
                        escolheuDorNoCorpo = true;
                        todasAsReacoesSofridas += "| Dor no Corpo ";
                        incrementarQuantidadeReacoes(reacaoEscolhida); // incrementaAQtdReacoes

                        // incrementa a qtd de reacoes que o user teve (NOVO)
                        if(userAtual.getQtdReacoesSofridas() <= reactions.getQuantidade()){
                            userAtual.setQtdReacoesSofridas(userAtual.getQtdReacoesSofridas()+1);
                        }
                    
                    
                    } else if(qualReacaoTeve[i].equalsIgnoreCase("Náuseas Ou Dores de cabeça") && !escolheuNausea){

                        reacaoEscolhida = 4;
                        escolheuNausea = true;
                        todasAsReacoesSofridas += "| Náuseas ou Dores de Cabeça";
                        incrementarQuantidadeReacoes(reacaoEscolhida); // incrementaAQtdReacoes


                        // incrementa a qtd de reacoes que o user teve (NOVO)
                        if(userAtual.getQtdReacoesSofridas() <= reactions.getQuantidade()){
                            userAtual.setQtdReacoesSofridas(userAtual.getQtdReacoesSofridas()+1);
                        }
                        

                    } else if(qualReacaoTeve[i].equalsIgnoreCase("Fadiga") && !escolheuFadiga){

                        reacaoEscolhida = 5;
                        escolheuFadiga = true;
                        todasAsReacoesSofridas += "| Fadiga ";
                        incrementarQuantidadeReacoes(reacaoEscolhida); // incrementaAQtdReacoes

                        // incrementa a qtd de reacoes que o user teve (NOVO)
                        if(userAtual.getQtdReacoesSofridas() <= reactions.getQuantidade()){
                            userAtual.setQtdReacoesSofridas(userAtual.getQtdReacoesSofridas()+1);
                        }                        

                    } else if(qualReacaoTeve[i].equalsIgnoreCase("Falta de Ar") && !escolheuFaltaDeAr){

                        reacaoEscolhida = 6;
                        escolheuFaltaDeAr = true;
                        todasAsReacoesSofridas += "| Falta de Ar ";
                        incrementarQuantidadeReacoes(reacaoEscolhida); // incrementaAQtdReacoes

                        // incrementa a qtd de reacoes que o user teve (NOVO)
                        if(userAtual.getQtdReacoesSofridas() <= reactions.getQuantidade()){
                            userAtual.setQtdReacoesSofridas(userAtual.getQtdReacoesSofridas()+1);
                        }                        

                    }
                } // ifmaior

                }

            }       
                   
                    /* caso a resposta se teve reacao for sim, mas ele disser que foi em nenhuma dose */
                    if(respostaSeSofreuReacao == 1 && emQualDoseSofreuReacaoNumeroOrdinalPorExtenso.equalsIgnoreCase("Nenhuma")){
                        todasAsReacoesSofridas = "Nenhuma";
                        teveReacao = false;
                    } 

                
                    
                // seta as reacoes sofridas e incrementa a qtd de vacina aplicada naquela vacina        
                userAtual.setReacoesSofridas(todasAsReacoesSofridas);
                userAtual.getVacinaTomada().setQtdPessoasQueSeVacinou(userAtual.getVacinaTomada().getQtdPessoasQueSeVacinou()+1);
                
                // atualiza no banco a qtdDosesAplicadas dessa vacina (OK)
                conexao.atualizarDados("update vacina set qtdDosesAplicadas = "+
                userAtual.getVacinaTomada().getQtdPessoasQueSeVacinou()+" where id = "+
                userAtual.getVacinaTomada().getId()+"");
                
                
                 
                
                
              
                    if(teveReacao){
                        dosesQueCausaramReacoesPreImplementado(userAtual, qtdDosesTomadas, emQualDoseSofreuReacaoNumeroOrdinalPorExtenso);
                    } else {    
                        incrementaQuantidadeDeDosesTomadasPeloUsuario(userAtual);
                    }
                    
                    
                    

                    // seta a qtd maxima de reacoes geradas pela vacina
                    userAtual.getVacinaTomada().setMaximoReacoesGeradas(userAtual.getVacinaTomada().getMaximoReacoesGeradas()+userAtual.getQtdReacoesSofridas()); 
                
                    // atualiza tambem no banco o max
                    conexao.atualizarDados("update vacina set maximoReacoesGeradas = "+
                    userAtual.getVacinaTomada().getMaximoReacoesGeradas()+" where id = "+
                    userAtual.getVacinaTomada().getId()+"");
                    
            conexao.desconectar();

                return teveReacao;
    }

    public static void incrementarQuantidadeReacoes(int reacaoEscolhida){ // aumenta a quantidade de reacoes
        
        //(OK)
        ConnectionFactory conexao = new ConnectionFactory();
        conexao.conectar();
        
        Reacao r = null;
        int idReacao = 0;
        
        // busca no banco
        if(reacaoEscolhida == 1){
              r = conexao.localizarReacao("Febre");  
        } else if(reacaoEscolhida == 2){
              r = conexao.localizarReacao("Calafrios");
        } else if(reacaoEscolhida == 3){
              r = conexao.localizarReacao("Dores no Corpo");
        } else if(reacaoEscolhida == 4){
              r = conexao.localizarReacao("Náuseas ou dores de cabeça");
        } else if(reacaoEscolhida == 5){
              r = conexao.localizarReacao("Fadiga");
        } else if(reacaoEscolhida == 6){
              r = conexao.localizarReacao("Falta de ar"); 
        } else {
            return;
        }   

        // incrementa
             idReacao = r.getId();
             
             r.setQtdPessoasQueTiveramReacoes(r.getQtdPessoasQueTiveramReacoes()+1);
             
             // atualiza no banco de dados
             conexao.atualizarDados("update reacoes set qtdPessoasQueTiveramReacoes = "+
                     r.getQtdPessoasQueTiveramReacoes()+" where id = "+idReacao+"");
             
             conexao.desconectar();
             
             
    }

    public static void incrementaQuantidadeDeDosesTomadasPeloUsuario(Pessoa usuario){ // altera a qtdDosesAplicadas em cada dose
            
               ConnectionFactory conexao = new ConnectionFactory();
               conexao.conectar();
                
               Dose primeira = doses.buscarDose("Primeira");
               Dose segunda = doses.buscarDose("Segunda");
               
               if(usuario.getQtdDosesTomadas() == 2){
                   
                   primeira.setQtdDosesAplicadas(primeira.getQtdDosesAplicadas() + 1);
                   segunda.setQtdDosesAplicadas(segunda.getQtdDosesAplicadas() + 1);
                   
                                       // para a primeira
                    conexao.atualizarDados("update doses set qtdDosesAplicadas = '"
                    +primeira.getQtdDosesAplicadas()+"',qtdDReacoesSomenteNestaDose = '"
                    +primeira.getQtdReacoesSomenteNestaDose()+"',qtdUsuariosQueSofreramReacao = '"
                    +primeira.getQuantidadeDeUsuariosQueSofreramReacao()+"' where id = '"+1+"'");
                    
                    
                    // para a segunda
                    conexao.atualizarDados("update doses set qtdDosesAplicadas = '"
                    +segunda.getQtdDosesAplicadas()+"',qtdDReacoesSomenteNestaDose = '"
                    +segunda.getQtdReacoesSomenteNestaDose()+"',qtdUsuariosQueSofreramReacao = '"
                    +segunda.getQuantidadeDeUsuariosQueSofreramReacao()+"' where id = '"+2+"'"); 
                   
                   
                   
               } else if(usuario.getQtdDosesTomadas() == 1){
                   
                   primeira.setQtdDosesAplicadas(primeira.getQtdDosesAplicadas() + 1); 
                                   
                   // para a primeira
                   conexao.atualizarDados("update doses set qtdDosesAplicadas = '"
                   +primeira.getQtdDosesAplicadas()+"',qtdDReacoesSomenteNestaDose = '"
                   +primeira.getQtdReacoesSomenteNestaDose()+"',qtdUsuariosQueSofreramReacao = '"
                   +primeira.getQuantidadeDeUsuariosQueSofreramReacao()+"' where id = '"+1+"'");
                   
                   
               } else {
                   
                   primeira.setQtdDosesAplicadas(primeira.getQtdDosesAplicadas() + 0);
                   segunda.setQtdDosesAplicadas(segunda.getQtdDosesAplicadas() + 0);
                   
               }
               
                conexao.desconectar();
        
    }
    
    // falta sicronizar com o banco
    public static void dosesQueCausaramReacoes(Pessoa userAtual, int qtdDosesTomadas){ // coleta em qual dose o user sofreu reacao

        ConnectionFactory conexao = new ConnectionFactory();
        conexao.conectar();
        
        
        // precisa indicar em qual vacina foi tb

        int resposta = 0; 
        int escolhaOpcao; 
        
        boolean foiEmAmbas = false;
        boolean soPrimeira = false;
        boolean soSegunda = false;

        Dose primeira = doses.buscarDose("Primeira");
        Dose segunda = doses.buscarDose("Segunda");    

        do {

            if(qtdDosesTomadas == 2){ // se tomou duas doses

                
                incrementaQuantidadeDeDosesTomadasPeloUsuario(userAtual); // novo
                

                System.out.println();
                System.out.println("[1] - Primeira Dose, apenas");
                System.out.println();
                System.out.println("[2] - Segunda Dose, apenas");
                System.out.println();
                System.out.println("[3] - Em ambas as doses");
                System.out.println();
                System.out.println("Em qual das doses você teve reações?");
                System.out.print("R: ");
                escolhaOpcao = sc.nextInt();
                sc.nextLine();

                if(escolhaOpcao <= 0 || escolhaOpcao > 3){ // escolha invalida

                    System.out.println();
                    System.out.println("[ERRO], opção "+resposta+" inválida, tente novamente.");
                    resposta = 1;
                    System.out.println();
    
                } else if(escolhaOpcao == 2) { // somente na segunda

                    soSegunda = true;
                    segunda = doses.buscarDose("Segunda");
    
                    userAtual.setQualDoseSofreuReacao("Segunda, apenas");
                    
                    
                    // somente na segunda
                    segunda.setQuantidadeDeUsuariosQueSofreramReacao(segunda.getQuantidadeDeUsuariosQueSofreramReacao()+1);
                    
                    // somente na segunda
                    segunda.setQtdReacoesSomenteNestaDose(segunda.getQtdReacoesSomenteNestaDose()+userAtual.getQtdReacoesSofridas());

                    //chama o metodo que incrementa em qual dose teve reacao
    
                } else if(escolhaOpcao == 1){ // so na primeira

                    soPrimeira = true;
                    primeira = doses.buscarDose("Primeira");
                    userAtual.setQualDoseSofreuReacao("Primeira, apenas"); // modifica atributo de users
                    
                    
                    //qtd usuarios que sofreram reacao somente na primeira dose 
                    primeira.setQuantidadeDeUsuariosQueSofreramReacao(primeira.getQuantidadeDeUsuariosQueSofreramReacao()+1);
                    
                    // qtd reacoes somente nesta dose
                    primeira.setQtdReacoesSomenteNestaDose(primeira.getQtdReacoesSomenteNestaDose()+userAtual.getQtdReacoesSofridas());
                    break;

                } else if(escolhaOpcao == 3){ // em ambas

                    foiEmAmbas = true;
                    primeira = doses.buscarDose("Primeira");
                    segunda = doses.buscarDose("Segunda");
    
                    userAtual.setQualDoseSofreuReacao("Primeira e Segunda");
                    
                    
                    primeira.setQuantidadeDeUsuariosQueSofreramReacao(primeira.getQuantidadeDeUsuariosQueSofreramReacao()+1);
                    primeira.setQtdReacoesSomenteNestaDose(primeira.getQtdReacoesSomenteNestaDose()+userAtual.getQtdReacoesSofridas());
    
                    segunda.setQuantidadeDeUsuariosQueSofreramReacao(segunda.getQuantidadeDeUsuariosQueSofreramReacao()+1);
                    segunda.setQtdReacoesSomenteNestaDose(segunda.getQtdReacoesSomenteNestaDose() + userAtual.getQtdReacoesSofridas());

                    //chama o metodo que incrementa em qual dose teve reacao
                }


            } else if (qtdDosesTomadas == 1){ // somente na primeira não entrando no switch

                    soPrimeira = true;
                    primeira = doses.buscarDose("Primeira");
                    userAtual.setQualDoseSofreuReacao("Primeira, apenas"); // modifica atributo de users
                    
                    primeira.setQtdDosesAplicadas(primeira.getQtdDosesAplicadas()+1);
                    
                    primeira.setQuantidadeDeUsuariosQueSofreramReacao(primeira.getQuantidadeDeUsuariosQueSofreramReacao()+1);
                    primeira.setQtdReacoesSomenteNestaDose(primeira.getQtdReacoesSomenteNestaDose()+userAtual.getQtdReacoesSofridas());

                //chama o metodo que incrementa em qual dose teve reacao

                break;

            }  
          
        } while(resposta == 1);
        
                    primeira = null;
                    segunda  = null;
                    
                    // verifica em qual foi primeira, segunfa ou ambas
            
            if(foiEmAmbas){
                
                    primeira = doses.buscarDose("Primeira");
                    segunda = doses.buscarDose("Segunda");
                
                    // para a primeira
                    conexao.atualizarDados("update doses set qtdDosesAplicadas = '"
                    +primeira.getQtdDosesAplicadas()+"',qtdDReacoesSomenteNestaDose = '"
                    +primeira.getQtdReacoesSomenteNestaDose()+"',qtdUsuariosQueSofreramReacao = '"
                    +primeira.getQuantidadeDeUsuariosQueSofreramReacao()+"' where id = '"+1+"'");
                    
                    
                    // para a segunda
                    conexao.atualizarDados("update doses set qtdDosesAplicadas = '"
                    +segunda.getQtdDosesAplicadas()+"',qtdDReacoesSomenteNestaDose = '"
                    +segunda.getQtdReacoesSomenteNestaDose()+"',qtdUsuariosQueSofreramReacao = '"
                    +segunda.getQuantidadeDeUsuariosQueSofreramReacao()+"' where id = '"+2+"'");                
            
            } else if(soPrimeira){
                
                    primeira = doses.buscarDose("Primeira");
                
                    // para a primeira
                    conexao.atualizarDados("update doses set qtdDosesAplicadas = '"
                    +primeira.getQtdDosesAplicadas()+"',qtdDReacoesSomenteNestaDose = '"
                    +primeira.getQtdReacoesSomenteNestaDose()+"',qtdUsuariosQueSofreramReacao = '"
                    +primeira.getQuantidadeDeUsuariosQueSofreramReacao()+"' where id = '"+1+"'");                    
                
            } else if(soSegunda){
                    
                    segunda = doses.buscarDose("Segunda");
                
                    // para a primeira
                    conexao.atualizarDados("update doses set qtdDosesAplicadas = '"
                    +segunda.getQtdDosesAplicadas()+"',qtdDReacoesSomenteNestaDose = '"
                    +segunda.getQtdReacoesSomenteNestaDose()+"',qtdUsuariosQueSofreramReacao = '"
                    +segunda.getQuantidadeDeUsuariosQueSofreramReacao()+"' where id = '"+2+"'");  
            
            
            }
            
                    conexao.desconectar();
        
        
    }
    
    // OK
    public static void dosesQueCausaramReacoesPreImplementado(Pessoa userAtual, int qtdDosesTomadas,String emQualDoseSofreuReacaoNumeroOrdinalPorExtenso){ // coleta em qual dose o user sofreu reacao

        ConnectionFactory conexao = new ConnectionFactory();
        conexao.conectar();
        
        boolean foiEmAmbas = false;
        boolean soPrimeira = false;
        boolean soSegunda = false;
        
        
        // precisa indicar em qual vacina foi tb


            Dose primeira = doses.buscarDose("Primeira");
            Dose segunda = doses.buscarDose("Segunda");   
        
            
            // incrementa a qtd de doses aplicadas de acordo com a qtd tomada pelo user
            
            
            incrementaQuantidadeDeDosesTomadasPeloUsuario(userAtual); // novo

            
            primeira = null;
            segunda = null;
            

            // verifica de acordo com a reacao, seta emQualDose sofreu no user e incrementa os valores de doses OK
            if(emQualDoseSofreuReacaoNumeroOrdinalPorExtenso.equalsIgnoreCase("Primeira e Segunda")){ // se tomou duas doses

                    foiEmAmbas = true;
                    
                    primeira = doses.buscarDose("Primeira");
                    segunda = doses.buscarDose("Segunda");
                    
    
                    userAtual.setQualDoseSofreuReacao("Primeira e Segunda");

                    
                    // qtd de usuarios que sofreram reacao nessa dose
                    primeira.setQuantidadeDeUsuariosQueSofreramReacao(primeira.getQuantidadeDeUsuariosQueSofreramReacao()+1);
                    
                    // qtd de reacoes geradas somente nessa dose
                    primeira.setQtdReacoesSomenteNestaDose(primeira.getQtdReacoesSomenteNestaDose()+userAtual.getQtdReacoesSofridas());
                    
                    
                    // qtd de usuarios que sofreram reacao nessa dose
                    segunda.setQuantidadeDeUsuariosQueSofreramReacao(segunda.getQuantidadeDeUsuariosQueSofreramReacao()+1);
                    
                    // qtd de reacoes geradas somente nessa dose
                    segunda.setQtdReacoesSomenteNestaDose(segunda.getQtdDosesAplicadas()+userAtual.getQtdReacoesSofridas());
                    
    
            } else if(emQualDoseSofreuReacaoNumeroOrdinalPorExtenso.equalsIgnoreCase("Primeira")
            || emQualDoseSofreuReacaoNumeroOrdinalPorExtenso.equalsIgnoreCase("Primeira, apenas")){ // so na primeira
                    
                    soPrimeira = true;
                    primeira = doses.buscarDose("Primeira");
                    userAtual.setQualDoseSofreuReacao("Primeira, apenas"); // modifica atributo de users
                    
                    // qtd de usuarios que sofreram reacao nessa dose
                    primeira.setQuantidadeDeUsuariosQueSofreramReacao(primeira.getQuantidadeDeUsuariosQueSofreramReacao()+1);
                    
                    // qtd de reacoes geradas somente nessa dose
                    primeira.setQtdReacoesSomenteNestaDose(primeira.getQtdReacoesSomenteNestaDose()+userAtual.getQtdReacoesSofridas());

              
            } else if(emQualDoseSofreuReacaoNumeroOrdinalPorExtenso.equalsIgnoreCase("Segunda, apenas") || emQualDoseSofreuReacaoNumeroOrdinalPorExtenso.equalsIgnoreCase("Segunda") ){ // somente na segunda dose 

                    soSegunda = true;
                    segunda = doses.buscarDose("Segunda");
                    userAtual.setQualDoseSofreuReacao("Segunda, apenas"); // modifica atributo de users
                    
                    // qtd de usuarios que sofreram reacao nessa dose
                    segunda.setQuantidadeDeUsuariosQueSofreramReacao(segunda.getQuantidadeDeUsuariosQueSofreramReacao()+1);
                    
                    // qtd de reacoes geradas somente nessa dose
                    segunda.setQtdReacoesSomenteNestaDose(segunda.getQtdReacoesSomenteNestaDose()+userAtual.getQtdReacoesSofridas());
                
            } else{                
                    conexao.desconectar();
                    return;
            }
            
            // verifica em qual foi primeira, segunfa ou ambas
            
            if(foiEmAmbas){
                
                    primeira = doses.buscarDose("Primeira");
                    segunda = doses.buscarDose("Segunda");
                
                    // para a primeira
                    conexao.atualizarDados("update doses set qtdDosesAplicadas = '"
                    +primeira.getQtdDosesAplicadas()+"',qtdDReacoesSomenteNestaDose = '"
                    +primeira.getQtdReacoesSomenteNestaDose()+"',qtdUsuariosQueSofreramReacao = '"
                    +primeira.getQuantidadeDeUsuariosQueSofreramReacao()+"' where id = '"+1+"'");
                    
                    
                    // para a segunda
                    conexao.atualizarDados("update doses set qtdDosesAplicadas = '"
                    +segunda.getQtdDosesAplicadas()+"',qtdDReacoesSomenteNestaDose = '"
                    +segunda.getQtdReacoesSomenteNestaDose()+"',qtdUsuariosQueSofreramReacao = '"
                    +segunda.getQuantidadeDeUsuariosQueSofreramReacao()+"' where id = '"+2+"'");                
            
            } else if(soPrimeira){
                
                    primeira = doses.buscarDose("Primeira");
                
                    // para a primeira
                    conexao.atualizarDados("update doses set qtdDosesAplicadas = '"
                    +primeira.getQtdDosesAplicadas()+"',qtdDReacoesSomenteNestaDose = '"
                    +primeira.getQtdReacoesSomenteNestaDose()+"',qtdUsuariosQueSofreramReacao = '"
                    +primeira.getQuantidadeDeUsuariosQueSofreramReacao()+"' where id = '"+1+"'");                    
                
            } else if(soSegunda){
                    
                    segunda = doses.buscarDose("Segunda");
                
                    // para a primeira
                    conexao.atualizarDados("update doses set qtdDosesAplicadas = '"
                    +segunda.getQtdDosesAplicadas()+"',qtdDReacoesSomenteNestaDose = '"
                    +segunda.getQtdReacoesSomenteNestaDose()+"',qtdUsuariosQueSofreramReacao = '"
                    +segunda.getQuantidadeDeUsuariosQueSofreramReacao()+"' where id = '"+2+"'");  
            
            
            }
            
            
                    conexao.desconectar();

    }
    
    public static void estatisticaDasReacoesPosVacina(){ // case 2
        
            ConnectionFactory conexao = new ConnectionFactory();
            conexao.conectar();
        
            ListaReacao reacoes = conexao.listarReacoes();
            ListaPessoa users = conexao.listarUsuarios();
            

            double qtdNaReacaoAtual = 0;
            final double totalDePessoasVacinadas;
            int porcentagemEmCadaReacao = 0;

            System.out.println();
            System.out.println("Estatística de Reações:");
            System.out.println();


            totalDePessoasVacinadas = users.qtdPessoasVacinadas();

            for(NodeReacao n = reacoes.getPrim(); n != null; n = n.getProximo()){ 

                qtdNaReacaoAtual = n.getInformacao().getQtdPessoasQueTiveramReacoes();
                
                porcentagemEmCadaReacao = (int)((qtdNaReacaoAtual/totalDePessoasVacinadas)*100);
                
                System.out.println(n.getInformacao().getTipo()+": "+porcentagemEmCadaReacao+"%");
   
            }
            
                conexao.desconectar();
     
    }

    public static void tiposEQuantitativosDeVacinas(){ // case 3
        
        ConnectionFactory conexao = new ConnectionFactory();
        conexao.conectar();
        
        ListaPessoa users = conexao.listarUsuarios();
        ListaVacina vacines = conexao.listarVacinas();
        
        
        double totalDePessoasVacinadas = users.qtdPessoasVacinadas();
        double qtdPessoasNaVacinaAtual;
        int porcentagemDePessoasACadaVacina;

        
        System.out.println();
        System.out.println("Vacinas disponíveis e porcentagem de vacinados:");
        System.out.println();

        for(NodeVacina n = vacines.getPrim(); n != null; n = n.getProximo()){

            qtdPessoasNaVacinaAtual = n.getInformacao().getQtdPessoasQueSeVacinou();
            porcentagemDePessoasACadaVacina = (int)((qtdPessoasNaVacinaAtual/totalDePessoasVacinadas)*100);
            
            System.out.println(n.getInformacao().getNome() + ": "+porcentagemDePessoasACadaVacina+"%");
            
        }
            System.out.println("");
            System.out.println("");
            
            conexao.desconectar();
    }

    public static void porcentagemDeVacinadosEmRelacaoAoSexo(){

        ConnectionFactory conexao = new ConnectionFactory();
        conexao.conectar();
        
        ListaPessoa users = conexao.listarUsuarios();
        
        
        final double totalVacinados = users.qtdPessoasVacinadas(); // independente do sexo
        double homensVacinados = 0;
        double mulheresVacinadas = 0;

        int porcentagemDeHomensVacinados = 0;
        int porcentagemDeMulheresVacinadas = 0;



        // pega a quantidade de acordo com o sexo
        for(NodePessoa n = users.getPrim(); n != null; n = n.getProximo()){
            if(n.getInformacao().getSexo() == 'M' && n.getInformacao().getVacinado()){ // somente os vacinados
                homensVacinados++;
                porcentagemDeHomensVacinados = (int)((homensVacinados/totalVacinados)*100);
            } else if(n.getInformacao().getSexo() == 'F' && n.getInformacao().getVacinado()){
                mulheresVacinadas++;
                porcentagemDeMulheresVacinadas = (int)((mulheresVacinadas/totalVacinados)*100);
            }
        }
                System.out.println();
                System.out.println("Porcentagem de vacinados em relação ao sexo:");
                System.out.println();
                System.out.println("Homens: "+porcentagemDeHomensVacinados+"%");
                System.out.println("Mulheres: "+porcentagemDeMulheresVacinadas+"%");
                

                System.out.println("");
                System.out.println("");
                
                conexao.desconectar();
    }

    public static void porcentagemDosesAplicadas(){ // case 5
        
            ConnectionFactory conexao = new ConnectionFactory();
            conexao.conectar();
            
            ListaPessoa users = conexao.listarUsuarios();

            double qtdPessoasQueTomaramApenasPrimeiraDose = 0;
            double qtdPessoasQueTomaramDuasDoses = 0;
            double qtdPessoasNaoTomouNenhumaDose = 0;

            double qtdPessoasQueTiveramReacaoSomenteNaPrimeiraDose = 0;
            double qtdPessoasQueTiveramReacaoSomenteNaSegundaDose = 0;
            double qtdPessoasQueNaoTiveramReacaoEmNenhumaDose = 0;
            double qtdPessoasQueTiveramReacaoNasDuasDoses = 0;

            double qtdVacinados = users.qtdPessoasVacinadas();

            int porcentagemPessoasQueTomaramApenasAPrimeiraDose = 0;
            int porcentagemPessoasQueTomaramAsDuasDoses = 0;
            int porcentagemPessoasQueNaoTomaramNenhumaDose = 0;

            int porcentagemQtdReacaoSomenteNaPrimeiraDose = 0;
            int porcentagemQtdReacaoSomenteNaSegundaDose = 0;
            int porcentagemQtdReacaoNasDuasDoses = 0;
            int porcentagemQtdReacaoEmNenhumaDose = 0;


            // coletar dados de acordo com a qtd de doses tomadas:
            for(NodePessoa n = users.getPrim(); n != null; n = n.getProximo()){

                if(n.getInformacao().getQtdDosesTomadas() == 1){ // tomaram só a primeira

                    qtdPessoasQueTomaramApenasPrimeiraDose++;
                    porcentagemPessoasQueTomaramApenasAPrimeiraDose = (int)((qtdPessoasQueTomaramApenasPrimeiraDose/qtdVacinados)*100);

                } else if(n.getInformacao().getQtdDosesTomadas() == 2){ // tomaram as duas doses

                    qtdPessoasQueTomaramDuasDoses++;
                    porcentagemPessoasQueTomaramAsDuasDoses = (int)((qtdPessoasQueTomaramDuasDoses/qtdVacinados)*100);

                } else if(n.getInformacao().getQtdDosesTomadas() == 0){ // nao se vacinou

                    qtdPessoasNaoTomouNenhumaDose++;
                    porcentagemPessoasQueNaoTomaramNenhumaDose = (int)((qtdPessoasNaoTomouNenhumaDose/qtdVacinados)*100);
                    
                }

            }

            // coletar dados de acordo com as reacoes em cada dose
            for(NodePessoa n = users.getPrim(); n != null; n = n.getProximo()){

                if(n.getInformacao().getQualDoseSofreuReacao().equalsIgnoreCase("Primeira, apenas")){

                    qtdPessoasQueTiveramReacaoSomenteNaPrimeiraDose++; // somente primeira
                    porcentagemQtdReacaoSomenteNaPrimeiraDose = (int)((qtdPessoasQueTiveramReacaoSomenteNaPrimeiraDose/qtdVacinados)*100);

                } else if(n.getInformacao().getQualDoseSofreuReacao().equalsIgnoreCase("Primeira e Segunda")){

                    qtdPessoasQueTiveramReacaoNasDuasDoses++; // duas doses
                    porcentagemQtdReacaoNasDuasDoses = (int)((qtdPessoasQueTiveramReacaoNasDuasDoses/qtdVacinados)*100);

                } else if(n.getInformacao().getQualDoseSofreuReacao().equalsIgnoreCase("Segunda, apenas")){

                    qtdPessoasQueTiveramReacaoSomenteNaSegundaDose++; // somente na segunda
                    porcentagemQtdReacaoSomenteNaSegundaDose = (int)((qtdPessoasQueTiveramReacaoSomenteNaSegundaDose/qtdVacinados)*100);

                } else if(n.getInformacao().getQualDoseSofreuReacao().equalsIgnoreCase("Nenhuma")){

                    qtdPessoasQueNaoTiveramReacaoEmNenhumaDose++; // em nenhuma dose
                    porcentagemQtdReacaoEmNenhumaDose = (int)((qtdPessoasQueNaoTiveramReacaoEmNenhumaDose/qtdVacinados)*100);
                    // fiz em nenhuma dose, mas achei desnecessário mostrar, caso precise, está feito!
                }
            }


            //imprimir os dados

            System.out.println();
            System.out.println();
            System.out.println("Dados em relação as doses aplicadas: ");
            System.out.println();

            System.out.println("- Porcentagem dos vacinados de acordo com a dose tomada: ");
            System.out.println();
            System.out.println("Primeira dose: "+porcentagemPessoasQueTomaramApenasAPrimeiraDose+"%");
            System.out.println();
            System.out.println("Primeira e Segunda dose: "+porcentagemPessoasQueTomaramAsDuasDoses+"%");
            System.out.println();
            System.out.println("Não vacinadas: "+porcentagemPessoasQueNaoTomaramNenhumaDose+"%");
            System.out.println();
            System.out.println();

            System.out.println("- Porcentagem das reações de acordo com a dose tomada:");
            System.out.println();
            System.out.println("Somente na primeira dose: "+porcentagemQtdReacaoSomenteNaPrimeiraDose+"%");
            System.out.println();
            System.out.println("Somente na segunda dose: "+porcentagemQtdReacaoSomenteNaSegundaDose+"%");
            System.out.println();
            System.out.println("Em ambas as doses: "+porcentagemQtdReacaoNasDuasDoses+"%");
            System.out.println();
            System.out.println("Em nenhuma dose: "+porcentagemQtdReacaoEmNenhumaDose+"%");
            System.out.println();
            System.out.println();
            
            System.out.println("");
            System.out.println("");
            
            conexao.desconectar();

    }   

    public static void estatisticaDasReacoesComBaseNaIdade(){ // (aparentemente acabado rs)
        
        ConnectionFactory conexao = new ConnectionFactory();
        conexao.conectar();
        
        
        ListaPessoa users = conexao.listarUsuarios();
        
        
        double faixa1 = 0; // (12 a 18 anos)
        double faixa2 = 0; // (19 a 30 anos)
        double faixa3 = 0; // (31 a 45 anos) 
        double faixa4 = 0; // (46 a 80 anos)
        double totalVacinados = users.qtdPessoasVacinadas();

        int porcentagemFaixa1 = 0;
        int porcentagemFaixa2 = 0;
        int porcentagemFaixa3 = 0;
        int porcentagemFaixa4 = 0;

        for(NodePessoa n = users.getPrim(); n != null; n = n.getProximo()){

            if(!n.getInformacao().getVacinado()){ // ignora quem não foi vacinado
                
                continue;

            } else if(n.getInformacao().getReacoesSofridas().equalsIgnoreCase("Nenhuma")){ // se foi vacinado mas nao apresentou nenhuma reacao

                continue;

            } else {


                if(n.getInformacao().getIdade() >= 12 && n.getInformacao().getIdade() <= 18){
                    faixa1++;
                    porcentagemFaixa1 = (int)((faixa1/totalVacinados)*100);
                } else if(n.getInformacao().getIdade() <= 30){
                    faixa2++;
                    porcentagemFaixa2 = (int)((faixa2/totalVacinados)*100);
                } else if(n.getInformacao().getIdade() <= 45){
                    faixa3++;
                    porcentagemFaixa3 = (int)((faixa3/totalVacinados)*100);
                } else {
                    faixa4++;
                    porcentagemFaixa4 = (int)((faixa4/totalVacinados)*100);
                }

            }
                    
        }

        System.out.println();
        System.out.println("Porcentagem das reações pós vacina com base na faixa etária: ");
        System.out.println();

        System.out.println();
        System.out.println("12 a 18 anos: "+porcentagemFaixa1+"%");
        System.out.println();
        System.out.println("19 a 30 anos: "+porcentagemFaixa2+"%");
        System.out.println();
        System.out.println("31 a 45 anos: "+porcentagemFaixa3+"%");
        System.out.println();
        System.out.println("Acima de 45 anos: "+porcentagemFaixa4+"%");
        System.out.println();
        System.out.println();


        /* 
        
            o calculo n mostra 100 % pq sempre sobra uma
            margem daqueles que não tiveram reação ou
            não se vacinaram
        
        */
        
            System.out.println("");
            System.out.println("");
            
            conexao.desconectar();

    }

    public static void porcentagemDeVacinasQueCausaramMaisReacoes(){

        ConnectionFactory conexao = new ConnectionFactory();
        conexao.conectar();
        
        ListaVacina vacines = conexao.listarVacinas();
        
        /* 
        
        Soma todas as qtds de reacoes em cada pessoa, de acordo
        com a vacina tomada
        
        */

        //Vacina vacinaAtual = null;
        final double maximaTotal = vacines.totalDeReacaoGerada();
        double qtdReacoesNaVacinaAtual = 0;
        int porcentagemReacoesGeradas = 0;

            System.out.println();
            System.out.println("Porcentagem de reações geradas por cada vacina:");
            System.out.println();

        for(NodeVacina n = vacines.getPrim(); n != null; n = n.getProximo()){

            if(n.getInformacao().getQtdPessoasQueSeVacinou() > 0){ // so retorna doses que foram aplicadas

            qtdReacoesNaVacinaAtual = n.getInformacao().getMaximoReacoesGeradas();
            porcentagemReacoesGeradas = (int)((qtdReacoesNaVacinaAtual/maximaTotal)*100);

            System.out.print("- "+n.getInformacao().getNome()+": "+porcentagemReacoesGeradas+"%");
            System.out.println();

            } else {
                continue;
            }
        }
                System.out.println("");
                System.out.println("");
                
                conexao.desconectar();

    }
     
}
