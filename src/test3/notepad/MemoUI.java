package test3.notepad;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MemoUI {
	
	public void createUi() {
		Frame f=new Frame("�޸���");
		TextArea ta=new TextArea();
		MenuBar mb = new MenuBar();
		Menu file_menu = new Menu("����");
		Menu edit_menu = new Menu("����");
		MenuItem new_item = new MenuItem("���θ����");
		MenuItem open_item = new MenuItem("����");
		MenuItem save_item = new MenuItem("����");
		
		file_menu.add(new_item);
		file_menu.add(open_item);
		file_menu.add(save_item);
		mb.add(file_menu);
		mb.add(edit_menu);
		f.setMenuBar(mb);
		f.add(ta);
		f.setSize(400,500);
		f.setLocation(1300,150);
		
		open_item.addActionListener(new ActionListener() {

			//����
			@Override
			public void actionPerformed(ActionEvent ec) {
				FileDialog open_dialog = new FileDialog(f,"����",FileDialog.LOAD);
				open_dialog.setVisible(true);
				String path = open_dialog.getDirectory()+open_dialog.getFile();
				try(BufferedReader in = new BufferedReader(new FileReader(path))) {
					String oneLine = "";
					while((oneLine =in.readLine())!=null) {
						ta.append(oneLine+'\n');
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		//����
		save_item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ec) {
				//���� ���̾�αװ� ������
				FileDialog save_dialog = new FileDialog(f, "����", FileDialog.SAVE);
				save_dialog.setVisible(true);
				String path = save_dialog.getDirectory()+save_dialog.getFile();
				try(FileWriter out = new FileWriter(path)) { //auto-closable
					out.write(ta.getText());
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				
			}
			}
		});
		
		new_item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
			}
		});
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		f.setVisible(true);
	}

	public static void main(String[] args) {		
		new MemoUI().createUi();
	}

}
