import javax.swing.*;
public class Vereador extends Candidato {
	int numero=0;
	int limitesuperior=43000;
	private void Vereador(){
		numero= 0;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
	
		if(numero<10000 || numero>limitesuperior){
			this.numero = limitesuperior;
			limitesuperior--;
		}else{
			this.numero=numero;
		}
	}
}
