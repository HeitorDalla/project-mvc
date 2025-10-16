module br.edu.unicesumar {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    opens br.edu.unicesumar to javafx.fxml;
    exports br.edu.unicesumar;
}