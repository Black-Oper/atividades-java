public class Calcular {
    public static float calculadora(int num1, int num2, String op) {
        float result = 0;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("IMPOSSÍVEL DIVIDIR POR ZERO!!!");
                } else {
                    result = (float) num1 / num2;
                }
                break;
            default:
                System.out.println("OPERADOR INVÁLIDO!!!");
                break;
        }
        return result;
    }
}
