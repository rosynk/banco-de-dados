package model;

public class Cliente extends Usuario {

    private String cpf = "";

    public Cliente(String nome, String email, String telefone, String cpf, String senha) {
        super(nome, email, telefone, senha);
        this.cpf = cpf;
    }

    public Cliente (){
        super("", "", "", "");
        this.cpf = "";
    }
   

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    } 

}
