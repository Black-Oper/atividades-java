import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o primeiro numero: ");
        int num1 = leitor.nextInt();

        System.out.print("Informe o segundo numero: ");
        int num2 = leitor.nextInt();
        leitor.nextLine();

        System.out.print("Informe o operador (+ - * /): ");
        String op = leitor.nextLine();

        float result = Calcular.calculadora(num1, num2, op);

        System.out.println("RESULTADO: " + result);
    }
}
