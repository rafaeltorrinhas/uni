public class Vector extends Variable {
    double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public double[] getValue() {
        return this.value;
    }

    @Override
    public Variable sum(Variable v1) {
        double[] total = new double[this.value.length];
        for (int i = 0; i < this.value.length; i++) {
            total[i] = this.value[i] + ((Vector) v1).getValue()[i];
        }
        return new Vector(total);
    }

    @Override
    public Variable sub(Variable v1) {
        double[] total = new double[this.value.length];
        for (int i = 0; i < this.value.length; i++) {
            total[i] = this.value[i] - ((Vector) v1).getValue()[i];
        }
        return new Vector(total);
    }

    @Override
    public Variable mult(Variable v1) {
        double[] total = new double[this.value.length];
        if (v1 instanceof Vector) {
            System.out.println("ERROR: Cannot perform \"*\" operation between Vector and Vector.");
            return null;
        } else {
            for (int i = 0; i < this.value.length; i++) {
                total[i] = this.value[i] * ((Num) v1).getValue();
            }
        }
        return new Vector(total);
    }

    @Override
    public Variable product(Variable v1) {
        double total = 0;
        if (v1 instanceof Num) {
            for (int i = 0; i < this.value.length; i++) {
                total += this.value[i] * ((Num) v1).getValue();
            }
        } else {
            for (int i = 0; i < this.value.length; i++) {
                total += this.value[i] * ((Vector) v1).getValue()[i];
            }
        }

        return new Num(total);
    }

    @Override
    public Variable minus() {
        double[] total = new double[this.value.length];
        for (int i = 0; i < this.value.length; i++) {
            total[i] = -this.value[i];
        }
        return new Vector(total);
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(value);
    }
}
