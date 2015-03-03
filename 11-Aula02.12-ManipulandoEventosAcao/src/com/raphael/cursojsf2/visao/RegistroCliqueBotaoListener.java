package com.raphael.cursojsf2.visao;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

@ManagedBean
public class RegistroCliqueBotaoListener implements ActionListener {

	@Override
	public void processAction(ActionEvent e) throws AbortProcessingException {
		System.out.println("Clicando no botão: " + e.getComponent().getId());
	}

}
