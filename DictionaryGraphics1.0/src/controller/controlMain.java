package controller;

import application.Dictionary;
import application.DictionaryManagement;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class controlMain extends Dictionary implements Initializable {
    @FXML
    private TextField searchField;
    @FXML
    private TextField wordTarget;
    @FXML
    private TextField wordExplain;
    @FXML
    private TextField wordDelete;

    @FXML
    private TextArea textAreaMenu;


    @FXML
    public void setInput(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            String wordLook = searchField.getText();
            textAreaMenu.setText(DictionaryManagement.dictionaryLookup(wordLook));
        }
    }

    @FXML
    public void wordTargetInput(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            String word = wordTarget.getText();
            System.out.println(word);
        }
    }

    @FXML
    public void wordDeleteInput(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            String word = wordDelete.getText();
            System.out.println(word);
            DictionaryManagement.deleteWord(word);
        }
    }

    @FXML
    public void wordExplainInput(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            String word = wordExplain.getText();
            System.out.println(word);
        }
    }

    @FXML
    public void buttonSearch(ActionEvent event) {
        String wordLook = searchField.getText();
        textAreaMenu.setText(DictionaryManagement.dictionaryLookup(wordLook));
    }
    @FXML
    public void buttonShowAllWord(ActionEvent event) throws IOException {
        textAreaMenu.setText(DictionaryManagement.dictionaryShowAllWord());
    }

    @FXML
    public void actionExit (ActionEvent event) {
        System.out.println("Kết thúc chương trình!");
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final Tooltip tooltip1 = new Tooltip();
        tooltip1.setText("input");
        searchField.setTooltip(tooltip1);
        final Tooltip tooltip3=new Tooltip();
        tooltip3.setText("Meaning!");
        textAreaMenu.setTooltip(tooltip3);
        DictionaryManagement.insertListFromFile();
    }
}
