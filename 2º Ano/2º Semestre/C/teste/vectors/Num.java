public class Num extends Variable {
    double value;

    public Num(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public Variable sum(Variable v1) {
        return new Num(this.value + ((Num) v1).getValue());
    }

    @Override
    public Variable sub(Variable v1) {
        return new Num(this.value - ((Num) v1).getValue());
    }

    @Override
    public Variable mult(Variable v1) {
        if (v1 instanceof Num) {
            return new Num(this.value * ((Num) v1).getValue());
        } else {
            Vector newV1 = (Vector) v1.mult(this);
            return newV1;
        }
    }

    @Override
    public Variable product(Variable v1) {
        if (v1 instanceof Num) {
            System.out.println("ERROR: Cannot perform \".\" operation between Num and Num");
            return null;
        } else {
            Variable vec = v1.product(this);
            return vec;
        }

    }

    @Override
    public Variable minus() {
        return new Num(-value);
    }

    @Override
    public String toString() {
        return Double.toString(this.value);
    }

}