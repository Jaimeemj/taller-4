package Interfaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class VentanaTop extends JFrame{

private DefaultListModel<String> lstTemp;
private JList<String> lst;
private VentanaPrincipal principal;
private Collection<RegistroTop10> lstTop;
public VentanaTop(VentanaPrincipal principal) 
{
	this.principal = principal;
	lstTemp = new DefaultListModel<String>();
	cargarDatos();
	setSize(200,400);
	setTitle("Top 10");

	

    
    setLst();
    String name;
    int puntos;
    int i = 1;
    lstTemp.addElement("# nombre");
    for (Iterator iterator = lstTop.iterator(); iterator.hasNext();) {
		RegistroTop10 registroTop10 = (RegistroTop10) iterator.next();
		name = registroTop10.darNombre();
		puntos = registroTop10.darPuntos();
		lstTemp.addElement(Integer.toString(i)+" "+name +" "+Integer.toString(puntos));
		i+=1;
	}
    lst = new JList<String>(lstTemp);
    lst.setFont(new Font("arial",Font.BOLD,18));
    JScrollPane scroll = new JScrollPane(lst);
    add(scroll,BorderLayout.CENTER);
    this.setLocationRelativeTo(principal);
    setVisible(true);
} 

	
	
private void cargarDatos() 
{
	principal.cargarDatosTop();
	setLst();
}

public void setLst() {
lstTop = principal.getRegistros();

}

}
