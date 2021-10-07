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
    String wordTar, wordEx, wordDele;


    // Nhập từ tìm kiếm.
    @FXML
    public void setInput(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            String wordLook = searchField.getText();
            textAreaMenu.setText(DictionaryManagement.dictionaryLookup(wordLook));
        }
    }

    // Thêm từ tiếng anh.
    @FXML
    public void wordTargetInput(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            wordTar = wordTarget.getText();
            System.out.println(wordTar);
        }
    }

    // Từ để xóa.
    @FXML
    public void wordDeleteInput(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            wordDele = wordDelete.getText();
            System.out.println(wordDele);
        }
    }

    // Nhập nghĩa tiếng Việt.
    @FXML
    public void wordExplainInput(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            wordEx = wordExplain.getText();
            System.out.println(wordEx);
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

    // Accept từ mới.
    @FXML
    public void buttonInsert(ActionEvent event) {
        wordTar = wordTarget.getText();
        wordEx = wordExplain.getText();
        if (!wordEx.equals("") || !wordTar.equals("")) {
            DictionaryManagement.insertWordToFile(wordTar, wordEx);
            System.out.println("Thêm từ thành công.");
        }

    }

    @FXML
    public void buttonDelete(ActionEvent event) {
        wordDele = wordDelete.getText();
        DictionaryManagement.deleteWord(wordDele);
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
