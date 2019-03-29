#########################################################################################
##
## Description:		This Makefile builds the provided example.
##					It is tested with GNU Make, Miktex 2.9 and TexLive2016 on 64-bit.
##
##					The beamerthemedhbw is based on jacksbeamertheme
##					(https://github.com/JacknJo/jacksbeamertheme)
##
## Author:			Hannes Bartle																				
## 					DHBW Ravensburg Campus Friedrichshafen		
##					September 2016	
## 
## The beamerthemedhbw is free software: you can redistribute it and/or modify
## it under the terms of the GNU General Public License as published by
## the Free Software Foundation, either version 3 of the License, or
## (at your option) any later version.
## 
## The beamerthemedhbw is distributed in the hope that it will be useful,
## but WITHOUT ANY WARRANTY; without even the implied warranty of
## MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
## GNU General Public License for more details.
## 
## You should have received a copy of the GNU General Public License
## along with the beamerthemedhbw.  If not, see <http://www.gnu.org/licenses/>.
## 
## 
#########################################################################################
.SILENT:
## Main documents
DIRECTORIES = $(patsubst ./texfiles/%/,%,$(dir $(wildcard ./texfiles/*/.)))

# Build Ordner
BUILDDIR = build/
SLIDESDIR = slides/
HANDOUTDIR = handout/


# Latex-Files Ordner
TEXFILES = texfiles/


# Commands
TEX = TEXINPUTS=./sty:$(TEXINPUTS) pdflatex  
TEXFLAGS =-file-line-error -interaction=batchmode -synctex=1 -output-directory=$(BUILDDIR) -jobname $*
DEL = rm -rf 
ECHO = echo 
ECHOCOLOR = \033[1;32m
ECHONC = \033[0m
MOVE = mv
MKDIR = mkdir
VIEWPDF = firefox
PARSELOG = grep --color -E ".*:[0-9]*:.*|Warning:|Error:" $(BUILDDIR)
TRANSFORM = tr " " "\n"
SEDMAKEHANDOUT = sed -i -e 's/%handout-PLACEHOLDER/handout%PLACEHOLDER/g' ./texfiles/$*/main.tex
SEDMAKESLIDES = sed -i -e 's/handout%PLACEHOLDER/%handout-PLACEHOLDER/g' ./texfiles/$*/main.tex
BIB = biber

# Main build rule
all: listfiles $(DIRECTORIES)

# List files in command line
.PHONY: listfiles
listfiles:
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Building PDFs for TeX-Files:"
	@$(ECHO) "$(DIRECTORIES)" | $(TRANSFORM)
	@$(ECHO) "=======================================================================""$(ECHONC)"
	test -d $(BUILDDIR) || mkdir $(BUILDDIR)

# Iterate over all tex directories
$(DIRECTORIES): %: $(SLIDESDIR)%.pdf $(HANDOUTDIR)%.pdf

# Build rule for slides
$(SLIDESDIR)%.pdf: sty/* texfiles/%/*.tex texfiles/contact.tex texfiles/sources.bib %-slides1 %-bib %-slides2
	@$(MOVE) $(BUILDDIR)$*.pdf $(SLIDESDIR)

# First build for slides
%-slides1:
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Build PDF(""$*""(Slides), 1/2)"
	@$(ECHO) "=======================================================================""$(ECHONC)"
	test -d $(BUILDDIR) || mkdir $(BUILDDIR)
	test -d $(SLIDESDIR) || mkdir $(SLIDESDIR)
	
	$(TEX) $(TEXFLAGS) ./texfiles/$*/main.tex 
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Done!!"
	@$(ECHO) "=======================================================================""$(ECHONC)"

# Second build for slides
%-slides2:
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Build PDF(""$*""(Slides), 2/2)"
	@$(ECHO) "=======================================================================""$(ECHONC)"
	$(TEX) $(TEXFLAGS) ./texfiles/$*/main.tex
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Done!!"
	@$(ECHO) "=======================================================================""$(ECHONC)"
	
# Build rule for handout
$(HANDOUTDIR)%.pdf: sty/* texfiles/%/*.tex texfiles/contact.tex texfiles/sources.bib %-makehandout %-handout1 %-handout2 %-makeslide
	@$(MOVE) $(BUILDDIR)$*.pdf $(HANDOUTDIR)	
	
# First build for handout
%-handout1:
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Build PDF(""$*""(Handout), 1/2)"
	@$(ECHO) "=======================================================================""$(ECHONC)"
	test -d $(BUILDDIR) || mkdir $(BUILDDIR)
	test -d $(HANDOUTDIR) || mkdir $(HANDOUTDIR)
	
	$(TEX) $(TEXFLAGS) ./texfiles/$*/main.tex 
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Done!!"
	@$(ECHO) "=======================================================================""$(ECHONC)"

# Second build for Handout
%-handout2:
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Build PDF(""$*""(Handout), 2/2)"
	@$(ECHO) "=======================================================================""$(ECHONC)"
	$(TEX) $(TEXFLAGS) ./texfiles/$*/main.tex
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Done!!"
	@$(ECHO) "=======================================================================""$(ECHONC)"
	
# Replace placeholder to change mode from slide to handout
%-makehandout:
	touch "$(BUILDDIR)reffile" -r ./texfiles/$*/main.tex
	$(SEDMAKEHANDOUT)
	
# Replace placeholder to change mode from handout to slide
%-makeslide:
	$(SEDMAKESLIDES)
	touch ./texfiles/$*/main.tex -r "$(BUILDDIR)reffile"
	rm "$(BUILDDIR)reffile"
    
# Build rule for bibliography
.PHONY: %-bib
%-bib:
	
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Build bibliography..."
	@$(ECHO) "=======================================================================""$(ECHONC)"
	$(BIB) $(BUILDDIR)$*
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Done!!"
	@$(ECHO) "=======================================================================""$(ECHONC)"

   
# View all PDF documents
.PHONY: view
view: viewpdf

viewpdf:
	@$(ECHO) "$(ECHOCOLOR)""======================================================================="
	@$(ECHO) "View PDF..."
	@$(ECHO) "=======================================================================""$(ECHONC)"
	@$(VIEWPDF) *.pdf &

# View specific PDF document
.PHONY: %-view
%-view:
	@$(ECHO) "$(ECHOCOLOR)""======================================================================="
	@$(ECHO) "View PDF..."
	@$(ECHO) "=======================================================================""$(ECHONC)"
	@$(VIEWPDF) $*.pdf &
	
# View Warning/Error Messages for all logfiles
viewlog:
	@$(ECHO) "$(ECHOCOLOR)""======================================================================="
	@$(ECHO) "Warnings:\\n"
	@$(PARSELOG)*.log
	@$(ECHO) "\\n=======================================================================""$(ECHONC)"
	
# View Warning/Error Messages for one specific file
%-viewlog:
	@$(ECHO) "$(ECHOCOLOR)""======================================================================="
	@$(ECHO) "Warnings:\\n"
	@$(PARSELOG)$*.log
	@$(ECHO) "\\n=======================================================================""$(ECHONC)"   
	
# Clean build directory and delete pdf's
mrproper:
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Clean Working Directory...""$(ECHONC)"
	$(DEL) $(BUILDDIR)*
	$(DEL) $(HANDOUTDIR)*.pdf
	$(DEL) $(SLIDESDIR)*.pdf
	@$(ECHO) "$(ECHOCOLOR)""Done!"
	@$(ECHO) "=======================================================================""$(ECHONC)"
    

# Rule for building glossaries. Unused and not updated to multi-file building
# .PHONY: glos
# glos:

	# @$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	# @$(ECHO) "Build glossary..."
	# @$(ECHO) "=======================================================================""$(ECHONC)"
	# $(INDEX) -s $(BUILDDIR)$(MAINFILE).ist -t $(BUILDDIR)$(MAINFILE).glg -o $(BUILDDIR)$(MAINFILE).gls $(BUILDDIR)$(MAINFILE).glo
	# @$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	# @$(ECHO) "Build list of abbreviations..."
	# @$(ECHO) "=======================================================================""$(ECHONC)"
	# $(INDEX) -s $(BUILDDIR)$(MAINFILE).ist -t $(BUILDDIR)$(MAINFILE).alg -o $(BUILDDIR)$(MAINFILE).acr $(BUILDDIR)$(MAINFILE).acn 
	# @$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	# @$(ECHO) "Done!!"
	# @$(ECHO) "=======================================================================""$(ECHONC)"