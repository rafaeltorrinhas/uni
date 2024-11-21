#!/bin/bash
echo "O meu editor por omissão BASH $BASH \$BASH"
echo 'O meu editor por omissão BASH $BASH \$BASH'
echo $(( 5 + 5 ))
(( 5 > 0 )) && echo "cinco é maior que zero"
today=$(date); 
echo $today


echo "-----------------------------------"
ls /etc/
echo "-----------------------------------"
ls /etc/a*
echo "-----------------------------------"
ls /etc/a???*
echo "-----------------------------------"
ls /etc/*conf*
