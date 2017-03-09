package br.ufpr.inf.gres.irace.measure.qualityindicator;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.front.Front;
import org.uma.jmetal.util.front.imp.ArrayFront;
import org.uma.jmetal.util.front.util.FrontUtils;

public abstract class Calculator {

    protected double[] maximumValues;
    protected double[] minimumValues;
    protected Front paretoTrueFront;
    protected int numberOfObjectives;

    public Calculator() {
        this.maximumValues = null;
        this.minimumValues = null;
    }

    public Calculator(int numberOfObjectives, String path) {
        this.numberOfObjectives=numberOfObjectives;
        try {
            paretoTrueFront = new ArrayFront(path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.maximumValues = null;
        this.minimumValues = null;
    }

    public double[] getMaximumValues() {
        return maximumValues;
    }

    public double[] getMinimumValues() {
        return minimumValues;
    }

    public void addParetoFront(Front front) {
        double[] tempMinimum = FrontUtils.getMinimumValues(front);
        double[] tempMaximum = FrontUtils.getMaximumValues(front);

        addMinMaxReference(tempMinimum, tempMaximum);
    }

    public void addMinMaxReference(double[] tempMinimum, double[] tempMaximum) {
        // Compare min 
        if (minimumValues == null) {
            minimumValues = tempMinimum;
        } else {
            for (int i = 0; i < tempMinimum.length; i++) {
                minimumValues[i] = Double.min(tempMinimum[i], minimumValues[i]);
            }
        }

        // Compare max
        if (maximumValues == null) {
            maximumValues = tempMaximum;
        } else {
            for (int i = 0; i < tempMaximum.length; i++) {
                maximumValues[i] = Double.max(tempMaximum[i], maximumValues[i]);
            }
        }
    }

    public void addParetoFront(List<? extends Solution<?>> front) {
        addParetoFront(new ArrayFront(front));
    }

    public void addParetoFront(String path) throws FileNotFoundException {
        addParetoFront(new ArrayFront(path));
    }

    public void clear() {
        this.minimumValues = null;
        this.maximumValues = null;
    }

    public double execute(String frontPath) throws FileNotFoundException {
        return execute(new ArrayFront(frontPath));
    }

    public double execute(Front front) {
        return execute(front, maximumValues, minimumValues);
    }

    public double execute(String frontPath, double[] maximumValues, double[] minimumValues) throws FileNotFoundException {
        return execute(new ArrayFront(frontPath), maximumValues, minimumValues);
    }

    public double execute(List<? extends Solution<?>> front, double[] maximumValues, double[] minimumValues) {
        return execute(new ArrayFront(front), maximumValues, minimumValues);
    }

    public Front getParetoTrueFront() {
        return paretoTrueFront;
    }

    public void setParetoTrueFront(Front paretoTrueFront) {
        this.paretoTrueFront = paretoTrueFront;
    }

    public abstract double execute(Front front, double[] maximumValues, double[] minimumValues);

    public abstract double execute(List<? extends Solution<?>> front);

}
