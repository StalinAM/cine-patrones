package com.cine.bean;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.cine.state.AsientoDisponible;
import com.cine.state.State;

public class Asiento implements State {
	private State state;
	private ImageIcon iconDisponible;
	private ImageIcon iconSeleccionado;
	private ImageIcon iconOcupado;

	public Asiento(ImageIcon iconDisponible, ImageIcon iconSeleccionado, ImageIcon iconOcupado) {
		this.iconDisponible = iconDisponible;
		this.iconSeleccionado = iconSeleccionado;
		this.iconOcupado = iconOcupado;
		this.state = new AsientoDisponible(iconDisponible); // Estado inicial
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public ImageIcon getIconDisponible() {
		return iconDisponible;
	}

	public ImageIcon getIconSeleccionado() {
		return iconSeleccionado;
	}

	public ImageIcon getIconOcupado() {
		return iconOcupado;
	}

	@Override
	public void handle(Asiento asiento, JButton button) {
		// TODO Auto-generated method stub
		state.handle(this, button);
	}
}