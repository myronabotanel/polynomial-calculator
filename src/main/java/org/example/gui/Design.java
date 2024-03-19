package org.example.gui;

import javax.swing.*;

public class Design extends JFrame {

    private JTextField poly1Text;
    private JTextField poly2Text;
    private JTextField resultText;
    private JButton addBtn;
    private JButton subtractBtn;
    private JButton multiplyBtn;
    private JButton divideBtn;
    private JButton derivativeBtn;
    private JButton integrationBtn;

    public Design() {
        this.setSize(500, 300); // Setează dimensiunea ferestrei
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); // Folosește layout null pentru poziționare manuală

        // Titlu
        JLabel titleLabel = new JLabel("POLYNOMIAL CALCULATOR");
        titleLabel.setBounds(150, 10, 200, 30); // Poziționează titlul
        this.add(titleLabel);

        // Primul polinom
        JLabel poly1Label = new JLabel("Polynom 1 = ");
        poly1Label.setBounds(20, 50, 100, 30); // Poziționează eticheta
        this.add(poly1Label);

        poly1Text = new JTextField();
        poly1Text.setBounds(120, 50, 300, 30); // Poziționează câmpul de text
        this.add(poly1Text);

        // Al doilea polinom
        JLabel poly2Label = new JLabel("Polynom 2 = ");
        poly2Label.setBounds(20, 90, 100, 30); // Poziționează eticheta
        this.add(poly2Label);

        poly2Text = new JTextField();
        poly2Text.setBounds(120, 90, 300, 30); // Poziționează câmpul de text
        this.add(poly2Text);

        // Buton adunare
        addBtn = new JButton("ADD");
        addBtn.setBounds(20, 130, 100, 30); // Poziționează butonul
        this.add(addBtn);

        // Buton scădere
        subtractBtn = new JButton("Subtract");
        subtractBtn.setBounds(130, 130, 100, 30); // Poziționează butonul
        this.add(subtractBtn);

        // Buton înmulțire
        multiplyBtn = new JButton("Multiply");
        multiplyBtn.setBounds(240, 130, 120, 30); // Poziționează butonul
        this.add(multiplyBtn);

        // Buton împărțire
        divideBtn = new JButton("Divide");
        divideBtn.setBounds(370, 130, 100, 30); // Poziționează butonul
        this.add(divideBtn);

        // Buton derivare
        derivativeBtn = new JButton("Derivative");
        derivativeBtn.setBounds(30, 170, 100, 30); // Poziționează butonul
        this.add(derivativeBtn);

        // Buton integrare
        integrationBtn = new JButton("Integration");
        integrationBtn.setBounds(140, 170, 100, 30); // Poziționează butonul
        this.add(integrationBtn);

        // Rezultat
        JLabel resultLabel = new JLabel("Result = ");
        resultLabel.setBounds(20, 210, 100, 30);
        this.add(resultLabel);

        resultText = new JTextField();
        resultText.setBounds(120, 210, 300, 30); // Poziționează câmpul de text
        resultText.setEditable(false); // Face ca câmpul de text să fie doar pentru afișare
        this.add(resultText);

        // Facem fereastra vizibilă
        this.setVisible(true);
    }

    public String getPoly1Text() {
        return poly1Text.getText().trim();
    }

    public String getPoly2Text() {
        return poly2Text.getText().trim();
    }

    public void setResultText(String text) {
        resultText.setText(text);
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getSubtractBtn() {
        return subtractBtn;
    }

    public JButton getMultiplyBtn() {
        return multiplyBtn;
    }

    public JButton getDivideBtn() {
        return divideBtn;
    }

    public JButton getDerivativeBtn() {
        return derivativeBtn;
    }

    public JButton getIntegrationBtn() {
        return integrationBtn;
    }
}
