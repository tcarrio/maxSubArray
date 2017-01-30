#!/usr/bin/env sh
n="Subarrays"
j="java"
jc="javac"
c="class"
$jc $n.$j; [ -f $n.$c ] && $j -Xms11000M -Xmx11000M $n && rm $n.$c

