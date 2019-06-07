package sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{
    TableView<Movie> table;
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

        TableColumn<Movie,String> title=new TableColumn<>("Title");
        title.setPrefWidth(300);
        PropertyValueFactory<Movie,String> p=new PropertyValueFactory<>("name");
        title.setCellValueFactory(p);

        TableColumn<Movie,String> genre=new TableColumn<>("Genre");
        genre.setPrefWidth(100);
        PropertyValueFactory<Movie,String> q=new PropertyValueFactory<>("genre");
        genre.setCellValueFactory(q);

        TableColumn<Movie,String> year=new TableColumn<>("Year");
        year.setPrefWidth(100);
        PropertyValueFactory<Movie,String> r=new PropertyValueFactory<>("year");
        year.setCellValueFactory(r);


        table.getColumns().addAll(title,genre,year);





        BorderPane pane=new BorderPane(table);
        Scene scene=new Scene(pane,500,600);

        primaryStage.setTitle("Movie List");

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    public class Movie {
        public String name;
        protected int year;
        protected String genre;

        public Movie(String name,int year,String genre){
            this.name=name;
            this.year=year;
            this.genre=genre;
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




}
