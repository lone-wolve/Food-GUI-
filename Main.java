package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main extends Application {

//    Category 1


    Label BreakFast_Category1;
    CheckBox CheckBox1;
    CheckBox CheckBox2;
    CheckBox CheckBox3;

//    Category 2

     Label    Lunch_Category2;
     CheckBox CheckBox4;
     CheckBox CheckBox5;
     CheckBox CheckBox6;

//    Category3

    Label    Dinner_Category3;
    CheckBox CheckBox7;
    CheckBox CheckBox8;
    CheckBox CheckBox9;

    //Text Area
    TextArea OutputTextArea;
  //Array list to insert selected items

    ArrayList<String> SelectedList= new ArrayList<>();
      Boolean isOrdered= false;









   @Override
    public void start(Stage stage) throws Exception{
       BreakFast_Category1 = new Label("BreakFast1");
       CheckBox1 = new CheckBox("Freid Egg" + "\t"+ "D40");
       CheckBox2 = new CheckBox ("Egg Rapp" + "\t"+ "D60");
       CheckBox3 = new CheckBox(" Chicken Rapp" + "\t"+ "D80");
       VBox Pane_Categorie1 = new VBox(BreakFast_Category1, CheckBox1,CheckBox2,CheckBox3);
       Pane_Categorie1.setSpacing(10);


       Lunch_Category2= new Label("Lunch");
       CheckBox4 = new CheckBox("Benachine"+ "\t"+ "D100");
       CheckBox5 = new CheckBox ("Domoda"+ "\t"+ "D100");
       CheckBox6 = new CheckBox(" Mbahal" + "\t"+ "D75");
       VBox Pane_Categorie2 = new VBox(Lunch_Category2, CheckBox4,CheckBox5,CheckBox6);
       Pane_Categorie2.setSpacing(10);

       Dinner_Category3= new Label("Dinner");
       CheckBox7 = new CheckBox("Icecream" + "\t"+ "D50");
       CheckBox8 = new CheckBox ("Youghurt" + "\t"+ "D75");
       CheckBox9 = new CheckBox(" Pourage"+ "\t"+ "D50");
       VBox pane_Categorie3 = new VBox(Dinner_Category3, CheckBox7,CheckBox8,CheckBox9);
       pane_Categorie3.setSpacing(10);


        Button OrderBtn = new Button();
        Button RefreshButton = new Button();
        Button Save = new Button();
        RefreshButton.setText("Refresh");
        OrderBtn.setText("Oder");
        Save.setText("Save");
        OrderBtn.setOnAction(e -> OderBtn_Click());
        RefreshButton.setOnAction(e -> RefreshButton_Clicked());
       RefreshButton.setOnAction(e -> RefreshButton_Clicked());

        HBox PaneButton = new HBox(10,OrderBtn,RefreshButton, Save);
        PaneButton.setAlignment(Pos.BOTTOM_LEFT);



       OutputTextArea = new TextArea("");
       HBox OutputTextAreaa = new HBox(OutputTextArea);
       OutputTextArea.setEditable(false);
       OutputTextAreaa.setPrefWidth(500);
       OutputTextAreaa.setPrefHeight(250);

        HBox paneBottom = new HBox(10, OutputTextAreaa);
        paneBottom.setSpacing(10);
        paneBottom.setAlignment(Pos.BASELINE_CENTER);
        paneBottom.setPadding(new Insets(50));

        HBox PaneOder = new HBox( 50,Pane_Categorie1,Pane_Categorie2, pane_Categorie3,PaneButton);
//
        VBox PaneCentre  = new VBox(PaneOder);
        PaneCentre.setPadding(new Insets(20,50,20,75));

       BorderPane Painmain = new BorderPane();
       Painmain.setCenter(PaneCentre);
       Painmain.setBottom(paneBottom);


//        Ui for category one

//        set pane in stage
        Group root = new Group();
        stage.setTitle("Food Order system");
        Scene scene = new Scene(root, Color.GRAY);
        Scene scene2 = new Scene(Painmain);
        stage.setScene(scene);
        stage.setScene(scene2);
        stage.setTitle("Food Odering system");
        stage.setHeight(500);
        stage.setWidth(800);
        stage.setResizable(false);
        stage.show();
    }

    private void RefreshButton_Clicked() {

        CheckBox1.setSelected(false);
        CheckBox2.setSelected(false);
        CheckBox3.setSelected(false);
        CheckBox4.setSelected(false);
        CheckBox5.setSelected(false);
        CheckBox6.setSelected(false);
        CheckBox7.setSelected(false);
        CheckBox8.setSelected(false);
        CheckBox9.setSelected(false);
        OutputTextArea.clear();

}

    private void OderBtn_Click() {



            String Selected_ = "";


            double Total = 0;
            String newLine = "\n";
            String tTab = "\t";


            if (CheckBox1.isSelected()) {
                Selected_ = CheckBox1.getText();
                SelectedList.add(Selected_);
                Total = 40;

            }
            if (CheckBox2.isSelected()) {
                Selected_ = CheckBox2.getText();
                SelectedList.add(Selected_);
                Total = Total + 60;
            }

            if (CheckBox3.isSelected()) {
                Selected_ = CheckBox3.getText();
                SelectedList.add(Selected_);
                Total = Total + 80;
            }
            if (CheckBox4.isSelected()) {
                Selected_ = CheckBox4.getText();
                SelectedList.add(Selected_);
                Total = Total + 100;

            }
            if (CheckBox5.isSelected()) {
                Selected_ = CheckBox5.getText();
                SelectedList.add(Selected_);
                Total = Total + 100;

            }
            if (CheckBox6.isSelected()) {
                Selected_ = CheckBox6.getText();
                SelectedList.add(Selected_);
                Total = Total + 75;


            }

            if (CheckBox7.isSelected()) {
                Selected_ = CheckBox7.getText();
                SelectedList.add(Selected_);
                Total = Total + 50;

            }
            if (CheckBox8.isSelected()) {
                Selected_ = CheckBox8.getText();
                SelectedList.add(Selected_);
                Total = Total + 75;

            }
            if (CheckBox9.isSelected()) {
                Selected_ = CheckBox9.getText();
                SelectedList.add(Selected_);


                Total = Total + 50;

            }
        if (SelectedList.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erro message");
            alert.setHeaderText("Erro Message");
            alert.setContentText("Please select checkbox to Order");

            alert.showAndWait();
        }

            StringBuffer sb = new StringBuffer();

            for (String s : SelectedList) {
                sb.append(s);
                sb.append("\n");
            }
            String str = sb.toString();
            isOrdered= true;


            OutputTextArea.setText(str + newLine + " Your Total is " + Total + newLine +
                    " Thank you for odering have a nice meal" + newLine);




        }



















        public static void main(String[] args) {
        launch(args);
    }
}
