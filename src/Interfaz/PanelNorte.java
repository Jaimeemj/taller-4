package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class PanelNorte extends JPanel implements ActionListener{
	
	private static final Color CYAN = null;
	//labels
	private JLabel lblTamanio;
	private JLabel lblDificultad;
	private JLabel lblFacil;
	private JLabel lblMedio;
	private JLabel lblDificil;
	
	 private VentanaPrincipal principal;

	  private JRadioButton facilButton;
	  private JRadioButton medioButton;
	  private JRadioButton dificilButton;

	  private int dificultad;

	  
	  private JComboBox<String> lblComboBox;
	  private int tamanioTablero;

	//user interaction
	
	private JCheckBox cbFacil;
	private JCheckBox cbMedio;
	private JCheckBox cbDificil;
	private JComboBox<String> cBtamanio;
	private String[] comboBoxOptions = {"5x5", "9x9","11x11"};
	
    private boolean estadoFacil;
    private boolean estadoMedio;
    private boolean estadoDificil;

    
	
public PanelNorte(VentanaPrincipal principal,int tamanio,boolean estadoFacil,boolean estadoMedio,boolean estadoDificil) 
{
	setTamanioTablero(tamanio);
    setLayout(new GridLayout(1, 3));
    setBorder(new EmptyBorder(20, 20, 20, 20));
    setBackground(Color.CYAN);
	lblTamanio = new JLabel("Tamaño:");
    Font font1 = new Font(lblTamanio.getFont().getName(), Font.BOLD, 18);
	lblDificultad = new JLabel("Dificultad:");

	
    lblComboBox = new JComboBox<>(comboBoxOptions);
    lblComboBox.addActionListener(this);




    lblDificultad = new JLabel("Dificultad: ");
    Font font2 = new Font(lblDificultad.getFont().getName(), Font.BOLD, 18);
    lblDificultad.setFont(font2);


    ButtonGroup dificultadGroup = new ButtonGroup(); 

    facilButton = new JRadioButton("Fácil", estadoFacil);
    facilButton.setBackground(Color.CYAN);
    facilButton.addActionListener(this);
    dificultadGroup.add(facilButton); 


    medioButton = new JRadioButton("Medio", estadoMedio);
    medioButton.setBackground(Color.CYAN);
    medioButton.addActionListener(this);
    dificultadGroup.add(medioButton); 
    
    
    dificilButton = new JRadioButton("Difícil", estadoDificil);
    dificilButton.setBackground(Color.CYAN);
    dificilButton.addActionListener(this);
    dificultadGroup.add(dificilButton); 


	add(lblTamanio);
	add(lblComboBox);
    add(lblDificultad);
 
    add(facilButton);
    add(medioButton);
    add(dificilButton);

	
}


@Override
public void actionPerformed(ActionEvent e) 
{
    if (e.getSource() == facilButton) 
    {
    	setBtn("f");
    } 
    else if (e.getSource() == medioButton) 
    {
    	setBtn("m");
    } 
    else if (e.getSource() == dificilButton) 
    {
    	setBtn("dificil");
    } 
    else if (e.getSource() == lblComboBox) 
    	{
        String selectedSize = (String) lblComboBox.getSelectedItem();

            
        if (selectedSize.equals("5x5")) 
        {
        	setTamanioTablero(5);
        } 
        else if (selectedSize.equals("9x9")) 
        {
        	setTamanioTablero(8);
        	
        } 
        else if (selectedSize.equals("11x11")) 
        {
        	setTamanioTablero(11);
        	
        }
    }
}
private void setTamanioTablero(int nuevoValor) 
{
    tamanioTablero = nuevoValor;
}
public int getTamanio() 
{
    return tamanioTablero;
}
public int getDificultad() {
	// TODO Auto-generated method stub
	return dificultad;
}
public void setDificultad(int dificultad) {
	this.dificultad = dificultad;
}

public void setBtn(String btn) 
{
    if (btn.equals("f"))
    {
        estadoFacil = true;
        estadoMedio = false;
        estadoDificil = false;
        setDificultad(3);
    }
    else if (btn.equals("m")) 
    {
    	estadoFacil = false;
    	estadoMedio = true;
    	estadoDificil = false;
        setDificultad(7);
    }
    else 
    {
    	estadoFacil = false;
        estadoMedio = false;
        estadoDificil = true;
        setDificultad(10);
    }


}
public boolean[] getBtnEstados() 
{
    boolean[] estados = {estadoFacil,estadoMedio,estadoDificil};
    return estados;
    }


}
