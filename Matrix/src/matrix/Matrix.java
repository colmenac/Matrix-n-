package matrix;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;


public class Matrix {
    public Matrix(){
        //No need for constructor
    }
    public void start() throws IOException{
        int rowOne,rowTwo,ColumnOne,ColumnTwo;
        System.out.println(("Please enter matrix one's size"));
        Scanner scan = new Scanner(System.in);
        rowOne= scan.nextInt();
        ColumnOne= scan.nextInt();
        System.out.println(("Please enter matrix two's size"));
        rowTwo=scan.nextInt();
        ColumnTwo= scan.nextInt();;
        if(ColumnOne==rowTwo)
        {
            int a[][]= new int[rowOne][ColumnOne];
            int b[][]= new int[rowTwo][ColumnTwo];
            int result[][]=new int[rowOne][ColumnTwo];

            System.out.println("Contents of matrix1:");
            for(int i=0;i<rowOne;i++)
            {
                for(int j=0;j<ColumnOne;j++)
                {
                    a[i][j] = (int) (Math.random() % 20 + 1);
                    System.out.print(" "+a[i][j]);
                }
                System.out.println();
            }

            System.out.println();

            System.out.println("Contents of matrix2:");
            for(int i=0;i<rowTwo;i++)
            {
                for(int j=0;j<ColumnTwo;j++)
                {
                    b[i][j]=(int) Math.random()%20+1;
                    System.out.print(" "+b[i][j]);
                }
                System.out.println();
            }

            System.out.println();
            for(int i = 0; i < rowOne; i++)
            {
                for(int j = 0; j < ColumnTwo; j++)
                {
                    result[i][j]=0;
                }
            }

            for(int i = 0; i < rowOne; ++i)
            {
                for(int j = 0; j < ColumnTwo; ++j)
                {
                    for(int k = 0; k < ColumnOne; ++k)
                    {
                        result[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            File filey= new File("programOutput.txt");
            BufferedWriter bf = new BufferedWriter(new FileWriter(filey));

            System.out.println("Output Matrix contents:");
            for(int i = 0; i < rowOne; ++i)
            {
                for(int j = 0; j < ColumnTwo; ++j)
                {
                    System.out.print(" " + result[i][j]);
                    bf.write(result[i][j]+" ");
                    if(j == ColumnTwo-1)
                    {
                        System.out.println();
                        bf.write("\n");
                    }
                }
            }
            bf.close();
        }
        else{
            System.out.println("Not available with the current parameters, try again.");
        }
    }

    public static void main(String[] args) throws IOException{
        Matrix neo = new Matrix();
        neo.start();
        System.out.println("Terminating...");
        }
}