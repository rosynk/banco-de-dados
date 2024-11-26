package control;

import model.Cliente;
import model.Vendedor;
import model.Endereco;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import dao.ClienteDAO;
import dao.VendedorDao;
import daoImp.VendedorDAOImp;
import daoImp.ClienteDAOImp;
import daoImp.MarketplaceException;

public class UsuarioControl {

    private ClienteDAO cDAO = null;
    private VendedorDao vDao = null;

    public UsuarioControl() throws MarketplaceException{
        try{
        cDAO = new ClienteDAOImp();
        vDao = new VendedorDAOImp();
        } catch(Exception e){
            throw new MarketplaceException(e);
        }
    }

    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private StringProperty cpf = new SimpleStringProperty("");
    private StringProperty cnpj = new SimpleStringProperty("");
    private StringProperty senha = new SimpleStringProperty("");

    private StringProperty logradouro = new SimpleStringProperty("");
    private IntegerProperty numero = new SimpleIntegerProperty(0);
    private StringProperty complemento = new SimpleStringProperty("");
    private StringProperty bairro = new SimpleStringProperty("");
    private StringProperty cidade = new SimpleStringProperty("");
    private StringProperty estado = new SimpleStringProperty("");
    private StringProperty cep = new SimpleStringProperty("");

    
    public void gravarCliente() throws MarketplaceException{
        
        Cliente c = new Cliente(      
            this.nome.get(),     
            this.email.get(),    
            this.telefone.get(), 
            this.cpf.get(),   
            this.senha.get()    
        );
        cDAO.inserir(c);
    }

    
    public void gravarVendedor() throws MarketplaceException {
       
        Vendedor v = new Vendedor(      
            this.nome.get(),     
            this.email.get(),    
            this.telefone.get(), 
            this.cnpj.get(),
            this.senha.get()      
        );
        vDao.inserir(v);
    }

public void gravarEndereco() throws MarketplaceException{
    Endereco e = new Endereco();
        e.setLogradouro( logradouro.get() );
        e.setNumero( numero.get() );
        e.setComplemento( complemento.get() );
        e.setBairro( bairro.get() );
        e.setCidade( cidade.get() );
        e.setEstado( estado.get() );
        e.setCep( cep.get() );

        
}
    




    public StringProperty nomeProperty() {
        return this.nome;
    }

    public StringProperty emailProperty() {
        return this.email;
    }

    public StringProperty telefoneProperty() {
        return this.telefone;
    }

    public StringProperty cpfProperty() {
        return this.cpf;
    }

    public StringProperty cnpjProperty() {
        return this.cnpj;
    }

    public StringProperty senhaProperty() {
        return this.senha;
    }
        public StringProperty logradouroProperty() { 
        return this.logradouro;
    }
    public IntegerProperty numeroProperty() { 
        return this.numero;
    }
    public StringProperty bairroProperty() { 
        return this.bairro;
    }
    public StringProperty complementoProperty() { 
        return this.complemento;
    }
    public StringProperty cidadeProperty() { 
        return this.cidade;
    }
    public StringProperty estadoProperty() { 
        return this.estado;
    }
    public StringProperty cepProperty() { 
        return this.cep;
    }
}

