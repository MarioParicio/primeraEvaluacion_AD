package Piedra_Papel_Tijera;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;




public class Main {

    static Scanner sc = new Scanner(System.in);
    static String turn = "1";
    static String player1Choice = "";
    static String player2Choice = "";

    static Random rm = new Random();
    static String[] validActions = new String[]{"p", "x", "t"};

    public static void main(String[] args) {



        String[] gameModeValidValues = new String[]{"j", "m"};
        boolean gameStarted = false;

        System.out.println("Bienvenido a piedra, papel o tijera");

        while (!gameStarted) {

            System.out.println("Desea jugar contra otro jugador(j) o contra la maquina(m)");
            String gameMode = sc.nextLine();

            try{
                valorNoValido(gameMode, gameModeValidValues);
            } catch (valueNotValidException e){
                System.out.println(e.getMessage());
            }

            if (gameMode.equals("j")){
                gameStarted = true;
                gameVersusPlayer();
            }
            if (gameMode.equals("m")){
                gameStarted = true;
                getGameVersusPc();
            }
        }

    }

    private static void getGameVersusPc() {

        String choice = "";

        System.out.println("Jugador " + turn + ": Seleccione piedra(p), papel(x) o tijera(t)");
        if (turn == "1") {
            choice = sc.nextLine();
            player1Choice = choice;
        } else if(turn == "2"){
            sc.nextLine();
            choice = validActions[(int) (rm.nextInt(3- 0) + 0)];
            player2Choice = choice;
        }
        try {
            valorNoValido(choice, validActions);
        } catch (valueNotValidException e) {
            System.out.println(e.getMessage());
            gameVersusPlayer();
        }
        if (turn == "1"){
            for (int i = 0; i < 15; i++) {
                System.out.println("");
            }
            System.out.println("El jugador 1 ya ha seleccionado");
            turn = "2";
            gameVersusPlayer();
        } else if (turn == "2") {
        }
        {
            comprobarGanador(player1Choice, player2Choice);
        }
    }

    private static void gameVersusPlayer() {
        String choice = "";

        System.out.println("Jugador " + turn + ": Seleccione piedra(p), papel(x) o tijera(t)");
        if (turn == "1") {
            choice = sc.nextLine();
            player1Choice = choice;
        } else if(turn == "2"){
            choice = sc.nextLine();

        }
        try {
            valorNoValido(choice, validActions);
        } catch (valueNotValidException e) {
            System.out.println(e.getMessage());
            gameVersusPlayer();
        }
        if (turn == "1"){
            for (int i = 0; i < 15; i++) {
                System.out.println("");
            }
            System.out.println("El jugador 1 ya ha seleccionado");
            turn = "2";
            gameVersusPlayer();
        } else if (turn == "2") {
        }
        {
            comprobarGanador(player1Choice, player2Choice);
        }

    }

    private static void comprobarGanador(String player1Choice, String player2Choice) {

        switch (player1Choice) {
            case "p":
                if (player2Choice.equals("p")) {
                    System.out.println("Empate");
                    break;
                } else if (player2Choice.equals("x")){
                    System.out.println("Gana jugador 1");
                } else if (player2Choice.equals("t")){
                    System.out.println("Gana jugador 2");
                }
                break;

            case "x":
                if (player2Choice.equals("p")) {
                    System.out.println("Gana jugador 1");
                } else if (player2Choice.equals("x")) {
                    System.out.println("Empate");
                } else if (player2Choice.equals("t")) {
                    System.out.println("Gana jugador 2");
                }
                break;
                case "t":
                if (player2Choice.equals("p")) {
                    System.out.println("Gana jugador 2");
                } else if (player2Choice.equals("x")) {
                    System.out.println("Gana jugador 1");
                } else if (player2Choice.equals("t")) {
                    System.out.println("Empate");
                }
                break;
        }
    }

    public static void valorNoValido(String valorIntroducido, String[] valoresValidos) throws valueNotValidException {

        int j = 0;
        for (int i = 0; i < valoresValidos.length; i++) {
            if (!valoresValidos[i].equals(valorIntroducido)) {
                j++;
            }
        }
        if (j == valoresValidos.length) {
            throw new valueNotValidException();
        }
    }
}