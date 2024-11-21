#!/bin/bash
echo "Checking..."


if [ $# -eq 1 ]; then 
  if [[ -f $1 ]] ; then
    echo "$1 existe."
  else
    echo "$1 não existe"
  fi

  if [[ -d $1 ]]; then
    echo "$1 é uma pasta"
  fi

  if [[ -r $1 ]]; then
    echo "$1 pode ser lido"
  else
    echo "$1 não pode ser lido"
  fi

  if [[ -w $1 ]]; then
    echo "$1 é editável"
  else 
    echo "$1 não é editável"
  fi

  if [[ -x $1 ]]; then 
    echo "$1 é executável"
  else
    echo "$1 não é executável"
  fi 


else
  echo "Apresente apenas 1 argumento"
fi


echo "...done."
