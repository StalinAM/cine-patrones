package com.cine.state;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.cine.bean.Asiento;

public class AsientoOcupado implements State {

	private ImageIcon iconOcupado;

	public AsientoOcupado(ImageIcon iconOcupado) {
		this.iconOcupado = iconOcupado;
	}

	@Override
	public void handle(Asiento asiento, JButton button) {
		button.setIcon(iconOcupado);
		// No cambiar de estado, el asiento permanece ocupado
	}

}
