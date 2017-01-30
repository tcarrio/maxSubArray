#!/usr/bin/env sh
n="Subarrays"
j="java"
jc="javac"
c="class"
$jc $n.$j; [ -f $n.$c ] && $j -Xms1000M -Xmx1000M $n && rm $n.$c

