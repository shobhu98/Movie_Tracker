package sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{
    TableView<Movie> table;
    TextField textField;
    TextField yea;
    TextField genr;


    @Override
    public void start(Stage primaryStage) throws Exception{

      //  Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Movie m1=new Movie("Avatar",2009,"Drama");
        Movie m2=new Movie("End Game",2019,"Fiction");
        Movie m3=new Movie("Titanic",1997,"Romantic");


        Label label=new Label("Movie Inventory");
        label.setFont(new Font("Arial",20));
        label.setPadding(new Insets(20,20,0,20));

        table=new TableView<>();
        table.getItems().addAll(m1,m2,m3);
        table.setEditable(true);



        TableColumn<Movie,String> title=new TableColumn<>("Title");
        title.setPrefWidth(300);
        PropertyValueFactory<Movie,String> p=new PropertyValueFactory<>("name");
        title.setCellValueFactory(p);

        TableColumn<Movie,String> genre=new TableColumn<>("Genre");
        genre.setPrefWidth(100);
        PropertyValueFactory<Movie,String> q=new PropertyValueFactory<>("genre");
        genre.setCellValueFactory(q);

        TableColumn<Movie,Integer> year=new TableColumn<>("Year");
        year.setPrefWidth(100);
        PropertyValueFactory<Movie,Integer> r=new PropertyValueFactory<>("year");
        year.setCellValueFactory(r);


        table.getColumns().addAll(title,genre,year);


     TextField textField=new TextField();
     textField.setPromptText("Enter Title");
     textField.prefWidth(200);
     TextField yea=new TextField();
     yea.setPromptText("Year");
     yea.prefWidth(100);
     TextField genr=new TextField();
     genr.setPromptText("Genre");
     genr.setPrefWidth(100);
        Button add=new Button("Add");
        add.setOnAction(e->btnclicked());
        Button del=new Button("Delete");
        add.minWidth(100);
        del.prefWidth(100);

        title.setCellFactory(TextFieldTableCell.forTableColumn());
        genre.setCellFactory(TextFieldTableCell.forTableColumn());

//        title.setOnEditCommit();
//        genre.setOnEditCommit();


        HBox hBox=new HBox(textField,yea,genr,add,del);



        VBox vBox=new VBox(table,hBox);











        VBox pane=new VBox(vBox);
        Scene scene=new Scene(pane,500,300);

        primaryStage.setTitle("Movie List");

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    public class Movie {
        public String name;
        protected Integer year;
        protected String genre;

        public Movie(String name,int year,String genre){
            this.name=name;
            this.year=year;
            this.genre=genre;
        }
        public Movie(){

        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
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
        Movie m=new Movie();
        m.setName(textField.getText());
        m.setGenre(genr.getText());
        m.setYear(Integer.parseInt(yea.getText()));
        table.getItems().add(m);
        textField.clear();
        genr.clear();
        yea.clear();





    }




}
