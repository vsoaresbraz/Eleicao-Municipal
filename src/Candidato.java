import javax.swing.*;
public class Candidato {
	private String Nome="";
	private String Partido="";
	private int numVotos=0;
	private void Candidato(){
		String Nome="Indefinido";
		String Partido="Indefinido";
		numVotos=0;
	}
	public void incrementaVoto(){
		numVotos++;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getPartido() {
		return Partido;
	}
	public void setPartido(String partido) {
		Partido = partido;
	}
	public int getNumVotos() {
		return numVotos;
	}
	public void setNumVotos(int numVotos) {
		this.numVotos = numVotos;
	}
	
}
