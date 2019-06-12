package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import  javafx.beans.*;
import javafx.util.converter.IntegerStringConverter;


public class Main extends Application{
    TableView<Movie> table;
    TextField textField=new TextField();
    TextField yea=new TextField();
    TextField genr=new TextField();


    @Override
    public void start(Stage primaryStage) throws Exception{

      //  Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        Movie m1=new Movie();
//        Movie m2=new Movie("End Game",2019,"Fiction");
//        Movie m3=new Movie("Titanic",1997,"Romantic");


        Label label=new Label("Movie Inventory");
        label.setFont(new Font("Arial",20));
        label.setPadding(new Insets(20,20,0,20));






        TableColumn<Movie,String> title=new TableColumn<>("Title");
        title.setPrefWidth(300);
      //  PropertyValueFactory<Movie,String> p=new PropertyValueFactory<>("name");
        title.setCellValueFactory(new PropertyValueFactory<>("name"));
        title.setCellFactory(TextFieldTableCell.forTableColumn());


        TableColumn<Movie,String> genre=new TableColumn<>("Genre");
        genre.setPrefWidth(100);
     //   PropertyValueFactory<Movie,String> q=new PropertyValueFactory<>("genre");
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        genre.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Movie,Integer> year=new TableColumn<>("Year");
        year.setPrefWidth(100);
       // PropertyValueFactory<Movie,Integer> r=new PropertyValueFactory<>("year");
         year.setCellValueFactory(new PropertyValueFactory<>("year"));
         year.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        table=new TableView<>();
//        table.getItems().addAll(m1,m2,m3);
        table.setEditable(true);
        table.setItems(loadata());




        table.getColumns().addAll(title,genre,year);


   //  TextField textField=new TextField();
     textField.setPromptText("Enter Title");
     textField.prefWidth(200);
       // title.setOnEditCommit(e-> changetitle(e));

    // TextField yea=new TextField();
     yea.setPromptText("Year");
     yea.prefWidth(100);
  //   TextField genr=new TextField();
     genr.setPromptText("Genre");
     genr.setPrefWidth(100);
        Button add=new Button("Add");
        add.setOnMouseClicked(e->btnclicked());
        Button del=new Button("Delete");
        add.minWidth(100);
        del.prefWidth(100);





//
//        genre.setOnEditCommit();


        HBox hBox=new HBox(textField,yea,genr,add,del);
        VBox vBox=new VBox(table,hBox);
        VBox pane=new VBox(vBox);
        Scene scene=new Scene(pane,500,300);

        primaryStage.setTitle("Movie List");

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void changetitle(Event e) {
        TableColumn.CellEditEvent<Movie,String> ce;
        ce=(TableColumn.CellEditEvent)e;
        Movie m=ce.getRowValue();
        m.setName(ce.getNewValue());

    }
    public ObservableList<Movie> loadata(){


        ObservableList<Movie> data=FXCollections.observableArrayList();
        data.add(new Movie("End Game",2019,"Fiction"));
        data.add(new Movie("Titanic",1997,"Romantic"));

        return data;


    }


    public static void main(String[] args) {
        launch(args);
    }


    public class Movie {
        public String name;
        public Integer year;
        public String genre;

        public Movie(String name,Integer year,String genre){
            this.name=name;
            this.year=year;
            this.genre=genre;
        }
       Movie(){

       }

        public String getName() {

            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year)
        {
            this.year = year;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {

            this.genre = genre;
        }
    }
    public void btnclicked(){
        Movie x=new Movie();
        String msg=textField.getText();
        x.setName(msg);
        x.setGenre(genr.getText());
        x.setYear(Integer.parseInt(yea.getText()));
        table.getItems().add(x);
        textField.clear();
        genr.clear();
        yea.clear();
    }





}
