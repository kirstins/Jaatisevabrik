import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by kirstin on 02/02/2017.
 */
public class Aken {
    Stage stage = new Stage();
    VBox vbox;
    Scene scene;
    TextField tootedValja;
    TextField ostetud;
    TextField hind;
    Label label1;
    Label label2;
    Label label3;
    Label label4;
    Label label5;
    Label label6;
    Button button;
    Andmed andmed = new Andmed();


    public Aken(){
        seadistaaken();
        lisaAndmedJaArvuta();
    }

    private void seadistaaken() {
        vbox= new VBox();
        scene=new Scene(vbox, 500, 500);
        stage.setScene(scene);
        stage.show();

        tootedValja=new TextField();
        tootedValja.setPromptText("Mitu toodet hommikul välja saadeti?");
        ostetud = new TextField();
        ostetud.setPromptText("Mitu toodet õhtuks maha müüdi?");
        hind= new TextField();
        hind.setPromptText("Mis oli toote hind?");
        label1=new Label();
        label2=new Label();
        label3=new Label();
        label4=new Label();
        label5=new Label();
        label6=new Label();

        button = new Button("Salvesta info päeva kohta");
        vbox.getChildren().addAll(tootedValja, ostetud, hind, label1, label2, label3, label4, label5, label6, button);

    }

    private void lisaAndmedJaArvuta() {
        button.setOnAction(event -> {
            andmed.lisaAndmed(Integer.parseInt(tootedValja.getText()), Integer.parseInt(ostetud.getText()), Integer.parseInt(hind.getText()));
            label1.setText("Kokku on välja saadetud "+String.valueOf(andmed.kokkuValjaSaadetud())+" toodet");
            label2.setText("Kokku on ära ostetud "+String.valueOf(andmed.kokkuAraOstetud())+" toodet");
            label3.setText("Poodides seisab "+String.valueOf(andmed.seisevKaup())+" toodet");
            label4.setText("Statistikat on peetud "+String.valueOf(andmed.statistikatPeetud())+" päeva");
            label5.setText("Kogukasum on: "+String.valueOf(andmed.kasumKokku())+" eurot");
            label6.setText("Ideaalne hind on: "+andmed.ideaalneHind());

            tootedValja.clear();
            hind.clear();
            ostetud.clear();
        });


    }
}
