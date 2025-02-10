package org.example.servicioapi_smtp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField correoDestinatario;
    @FXML
    private TextField asunto;
    @FXML
    private TextArea mensaje;
    @FXML
    public void enviar(ActionEvent actionEvent) {
        EmailService.correos(correoDestinatario.getText(),asunto.getText(),mensaje.getText());
    }
}