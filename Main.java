import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char choice;
        System.out.println("\n\t\tProject 1");
        System.out.println("\t-----------------");
        do{
           System.out.println("1- Play one round\n\n2- Play three rounds\n\ne- to exit\n");
            System.out.print("-> ");
          choice = scan.next().charAt(0);
       }while(choice !='1' && choice!='2'&& choice!='e' );
        if(choice == '1'){
            System.out.println(playBoard()+"\n");
        }else if(choice == '2'){
            int p1,p2;
            p1=0;
            p2=0;
            for (int i = 0 ; i <3 ;i++){
                System.out.printf("Round %d \n---------\n",i+1);
                String winner = playBoard();
                if(winner.equals("Player 1 win"))p1++;
                else if (winner.equals("Player 2 win")) p2++;
                else {
                    p1++;
                    p2++;
                }
            }
            System.out.printf("\t\tThe result \n \t----------------- \nPlayer 1 = %d\tPlayer 2 = %d \n\n",p1,p2);
            if(p1>p2) System.out.println("Player 1 win");
            else if (p1<p2) System.out.println("Player 2 win");
            else System.out.println("Draw");
        }

    }

        public static void display(char [] [] board){
            System.out.println("\t0\t\t1\t\t2");
            for(int i = 0 ; i <board.length ; i++){
                System.out.print(i+"\t");
                for(int j = 0; j<board[i].length;j++){
                    if(j==1){
                        System.out.print("\t|\t"+board[i][j]+"\t|\t");
                    }else{
                        System.out.print(board[i][j]);
                    }

                }
                if(i!=2)System.out.println("\n\t--------------------");
                else System.out.println();
            }
        }

        public static String playBoard(){
            Scanner scan = new Scanner(System.in);
            Random rand = new Random();
            char board [] []=  new char[3][3];
            char player;
            do{
                System.out.println("Choose x  or o");
                player = scan.next().charAt(0);
            }while(player != 'x'&& player != 'o');
            int i=0;
            boolean player1= false;
            boolean player2= false;

            for(i = 0; i <9 ;){
                boolean oOrx = false;
                if(player == 'o') oOrx = true;
                int col ;
                int row ;
                do{
                    do{
                        System.out.println("Enter col number between 0-2: ");
                        col = scan.nextInt();
                    }while(col != 0 && col!= 1 && col != 2);
                    do{
                        System.out.println("Enter row number between 0-2: ");
                        row = scan.nextInt();
                    }while(row != 0 && row != 1 && row !=2);

                }while(board[col][row]=='x'||board[col][row]=='o');
                board[col] [row] = player;
                i++;
                if(check(board,col,row)){
                    player1= true;
                    break;
                }

                int randCol;
                int randRow;
                do{
                    randCol=rand.nextInt(3);
                    randRow=rand.nextInt(3);
                }while(board[randCol][randRow]=='x'||board[randCol][randRow]=='o');
                System.out.println("randCol= "+randCol+" randRow= "+randRow);
                if(oOrx) board[randCol][randRow] = 'x';
                else board[randCol][randRow] = 'o';
                i++;
                if(check(board,randCol,randRow)){
                    player2= true;
                    break;
                }
                display(board);
            }

            display(board);
            if(player1) return "Player 1 win";
            else if(player2) return "Player 2 win";
            else return "Draw";

        }

        public static boolean check(char [] [] ar , int col , int row){
            if(col == 1 && row ==1){
                if(ar[col][row]== ar[0][0] && ar[col][row]==ar[2][2]){
                    return true;
                }
                if(ar[col][row]== ar[2][0]&& ar[col][row]== ar[0][2]){
                    return true;
                }
                if(ar[col][row]== ar[0][1]&& ar[col][row]== ar[2][1]){
                    return true;
                }
                if(ar[col][row]== ar[2][0]&& ar[col][row]== ar[0][2]){
                    return true;

                }
                if(ar[col][row]== ar[1][0]&& ar[col][row]== ar[1][2]){
                    return true;
                }
            }else if(col == 0&& row ==0){
                if(ar[col][row]== ar[1][1] && ar[col][row]==ar[2][2]){
                    return true;
                }if(ar[col][row]== ar[1][0] && ar[col][row]==ar[2][0]){
                    return true;
                }
                if(ar[col][row]== ar[0][1] && ar[col][row]==ar[0][2]){
                    return true;
                }
            }else if(col == 2 && row == 2){
                if(ar[col][row]== ar[1][1] && ar[col][row]==ar[0][0]){
                    return true;
                }
                if(ar[col][row]== ar[1][2] && ar[col][row]==ar[0][2]){
                    return true;
                }
                if(ar[col][row]== ar[2][0] && ar[col][row]==ar[2][1]){
                    return true;
                }
            }else if(col == 0 && row == 2){
                if(ar[col][row]== ar[1][1] && ar[col][row]==ar[2][0]){
                    return true;
                }
                if(ar[col][row]== ar[0][0] && ar[col][row]==ar[0][1]){
                    return true;
                }
                if(ar[col][row]== ar[1][2] && ar[col][row]==ar[2][2]){
                    return true;
                }
            }else if(col == 2 && row == 0){
                if(ar[col][row]== ar[1][1] && ar[col][row]==ar[0][2]){
                    return true;
                }
                if(ar[col][row]== ar[0][0] && ar[col][row]==ar[1][0]){
                    return true;
                }
                if(ar[col][row]== ar[2][1] && ar[col][row]==ar[2][2]){
                    return true;
                }
            }else{
                int c = 0;
                int r = 0;
                for(int i = 0 ; i<3;i++){
                     if(ar[i][row]== ar[col][row]) c++;
                }
                for(int i = 0 ; i<3;i++){
                    if(ar[col][i] ==ar[col][row]) r++;
                }
                if(r==3 || c==3) return true;

            }
            return false;
        }



}