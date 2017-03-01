package ru.lesson.lessons.miner.v3;

/**
 * Created by user1 on 01.03.2017.
 */

// ������ � ���� "�����"
public class MinerCell {

    private boolean isBomb; // true = ����
    private boolean isMarkedAsBomb; // true = �������� ������������� ��� ����
    private boolean isOpen; // true = ������ ������� �������������
    private int cntMinesAround; // ���������� ��� ������ ������ ������


    public MinerCell(boolean isBomb){ //isBomb: true = ����
        this.isBomb=isBomb;
        this.isMarkedAsBomb=false;
        this.isOpen=false;
        this.cntMinesAround=0;
    }

    public boolean getIsBomb(){
        return this.isBomb;
    }

    public boolean getIsMarkedAsBomb(){
        return this.isMarkedAsBomb;
    }

    public void markAsBomb(boolean IsMarkedAsBomb){
        this.isMarkedAsBomb = IsMarkedAsBomb;
    }

    public int getCntMinesAround(){
        return this.cntMinesAround;
    }
    public void setCntMinesAround(int cntMinesAround){
        this.cntMinesAround = cntMinesAround;
    }

    public boolean getIsOpen(){
        return this.isOpen;
    }
    public void setIsOpen(boolean isOpen){
        this.isOpen = isOpen;
    }
}
