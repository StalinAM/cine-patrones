package com.cine.state;

import javax.swing.JButton;

import com.cine.bean.Asiento;

public interface State {

	void handle(Asiento asiento, JButton button);

}
