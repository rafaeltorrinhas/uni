package aula4.src;

public class Circulo {

    double raio;

    public Circulo(double valorRaio) {

        if (valorRaio <= 0) {

            System.out.println("Valor inválido - será considerado um valor de raio igual a 1.0");
            raio = 1.0;

        } else {

            raio = valorRaio;

        }

    }

    public String toString() {
        return "Circulo - raio: " + raio;
    }

    public void setRaio(double novoValor) {

        if (raio <= 0) {

            System.out.println("Valor inválido - será considerado um valor de raio igual a 1.0");
            raio = 1.0;

        } else {

            raio = novoValor;

        }
    }

    public double getRaio() {
        return raio;
    }

    public boolean equals(Circulo outroCirculo) {
        return (raio == outroCirculo.raio);
    }

    public double perimetro() {
        return 2 * Math.PI * raio;
    }

    public double area() {
        return Math.PI * Math.pow(raio, 2);
    }
}
