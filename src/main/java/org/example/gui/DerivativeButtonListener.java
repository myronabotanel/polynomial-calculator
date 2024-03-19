package org.example.gui;

import org.example.logic.Operations;
import org.example.model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DerivativeButtonListener implements ActionListener
{
    private Design design;
    public DerivativeButtonListener (Design design)
    {
        this.design = design;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String input1 = design.getPoly1Text();
        Polinom p1 = new Polinom(input1);
        Polinom result = Operations.derivative(p1);
        design.setResultText(result.toString());
    }

}

