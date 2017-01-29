#!/usr/bin/env sh
n="Subarrays"
j="java"
jc="javac"
c="class"
$jc $n.$j; [ -f $n.$c ] && $j -Xms3500M -Xmx3500M $n && rm $n.$c

