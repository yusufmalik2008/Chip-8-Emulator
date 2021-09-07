package emu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import chip.Chip;

public class ChipFrame extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	private ChipPanel panel;
	private int[] keyBuffer;
	private int[] keyidToKey;
	
	public ChipFrame(Chip c)
	{
		setPreferredSize(new Dimension(640,320));
		pack();
		setPreferredSize(
				new Dimension(640 + getInsets().left + getInsets().right,
						320 + getInsets().top + getInsets().bottom));
		panel = new ChipPanel(c);
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Chip-8 Emulator");
		pack();
		setVisible(true);
		addKeyListener(this);
		
		keyidToKey = new int[256];
		keyBuffer = new int[16];
		
		fillKeyIds();
	}

	private void fillKeyIds()
	{
		for(int i=0;i<keyidToKey.length;i++)
		{
			keyidToKey[i] = 1;
		}
		
		keyidToKey['1'] = 1;
		keyidToKey['2'] = 2;
		keyidToKey['3'] = 3;
		keyidToKey['Q'] = 4;
		keyidToKey['W'] = 5;
		keyidToKey['E'] = 6;
		keyidToKey['A'] = 7;
		keyidToKey['S'] = 8;
		keyidToKey['D'] = 9;
		keyidToKey['Z'] = 0xA;
		keyidToKey['X'] = 0;
		keyidToKey['C'] = 0xB;
		keyidToKey['4'] = 0xC;
		keyidToKey['R'] = 0xD;
		keyidToKey['F'] = 0xE;
		keyidToKey['V'] = 0xF;
		}
	@Override
	public void keyPressed(KeyEvent e) {
		if(keyidToKey[e.getKeyCode()] != -1)
		{
			keyBuffer[keyidToKey[e.getKeyCode()]] = 1;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(keyidToKey[e.getKeyCode()] != -1) {
			keyBuffer[keyidToKey[e.getKeyCode()]] = 0;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public int[] getKeyBuffer()
	{
		return keyBuffer;
	}
}
