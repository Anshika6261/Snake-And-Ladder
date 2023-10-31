import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.Random;
import username.*;
class Dice{
    int dice(){
        Random dice1=new Random();
        int dice2=dice1.nextInt(1,6);
        return dice2;
    }
}

class Snake{
    int snakeTail;
    int snake(int snakeHead){
        switch(snakeHead){
            case 29: this.snakeTail=9; break;
            case 38: this.snakeTail=15; break;
            case 47: this.snakeTail=5; break;
            case 53: this.snakeTail=33;break;
            case 62:this.snakeTail=37;break;
            case 86: this.snakeTail=54;break;
            case 92: this.snakeTail=70;break;
            case 97: this.snakeTail=25;break;
            default: this.snakeTail=snakeHead;
        }
        return snakeTail;
    }
}

class Ladder{
    int LadderEnd;
    int ladder(int LadderStart){
        switch(LadderStart){
            case 2:  this.LadderEnd=23; break;
            case 8:  this.LadderEnd=34; break;
            case 20:  this.LadderEnd=77; break;
            case 32:  this.LadderEnd=68; break;
            case 41:  this.LadderEnd=79; break;
            case 74:  this.LadderEnd=88; break;
            case 85:  this.LadderEnd=95; break;
            case 82:  this.LadderEnd=100; break;
            default:  this.LadderEnd=LadderStart;
        }
        return LadderEnd;
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name of the player1: ");
        String name1 = sc.nextLine();

        System.out.print("Enter age of the player1: ");
        int age1 = sc.nextInt();

        System.out.print("Enter name of the player2: ");
        String name2 = sc.next();

        System.out.print("Enter age of the player2: ");
        int age2 = sc.nextInt();

        Player player1 = new GamePlayer(name1, age1);
        player1.displayInfo1();
        Player player2 = new GamePlayer(name2, age2);
        player2.displayInfo2();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("2D Matrix");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            int numRows = 10; // Number of rows
            int numCols = 10; // Number of columns
            int[][] matrix = new int[numRows][numCols];

            JPanel matrixPanel = new JPanel(new GridLayout(numRows, numCols));

            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    JLabel label = new JLabel(Integer.toString(matrix[row][col]));
                    label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    matrixPanel.add(label);
                }
            }

            frame.add(matrixPanel);
            frame.pack();
            frame.setVisible(true);
            int i=100;
            // Update the matrix with new values (e.g., after some processing)
            for (int row = 0; row < numRows; row++) {
                if(row%2==0){
                    for (int col=0;col<numCols;col++){
                        matrix[row][col]= i;
                        JLabel label = (JLabel) matrixPanel.getComponent(row * numCols + col);
                        label.setText(Integer.toString(matrix[row][col]));
                        i--;
                    }
                }
                else{
                    for (int col=matrix[row].length-1;col>=0;col--){
                        matrix[row][col]=i;
                        JLabel label = (JLabel) matrixPanel.getComponent(row * numCols + col);
                        label.setText(Integer.toString(matrix[row][col]));
                        i--;
                    }
                }
            }
            //logic
            int position1=0;
            int position2=0;
            Dice di=new Dice();
            Snake sn=new Snake();
            Ladder la=new Ladder();
            while(position1<=100 && position2<=100){
                //player 1 dice logic
                position1=di.dice()+position1;
                position1=sn.snake(position1);
                position1=la.ladder(position1);
                if(position1>100){
                    position1=position1- di.dice();
                }

                //player 2 dice logic
                position2= di.dice()+position2;
                position2=sn.snake(position2);
                position2=la.ladder(position2);
                if(position2>100){
                    position2=position2- di.dice();
                }
                for (int row = 0; row < numRows; row++) {
                    for (int col = 0; col < numCols; col++) {
                        JLabel label = (JLabel) matrixPanel.getComponent(row * numCols + col);
                        if(matrix[row][col]==position1){
                            label.setText("#p1");
                        }
                        else if(matrix[row][col]==position2){
                            label.setText("#p2");
                        }
                    }
                }
            }

        });

    }
}