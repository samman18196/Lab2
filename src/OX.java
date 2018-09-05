public class OX {



    private String[][] table = {

            {" " ,"0" ,"1" ,"2"} ,

            {"0" ,"-" ,"-" ,"-"} ,

            {"1" ,"-" ,"-" ,"-"} ,

            {"2" ,"-" ,"-" ,"-"} ,

    };

    private String player;

    private int countX;

    private int countO;

    private int countDraw;

    private int turnCount;



    public OX(){

        player = "X";

        turnCount =0;

        countX = 0;

        countO = 0;

        countDraw = 0;



    }



    public String getTableString() {

        String result = "";

        for( int row=0 ;row<table.length; row++){

            for( int col=0; col<table[row].length; col++){

                result = result + table[row][col];

            }

            result = result + "\n";

        }

        return result;

    }





    public String getCurrentPlayer() {



        return player;

    }



    public int getCountO() {

        return countO;

    }



    public int getCounrX() {



        return countX;

    }



    public int getCountDraw() {



        return countDraw;

    }





    public boolean put(int col, int row) {

        try {

            if(!table[row+1][col+1].equals("-")){

                return false;

            }

            table[row+1][col+1] = player;

        }catch (ArrayIndexOutOfBoundsException e){

            return  false;

        }

        turnCount++;



        if(checkWin(col, row)){

            if(getCurrentPlayer().equals("X")){

                countX++;

            }else if(getCurrentPlayer().equals("O")){

                countO++;

            }



        }

        if(isDraw()){

            countX++;

        }





        return true;

    }



    public void switchPlayer() {

        if( player == "X"){

            player = "O";

        }else {

            player = "X";

        }



    }



    public boolean checkWin(int col, int row) {

        // checkColWin

        boolean colWin = true;

        for( int i=0; i<3; i++){

            if(!table[i+1][col+1].equals(getCurrentPlayer())){

                colWin = false;

            }

        }

        if(colWin){

            return true;

        }

        // checkRowWin

        boolean rowWin = true;

        for( int i=0; i<3; i++){

            if(!table[row+1][i+1].equals(getCurrentPlayer())){

                rowWin = false;

            }

        }

        if(rowWin){

            return true;

        }

        // checkRowES

        boolean esWin = true;

        for( int i=0; i<3; i++){

            if(!table[i+1][i+1].equals(getCurrentPlayer())){

                esWin = false;

            }

        }

        if(esWin){

            return true;

        }

        // checkRowSS

        boolean ssWin = true;

        for( int i=0; i<3; i++){

            if(!table[i+1][3-i].equals(getCurrentPlayer())){

                ssWin = false;

            }

        }

        if(ssWin){

            return true;

        }





        return false;

    }

    public String get(int col, int row){

        if(col > 2 || col < 0 || row > 2 || row < 0){

            return null;

        }



        return table[row+1][col+1];



    }





    public void reset() {

        for( int i=0; i<3; i++){

            for( int j=0; j<3; j++){

                table[i+1][j+1] = "-";



            }

        }

        player = "X";

        turnCount = 0;

    }



    public int getTurnCount() {

        return  turnCount;



    }



    public boolean isDraw() {

        if(turnCount < 9){

            return  false;

        }

        return true;

    }



}