/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.inf.gres.irace.core;

import java.io.File;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.problem.multiobjective.wfg.*;

/**
 *
 * @author vinicius
 */
public class ProblemBuilder {

    public static Problem[] getProblems(String tipo, int wfgNumberOfPositions, int numberOfDistanceVariables, int numberOfObjectives) throws ClassNotFoundException {
        if (tipo.equalsIgnoreCase("WFG1")) {
            Problem[] problems = {
                new WFG1(wfgNumberOfPositions, numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("WFG2")) {
            Problem[] problems = {
                new WFG2(wfgNumberOfPositions, numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("WFG3")) {
            Problem[] problems = {
                new WFG3(wfgNumberOfPositions, numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("WFG4")) {
            Problem[] problems = {
                new WFG4(wfgNumberOfPositions, numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("WFG5")) {
            Problem[] problems = {
                new WFG5(wfgNumberOfPositions, numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("WFG6")) {
            Problem[] problems = {
                new WFG6(wfgNumberOfPositions, numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("WFG7")) {
            Problem[] problems = {
                new WFG7(wfgNumberOfPositions, numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("WFG8")) {
            Problem[] problems = {
                new WFG8(wfgNumberOfPositions, numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("WFG9")) {
            Problem[] problems = {
                new WFG9(wfgNumberOfPositions, numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        }
        return null;
    }

    public static Problem[] getProblems() throws ConfigurationException, ClassNotFoundException {
        Configurations configs = new Configurations();
        String dir="/home/vinicius/Projetos/irace/";//ver problema com subdiretorio
        File problemFile = new File(dir + File.separator + "irace" + File.separator + "problem");
        Configuration configProblem = configs.properties(problemFile);
        return ProblemBuilder.getProblems(configProblem.getString("problemName"), configProblem.getInt("numberOfPositionVariables"), configProblem.getInt("numberOfDistanceVariables"), configProblem.getInt("nObj"));
    }
}
