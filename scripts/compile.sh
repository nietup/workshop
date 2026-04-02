#!/usr/bin/env bash
set -e
mkdir -p out
find src -name "*.java" > sources.txt
javac -d out @sources.txt
echo "Skompilowano do katalogu out/"
