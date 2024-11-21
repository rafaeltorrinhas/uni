#!/bin/bash
function imprime_msg()
{
echo "A minha primeira funcao"
echo $(date)
echo "$USER @ $(hostname)"
return 0
}
imprime_msg
