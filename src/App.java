import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) throws Exception {
        String[] candidatos = {"mateus", "luiz", "amanda", "luiza", "joão", "lucas", "julio", "sergio"};

        for (String candidato : candidatos){
            entrarEmContato(candidato);
        }
    }

    static void entrarEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuaTentando = !atendeu;

            if (continuaTentando){
                tentativasRealizadas ++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
            }
        } while (continuaTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " na tentativa " + tentativasRealizadas);
        } else {
            System.out.println("Não conseguimos contato com o candidato " + candidato);
        }
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String[] candidatos = {"mateus", "luiz", "amanda", "luiza", "joão"};

        for (int i = 0; i < candidatos.length; i ++){
            System.out.printf("O candidato de n* %d é o candidato %s\n", (i + 1), candidatos[i]);
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double  salarioPretendido){
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para candidato com contra resposta");
        } else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
}
