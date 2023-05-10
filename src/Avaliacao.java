public class Avaliacao {
    private static int qtdCorreta = 0;
    private static String[] respostasInformadas = new String[Dados.Perguntas.length];
    private static int index = 0;

    public static int getQtdCorreta() {
        return qtdCorreta;
    }

    public static void addQtdCorreta() {
        qtdCorreta++;
    }

    public static int getTotalQuestoes() {
        return Dados.Perguntas.length;
    }

    public static float getNota() {
        return (float)qtdCorreta / (float)getTotalQuestoes() * 10.0f;
    }

    public static String[] getRespostasInformadas() {
        return respostasInformadas;
    }

    public static void addResposta(String resposta) {
        respostasInformadas[index] = resposta;
        index++;
    }
}
