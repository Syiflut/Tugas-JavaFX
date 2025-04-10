import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kalkulator Matematika");

        // Membuat elemen-elemen antarmuka
        Label labelOperasi = new Label("Pilih operasi:");
        ComboBox<String> comboOperasi = new ComboBox<>();
        comboOperasi.getItems().addAll("Faktorial", "Bilangan Fibonacci");
        comboOperasi.setValue("Faktorial");

        Label labelInput = new Label("Masukkan angka:");
        TextField inputField = new TextField();
        Button calculateButton = new Button("Hitung");
        Label resultLabel = new Label("Hasil akan ditampilkan di sini");

        // Menetapkan aksi pada tombol
        calculateButton.setOnAction(e -> {
            String operasi = comboOperasi.getValue();
            String inputText = inputField.getText();
            try {
                int number = Integer.parseInt(inputText);
                if (number < 0) {
                    resultLabel.setText("Masukkan angka non-negatif.");
                } else {
                    if (operasi.equals("Faktorial")) {
                        long result = hitungFaktorial(number);
                        resultLabel.setText("Faktorial dari " + number + " adalah: " + result);
                    } else if (operasi.equals("Bilangan Fibonacci")) {
                        long result = hitungFibonacci(number);
                        resultLabel.setText("Bilangan Fibonacci ke-" + number + " adalah: " + result);
                    }
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Harap masukkan angka yang valid.");
            }
        });

        // Menyusun elemen dalam layout
        VBox vbox = new VBox(10, labelOperasi, comboOperasi, labelInput, inputField, calculateButton, resultLabel);
        vbox.setPadding(new Insets(10));
        vbox.setStyle("-fx-alignment: center;");

        // Menampilkan scene
        Scene scene = new Scene(vbox, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Metode untuk menghitung faktorial secara iteratif
    private long hitungFaktorial(int n) {
        long hasil = 1;
        for (int i = 1; i <= n; i++) {
            hasil *= i;
        }
        return hasil;
    }

    // Metode untuk menghitung bilangan Fibonacci secara iteratif
    private long hitungFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
