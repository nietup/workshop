@echo off
setlocal enabledelayedexpansion

if not exist out mkdir out

(for /r src\main %%f in (*.java) do echo %%f) > sources.txt

javac -d out @sources.txt

echo Skompilowano do katalogu out/
