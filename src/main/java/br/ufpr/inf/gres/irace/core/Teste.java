/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.inf.gres.irace.core;

import br.ufpr.inf.gres.irace.evaluation.indicator.HypervolumeIndicator;
import br.ufpr.inf.gres.irace.runner.IraceRunner;
import java.io.File;

/**
 *
 * @author vinicius
 */
public class Teste {

    public static void main(String[] args) {
        try {
/*
            HookEvaluateCommands jct0 = new HookEvaluateCommands();

            jct0.candidateId = 1;
            jct0.directory = System.getProperty("user.dir") + File.separator + "execDir";
            jct0.fileName = "c1.dat";

            new HypervolumeIndicator().run(jct0);
*/
            HookRunCommands jct = new HookRunCommands();

            jct.candidateId = 1;
            jct.directory = System.getProperty("user.dir") + File.separator + "execDir";
            jct.algorithmName = "NSGA-II";
            jct.populationSize = 100;
            jct.maxEvaluations = 600000;
            jct.selectionOperator = "Binary";
            jct.crossoverOperator = "BLXAlphaCrossover";
            jct.crossoverProbability = 0.9;
            jct.mutationOperator = "PolynomialMutation";
            jct.mutationProbability = 0.3;
            jct.alpha = 0.5;
            jct.distributionIndexCross = 30;
            jct.distributionIndexMuta = 20;
            jct.pertubation = 0.2;

            new IraceRunner().run(jct);

        } catch (Exception e) {

        }
    }
}
