package view;

import control.MudarTela;
import control.UsuarioControl;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ToggleGroup;
import daoImp.MarketplaceException;

public class UsuarioBoundary {
    private TextField txtEmail = new TextField();
    private TextField txtTelefone = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtTipo = new TextField();
    private TextField txtSenha = new TextField();
    
    // Endereço
    private TextField txtLogradouro = new TextField();
    private TextField txtNumero = new TextField();
    private TextField txtComplemento = new TextField();
    private TextField txtBairro = new TextField();
    private TextField txtCidade = new TextField();
    private TextField txtEstado = new TextField();
    private TextField txtCep = new TextField();

    private UsuarioControl control = null;
    private MudarTela mt = new MudarTela();

    // Botões de tipo (CPF / CNPJ)
    RadioButton btnCpf = new RadioButton("CPF");
    RadioButton btnCnpj = new RadioButton("CNPJ");

    public UsuarioBoundary() throws MarketplaceException{
         try{
            control = new UsuarioControl();
        } catch (MarketplaceException e){
            alert(AlertType.ERROR, "Erro ao gravar usuário.");
        }
    }

    public void telaCadastrar(GridPane pane, ToggleGroup group) throws MarketplaceException {

       
        // Adicionar campos de cadastro
        pane.add(new Label("Nome"), 0, 2);
        pane.add(txtNome, 1, 2);
        pane.add(new Label("E-mail"), 0, 3);
        pane.add(txtEmail, 1, 3);
        pane.add(new Label("Telefone"), 0, 4);
        pane.add(txtTelefone, 1, 4);
        pane.add(new Label("Logradouro"), 0, 5);
        pane.add(txtLogradouro, 1, 5);
        pane.add(new Label("Número"), 0, 6);
        pane.add(txtNumero, 1, 6);
        pane.add(new Label("Complemento"), 0, 7);
        pane.add(txtComplemento, 1, 7);
        pane.add(new Label("Bairro"), 0, 8);
        pane.add(txtBairro, 1, 8);
        pane.add(new Label("Cidade"), 0, 9);
        pane.add(txtCidade, 1, 9);
        pane.add(new Label("Estado"), 0, 10);
        pane.add(txtEstado, 1, 10);
        pane.add(new Label("CEP"), 0, 11);
        pane.add(txtCep, 1, 11);

        // Botões CPF e CNPJ
        btnCpf.setToggleGroup(group);
        btnCnpj.setToggleGroup(group);

        pane.add(btnCpf, 0, 0);
        pane.add(btnCnpj, 1, 0);

        Button btnGravar = new Button("Gravar");
        Button btnEntrar = new Button("Entrar");

        btnCpf.setOnAction(e -> adicionarCamposCpfOuCnpj(pane, btnGravar, btnEntrar, "CPF"));
        btnCnpj.setOnAction(e -> adicionarCamposCpfOuCnpj(pane, btnGravar, btnEntrar, "CNPJ"));
    }

    private void adicionarCamposCpfOuCnpj(GridPane pane, Button btnGravar, Button btnEntrar, String tipo) {
        // Limpar os campos de CPF ou CNPJ anteriores, se houver
        pane.getChildren().removeIf(node -> GridPane.getRowIndex(node) >= 12);

        // Adicionar campos específicos do tipo (CPF ou CNPJ)
        pane.add(new Label(tipo), 0, 12);
        pane.add(txtTipo, 1, 12);
        pane.add(new Label("Crie sua senha"), 0, 13);
        pane.add(txtSenha, 1, 13);

        pane.add(btnGravar, 0, 14);

        // Ação do botão Gravar
        btnGravar.setOnAction(ex -> {
            try {
                pane.add(btnEntrar, 1, 14);
                if (btnCpf.isSelected()) {
                    control.gravarCliente();  // Processar como Cliente e ir para a tela
                    btnEntrar.setOnAction(exc -> {
                        try {
                            mt.mudarScene(pane, null, tipo);
                        } catch (MarketplaceException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    });
                } else if (btnCnpj.isSelected()) {
                    control.gravarVendedor();  // Processar como Vendedor e ir para a tela
                    btnEntrar.setOnAction(exc -> {
                        try {
                            mt.mudarScene(pane, null, tipo);
                        } catch (MarketplaceException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    });
                }
                alert(AlertType.INFORMATION, "Usuário cadastrado com sucesso!");
            } catch (Exception ecx) {
                alert(AlertType.ERROR, "Erro ao gravar usuário.");
            }
        });
    }

    public void alert(AlertType tipo, String msg) {
        Alert alertWindow = new Alert(tipo);
        alertWindow.setHeaderText("Alerta");
        alertWindow.setContentText(msg);
        alertWindow.showAndWait();
    }
}
