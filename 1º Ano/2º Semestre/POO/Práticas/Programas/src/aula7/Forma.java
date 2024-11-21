package aula7;

public abstract class Forma {
    protected String cor;

    public Forma(String cor) {
        this.cor = cor;
    }

    public abstract double perimetro();

    public abstract double area();
}

class Triangulo extends Forma {

    double lado1, lado2, lado3;

    public Triangulo(String cor, double l1, double l2, double l3) {
        super(cor);
        if (l1 <= 0 || l2 <= 0 || l3 <= 0 || l1 >= l2 + l3 || l2 >= l1 + l3 || l3 >= l1 + l2) {
            System.out.println("Valores inválidos - todos os lados serão considerados com valor igual a 1.0!");
            l1 = 1.0;
            l2 = 1.0;
            l3 = 1.0;
        } else {
            lado1 = l1;
            lado2 = l2;
            lado3 = l3;
        }
    }

    public String toString() {
        return ("Triangulo - lado 1: " + lado1 + " lado 2: " + lado2 + " lado3: " + lado3);
    }

    public void setLados(double NLado1, double NLado2, double NLado3) {
        if (NLado1 <= 0 || NLado2 <= 0 || NLado3 <= 0 || NLado1 >= NLado2 + NLado3 || NLado2 >= NLado1 + NLado3
                || NLado3 >= NLado1 + NLado2) {
            System.out.println("Valores inválidos - todos os lados serão considerados com valor igual a 1.0!");
            NLado1 = 1.0;
            NLado2 = 1.0;
            NLado3 = 1.0;
        } else {
            lado1 = NLado1;
            lado2 = NLado2;
            lado3 = NLado3;
        }
    } // deveria colocar 1 set +ara cada atributo

    public String getLados() {
        String stringLados = String.format("%.2f, %.2f, %.2f", lado1, lado2, lado3);
        return stringLados;
    } // deveria colocar 1 get +ara cada atributo

    public boolean equals(Triangulo outroTriangulo) {
        if ((lado1 == outroTriangulo.lado1 && lado2 == outroTriangulo.lado2 && lado3 == outroTriangulo.lado3)
                || (this.cor == outroTriangulo.cor))
            return true;
        else
            return false;

    }

    public double area() {
        double s = (lado1 + lado2 + lado3) / 2.0;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    public double perimetro() {
        double p = lado1 + lado2 + lado3;
        return p;
    }
}

class Circulo extends Forma {

    double raio;

    public Circulo(String cor, double valorRaio) {
        super(cor);
        if (valorRaio <= 0) {
            System.out.println("Valor inválido - será consuderado um raio igual a 1.0!");
            raio = 1.0;
        }

        else
            raio = valorRaio;
    }

    public String toString() {
        return "Circulo - raio: " + raio;
    }

    public void setRaio(double novoValor) {
        if (novoValor <= 0) {
            System.out.println("Valor inválido - será consuderado um raio igual a 1.0!");
            raio = 1.0;
        }

        else
            raio = novoValor;
    }

    public double getRaio() {
        return raio;
    }

    public boolean equals(Circulo outroCirculo) {
        // return raio == outroCirculo.raio;

        if ((raio == outroCirculo.raio) || (this.cor == outroCirculo.cor))
            return true;
        else
            return false;
    }

    public double perimetro() {
        return 2 * Math.PI * raio;
    }

    public double area() {
        return Math.PI * Math.pow(raio, 2);
    }

}

class Retangulo extends Forma {

    double comprimento, altura;

    public Retangulo(String cor, double comprimento, double altura) {
        super(cor);
        if (altura <= 0 || comprimento <= 0) {
            System.out.println("Valores inválidos - altura e comprimento serão considerados como iguais a 1.0!");
            this.comprimento = 1.0;
            this.altura = 1.0;
        } else {
            this.comprimento = comprimento;
            this.altura = altura;
        }
    }

    public String toString() {
        return "Retangulo: Comprimento: " + comprimento + " Altura: " + altura;
    }

    public void setDimensoes(double novoComprimento, double novaAltura) {
        if (novaAltura <= 0 || novoComprimento <= 0) {
            System.out.println("Valores inválidos - altura e comprimento serão considerados como iguais a 1.0!");
            comprimento = 1.0;
            altura = 1.0;
        } else {
            comprimento = novoComprimento;
            altura = novaAltura;
        }
    } // deveria colocar 1 set +ara cada atributo

    public double[] getDimensoes() {
        double[] dimensoes = new double[] { comprimento, altura };
        return dimensoes;
    } // deveria colocar 1 get +ara cada atributo

    public boolean equals(Retangulo outroRetangulo) {
        if ((comprimento == outroRetangulo.comprimento || comprimento == outroRetangulo.altura)
                && (altura == outroRetangulo.altura || altura == outroRetangulo.comprimento)
                || (this.cor == outroRetangulo.cor))
            return true;
        else
            return false;
    }

    public double area() {
        double area = comprimento * altura;
        return area;
    }

    public double perimetro() {
        double perimetro = 2 * comprimento + 2 * altura;
        return perimetro;
    }
}
