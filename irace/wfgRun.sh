#!/bin/bash
problems="WFG1 WFG9 WFG2 WFG3 WFG6 WFG8 WFG5 WFG4 WFG7"
#problems="WFG1"

function addToExecution {
	problem=$1
	nObj=$2
	k=$3
	l=$4
    echo "problemName = "$problem > "problem"
	echo "numberOfPositionVariables = "$k >> "problem"
	echo "numberOfDistanceVariables = "$l >> "problem"
	echo "nObj = "$nObj >> "problem"
	echo $problem > "instances-list"
	sleep 10
	echo "Created"
}  


for problem in $problems
do
    addToExecution $problem 2 4 20
    wait
    echo "Run"
    Rscript irace-run.R > $problem"_outcome.txt"
    wait
done
