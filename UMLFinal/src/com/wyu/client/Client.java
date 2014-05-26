package com.wyu.client;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.wyu.jframe.LoginFace;

public class Client {

	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFace frame = new LoginFace();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
