package ru.lesson.lessons.miner.v3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;


import ru.lesson.lessons.miner.v3.MinerBoard;
import ru.lesson.lessons.miner.v3.MinerBoardGenerator;



/**
 * Created by user1 on 01.03.2017.
 */

// главный класс дл€ игры "—апер"
public class MinerMain {
    private static final JPanel controlPanel = new JPanel();
    private static final MinerBoard board = new MinerBoard();
    private static final MinerBoardGenerator minerBoardGenerator = new MinerBoardGenerator();


    public static void main(String[] arg) {
        new MinerMain().run();
    }


    public void run() {
        final JFrame frame = new JFrame();
        frame.setTitle("Miner");
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 500);

        frame.add(board, BorderLayout.CENTER);

        frame.add(controlPanel, BorderLayout.PAGE_END);
        controlPanel.setLayout(new FlowLayout());

        final JButton generate = new JButton("Start game");
        generate.addActionListener(new GenerateListener());
        controlPanel.add(generate);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public class GenerateListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            board.drawBoard(minerBoardGenerator.generate(3,3,20)); // создаем массив €чеек 3x3 и запускаем игру
            System.out.println("Game started");
        }
    }
}
