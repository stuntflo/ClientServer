package amort;

import javax.swing.JOptionPane;

public class main {
	
	static int min = 10000;
	static int anzahlRouter;
	static int zwischenspeicher = 0; 
	static int[] kuerzesteRoute = new int[100];
	static int[][] kostenRouten = new int[100][100]; 
	static int[] gesehen = new int[100]; 
	
	public static void main(String[] args){
		
		try{
			anzahlRouter=Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die Anzahl der Router ein!"));
		
			for(int i = 0; i < anzahlRouter; i++){ 
				gesehen[i] = 0; // Array gesehen wird mit Nullen gefüllt
			
				for(int j = 0; j < anzahlRouter; j++){
					kostenRouten[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die Kosten zwischen Router "+
							i+" und "+j+" ein!")); 
				}
			}
		}
		
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"Sie müssen etwas eingeben!","Warnung", JOptionPane.ERROR_MESSAGE);	
		}
		
		for(int i=0; i < anzahlRouter;i++){
			for(int j=0; j < anzahlRouter;j++){
				System.out.println("Kosten von [Router"+i+"]"+" zu"+" [Router"+j+"] = "+kostenRouten[i][j]);
			}
		}
		
		kuerzesteRoute = kostenRouten[0]; //vergleichen bekommt die Werte (Kosten) von StartRouter (A)
		
		gesehen[0] = 1; //StartRouter kennt man
		
		for(int j = 0; j<anzahlRouter; j++){
			
			for(int i = 0; i < anzahlRouter; i++){
				
				if(min > kuerzesteRoute[i] && gesehen[i]!=1 && kuerzesteRoute[i]>0){
					
					min = kuerzesteRoute[i];
					zwischenspeicher = i;
				}
			}
			
			gesehen[zwischenspeicher] = 1; //Diesen Router kennt man durch Router (i)
			
			for(int i = 0; i < anzahlRouter; i++){
				
				if(gesehen[i]!=1){
					
					if(min+kostenRouten[zwischenspeicher][i] < kuerzesteRoute[i]){
						
						kuerzesteRoute[i] = min+kostenRouten[zwischenspeicher][i];
						zwischenspeicher=i;
					}
				}
			}
		}
		
		System.out.println("Kürzester Weg:"+kuerzesteRoute[zwischenspeicher]);
		
		for(int i=0; i< anzahlRouter;i++){
			System.out.println("Pfad von Router 0 -->");
			System.out.println(zwischenspeicher);
		}
		
	}
}