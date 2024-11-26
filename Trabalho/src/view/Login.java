package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ToggleGroup;
import control.MudarTela;
import control.VerificaUsuario;
import daoImp.MarketplaceException;

public class Login {
    private TextField txtSenha = new TextField();
    private TextField txtTipo = new TextField();
    private MudarTela mt = new MudarTela();
    private VerificaUsuario vu = new VerificaUsuario();

    public void telaLogin(GridPane pane, ToggleGroup group) {
        // Adicionando campos de Login
        pane.add(new Label("CPF ou CNPJ"), 0, 1);
        pane.add(txtTipo, 1, 1);

        pane.add(new Label("Senha"), 0, 2);
        pane.add(txtSenha, 1, 2);

        Button loginBtn = new Button("Login");
        pane.add(loginBtn, 0, 3);

        loginBtn.setOnAction(e -> {
            try {
                String tipo = txtTipo.getText();
                verificaTipo(tipo);
            } catch (Exception ex) {
                alert(AlertType.ERROR, "Erro ao entrar. CPF/CNPJ ou Senha inválidos.");
            }
        });

        RadioButton btnCadastrarCPF = new RadioButton("Cadastrar");
        pane.add(btnCadastrarCPF, 1, 3);
        btnCadastrarCPF.setOnAction(e -> {
            try {
                mt.mudarScene(pane, group, "CADASTRAR");
            } catch (MarketplaceException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
    }

    public void verificaTipo(String tipo) {
        vu.verificaTipo(tipo); // Terminar essa verificação após as DAOs
    }

    public void alert(AlertType tipo, String msg) {
        Alert alertWindow = new Alert(tipo);
        alertWindow.setHeaderText("Alerta");
        alertWindow.setContentText(msg);
        alertWindow.showAndWait();
    }
}
