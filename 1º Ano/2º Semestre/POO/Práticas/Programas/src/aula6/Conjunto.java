package aula6;

import java.util.Vector;

public class Conjunto {
    private Vector<Integer> data = new Vector<>();

    public void insert(int n) {
        if (!data.contains(n)) {
            data.add(n);
        }
    }

    public boolean contains(int n) {
        boolean flag = false;

        for (int c = 0; c < data.size(); c++) {
            if (data.get(c) == n) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void remove(int n) {
        if (contains(n)) {
            data.removeElement(n);
        }
    }

    public void empty() {
        data.clear();
    }

    public int size() {
        return data.size();
    }

    public Conjunto combine(Conjunto adicionar) {
        Conjunto a = new Conjunto();

        for (int c = 0; c < this.size(); c++) {
            int val = this.data.get(c);

            a.insert(val);
        }

        for (int c = 0; c < adicionar.size(); c++) {
            int val = adicionar.data.get(c);

            a.insert(val);
        }

        return a;
    }

    public Conjunto subtract(Conjunto dif) {
        Conjunto a = new Conjunto();

        for (int c = 0; c < this.size(); c++) {
            int val = this.data.get(c);

            if (dif.contains(val)) {
            } else {
                a.insert(val);
            }
        }

        return a;
    }

    public Conjunto intersect(Conjunto inter) {
        Conjunto a = new Conjunto();

        for (int c = 0; c < this.size(); c++) {
            if (inter.contains(this.data.get(c))) {
                a.insert(this.data.get(c));
            }
        }

        return a;
    }

    @Override
    public String toString() {
        String resp = "";

        for (int i = 0; i < this.data.size(); i++) {
            if (i != 0)
                resp += " ";

            resp += this.data.get(i);
        }

        return resp;
    }
}