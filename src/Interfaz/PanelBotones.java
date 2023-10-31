package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class PanelBotones extends JPanel implements ActionListener{
    private JButton btnNuevo;
    private JButton btnReiniciar;
    private JButton btnTop;
    private JButton btnJugador;
    private VentanaPrincipal principal;
    public PanelBotones(VentanaPrincipal prPrincipal) 
    {
    	principal = prPrincipal;
    	add(new JLabel(""));
    	add(new JLabel(""));
    	add(new JLabel(""));
        setLayout(new GridLayout( 14, 1 ));
        btnNuevo = new JButton("Nuevo");

        add(btnNuevo);
        add(new JLabel(""));
        btnReiniciar = new JButton("REINICIAR");
        add(btnReiniciar);
        add(new JLabel(""));
        btnTop = new JButton("TOP-10");
        add(btnTop);
        add(new JLabel(""));
        btnJugador = new JButton("CAMBIAR JUGADOR");
        add(btnJugador);
        add(new JLabel(""));
        
        btnNuevo.addActionListener(this);
        btnNuevo.setActionCommand("NUEVO");
        btnTop.addActionListener(this);
        btnTop.setActionCommand("TOP");
        btnJugador.addActionListener(this);
        btnJugador.setActionCommand("CAMBIAR JUGADOR");
        btnReiniciar.addActionListener(this);
        btnReiniciar.setActionCommand("REINICIAR");
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
    }
   
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("NUEVO")) 
		{
			int val =principal.getTamanioTablero();
			int dif = principal.getDificultad();
			boolean[] estados = principal.getBtnEstados();
			principal.cambiarTablero(val,dif,estados[0],estados[1],estados[2]);
		}
		else if(e.getActionCommand().equals("REINICIAR")) 
		{
			principal.reiniciarTablero();
		}
		
		else if(e.getActionCommand().equals("TOP")) 
		{
			principal.ventanaTop();
		}
		else if(e.getActionCommand().equals("CAMBIAR JUGADOR")) 
		{
			principal.cambiarNomber();
		}
	}
    
    
}