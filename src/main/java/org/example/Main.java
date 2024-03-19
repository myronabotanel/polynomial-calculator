package org.example;

import org.example.gui.Controller;
import org.example.gui.Design;
import org.example.logic.Operations;
import org.example.model.Polinom;

public class Main {
    public static void main(String[] args) {
        Design design = new Design();
        Controller controller = new Controller(design);
        design.setVisible(true);
    }
}