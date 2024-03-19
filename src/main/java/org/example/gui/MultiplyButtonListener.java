package org.example.gui;

import org.example.logic.Operations;
import org.example.model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiplyButtonListener implements ActionListener
{
    private Design design;
    public MultiplyButtonListener(Design design)
    {
        this.design = design;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String input1 = design.getPoly1Text();
        String input2 = design.getPoly2Text();
        Polinom p1 = new Polinom(input1);
        Polinom p2 = new Polinom(input2);
        Polinom result = Operations.multiply(p1, p2);
        design.setResultText(result.toString());
    }
}
