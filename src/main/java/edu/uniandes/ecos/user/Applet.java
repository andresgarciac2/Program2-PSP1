package edu.uniandes.ecos.user;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.uniandes.ecos.program.Part;
import edu.uniandes.ecos.program.ProgramResult;
import edu.uniandes.ecos.reader.Reader;


public class Applet extends JPanel
   implements ActionListener {
   JButton go;
   JLabel output;
   Reader reader = new Reader();
   JFileChooser chooser;
   String choosertitle;
   
  public Applet() {
    go = new JButton("Buscar folder");
    go.setSize(100,100);
    go.addActionListener(this);
    add(go);
   }

  public void actionPerformed(ActionEvent e) {
    int result;
    ProgramResult pr = new ProgramResult(new ArrayList<Part>(), 0);  
    String totalSize = "";
    chooser = new JFileChooser(); 
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle(choosertitle);
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
      reader.listFilesForFolder(chooser.getSelectedFile());
      pr = reader.getResults();
      for(Part p : pr.getParts()){
    	  totalSize += "Nombre de la clase: " + p.getName()+ "\n";
    	  totalSize += "Numero de metodos: " + p.getMethods()+ "\n";
    	  totalSize += "Tamaño de la clase: " + p.getSize()+ "\n";
    	  totalSize += "----------------------------------------\n";
      }
      totalSize += "TAMAÑO TOTAL: " + pr.getSize();
      System.out.println(totalSize);
      JOptionPane.showMessageDialog(null, totalSize);
      }
     }
   public String getSelectedFolder(){
	   return chooser.getSelectedFile().getPath();
   }
  public Dimension getPreferredSize(){
    return new Dimension(550, 550);
    }
}