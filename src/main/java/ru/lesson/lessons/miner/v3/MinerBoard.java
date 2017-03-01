package ru.lesson.lessons.miner.v3;

import ru.lesson.lessons.miner.v3.MinerCell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by user1 on 01.03.2017.
 */

// "�����" ��� ���� "�����"
public class MinerBoard extends JPanel implements ActionListener, MouseListener {

    public MinerCell[][] minerCells; // ������ �����
    private boolean isActive; // true = ���� ������������, false = ���� ���������
    private int CELL_SIZE=50; // ������ ������ � ��������

    public MinerBoard() {
        this.addMouseListener(this);
    }

    // ������ ������ ����� ��� ����� ����
    void drawBoard(MinerCell[][] minerCells){
        this.minerCells = minerCells;
        this.isActive=true;
        this.repaint();
    }


    // ������ �����
    public void paint(Graphics g)
    {
        super.paint(g);

        if (this.minerCells != null) {

            // �������������� ��� �����
            for (int x=0;x<minerCells.length;x++) {
                for (int y=0;y<minerCells[0].length;y++) {

                    g.drawRect(x*CELL_SIZE, y*CELL_SIZE, CELL_SIZE, CELL_SIZE);

                    if (minerCells[x][y].getIsMarkedAsBomb()){
                        g.drawString("B", x*CELL_SIZE+(CELL_SIZE/2), y*CELL_SIZE+(CELL_SIZE/2));
                    }

                    if ((minerCells[x][y].getIsOpen()) || (!isActive)){
                        if (minerCells[x][y].getIsBomb()){
                            g.drawString("!", x*CELL_SIZE+(CELL_SIZE/2), y*CELL_SIZE+(CELL_SIZE/2));
                        }
                        else{
                            g.drawString(Integer.toString(minerCells[x][y].getCntMinesAround()), x*CELL_SIZE+(CELL_SIZE/2), y*CELL_SIZE+(CELL_SIZE/2));
                        }
                    }
                }
            }

            // ��������� �������� ���������� ����
            if ((checkSuccess()) && (isActive)){
                System.out.println("Congratulations! You successfully finished the game.");
                isActive=false;
            }
        }
    }


    // ��������� �������� ���������� ���� (true = ���� ������� ���������)
    public boolean checkSuccess()
    {
        boolean isSuccess = true;

        for (int x=0;x<minerCells.length;x++) {
            for (int y=0;y<minerCells[0].length;y++) {

                // ���� ���� �� �������� - �� ��� ��� �� ����� ����
                if ((minerCells[x][y].getIsBomb()) && (!(minerCells[x][y].getIsMarkedAsBomb()))) {
                    isSuccess=false;
                    break;
                }

                // ���� ���� �� ������� � �� �������� ��� ����� - �� ��� ��� �� ����� ����
                if ((!(minerCells[x][y].getIsOpen())) && (!(minerCells[x][y].getIsMarkedAsBomb()))) {
                    isSuccess=false;
                    break;
                }

            }
            if (!(isSuccess)) {
                break;
            }
        }
        return isSuccess;
    }


    public void actionPerformed(ActionEvent e) {
        //this.initGame();
    }

    //@Override
    // ������������ ���� ������
    public void mouseClicked(MouseEvent e) {

        // ��������� ������� ������
        int x=e.getX()/CELL_SIZE;
        int y=e.getY()/CELL_SIZE;
        int buttonPressed=e.getButton(); // ����� ������ ���� ������

        // ��������� ��� ������ � ������
        try{
            minerCells[x][y].getIsMarkedAsBomb();
        }catch(java.lang.ArrayIndexOutOfBoundsException ex){
            return;
        }

        // ���� ����� �������
        if((buttonPressed ==1) && (!minerCells[x][y].getIsMarkedAsBomb())){
            minerCells[x][y].setIsOpen(true);
            if (minerCells[x][y].getIsBomb()) {
                isActive=false; // ���� ������ �� ���� - ��������� ����
                System.out.println("Game over");
            }
            this.repaint();
        }

        // ���� ������ �������
        if((buttonPressed==3) && (!minerCells[x][y].getIsOpen())){
            minerCells[x][y].markAsBomb(!(minerCells[x][y].getIsMarkedAsBomb()));
            this.repaint();
        }

    }

    //@Override
    public void mousePressed(MouseEvent e) {

    }

    //@Override
    public void mouseReleased(MouseEvent e) {

    }

    //@Override
    public void mouseEntered(MouseEvent e) {

    }

    //@Override
    public void mouseExited(MouseEvent e) {

    }




}
