package newmemory;

import javax.swing.*;

public class Kort extends JButton {
	public enum Status {DOLT, SYNLIGT, SAKNAS}
	private Status state;
	public Icon icon;

	//KONSTRUKTOR MED 1 PARAMETER
	public Kort(Icon icon){
		this.icon = icon;
		this.state = Kort.Status.SAKNAS;
	}
	//KONSTRUKTOR MED 2 PARAMETRAR
	public Kort(Icon icon, Status status){
		this.icon = icon;
		this.state = status;
	}

	public void setStatus(Status status){
		this.state = status;
	}

	public Status getStatus(){
		return this.state;
	}

	public Kort copy(){
		return new Kort(this.icon, this.state);
	}

	public Boolean sammaBild(Kort kort){
		if (this.getIcon() == kort.getIcon()) return true;
		return false;
	}

}