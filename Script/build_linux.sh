#!/bin/bash

#Folders
BUILDDIR="build/"
SLIDESDIR="slides/"
HANDOUTDIR="handout/"

# Commands
# TEX=TEXINPUTS=./sty;$TEXINPUTS pdflatex -file-line-error -interaction=batchmode -synctex=1 -output-directory=$BUILDDIR
DEL="rm -rf"
ECHOCOLOR="\033[1;32m"
ECHONC="\033[0m"
build_handout(){
	test -d $HANDOUTDIR || mkdir $HANDOUTDIR
	sed -i -e 's/%handout-PLACEHOLDER/handout%PLACEHOLDER/g' ./texfiles/$1/main.tex
	pdf1 $1
    bib $1
	pdf2 $1
	sed -i -e 's/handout%PLACEHOLDER/%handout-PLACEHOLDER/g' ./texfiles/$1/main.tex
	mv $BUILDDIR$1.pdf $HANDOUTDIR
}

build_slides(){
	test -d $SLIDESDIR || mkdir $SLIDESDIR
	pdf1 $1
    bib $1
	pdf2 $1
	mv $BUILDDIR$1.pdf $SLIDESDIR
}

pdf1(){
	echo -e "$ECHOCOLOR\\n======================================================================="
	echo -e "Building PDF: $1 (1/2)"
	echo -e "=======================================================================$ECHONC"
	test -d $BUILDDIR || mkdir $BUILDDIR
	TEXINPUTS=./sty:$TEXINPUTS pdflatex -file-line-error -interaction=batchmode -synctex=1 -output-directory=$BUILDDIR -jobname=$1 ./texfiles/$1/main.tex
	echo -e "$ECHOCOLOR\\n======================================================================="
	echo -e "Done!!"
	echo -e "=======================================================================$ECHONC"
}

pdf2(){
	echo -e "$ECHOCOLOR\\n======================================================================="
	echo -e "Building PDF: $1 (2/2)"
	echo -e "=======================================================================$ECHONC"
	TEXINPUTS=./sty:$TEXINPUTS pdflatex -file-line-error -interaction=batchmode -synctex=1 -output-directory=$BUILDDIR -jobname=$1 ./texfiles/$1/main.tex
	echo -e "$ECHOCOLOR\\n======================================================================="
	echo -e "Done!!"
	echo -e "=======================================================================$ECHONC"
}

bib(){
    echo -e "$(ECHOCOLOR)\\n======================================================================="
	echo -e "Build bibliography..."
	echo -e "=======================================================================""$(ECHONC)"
	biber $BUILDDIR$1
	echo -e "$(ECHOCOLOR)""\\n======================================================================="
	echo -e "Done!!"
	echo -e "=======================================================================""$(ECHONC)"
}

# Loop through all folders
for file in ./texfiles/*/; do
	build_slides $(basename $file)
	build_handout $(basename $file)
done

