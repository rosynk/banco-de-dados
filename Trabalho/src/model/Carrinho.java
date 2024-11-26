package model;

public class Carrinho {
    private String id;
    private int quantidadeProdutos;

    public Carrinho (String id, int quantidadeProdutos){

    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }
    public void setQuantidadeProdutos(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }
    
}
