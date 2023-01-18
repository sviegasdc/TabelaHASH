import java.util.ArrayList;

public class Hash {
  private ArrayList<No> TabelaH;
  private double alfa;
  // é a razão entre o número de elementos armazenados na tabela hash e o tamanho total da tabela

  public Hash(double alfa){
      this.alfa = alfa;
  }

    //Insert
  public No inserir(int chave, Object elemento){
      //Linear Probing
      int posicao = posicaoDoNo(chave);
      while (TabelaH.get(posicao) != null) {
          posicao = (posicao + 1) % 13;
          // fator de dispersão
      }
      No novoNo = new No(chave, elemento);
      // criando o novo No
      TabelaH.set(posicao, novoNo);
      // adicionando o No Tabela usando a função de dispersão para encontrar o index onde ela será adicionada
      return novoNo;
  }

  public int posicaoDoNo(int chave){
      int posicao = chave % 13;
      return posicao;
  }

  //Remove
  public No remover(int chave){
      No noRemovido = null;
      int posicao = posicaoDoNo(chave);
      while (TabelaH.get(posicao) !=null){
          if(TabelaH.get(posicao).getChave() == chave){
              noRemovido = TabelaH.get(posicao);
              // setar como AVAILABLE
              noRemovido.setElemento("AVAILABLE");
//              noRemovido.setChave(-1);
          }
      }

      return noRemovido;
  }

  //Pesquisa




  //Double Hash

  //ReHash
  // aparentemente tem que usar array normal

}
