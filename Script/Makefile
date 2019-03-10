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
## Main document
MAINFILES = $(patsubst %.tex,%,$(wildcard *.tex))

# Build Ordner
BUILDDIR = build/
SLIDESDIR = slides/
HANDOUTDIR = handouts/

# Latex-Files Ordner
TEXFILES = texfiles/


# Commands
TEX = pdflatex  
TEXFLAGS =-file-line-error -interaction=batchmode -synctex=1 -output-directory=$(BUILDDIR)
DEL = rm -rf 
ECHO = echo 
ECHOCOLOR = \033[1;32m
ECHONC = \033[0m
MOVE = mv
MKDIR	= mkdir
GIT	= git
VIEWPDF = firefox
PARSELOG = grep --color -E ".*:[0-9]*:.*|Warning:|Error:" $(BUILDDIR)
TRANSFORM = tr " " "\n"


all: listfiles $(MAINFILES)

listfiles:
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Building PDFs for TeX-Files:"
	@$(ECHO) "$(MAINFILES)" | $(TRANSFORM)
	@$(ECHO) "=======================================================================""$(ECHONC)"
	test -d $(BUILDDIR) || mkdir $(BUILDDIR)

.PHONY: bib
bib:

	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Build bibliography..."
	@$(ECHO) "=======================================================================""$(ECHONC)"
	$(BIB) $(BIBFLAGS) $(BUILDDIR)$(MAINFILE)
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Done!!"
	@$(ECHO) "=======================================================================""$(ECHONC)"

.PHONY: glos
glos:

	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Build glossary..."
	@$(ECHO) "=======================================================================""$(ECHONC)"
	$(INDEX) -s $(BUILDDIR)$(MAINFILE).ist -t $(BUILDDIR)$(MAINFILE).glg -o $(BUILDDIR)$(MAINFILE).gls $(BUILDDIR)$(MAINFILE).glo
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Build list of abbreviations..."
	@$(ECHO) "=======================================================================""$(ECHONC)"
	$(INDEX) -s $(BUILDDIR)$(MAINFILE).ist -t $(BUILDDIR)$(MAINFILE).alg -o $(BUILDDIR)$(MAINFILE).acr $(BUILDDIR)$(MAINFILE).acn 
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Done!!"
	@$(ECHO) "=======================================================================""$(ECHONC)"	

	
# Clean Working Directory
mrproper:
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Clean Working Directory...""$(ECHONC)"
	$(DEL) $(BUILDDIR)*
	$(DEL) $(EXAMPLE)*.bak
	$(DEL) $(EXAMPLE)*.~	
	$(DEL) $(MAINFILE).pdf
	@$(ECHO) "$(ECHOCOLOR)""Done!"
	@$(ECHO) "=======================================================================""$(ECHONC)"
	
# View all PDF documents
view: viewpdf

viewpdf:
	@$(ECHO) "$(ECHOCOLOR)""======================================================================="
	@$(ECHO) "View PDF..."
	@$(ECHO) "=======================================================================""$(ECHONC)"
	@$(VIEWPDF) *.pdf &

# View specific PDF document
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
	
	
%-viewlog:
	@$(ECHO) "$(ECHOCOLOR)""======================================================================="
	@$(ECHO) "Warnings:\\n"
	@$(PARSELOG)$*.log
	@$(ECHO) "\\n=======================================================================""$(ECHONC)"
	
$(MAINFILES): %: $(SLIDESDIR)%.pdf

$(SLIDESDIR)%.pdf: %.tex texfiles/%/*.tex texfiles/contact.tex %-pdf1 %-pdf2
	@$(MOVE) $(BUILDDIR)$*.pdf $(SLIDESDIR)

%-pdf1:
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Build PDF(""$*"", 1/2)"
	@$(ECHO) "=======================================================================""$(ECHONC)"
	test -d $(BUILDDIR) || mkdir $(BUILDDIR)
	
	$(TEX) $(TEXFLAGS) $*.tex 
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Done!!"
	@$(ECHO) "=======================================================================""$(ECHONC)"

%-pdf2:
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Build PDF(""$*"", 2/2)"
	@$(ECHO) "=======================================================================""$(ECHONC)"
	$(TEX) $(TEXFLAGS) $*.tex 
	@$(ECHO) "$(ECHOCOLOR)""\\n======================================================================="
	@$(ECHO) "Done!!"
	@$(ECHO) "=======================================================================""$(ECHONC)"

	
test:
	@$(ECHO) "$(TESTING)"