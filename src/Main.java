import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        imprimirTitulo("Quiz - Tema: Curiosidades Sobre Comidas");
        System.out.print("\nPressione qualquer tecla para iniciar...");
        scanner.nextLine();

        for(int i = 0; i < Dados.Perguntas.length; i++) {
            limparConsole();
            imprimirTitulo("Questão " + (i+ 1));
            Questao q = new Questao(Dados.Perguntas[i], Dados.Respostas[i]);
            q.exibirQuestao();
        }

        limparConsole();
        imprimirTitulo("Fim do Questionário!");

        for (int i = 0; i < Avaliacao.getTotalQuestoes(); i++) {
            System.out.printf("\nQuestão %d - %s\n\nVocê escolheu a alternativa: %s\nResposta Correta: %s\n\n", i+1, Dados.Perguntas[i], Avaliacao.getRespostasInformadas()[i], Dados.Respostas[i]);
        }

        imprimirCentralizado("", 100, "=");
        System.out.printf("\nVocê acertou %d de %d questões!\n", Avaliacao.getQtdCorreta(), Avaliacao.getTotalQuestoes());
        System.out.printf("\nSua nota foi: %.1f\n\n", Avaliacao.getNota());
        imprimirCentralizado("", 100, "=");
        System.out.println();
    }

    public static void limparConsole()  {
        try{
            String operatingSystem = System.getProperty("os.name");

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        } catch(Exception e){ }
    }

    public static void imprimirTitulo(String titulo) {
        int tam = 100;

        imprimirCentralizado("", tam, "=");
        imprimirCentralizado(titulo, tam, " ");
        imprimirCentralizado("", tam, "=");
    }

    public static void imprimirCentralizado(String texto, int tamanhoMax, String caractereRepetir) {
        int esquerda = (tamanhoMax - texto.length()) / 2;
        int direita = tamanhoMax - esquerda - texto.length();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < esquerda; i++) {
            sb.append(caractereRepetir);
        }
        sb.append(texto);
        for (int i = 0; i < direita; i++) {
            sb.append(caractereRepetir);
        }

        System.out.println(sb.toString());
    }
}