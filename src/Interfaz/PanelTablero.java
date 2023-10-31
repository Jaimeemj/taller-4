package Interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelTablero extends JPanel implements MouseListener {
	private boolean[][] tablero;
	private VentanaPrincipal principal;
	public PanelTablero(boolean[][] tablero,VentanaPrincipal rPrincipal) 
	{

		principal = rPrincipal;
		this.tablero = tablero;
		add(new JLabel ("                                   "));
		addMouseListener(this);
	
	}
	public void paint(Graphics g) 
	{
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("./data/luz.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        Graphics2D g2d = (Graphics2D) g;
        int ancho = getWidth();
        int alto = getHeight();
        System.out.println(tablero.length);
        int anchoRect = ancho / tablero.length;
        int altoRect = alto / tablero.length;
		for (int i = 0;i<tablero.length;i++) 
		{
			
			for (int j = 0; j<tablero.length;j++) 
			{
				Rectangle2D.Double rect= new Rectangle2D.Double( i*anchoRect , j*altoRect, anchoRect, altoRect );
				if (tablero[j][i]==true) 
				{
					g.setColor( Color.YELLOW );
				}
				else 
				{
					g.setColor( Color.GRAY );
				}
				g2d.fill(rect);
	             g.setColor( Color.BLACK );
	             g2d.draw( rect );
			}

			}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    public void mousePressed( MouseEvent e )
    {
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        principal.jugar(click_x,click_y);
        cambiarColorYVecinos(casilla[0], casilla[1]);
        int jugadas = principal.getJugadas();        
        principal.changeValue(jugadas);
        
        repaint();
        if (principal.completo()) 
        {
        	principal.gano();
        }
       
    }
    private int[] convertirCoordenadasACasilla(int x, int y)
    {
    int ladoTablero = tablero.length;
    int altoPanelTablero = getHeight();
    int anchoPanelTablero = getWidth();
    int altoCasilla = altoPanelTablero / ladoTablero;
    int anchoCasilla = anchoPanelTablero / ladoTablero;
    int fila = (int) (y / altoCasilla);
    int columna = (int) (x / anchoCasilla);
    return new int[] { fila, columna };
    }
    private void cambiarColorYVecinos(int fila, int columna)
    {
        tablero[fila][columna] = !tablero[fila][columna];
        int[] filasVecinas = {fila - 1, fila + 1};
        int[] columnasVecinas = {columna - 1, columna + 1};

        for (int i : filasVecinas)
        {
            if (i >= 0 && i < tablero.length)
            {
                tablero[i][columna] = !tablero[i][columna];
            }
        }

        for (int j : columnasVecinas)
        {
            if (j >= 0 && j < tablero.length)
            {
                tablero[fila][j] = !tablero[fila][j];
            }
        }
    }
    public boolean[][] getTablero() 
    {
    	return tablero;
    }

    public boolean[][] reiniciarTablero(boolean[][] tab) 
    {
    	tablero = tab;
    	return tablero;
    }
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
