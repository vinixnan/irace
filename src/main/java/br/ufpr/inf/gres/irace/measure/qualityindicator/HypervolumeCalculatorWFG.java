package br.ufpr.inf.gres.irace.measure.qualityindicator;

import java.util.List;
import org.uma.jmetal.qualityindicator.impl.hypervolume.PISAHypervolume;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.front.Front;
import org.uma.jmetal.util.front.util.FrontNormalizer;
import org.uma.jmetal.util.front.util.FrontUtils;
import org.uma.jmetal.util.point.util.PointSolution;

public class HypervolumeCalculatorWFG extends Calculator {

    public HypervolumeCalculatorWFG(int numberOfObjectives, String path) {
        super(numberOfObjectives, path);
    }

    @Override
    public double execute(Front front, double[] maximumValues, double[] minimumValues) {
        if (maximumValues != null && minimumValues != null) {
            FrontNormalizer frontNormalizer = new FrontNormalizer(minimumValues, maximumValues);
            Front normalizedFront = frontNormalizer.normalize(front);
            List<PointSolution> normalizedPopulation = FrontUtils.convertFrontToSolutionList(normalizedFront);

            return new PISAHypervolume<PointSolution>(normalizedFront).evaluate(normalizedPopulation);
        }
        return 0D;
    }

    @Override
    public double execute(List<? extends Solution<?>> front) {
        this.addParetoFront(paretoTrueFront);
        return this.execute(front, maximumValues, minimumValues);
    }
}
