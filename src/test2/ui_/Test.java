package test2.ui_;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test {
	TextArea ta;
	TextField tf;
	
	public void createUI() {
		Frame f = new Frame("메모장");
		Button b1 = new Button("전송");
		Button b2 = new Button("button2");
		Button b3 = new Button("button3");
		Button b4 = new Button("button2");
		Button b5 = new Button("체크");
		Panel p = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Canvas ca = new Canvas();
		ta = new TextArea();
		tf = new TextField(30);
		
		f.setSize(400, 500);
		f.setLocation(70, 300);
		
		ca.setBackground(Color.orange);
		ca.setSize(100,500);
		ca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ta.append("마우스가 캔버스 안으로 진입"+'\n');
				tf.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ta.append("마우스가 캔버스 밖으로 나감"+'\n');
				tf.setText("");
			}
		});
		b2.setBounds(0,0, 130, 75);
		b3.setBounds(0,100, 130, 75);
		f.add(ta, BorderLayout.CENTER);
		f.add(p, BorderLayout.SOUTH);
		f.add(p2, BorderLayout.EAST);
		f.add(p3, BorderLayout.WEST);
		p3.add(b2);
		p3.add(b3);
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ta.append("button2 클릭"+'\n');
				tf.setText("");
		     }
		});
		b3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ta.append("button3 클릭"+'\n');
				tf.setText("");
		     }
		});
		p2.add(ca);
		p.add(tf);
		p.add(b1);
		
		/* 한 번만 사용 되는 코드 > 리팩토링
		 * WindowListener handler1 =new MyFrameHandler(); f.addWindowListener(handler1);
		 */
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		/*
		 * b1.addActionListener(handler2); tf.addActionListener(handler2);
		 */
		b1.addActionListener((e) -> {
				// TODO Auto-generated method stub
				ta.append(tf.getText()+'\n');
				tf.setText("");
			}
		);
		tf.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ta.append(tf.getText()+'\n');
				tf.setText("");
			}
		});
		
		f.setVisible(true);
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.createUI();
	}
	
	
	
}
