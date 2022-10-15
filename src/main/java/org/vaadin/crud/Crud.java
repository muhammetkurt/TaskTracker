package org.vaadin.crud;

import java.awt.*;

public interface Crud {

    boolean create(String st);
    String read(TextField tf);
    boolean update(String st);
    boolean delete(TextField tf);

}
