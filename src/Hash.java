
public class Hash {
  private No[] TabelaH;
  private double alfa;
  private int tamanho;
  private int numeroDeElemetos;
  // é a razão entre o número de elementos armazenados na tabela hash e o tamanho total da tabela

  public Hash(int tamanho){
      this.tamanho = tamanho;
      this.TabelaH = new No[tamanho];
      this.alfa = 0.0;
      int numeroDeElemetos = 0;
  }

    //Insert
  public No inserir(int chave, Object elemento){
      if(fatorDeCarga() > 0.8){
          System.out.println("Fator de carga chegou a maior de 0.8, executando o Rehash");
          ReHash();
      }
      //Linear Probing
      int posicao = posicaoDoNo(chave);
      while (TabelaH[posicao] != null) {
          if(TabelaH[posicao].getElemento() != "AVAILABLE" ){
              // enquanto estiver ocupado (e sem o available)
              posicao = (posicao + 1) % 13;
              // fator de dispersão
          }
      }
      No novoNo = new No(chave, elemento);
      // criando o novo No
      numeroDeElemetos++;
      // contar o número de elementos no array
      TabelaH[posicao] = novoNo;
      // adicionando o No na Tabela usando a função de dispersão para encontrar o index onde ela será adicionada
      return novoNo;
  }

  public No inserirComDH(int chave, Object elemento){
      if(fatorDeCarga() > 0.8){
          System.out.println("Fator de carga chegou a maior de 0.8, executando o Rehash");
          ReHashDH();
      }
      //Double Hash
      int posicao = posicaoDoNo(chave);
      int posicaoDH = 7 - chave % 7;
      while(TabelaH[posicao] != null){
      if( TabelaH[posicao].getElemento() != "AVAILABLE" ) {
          // enquanto estiver ocupado (e sem o available)
          posicao = (posicao + posicaoDH) % tamanho;
          // fator de dispersão
          }
      }
      No novoNo = new No(chave, elemento);
      // criando o novo No
      numeroDeElemetos++;
      // contar o número de elementos no array
      TabelaH[posicao] = novoNo;
      // adicionando o No na Tabela usando a função de dispersão para encontrar o index onde ela será adicionada
      return novoNo;
  }


  public int posicaoDoNo(int chave){
      int posicao = chave % 13;
      return posicao;
  }

  public double fatorDeCarga(){
       return alfa = (double) numeroDeElemetos / tamanho;
  }

  //Remove
  public No remover(int chave){
      No noRemovido = null;
      int posicao = posicaoDoNo(chave);
      while (TabelaH[posicao] !=null){
          if(TabelaH[posicao].getChave() == chave){
              noRemovido = TabelaH[posicao];
              // setar como AVAILABLE
              noRemovido.setElemento("AVAILABLE");
              noRemovido.setChave(-1);
          }
      }

      return noRemovido;
  }

  //Pesquisa
  public Object pesquisa(int chave) throws NO_SUCH_KEY {
      int posicao = posicaoDoNo(chave);
      int lProbing = 0;
      while(lProbing <= tamanho){
        No noAtual = TabelaH[posicao];
        if(noAtual == null){
            throw new NO_SUCH_KEY("Não existe essa chave na tabela hash");
        }
        else if(noAtual.getChave() == chave){
            return noAtual.getElemento();
        }
        else{
            posicao = (posicao + 1) % tamanho;
            lProbing++;
        }
      }
      return null;
  }


  //ReHash
  public void ReHash(){
      No[] novaTabela = new No[tamanho * 2];
      for (int i = 0; i < tamanho; i++) {
          if (TabelaH[i] != null) {
              int chave = TabelaH[i].getChave();
              int posicao = posicaoDoNo(chave);
              while (novaTabela[posicao] != null) {
                  posicao = (posicao + 1) % (tamanho * 2);
              }
              novaTabela[posicao] = TabelaH[i];
          }
      }
      TabelaH = novaTabela;
      tamanho = tamanho * 2;
  }

  public void ReHashDH(){
      No[] novaTabela = new No[tamanho * 2];
      // criando um array com o tamanho duplicado do primeiro
      for (int i = 0; i < tamanho; i++) {
          // fazendo o loop para copiar os nos para o novo array
          if (TabelaH[i] != null) {
              int chave = TabelaH[i].getChave();
              // fazendo as dispersões do Duplo Hashing
              int posicao = posicaoDoNo(chave);
              int posicaoDH = 7 - chave % 7;

              if (novaTabela[posicao] != null) {
                  posicao = (posicao + posicaoDH) % (tamanho * 2);
              }
              novaTabela[posicao] = TabelaH[i];
          }
      }
      TabelaH = novaTabela;
      tamanho = tamanho * 2;
  }


  public void mostraHash(){
      for(int i = 0; i < tamanho; i++){
          if(TabelaH[i] != null){
              System.out.println("chave = " + TabelaH[i].getChave() + ", elemento = "+ TabelaH[i].getElemento() + ", index = " + i);
          }
      }
  }

}
