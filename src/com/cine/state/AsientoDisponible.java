package com.cine.state;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.cine.bean.Asiento;


public class AsientoDisponible implements State {
	private ImageIcon iconDisponible;

	public AsientoDisponible(ImageIcon iconDisponible) {
		this.iconDisponible = iconDisponible;
	}

	@Override
	public void handle(Asiento asiento, JButton button) {
		button.setIcon(iconDisponible);
		asiento.setState(new AsientoSeleccionado(asiento.getIconSeleccionado()));
	}

}
