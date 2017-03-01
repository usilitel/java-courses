package ru.lesson.lessons.miner.v3;

/**
 * Created by user1 on 01.03.2017.
 */

// €чейка в игре "—апер"
public class MinerCell {

    private boolean isBomb; // true = мина
    private boolean isMarkedAsBomb; // true = помечено пользователем как мина
    private boolean isOpen; // true = €чейка открыта пользователем
    private int cntMinesAround; // количество мин вокруг данной €чейки


    public MinerCell(boolean isBomb){ //isBomb: true = мина
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
