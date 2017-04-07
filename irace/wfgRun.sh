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

function startrun {
    problem=$1
    nObj=$2
    k=$3
    l=$4
    addToExecution $problem $nObj $k $l
    namefile=$problem"_"$nObj"obj"
    wait
    echo "Run"
    SECONDS=0
    Rscript irace-run.R > $namefile"_outcome.txt"
    #wait
    echo "run "$namefile" in "$SECONDS
}

#WFG 2 obj
for problem in $problems
do
    startrun $problem 2 4 20
done

#WFG 2 correct
#for problem in $problems
#do
#    startrun $problem 2 2 20
#done


#WFG 3 obj
#for problem in $problems
#do
#    startrun $problem 3 4 20
#done

#DTLZ 2 obj
#startrun "DTLZ1" 2 0 6
#startrun "DTLZ2" 2 0 11
#startrun "DTLZ3" 2 0 11
#startrun "DTLZ4" 2 0 11
#startrun "DTLZ5" 2 0 11
#startrun "DTLZ6" 2 0 11
#startrun "DTLZ7" 2 0 21

#DTLZ 3 obj
#startrun "DTLZ1" 3 0 7
#startrun "DTLZ2" 3 0 12
#startrun "DTLZ3" 3 0 12
#startrun "DTLZ4" 3 0 12
#startrun "DTLZ5" 3 0 12
#startrun "DTLZ6" 3 0 12
#startrun "DTLZ7" 3 0 22
