import javax.swing.*;
import java.util.*;
public class Eleição extends JApplet{
	
	List<Prefeito> listadosprefeitos = new ArrayList<Prefeito>();
	
	List<Vereador> listadosvereadores = new ArrayList<Vereador>();

	public void cadastrarPrefeito(){
	try{	
		Prefeito novoprefeito = new Prefeito();
		
		String nomeescolhido = JOptionPane.showInputDialog(null,"Digite o nome do candidato a Prefeito: ");
		novoprefeito.setNome(nomeescolhido);
		
		String partidoescolhido = JOptionPane.showInputDialog(null,"Digite o partido do candidato a Prefeito: ");
		novoprefeito.setPartido(partidoescolhido);
		
		int numeroescolhido = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o numero do candidato a Prefeito: "));
		novoprefeito.setNumero(numeroescolhido);	
	
		listadosprefeitos.add(novoprefeito);
	}
		catch (NumberFormatException erro1) { JOptionPane.showMessageDialog(null,"Não é permitido inserir letras, informe apenas números inteiros!");
		}
	}
	
	public void cadastrarVereador(){
		
		Vereador novovereador = new Vereador();
		
		String nomeescolhido = JOptionPane.showInputDialog(null,"Digite o nome do candidato a Vereador: ");
		novovereador.setNome(nomeescolhido);
		
		String partidoescolhido = JOptionPane.showInputDialog(null,"Digite o partido do candidato a Vereador: ");
		novovereador.setPartido(partidoescolhido);
	try{	
		int numeroescolhido = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o numero do candidato a Vereador: "));
		novovereador.setNumero(numeroescolhido);	
		
		listadosvereadores.add(novovereador);
	}
		catch (NumberFormatException erro1) { JOptionPane.showMessageDialog(null,"Não é permitido inserir letras, informe apenas números inteiros!");
		}

	}

	public void candidatosPrefeito(){
		String escolha = "Escolha um Prefeito: ";
		for(Prefeito i : listadosprefeitos){
			escolha+="\nNome:"+i.getNome()+", número: "+i.getNumero()+", partido: "+i.getPartido()+"\n";
		}
	int votoprefeito = Integer.parseInt(JOptionPane.showInputDialog(escolha));
		for(Prefeito i: listadosprefeitos){	
			if(votoprefeito==i.getNumero()){
				i.incrementaVoto();
			}
		}
	}
	
	public void candidatosVereador(){
		String escolha = "Escolha um Prefeito: ";
		for(Vereador i : listadosvereadores){
			escolha+="\nNome:"+i.getNome()+", número: "+i.getNumero()+", partido: "+i.getPartido()+"\n";
		}
	int votovereador = Integer.parseInt(JOptionPane.showInputDialog(escolha));
		for(Vereador i: listadosvereadores){	
			if(votovereador==i.getNumero()){
				i.incrementaVoto();
			}
		}
	}

	public String PrefeitoEleito(){
		
		int prefeitoeleito=0;
		String resultadoprefeito=" ";
		
		for(Prefeito i: listadosprefeitos){
		
			if(prefeitoeleito<i.getNumVotos()){
				prefeitoeleito=i.getNumVotos();
				resultadoprefeito =" "+i.getNome()+" com "+i.getNumVotos()+" votos! \n";
			}
			else if(prefeitoeleito>=i.getNumVotos()){
				resultadoprefeito+=" "+i.getNome()+" não foi eleito,seus votos foram "+i.getNumVotos()+"\n";
			}
		}
		return resultadoprefeito;
	}
	
	public String VereadorEleito(){
		
		int vereadoreleito=0;
		String resultadovereador="";
		
		for(Vereador i: listadosvereadores){
		
			if(vereadoreleito<i.getNumVotos()){
				vereadoreleito=i.getNumVotos();
				resultadovereador =" "+i.getNome()+" com "+i.getNumVotos()+" votos! \n";
			}
			else if(vereadoreleito>=i.getNumVotos()){
				resultadovereador+=" "+i.getNome()+" não foi eleito,seus votos foram "+i.getNumVotos()+"\n";;
			}
		}
		return resultadovereador;
	}

	public void init(){
	
		int opçao=-1;
		while(opçao==-1){
			try{
			int escolha = Integer.parseInt(JOptionPane.showInputDialog(null,"1-Cadastrar Prefeito\n2-Cadastrar Vereador\n3-Sair"));
				switch(escolha){
					case 1:
						cadastrarPrefeito();
						break;
					case 2:
						cadastrarVereador();
						break;
					case 3:
						opçao=3;
						break;
					default:
						JOptionPane.showMessageDialog(null, "Por gentileza digite uma opção valida !");
						break;
				}
		}
		catch(NumberFormatException erro2){
			JOptionPane.showMessageDialog(null,"Não é permitido inserir letras, informe apenas números !");
		}
			
		}		
		opçao=-1;
		while(opçao==-1){
			
			try{
			int voto = Integer.parseInt(JOptionPane.showInputDialog(null,"1-Votar em um Prefeito\n2-Votar em um Vereador\n3-Ver os resultados da eleição e sair"));
				switch(voto){
					case 1:
						candidatosPrefeito();
						break;
					case 2:
						candidatosVereador();
						break;
					case 3:
						JOptionPane.showMessageDialog(null,"------------------------------------------------------------------------------\nO candidato à prefeito eleito foi: "
					+PrefeitoEleito()+"\n------------------------------------------------------------------------------\nO candidato à vereador eleito foi: "+VereadorEleito());
						opçao=3;
						break;
					default:
						JOptionPane.showMessageDialog(null,"Por gentileza digite uma opção valida !");
						break;
				}
			}catch(NumberFormatException erro3){ JOptionPane.showMessageDialog(null, "Não é permidido inserir letras, informe apenas números !");
				
			}
		}
	System.exit(0);
	}
}