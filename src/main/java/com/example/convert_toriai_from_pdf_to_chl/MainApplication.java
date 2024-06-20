package com.example.convert_toriai_from_pdf_to_chl;

import com.example.convert_toriai_from_pdf_to_chl.dao.SetupData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Tạo đối tượng Image từ file ảnh (đảm bảo file ảnh nằm trong thư mục resources)
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/convert_toriai_from_pdf_to_chl/ICON/LOGO_CHL.png")));
        // Thiết lập biểu tượng cho Stage
        stage.getIcons().add(icon);

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("convertPdfToExcelCHL.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("CHUYỂN ĐỔI FILE PDF TÍNH TOÁN VẬT LIỆU SANG CHL");
        stage.setScene(scene);


        stage.show();
        ((ConVertPdfToExcelCHLController) fxmlLoader.getController()).getControls().add(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
        try {
            SetupData.getInstance().loadSetup();
        } catch (IOException e) {
            System.out.println("không đọc được file");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}