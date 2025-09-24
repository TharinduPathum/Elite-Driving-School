module lk.ijse.orm_coursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires static lombok;
    requires jakarta.persistence;
    requires java.naming;
    requires jbcrypt;

    opens lk.ijse.javaFX.config to jakarta.persistence;
    opens lk.ijse.javaFX.entity to org.hibernate.orm.core;

    opens lk.ijse.javaFX.controller to javafx.fxml;
    opens lk.ijse.javaFX.dto.tm to javafx.base;
    exports lk.ijse.javaFX;
}