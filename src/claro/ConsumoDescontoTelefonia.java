package claro;

import java.util.Arrays;
import java.util.Scanner;

// Classe para representar um serviço
class Servico {
    private double valor;

    public Servico(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}

// Classe para representar o combo de serviços
class ComboServicos {
    private Servico[] servicos;
    private double[] descontos;
    private double descontoAdicional = 20.00;

    public ComboServicos(Servico[] servicos, double[] descontos) {
        this.servicos = servicos;
        this.descontos = descontos;
    }

    // Método para calcular o valor total do combo com descontos
    public double calcularValorTotal() {
        // Conta quantos serviços foram contratados (com valor maior que 0)
        int servicosContratados = (int) Arrays.stream(servicos)
                .filter(servico -> servico.getValor() > 0)
                .count();
        
        double desconto = 0;
        double porcentagemDesconto = 0;

        switch (servicosContratados) {
            case 1:
                porcentagemDesconto = descontos[0];
                break;
            case 2:
                porcentagemDesconto = descontos[1];
                break;
            case 3:
                porcentagemDesconto = descontos[2];
                desconto+=20;   
                break;   
        }

        for (Servico servico : servicos) {
            desconto+=servico.getValor()*(porcentagemDesconto/100);
        }
       

        // Calcula o valor total com desconto
        double valorComDesconto = Arrays.stream(servicos)
                .filter(servico -> servico.getValor() > 0)
                .mapToDouble(Servico::getValor)
                .sum() - desconto;

       
        return valorComDesconto;
        
    }
}

public class ConsumoDescontoTelefonia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura da primeira linha de entrada
        String[] entrada1 = scanner.nextLine().trim().split(",");
        double[] valoresServicos = Arrays.stream(entrada1)
                .mapToDouble(Double::parseDouble)
                .toArray();

        // Leitura da segunda linha de entrada
        String[] entrada2 = scanner.nextLine().trim().split(",");
        double[] descontos = Arrays.stream(entrada2)
                .mapToDouble(Double::parseDouble)
                .toArray();

        // Criando objetos Servico
        Servico[] servicos = new Servico[valoresServicos.length];
        for (int i = 0; i < valoresServicos.length; i++) {
            servicos[i] = new Servico(valoresServicos[i]);
        }

        // Criando o combo de serviços
        ComboServicos combo = new ComboServicos(servicos, descontos);

        // Calculando e imprimindo o valor total com desconto
        double valorTotal = combo.calcularValorTotal();
        System.out.printf("%.2f\n", valorTotal);

        scanner.close();
    }
}