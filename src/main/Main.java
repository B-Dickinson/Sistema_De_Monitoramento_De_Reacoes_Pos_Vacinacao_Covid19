package main;

import controller.*;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Controller controller = new Controller();


        try{


        int escolhaOpcaoMenu = 0;
        int voltarMenuOuNao = 0;

        do{

            escolhaOpcaoMenu = controller.menuDeOpcoes();

            do{

                switch(escolhaOpcaoMenu){
                    case 1:
                        controller.users.add(controller.cadastroDeUsuario()); // retorna um user para  a lista
                    break;
                    case 2:
                        controller.estatisticaDasReacoesPosVacina();   
                    break;
                    case 3:
                        controller.tiposEQuantitativosDeVacinas();
                    break;
                    case 4:
                        controller.porcentagemDeVacinadosEmRelacaoAoSexo();
                    break;
                    case 5:
                        controller.porcentagemDosesAplicadas();
                    break;
                    case 6:
                        controller.estatisticaDasReacoesComBaseNaIdade();
                    break;
                    case 7:
                        controller.porcentagemDeVacinasQueCausaramMaisReacoes();
                    break;
                    case 8:
                        System.out.println("Programa finalizado, volte sempre");
                        System.out.println();
                        System.exit(0);                        
                    break;
                    default:
                        System.out.println("Opção inválida");    
                }


                        System.out.println();

                        System.out.println("O que deseja?");
                        System.out.println();
                        System.out.println("[1] - Voltar ao menu\t[0] - Sair");
                        System.out.println();
                        System.out.print("R: ");
                        voltarMenuOuNao = sc.nextInt();
                        sc.nextLine();

                        System.out.println();

                        if(voltarMenuOuNao > 1 || voltarMenuOuNao < 0){
                            System.out.println();
                            System.out.println("Opção inválida, tente novamente");
                            System.out.println();
                            voltarMenuOuNao = 1;
                        } else if (voltarMenuOuNao == 0) {
                            escolhaOpcaoMenu = 8; // não volta para o menu
                            break;
                        } else {
                            break;
                        }
                    
            } while(voltarMenuOuNao == 1); 
         

        } while(escolhaOpcaoMenu != 8);
        
            System.out.println();
            System.out.println("Fim da execução!");
            System.out.println();
            sc.close();

        } catch(Exception e){ // tratar erro
            System.out.println();
            e.printStackTrace();
            System.out.println("Ops, você digitou uma opção inválida. Tente novamente mais tarde"+e);
            System.out.println();
            sc.close();
        }     
    }


 
}
