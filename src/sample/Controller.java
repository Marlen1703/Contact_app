package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
    @FXML private TableView<Person> tableView;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField emailField;
    @FXML private TextField lastName;
    @FXML
    private ImageView img;
    @FXML
    private TextField email;

    @FXML
    protected void addPerson(ActionEvent event) {
        if(firstNameField.getText().isEmpty()){
            return;
        }
        else{
            ObservableList<Person> data = tableView.getItems();
            data.add(new Person(firstNameField.getText(),
                    lastNameField.getText(),
                    emailField.getText()
            ));
        }

        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
    }
    public void initialize(){
        Image image=new Image("sample/No.jpg");
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
            @Override
            public void changed(ObservableValue<? extends Person> observableValue, Person person, Person t1) {
                lastName.setText(t1.getLastName());
                email.setText(t1.getEmail());
                img.setImage(image);
                img.setFitWidth(160);
            }
        });
    }


}
