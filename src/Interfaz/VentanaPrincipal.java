package Interfaz;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import uniandes.dpoo.taller4.modelo.*;

public class VentanaPrincipal extends JFrame {
	private PanelBotones PanelBtn;
	private PanelNorte PanelNorte;
	private PanelSur PanelSur;
	private PanelTablero PanelTablero;
	private Tablero Tablero;
	private Top10 top10 = new Top10();
	private VentanaTop ventTop;
	private Collection<RegistroTop10> lstTop;
	private File top = new File("./data/top10.csv");
	public VentanaPrincipal(int tamanio,int dificultad,boolean estadoFacil,boolean estadoMedio,boolean estadoDificil)
	    {

	        setSize( 750, 600 );
	        setTitle( "Lights out" );
	        setDefaultCloseOperation( EXIT_ON_CLOSE );
	        
	        setLayout( new BorderLayout( ) );
	        
	        PanelBtn = new PanelBotones(this);
	        add(PanelBtn,BorderLayout.EAST );
	        PanelNorte = new PanelNorte(this,tamanio,estadoFacil,estadoMedio,estadoDificil);
	        if (estadoFacil) {
		        PanelNorte.setBtn("f");
	        }
	        else if(estadoMedio)
	        {
	        	PanelNorte.setBtn("m");
	        }	        
	        else 
	        {
	        	PanelNorte.setBtn("sdsfd");
	        }
	        PanelNorte.setDificultad(dificultad);
	        add(PanelNorte,BorderLayout.NORTH);
	        
	        PanelSur = new PanelSur(this,"0");
	        add(PanelSur,BorderLayout.SOUTH);
	        
	        Tablero = new Tablero(tamanio);
	        desorganizar(dificultad);
	  		PanelTablero = new PanelTablero(Tablero.darTablero(),this);
	  		add(PanelTablero,BorderLayout.CENTER);
	  		
	    }
	  
public void cambiarTablero(int t,int dif,boolean estadoFacil,boolean estadoMedio,boolean estadoDificil) 
{
	Tablero = new Tablero(t);
	Tablero.desordenar(dif);
	PanelTablero.setVisible(false);
	PanelTablero = new PanelTablero(Tablero.darTablero(),this);
    PanelTablero.setVisible( true );

    add(PanelTablero,BorderLayout.CENTER);
    changeValue(0);
}
public void ventanaTop() 
{
	ventTop = new VentanaTop(this);
	ventTop.setLocationRelativeTo(this);
	ventTop.setVisible(true);
	}
public int getTamanioTablero() 
{
	return PanelNorte.getTamanio();
}
public int getDificultad()
{
	return PanelNorte.getDificultad();
}
public boolean[] getBtnEstados() 
{
return PanelNorte.getBtnEstados();	
}
public int getJugadas() 
{
	return Tablero.darJugadas();
}
public void cargarDatosTop()
{

	top10.cargarRecords(top);
}

public void changeValue(int valor) 
{
	PanelSur.cambiarJugadas(Integer.toString(valor));
}

public static void main(String[] args)
	    {
	        VentanaPrincipal ventana = new VentanaPrincipal(5,1,true,false,false);
	        ventana.setLocationRelativeTo( null );
	        ventana.setVisible( true );
	    }

public void reiniciarTablero() 
{
	Tablero.reiniciar();
	boolean[][] tab = PanelTablero.reiniciarTablero(PanelTablero.getTablero());
	PanelTablero.setVisible(false);
	PanelTablero = new PanelTablero(tab,this);
	changeValue(0);
	this.add(PanelTablero,BorderLayout.CENTER);
	
}
public Collection<RegistroTop10> getRegistros()
{
	lstTop = top10.darRegistros();

	return lstTop;
	
}
public boolean completo() 
{
return Tablero.tableroIluminado();

}
public void gano() 
{
	JOptionPane.showMessageDialog( this, "Haz ganado el juego" );
	int puntaje = Tablero.calcularPuntaje();
	String name = PanelSur.getNombre();
	if (top10.esTop10(puntaje)) 
	{
		top10.agregarRegistro(name, puntaje);
		try {
			top10.salvarRecords(top);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(this, "Haz entrado en el top10!!");
	}
	else 
	{
		JOptionPane.showMessageDialog(this, "No haz entrado en el top10 :(");
	}
}
public void cambiarNomber() 
{
	String nombreUsuario= JOptionPane.showInputDialog( this, "Ingrese el nombre que se desea poner", 
            "Cambiar nombre", JOptionPane.QUESTION_MESSAGE );
	PanelSur.setNombre(nombreUsuario);
}
private void desorganizar(int dif)
{
	Tablero.desordenar(dif);
}
public void jugar(int x, int y) 
{
Tablero.jugar(x, y);
}
}
