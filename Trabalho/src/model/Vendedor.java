package model;
public class Vendedor extends Usuario {

    private String cnpj = "";

    public Vendedor(String nome, String email, String telefone, String cnpj, String senha) {
        super(nome, email, telefone, senha);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
