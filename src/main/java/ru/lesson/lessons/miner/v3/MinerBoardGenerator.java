package ru.lesson.lessons.miner.v3;

import ru.lesson.lessons.miner.v3.MinerCell;
import java.util.Random;

/**
 * Created by user1 on 01.03.2017.
 */

// класс для генерации массива ячеек для игры "Сапер"
public class MinerBoardGenerator {

    // генерируем массив MinerCell[][] (x,y - размер поля, percentMines - вероятность появления мины(0-100))
    public MinerCell[][] generate(int x, int y, int percentMines){
        Random rnd = new Random();
        MinerCell[][] minerCellArray = new MinerCell[x][y];
        int[][] cntMinesAround = new int[x][y];

        for(int xValue=0; xValue<x; xValue++) {
            for (int yValue = 0; yValue < y; yValue++) {
                boolean isMine = rnd.nextInt(100) < percentMines; // вероятность получить мину
                minerCellArray[xValue][yValue]=new MinerCell(isMine);

                if(isMine){
                    for(int i=-1; i<2; i++){
                        for(int j=-1; j<2; j++){
                            try{
                                cntMinesAround[xValue+i][yValue+j]++;
                            }catch(java.lang.ArrayIndexOutOfBoundsException e){
                            }
                        }
                    }
                }


            }
        }

        for(int xValue=0; xValue<x; xValue++) {
            for (int yValue = 0; yValue < y; yValue++) {
                minerCellArray[xValue][yValue].setCntMinesAround(cntMinesAround[xValue][yValue]);
            }
        }

        return minerCellArray;
    }

}
