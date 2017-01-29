#!/usr/bin/env sh
n="Subarrays"
j="java"
jc="javac"
c="class"
$jc $n.$j; [ -f $n.$c ] && $j $n && rm $n.$c

