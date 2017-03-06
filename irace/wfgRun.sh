#!/bin/bash
problems="WFG9 WFG2 WFG3 WFG6 WFG8 WFG5 WFG1 WFG4 WFG7"
#problems="WFG9"

function addToExecution {
	problem=$1
	nObj=$2
	k=$3
	l=$4
    echo "problemName = "$problem > "problem"
	echo "numberOfPositionVariables = "$k >> "problem"
	echo "numberOfDistanceVariables = "$l >> "problem"
	echo "nObj = "$nObj >> "problem"
}  


for problem in $problems
do
    addToExecution $problem 2 4 20
    Rscript irace-run.R > $problem"_outcome.txt"
done
