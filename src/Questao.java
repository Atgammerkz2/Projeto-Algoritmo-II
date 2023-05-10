import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Questao {
    public Questao(String pergunta, String resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    private String pergunta;
    private String resposta;


    public void exibirQuestao() {
        System.out.println(pergunta);

        List<String> alternativas = new ArrayList<String>();
        alternativas.addAll(Arrays.asList(new String[]{"A", "B", "C", "D", "E"}));

        String valorInformado = "";
        do {
            System.out.print("\nDigite sua resposta (somente a letra da alternativa): ");
            valorInformado = Main.scanner.next();

            if(!alternativas.contains(valorInformado.toUpperCase())) {
                System.out.println("Alternativa inválida!");
            }
        } while (!alternativas.contains(valorInformado.toUpperCase()));

        if(valorInformado.equalsIgnoreCase(resposta)) {
            Avaliacao.addQtdCorreta();
        }
        Avaliacao.addResposta(valorInformado.toUpperCase());
    }
}
