module com.example.neaplikacechat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.neaplikacechat to javafx.fxml;
    exports com.example.neaplikacechat;
}