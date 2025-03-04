# Crea una funzione 'simulate' che prende in input lo stato di una board
# di Conway Game Of Life e ritorno lo stato successivo
from time import sleep
from Map import Map

dimensioni = 5
palle = Map(dimensioni)
for i in range(10):
    sleep(1)
    palle.changeTurn()