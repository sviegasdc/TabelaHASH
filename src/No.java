public class No {
    private int chave;
    private Object elemento;

    private boolean disponivel;

    public No(int chave, Object elemento){
        this.elemento = elemento;
        this.chave = chave;
    }

    public int getChave(){
        return chave;
    }

    public void setChave(int chave){
        this.chave = chave;
    }

    public Object getElemento(){
        return elemento;
    }

    public void setElemento(Object elemento){
        this.elemento = elemento;
    }

    public boolean ehDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}
