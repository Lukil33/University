#!/bin/bash

res=""

for i in {0..10000};
do
    if [[ $(( $i % 3 )) -eq 0 || $(( $i % 5 )) -eq 0 || $(( $i % 7 )) -eq 0 ]];
    then
        if [[ $(( $i % 3 )) -eq 0 ]];
        then
            res+="Pling "
        fi
        if [[ $(( $i % 5 )) -eq 0 ]];
        then
            res+="Plong "
        fi
        if [[ $(( $i % 7 )) -eq 0 ]]; 
        then
            res+="Plang "
        fi
    else
        res+="$i"
    fi
    res+="\n"
done

echo -e -n $res