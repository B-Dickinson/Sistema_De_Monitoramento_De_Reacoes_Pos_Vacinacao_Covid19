package factory;

import bean.*;
import java.sql.*;


import javax.swing.JOptionPane;


public class ConnectionFactory {
    
    
        public ConnectionFactory(){
           
        }
    
    
        private final String driver = "org.gjt.mm.mysql.Driver";
        private final String url = "jdbc:mysql://localhost:3306/projetoap3?"+"autoReconnect=true&useSSL=false"; // para não receber avisos SSL
        private final String user = "root";
        private final String password = "";
        private Connection conexao;
        
        
    public boolean conectar(){
                boolean result = true;
                
            try {
                
                Class.forName(driver);
                
                this.conexao = (Connection) DriverManager.getConnection(url, user, password);
                
                System.out.println("Conexão criada com sucesso!");
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"[ERRO] Driver não localizado"+ex);
                System.out.println("[ERRO] Driver não localizado"+ex);
                result = false;
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null,"[ERRO] Erro de conexão com o SGBD"+e);
                System.out.println("[ERRO] Erro de conexão com o SGBD"+e);
                result = false;
            }
            
            
                return result;
    }  
    
    public boolean desconectar(){
                boolean result = true;
       
            try {
                
                
                conexao.close();
                
                System.out.println("Conexão encerrada!");
                

            } catch (SQLException ex) {
                System.out.println("Não foi possível encerrar a conexão com o SGBD"+ex);
                result = false;
            }
                return result;
    }
        
    public boolean inserirUsuario(Pessoa usuario){
        
                boolean retorno = true;
                boolean vacinadoOuNao = true;
                String instrucao = "";
                
                 
                if(!usuario.getVacinado()){
                    vacinadoOuNao = false;
                }
                
        
            try {
                
                
                
                if(vacinadoOuNao){ // estando vacinado... 
                    
                    // criamos as variaveis
                    String nome = usuario.getNome();
                    int idade = usuario.getIdade();
                    char sexo = usuario.getSexo();
                    String bairro = usuario.getBairro();
                    String vacina = usuario.getVacinaTomada().getNome();
                    int qtdDosesTomadas = usuario.getQtdDosesTomadas();
                    String reacoesSofridas = usuario.getReacoesSofridas();
                    int qtdReacoesSofridas = usuario.getQtdReacoesSofridas();
                    String qualDoseSofreuReacao = usuario.getQualDoseSofreuReacao();
                    boolean vacinado = usuario.getVacinado();
                    
                    String msgSucesso = ("Usuário: "+nome+" cadastrado com sucesso!");
                    
                    String sql = "insert into pessoa values(default,'"+nome+"','"+idade+"','"+sexo+"','"+bairro+"','"
                    +vacina+"','"+qtdDosesTomadas+"','"+reacoesSofridas+"','"+qtdReacoesSofridas+"','"
                    +qualDoseSofreuReacao+"',"+vacinado+")"; 
                    
                    PreparedStatement ps = conexao.prepareStatement(sql);
                    instrucao = sql;
                    
                    ps.execute();
                    ps.close();
                
                    //JOptionPane.showMessageDialog(null,msgSucesso);
                    System.out.println(msgSucesso); 
                
                } else { // usuario nao vacinado
                    
                    
                    
                    String nome = usuario.getNome();
                    int idade = usuario.getIdade();
                    char sexo = usuario.getSexo();
                    String bairro = usuario.getBairro();
                    boolean vacinado = usuario.getVacinado();
                    
                    String msgSucesso = ("Usuário: "+nome+" cadastrado com sucesso!");
                    
                    String sql = "insert into pessoa(id,nome,idade,sexo,bairro,estaVacinado) values(default,'"
                    +nome+"','"+idade+"','"+sexo+"','"+bairro+"',"+vacinado+")";
                    
                    PreparedStatement ps = conexao.prepareStatement(sql);
                    instrucao = sql;
                    
                    ps.execute();
                    ps.close();
                
                    //JOptionPane.showMessageDialog(null,msgSucesso);
                    System.out.println(msgSucesso); 
                    
                }
                
                
                
                
            } catch (SQLException ex) {
                String msgErro = ("Não foi possível executar o comando: "+instrucao+" | "+ex);
                JOptionPane.showMessageDialog(null,msgErro);
                retorno = false;
            }
                return retorno;
        
    }
    
    public boolean inserirVacina(Vacina vacina){
        boolean retorno = true;
        String instrucao = "";
        
                String nome = vacina.getNome();
                String fabricante = vacina.getFabricante();
                Double eficacia = vacina.getEficacia();
                String reacoesAdversas = vacina.getReacoesAdversas();
                int qtdDosesAplicadas = vacina.getQtdPessoasQueSeVacinou();
                int maxReacoesGeradas = vacina.getMaximoReacoesGeradas();
        
            try {

                
                String msgSucesso = ("Vacina: "+nome+" cadastrada com sucesso!");
                
                String sql = "insert into vacina values(default,'"+nome+"','"+fabricante+"','"+eficacia+"','"
                        +reacoesAdversas+"','"+qtdDosesAplicadas+"','"+maxReacoesGeradas+"')";
                
                
                
                instrucao = sql;
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                ps.execute();
                ps.close();
                
                //JOptionPane.showMessageDialog(null,msgSucesso);
                System.out.println(msgSucesso); 
                
            } catch (SQLException ex) {
                String msgErro = ("Não foi possível executar o comando: "+instrucao+" | "+ex);
                JOptionPane.showMessageDialog(null,msgErro);
                retorno = false;               
            }
            
        return retorno;

    }
    
    public boolean inserirDoses(Dose dose){
        
            boolean retorno = true;
            String instrucao = "";
            
            String numero = dose.getNumeroOrdinalPorExtensoDaDose();
            int qtdDosesAplicadas = dose.getQtdDosesAplicadas();
            int qtdDosesSomenteAqui = dose.getQtdReacoesSomenteNestaDose();
            int qtdPessoasSofreramReacao = dose.getQuantidadeDeUsuariosQueSofreramReacao();
            
            try {
                
                String msgSucesso = ("Dose: "+numero+" cadastrada com sucesso!");
                
                String sql = "insert into doses values(default,'"+numero+"','"+qtdDosesAplicadas+"','"
                              +qtdDosesSomenteAqui+"','"+qtdPessoasSofreramReacao+"')";
                
                
                instrucao = sql;
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                ps.execute();
                ps.close();
                
                
                //JOptionPane.showMessageDialog(null,msgSucesso);
                System.out.println(msgSucesso); 
                
            } catch (SQLException ex) {
                String msgErro = ("Não foi possível executar o comando: "+instrucao+" | "+ex);
                JOptionPane.showMessageDialog(null,msgErro);
                retorno = false;
            } 
        
                return retorno;
    }
    
    public boolean inserirReacao(Reacao reacao){
            boolean retorno = true;
            String instrucao = "";
            
            String tipo = reacao.getTipo();
            int qtdPessoasQueTiveram = reacao.getQtdPessoasQueTiveramReacoes();
            
            try {
                
                String msgSucesso = ("Reação: "+tipo+" cadastrada com sucesso!");

                String sql = "insert into reacoes values(default,'"+tipo+"','"+qtdPessoasQueTiveram+"')";
                PreparedStatement ps = conexao.prepareStatement(sql);
                instrucao = sql;
                
                ps.execute();
                ps.close();
                
                //JOptionPane.showMessageDialog(null, msgSucesso);
                System.out.println(msgSucesso); 
                
                
            } catch (SQLException ex) {
                String msgErro = ("Não foi possível executar o comando: "+instrucao+" | "+ex);
                JOptionPane.showMessageDialog(null,msgErro);
                retorno = false;
            }
                
                return retorno;
        
    }
    
    public Vacina localizarVacina(String nomeVacina){
        
                Vacina vacina = new Vacina();
                String sql = "select * from vacina where nome = ?";
                String instrucao = "";
                String msgSucesso = "";
                ResultSet rs;
        
            try {
                
                instrucao = sql;
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                ps.setString(1, nomeVacina);
                rs = ps.executeQuery();
                
                if(rs.next()){
                    
                    vacina.setId(rs.getInt("id"));
                    vacina.setNome(rs.getString("nome"));
                    vacina.setFabricante(rs.getString("fabricante"));
                    vacina.setEficacia(rs.getDouble("eficacia"));
                    vacina.setReacoesAdversas(rs.getString("reacoesAdversas"));
                    vacina.setQtdPessoasQueSeVacinou(rs.getInt("qtdDosesAplicadas"));
                    vacina.setMaximoReacoesGeradas(rs.getInt("maximoReacoesGeradas"));
                    
                }
                
                rs.close();
                ps.close();
                
                    msgSucesso = "Busca realizada com sucesso!";
                    //JOptionPane.showMessageDialog(null,msgSucesso);
                    System.out.println(msgSucesso); 
                
                
            } catch (SQLException ex) {
                
                String msgErro = ("Não foi possível executar o comando: "+instrucao+" | "+ex);
                JOptionPane.showMessageDialog(null,msgErro);
                vacina = null;
                
            }
            
                return vacina;
    }
    
    public Pessoa localizarUsuario(int idUsuario){
        
                Pessoa retorno = new Pessoa();
                String sql;
                String instrucao = "";
                String msgSucesso = "Usuário localizado!";
                ResultSet res;
                
            try {
                
                sql = "select * from pessoa where id = ?";
                instrucao = sql;
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                ps.setInt(1, idUsuario);
                res = ps.executeQuery();
                
                if(res.next()){
                    
                    retorno.setId(res.getInt("id"));
                    retorno.setNome(res.getString("nome"));
                    retorno.setIdade(res.getInt("idade"));
                    retorno.setSexo(res.getString("sexo").charAt(0));
                    retorno.setBairro(res.getString("bairro"));
                    
                    Vacina vacinaTomada = localizarVacina(res.getString("vacinaTomada"));
                    retorno.setVacinaTomada(vacinaTomada);
                    
                    retorno.setQtdDosesTomadas(res.getInt("qtdDosesTomadas"));
                    retorno.setReacoesSofridas(res.getString("reacoesSofridas"));
                    retorno.setQtdDosesTomadas(res.getInt("qtdDosesTomadas"));
                    retorno.setQtdReacoesSofridas(res.getInt("qtdReacoesSofridas"));
                    retorno.setQualDoseSofreuReacao(res.getString("qualDoseSofreuReacao"));
                    retorno.setVacinado(res.getBoolean("estaVacinado"));
                }
                
                ps.close();
                res.close();
                
                //JOptionPane.showMessageDialog(null,msgSucesso); 
                System.out.println(msgSucesso);
                
                 
            } catch (SQLException ex) {
                
                String msgErro = ("Não foi possível executar o comando: "+instrucao+" | "+ex);
                JOptionPane.showMessageDialog(null,msgErro);
                retorno = null;
                
            }
                return retorno;
    }
 
    public Reacao localizarReacao(String tipo){
        
            Reacao r = new Reacao();
            String instrucao = "";
            ResultSet rs;
        
        
            try {
                String msgSucesso = "";
                String sql = "select * from reacoes where tipo = ?";
                instrucao = sql;
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                ps.setString(1, tipo);
                
                rs = ps.executeQuery();
                
                if(rs.next()){
                    
                    r.setId(rs.getInt("id"));
                    r.setTipo(rs.getString("tipo"));
                    r.setQtdPessoasQueTiveramReacoes(rs.getInt("qtdPessoasQueTiveramReacoes"));
                    
                }
                
                rs.close();
                ps.close();
                
                msgSucesso = "Reação localizada com sucesso!";
                //JOptionPane.showMessageDialog(null,msgSucesso);
                System.out.println(msgSucesso);
                
                
            } catch (SQLException ex) {
                
                String msgErro = ("Não foi possível executar o comando: "+instrucao+" | "+ex);
                //JOptionPane.showMessageDialog(null,msgErro);
                System.out.println(msgErro);
                r = null;
                
            }
            
                return r;
        
    }
    
    public Dose localizarDose(String numeroOrdinalDose){
            
            Dose dose = new Dose();
            String instrucao = "";
            ResultSet rs;
        
            try {
                String msgSucesso = "";
                String sql = "select * from doses where numeroOrdinalDose = ?";
                instrucao = sql;
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                ps.setString(1, numeroOrdinalDose);
                
                rs = ps.executeQuery();
                
                if(rs.next()){
                    dose.setId(rs.getInt("id"));
                    dose.setNumeroOrdinalPorExtensoDaDose(rs.getString("numeroOrdinalDose"));
                    dose.setQtdDosesAplicadas(rs.getInt("qtdDosesAplicadas"));
                    dose.setQtdReacoesSomenteNestaDose(rs.getInt("qtdDReacoesSomenteNestaDose"));
                    dose.setQuantidadeDeUsuariosQueSofreramReacao(rs.getInt("qtdUsuariosQueSofreramReacao"));
                }
                
                rs.close();
                ps.close();
                
                msgSucesso = "Dose localizada com sucesso!";
                //JOptionPane.showMessageDialog(null,msgSucesso);
                System.out.println(msgSucesso);
                
                
                
            } catch (SQLException ex) {
                
                String msgErro = ("Não foi possível executar o comando: "+instrucao+" | "+ex);
                JOptionPane.showMessageDialog(null,msgErro);
                System.out.println(msgErro);
                dose = null;
                
            }
        
                return dose;
    }
    
    public boolean atualizarDados(String sql){
        
                boolean retorno = true;
                String instrucao = "";
                
            try {
                
                String msgSucesso = ("Comando realizado com sucesso!");
                instrucao = sql;
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                ps.executeUpdate();
                ps.close();
                
                //JOptionPane.showMessageDialog(null,msgSucesso);
                System.out.println(msgSucesso); 
                
                
            } catch (SQLException ex) {
                String msgErro = ("Não foi possível executar o comando: "+instrucao+" | "+ex);
                JOptionPane.showMessageDialog(null,msgErro);
                retorno = false;
            }
            
                return retorno;
    }
    
    public ListaReacao listarReacoes(){
        
                String instrucao = "";
                ListaReacao retorno = new ListaReacao();
                ResultSet rs;
        
            try {
                
                String msgSucesso = "Comando realizado com sucesso!";
                
                String sql = "select * from reacoes";
                instrucao = sql;
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                rs = ps.executeQuery();
                
                while(rs.next()){
                    
                    Reacao r = new Reacao();
                    r.setId(rs.getInt("id"));
                    r.setTipo(rs.getString("tipo"));
                    r.setQtdPessoasQueTiveramReacoes(rs.getInt("qtdPessoasQueTiveramReacoes"));
                    
                    retorno.add(r);
                    
                }
                    
                    rs.close();
                    ps.close();
                
                    System.out.println(msgSucesso);
                    
            } catch (SQLException ex) {
                String msgErro = ("Não foi possível executar o comando: "+instrucao+" | "+ex);
                JOptionPane.showMessageDialog(null,msgErro);
                retorno = null;
            }
                return retorno;
    }
    
    public ListaDoses listarDoses(){
        
                String instrucao = "";
                ListaDoses retorno = new ListaDoses();
                ResultSet rs;
        
            try {
                
                String msgSucesso = "Comando realizado com sucesso!";
                
                String sql = "select * from doses";
                instrucao = sql;
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                rs = ps.executeQuery();
                
                while(rs.next()){
                    
                    Dose d = new Dose();
                    d.setId(rs.getInt("id"));
                    d.setNumeroOrdinalPorExtensoDaDose(rs.getString("numeroOrdinalDose"));
                    d.setQtdDosesAplicadas(rs.getInt("qtdDosesAplicadas"));
                    d.setQtdReacoesSomenteNestaDose(rs.getInt("qtdDReacoesSomenteNestaDose"));
                    d.setQuantidadeDeUsuariosQueSofreramReacao(rs.getInt("qtdUsuariosQueSofreramReacao"));
                    
                    retorno.add(d);
                    
                }
                    
                    rs.close();
                    ps.close();
                
                    System.out.println(msgSucesso);
                    
            } catch (SQLException ex) {
                String msgErro = ("Não foi possível executar o comando: "+instrucao+" | "+ex);
                JOptionPane.showMessageDialog(null,msgErro);
                retorno = null;
            }
                return retorno;
    }
    
    public ListaPessoa listarUsuarios(){
        
                String instrucao = "";
                ListaPessoa retorno = new ListaPessoa();
                ResultSet rs;
        
            try {
                
                String msgSucesso = "Comando realizado com sucesso!";
                
                String sql = "select * from pessoa";
                instrucao = sql;
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                rs = ps.executeQuery();
                
                while(rs.next()){
                    
                    Pessoa p = new Pessoa();
                    
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setIdade(rs.getInt("idade"));
                    p.setSexo(rs.getString("sexo").charAt(0));
                    p.setBairro(rs.getString("bairro"));
                    
                    Vacina v = localizarVacina(rs.getString("vacinaTomada"));
                    p.setVacinaTomada(v);
                    
                    p.setQtdDosesTomadas(rs.getInt("qtdDosesTomadas"));
                    p.setReacoesSofridas(rs.getString("reacoesSofridas"));
                    p.setQtdReacoesSofridas(rs.getInt("qtdReacoesSofridas"));
                    p.setQualDoseSofreuReacao(rs.getString("qualDoseSofreuReacao"));
                    p.setVacinado(rs.getBoolean("estaVacinado"));
                    
                    retorno.add(p);
                    
                }
                    
                    rs.close();
                    ps.close();
                
                    System.out.println(msgSucesso);
                    
            } catch (SQLException ex) {
                String msgErro = ("Não foi possível executar o comando: "+instrucao+" | "+ex);
                JOptionPane.showMessageDialog(null,msgErro);
                retorno = null;
            }
                return retorno;
    }
    
    public ListaVacina listarVacinas(){
        
                String instrucao = "";
                ListaVacina retorno = new ListaVacina();
                ResultSet rs;
        
            try {
                
                String msgSucesso = "Comando realizado com sucesso!";
                
                String sql = "select * from vacina";
                instrucao = sql;
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                rs = ps.executeQuery();
                
                while(rs.next()){
                    
                    Vacina v = new Vacina();
                    
                    v.setId(rs.getInt("id"));
                    v.setNome(rs.getString("nome"));
                    v.setFabricante(rs.getString("fabricante"));
                    v.setEficacia(rs.getDouble("eficacia"));
                    v.setReacoesAdversas(rs.getString("reacoesAdversas"));
                    v.setQtdPessoasQueSeVacinou(rs.getInt("qtdDosesAplicadas"));
                    v.setMaximoReacoesGeradas(rs.getInt("maximoReacoesGeradas"));
                    
                    retorno.add(v);
                    
                }
                    
                    rs.close();
                    ps.close();
                
                    System.out.println(msgSucesso);
                    
            } catch (SQLException ex) {
                String msgErro = ("Não foi possível executar o comando: "+instrucao+"\t|\t"+ex);
                JOptionPane.showMessageDialog(null,msgErro);
                retorno = null;
            }
                return retorno;
    }

// Listar as outras tabelas/....
}
