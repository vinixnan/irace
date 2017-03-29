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
import org.uma.jmetal.problem.multiobjective.dtlz.*;
import org.uma.jmetal.problem.multiobjective.wfg.*;
import org.uma.jmetal.problem.multiobjective.zdt.*;

/**
 *
 * @author vinicius
 */
public class ProblemBuilder {

    /*
        nObj = 2; //M Number of objective functions
        k = 4; //Number of position parameters
        l = 20; //Number of distance parameters
    */
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
        else if (tipo.equalsIgnoreCase("DTLZ1")) {
            Problem[] problems = {
                new DTLZ1(numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("DTLZ2")) {
            Problem[] problems = {
                new DTLZ2(numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("DTLZ3")) {
            Problem[] problems = {
                new DTLZ3(numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("DTLZ4")) {
            Problem[] problems = {
                new DTLZ4(numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("DTLZ5")) {
            Problem[] problems = {
                new DTLZ5(numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("DTLZ6")) {
            Problem[] problems = {
                new DTLZ6(numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("DTLZ7")) {
            Problem[] problems = {
                new DTLZ7(numberOfDistanceVariables, numberOfObjectives),};
            return problems;
        } else if (tipo.equalsIgnoreCase("ZDT1")) {
            Problem[] problems = {
                new ZDT1(numberOfDistanceVariables),};
            return problems;
        } else if (tipo.equalsIgnoreCase("ZDT2")) {
            Problem[] problems = {
                new ZDT2(numberOfDistanceVariables),};
            return problems;
        } else if (tipo.equalsIgnoreCase("ZDT3")) {
            Problem[] problems = {
                new ZDT3(numberOfDistanceVariables),};
            return problems;
        } else if (tipo.equalsIgnoreCase("ZDT4")) {
            Problem[] problems = {
                new ZDT4(numberOfDistanceVariables),};
            return problems;
        } else if (tipo.equalsIgnoreCase("ZDT5")) {
            Problem[] problems = {
                new ZDT5(numberOfDistanceVariables),};
            return problems;
        } else if (tipo.equalsIgnoreCase("ZDT6")) {
            Problem[] problems = {
                new ZDT6(numberOfDistanceVariables),};
            return problems;
        } else if (tipo.equalsIgnoreCase("DTLZ")) {
            Problem[] problems = {
                //segundo o artigo mixture
                new DTLZ1(5, 3),
                new DTLZ2(7, 3),
                new DTLZ3(12, 3),
                new DTLZ4(10, 3),
                new DTLZ5(10, 3),
                new DTLZ6(10, 3),
                new DTLZ7(),};
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
