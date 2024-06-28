package com.example.convert_toriai_from_pdf_to_chl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

public class AboutController {
    @FXML
    public Button okBtn;
    @FXML
    public Label introduce;
    @FXML
    public Label introduceContent;
    @FXML
    public Label using;
    @FXML
    public Label usingContent;
    @FXML
    public Label creator;

    private Dialog<Object> dialog;

    /**
     * xử lý sự kiện khi click vào nút ok thì đóng dialog
     */
    @FXML
    public void okAbout(ActionEvent actionEvent) {
        dialog.setResult(Boolean.TRUE);
        dialog.close();
    }

    /**
     * khởi tạo dialog
     * tạo sự kiện cho nút x để đóng dialog
     * thêm các control của dialog này vào list để set ngôn ngữ cho các control khi ấn nút chuyển ngôn ngữ hoặc khi dialog bắt đầu hiển thị
     * @param conVertPdfToExcelCHLController controller của cửa sổ convert
     * @param dialog đối tượng dialog của chính cửa sổ này
     */
    public void init(ConVertPdfToExcelCHLController conVertPdfToExcelCHLController, Dialog<Object> dialog) {
        this.dialog = dialog;

        // đóng dialog bằng nút X
        // cần tạo nút close ẩn
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        Node closeButton = dialog.getDialogPane().lookupButton(ButtonType.CLOSE);
        closeButton.managedProperty().bind(closeButton.visibleProperty());
        closeButton.setVisible(false);

        // thêm các control của dialog này vào list để set ngôn ngữ cho các control
        ObservableList<Object> controls = FXCollections.observableArrayList(okBtn, introduce, introduceContent, using, usingContent, creator, dialog);
        // gọi hàm chuyển ngôn ngữ để hiển thị ngôn ngữ của các controls theo ngôn ngữ đã chọn
        conVertPdfToExcelCHLController.updateLangInBackground(conVertPdfToExcelCHLController.languages.getSelectedToggle(), controls);
    }
}
