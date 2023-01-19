public class Main {
    public static void main(String[] args) {
        Hash TabelaH = new Hash(10);

        TabelaH.inserir(1,"dog");
        TabelaH.inserir(2,"auaua");
//        TabelaH.inserir(34,"iguana");
//        TabelaH.inserir(18,"furão");
//        TabelaH.inserir(7,"bearcum");
//        TabelaH.inserir(15,"chain");
//        TabelaH.inserir(5,"cat");
//        TabelaH.inserir(3,"jerbo");
//        TabelaH.inserir(8,"gay");
//        TabelaH.inserir(4,"be");
        TabelaH.mostraHash();
        System.out.println(TabelaH.pesquisa(1));
    }
}