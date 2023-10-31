package Interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelSur extends JPanel{
private JLabel jugadas;
private JLabel jugador;

private JTextField txtJugadas;
private JTextField txtJugador;
private VentanaPrincipal Principal;

PanelSur(VentanaPrincipal principal,String valueJugadas)
{
	Principal = principal;
	setLayout(new GridLayout(1,4));
    setBorder(new EmptyBorder(20, 20, 20, 20));

	jugadas = new JLabel("Jugadas: ");
	
	txtJugadas = new JTextField(valueJugadas);
	txtJugadas.setEditable(false);;
	jugador = new JLabel("Jugador: "); 
	txtJugador = new JTextField("");
	txtJugador.setEditable(false);
	add(jugadas);
	add(txtJugadas);
	add(jugador);
	add(txtJugador);
		
}
public void cambiarJugadas(String valor) 
{
	txtJugadas.setText(valor);
}
public String getJugadas() 
{
	return txtJugadas.getText();
}
public String getNombre() 
{
return txtJugador.getText();	
}
public void setNombre(String nombre) 
{
	txtJugador.setText(nombre);
}

}
