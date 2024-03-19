package org.example.gui;

import org.example.gui.Design;
import org.example.logic.Operations;
import org.example.model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Design design;

    public Controller(Design design) {
        this.design = design;
        // Adăugați ascultători pentru butoanele din interfață
        design.getAddBtn().addActionListener(new AddButtonListener(design));
        design.getSubtractBtn().addActionListener(new SubtractButtonListener(design));
        design.getMultiplyBtn().addActionListener(new MultiplyButtonListener(design));
         design.getDivideBtn().addActionListener(new DivideButtonListener(design));
         design.getDerivativeBtn().addActionListener(new DerivativeButtonListener(design));
         design.getIntegrationBtn().addActionListener(new IntegrationButtonListener(design));
    }



    // Definiți ascultătorii pentru celelalte operații așa cum este necesar
    // private class MultiplyButtonListener implements ActionListener { ... }
    // private class DivideButtonListener implements ActionListener { ... }
    // private class DerivativeButtonListener implements ActionListener { ... }
    // private class IntegrationButtonListener implements ActionListener { ... }
}
