import javax.swing.*;
public class Prefeito extends Candidato {

	int numero,limiteinferior=27;
	private void Prefeito(){
		numero=0;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		
		if(numero<limiteinferior||numero>99){
			this.numero = limiteinferior;
			limiteinferior++;
		}else{
			this.numero=numero;
		}	
		
	}
}
