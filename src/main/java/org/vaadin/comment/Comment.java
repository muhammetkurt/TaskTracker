package org.vaadin.comment;

import org.vaadin.crud.Crud;

import java.awt.*;

public class Comment implements Crud {
    private String comment;

    @Override
    public boolean create(String st) {
        return false;
    }

    @Override
    public String read(TextField tf) {
        return null;
    }

    @Override
    public boolean update(String st) {
        return false;
    }

    @Override
    public boolean delete(TextField tf) {
        return false;
    }
}
