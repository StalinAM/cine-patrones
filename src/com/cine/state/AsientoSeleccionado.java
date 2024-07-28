package com.cine.state;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.cine.bean.Asiento;

public class AsientoSeleccionado implements State {
	private ImageIcon iconSeleccionado;

	public AsientoSeleccionado(ImageIcon iconSeleccionado) {
		this.iconSeleccionado = iconSeleccionado;
	}

	@Override
	public void handle(Asiento asiento, JButton button) {
		button.setIcon(iconSeleccionado);
		asiento.setState(new AsientoDisponible(asiento.getIconDisponible()));
	}

}
