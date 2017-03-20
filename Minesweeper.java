
package minesweeper;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Minesweeper {
static char a[][]=new char[9][9];
static char b[][]=new char[9][9];
static char e[][]=new char[9][9];
static int c; 
static int d;
static int move1,move2,check=0;
static int counter=0;


static void random()
{
c=ThreadLocalRandom.current().nextInt(0,9); 
d=ThreadLocalRandom.current().nextInt(0,9);
        b[c][d]='M';
        }


static void board()
{
    System.out.println();
    System.out.println();
    System.out.println("   0 1 2 3 4 5 6 7 8");
    for(int i=0;i<9;i++)
{if(i==0)
System.out.println("  ------------------");
else
        System.out.println();
    System.out.printf(i+"| ");
 for(int j=0;j<9;j++)
 System.out.printf(e[i][j]+" ");}
}

static void finboard()
{
 for(int i=0;i<9;i++)
 for(int j=0;j<9;j++)
 {if(b[i][j]!='M')
     e[i][j]=a[i][j];
 else
     e[i][j]=b[i][j];
 }
board();
}


static void sweep()
{
        System.out.println();
        System.out.println();
        System.out.println("enter where to sweep according to the co-ordinates");
        Scanner scan=new Scanner(System.in);
        move1=scan.nextInt();
        move2=scan.nextInt();
}


static void gamelogic()
{
        for(int i=0;i<9;i++)
        for(int j=0;j<9;j++)
        {if(move1==i&&move2==j)
        if(b[i][j]=='M')
        {   System.out.println();  
            System.out.println("game over");
        finboard();
        check=2;}
        else
        {  
        if(a[i][j]=='0')
        {
        e[i][j]=a[i][j];
        }
        else
            e[i][j]=a[i][j];
        board();}
        }
}


static void check()
{
 int count=0;
 for(int i=0;i<9;i++)
 for(int j=0;j<9;j++)
     if(e[i][j]=='+')
         count++;
 if(count==counter)
 {
     System.out.println("you win!!!!!!!!!!");
 check=1;
 }
}


static void info()
{   
    System.out.println("this is a basic implementation of the game minesweeper");
    System.out.println("you have to enter the co-ordinates of the block which you want to sweep");
    System.out.println("the letter M denotes the mines the nos denote the number of mines around a particular block");
    System.out.println("the game still lacks a minor part that is the when an empty block is sweeped the other empty ");
    System.out.println("blocks around it aren't sweeped but without this part too the game is logically playable");
    System.out.println("THANK YOU");
}

    public static void main(String[] args) {
    int i,j,k,l;
    
    info();
    
        for(i=0;i<9;i++)
        for(j=0;j<9;j++)
        b[i][j]='+';
       
        for(i=0;i<12;i++)
        random();        
        
        for(i=0;i<9;i++)
        for(j=0;j<9;j++)
        {if(b[i][j]=='M')
            counter++;}
     
        for(i=0;i<9;i++)
        for(j=0;j<9;j++)
        {
         if(i==0&&j==0)
        {
         a[i][j]='0';
         for(k=0;k<2;k++)
         for(l=0;l<2;l++)
         if(b[k][l]=='M')
             a[i][j]++;
             }
         
        else if(i==0&&j>0&&(j<9))
        {
         a[i][j]='0';
         for(k=i;k<2;k++)
         for(l=j-1;l<=j+1&&l<=8;l++)
         {if(b[k][l]=='M')
             a[i][j]++;}
        }
        
        else if(i==8&&j>0&&(j<9))
        {
         a[i][j]='0';
        for(k=i-1;k<=i;k++)
        for(l=j-1;l<=j+1&&l<=8;l++)
        {if(b[k][l]=='M')
            a[i][j]++;}
        }
        
        else if(i==8&&j==0)
        {
         a[i][j]='0';
        for(k=7;k<9;k++)
        for(l=0;l<2;l++)
        {
            if(b[k][l]=='M')
            a[i][j]++;
             }
        } 
        
        else if(j==0)
        {
         a[i][j]='0';
        for(k=i-1;k<=i+1;k++)
        for(l=0;l<2;l++)
        {
            if(b[k][l]=='M')
            a[i][j]++;
             }
        }
        
        else if(j==8)
        {
         a[i][j]='0';
        for(k=i-1;k<=i+1;k++)
        for(l=7;l<9;l++)
        {
            if(b[k][l]=='M')
            a[i][j]++;}
        }
        
        else 
        {
            a[i][j]='0';
         for(k=i-1;k<i+2;k++)
         for(l=j-1;l<j+2;l++)
         {
             if(b[k][l]=='M')
         {
             a[i][j]++;
         }}
        }
        }
        
        for(i=0;i<9;i++)
        for(j=0;j<9;j++)
        e[i][j]='+';
        
        
       for(i=0;;i++)
       {
        if(i==0)
        board();
        sweep();
        gamelogic();
        check();
       if(check==1)
           break;
       if(check==2)
           break;
       }
        
    }
    }
    

