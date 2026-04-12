#!/bin/bash

# init repo
rm -rf workspace
mkdir workspace
cd workspace
git init

touch myfile.txt
git add . && git commit -m "C0 - base commit"

echo "FIRST line" > myfile.txt
git add . && git commit -m "C1 - first line"

echo "SECOND line" >> myfile.txt
git add . && git commit -m "C2 - second line"

touch shouldDeleteThis
git add . && git commit -m "C3 - wrong commit"

touch someGoodChanges
git add . && git commit -m "C4 - commit to keep"

touch somePartialChanges1
touch somePartialChanges2
git add . && git commit -m "C5 - commit to modify"