package bean;

public class NodeDose {
    
      private Dose informacao;
      private NodeDose proximo;

      public Dose getInformacao() {
          return informacao;
      }

      public void setInformacao(Dose informacao) {
          this.informacao = informacao;
      }

      public NodeDose getProximo() {
          return proximo;
      }

      public void setProximo(NodeDose proximo) {
          this.proximo = proximo;
      } 
      
      
}
