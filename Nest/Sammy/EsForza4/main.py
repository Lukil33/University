def LeggiMosse(testo):
    mosse = []
    for line in testo:
        parti = line.split()
        mossa = [parti[0], int(parti[1])]
        mosse.append(mossa)
    return mosse 

def vittoria(scacchiera):
    esito = "no"
    for riga in scacchiera: # vittoria orizzontale
        for i in range(4):
            if riga[i]==riga[i+1]==riga[i+2]==riga[i+3]:
                if riga[i] == "O":
                    esito = "G1"
                if riga[i] == "X":
                    esito = "G2"
    if esito == "no":
        for j in range(7):
            for i in range(3):
                if scacchiera[i][j]==scacchiera[i+1][j]==scacchiera[i+2][j]==scacchiera[i+3][j]:
                    if scacchiera[i][j] == "O":
                        esito = "G1"
                    if scacchiera[i][j] == "X":
                        esito = "G2"
    if esito == "no":
        for i in range(3): # vittoria obliqua destra
            for j in range(4):
                if scacchiera[5-i][j]==scacchiera[4-i][j+1]==scacchiera[3-i][j+2]==scacchiera[2-i][j+3]:
                    if scacchiera[5-i][j] == "O":
                        esito = "G1"
                    if scacchiera[5-i][j] == "X":
                        esito = "G2"
    if esito == "no":
        for i in range(3): # vittoria obliqua sinistra
            for j in range(4):
                if scacchiera[i][j]==scacchiera[i][j+1]==scacchiera[i][j+2]==scacchiera[i][j+3]:
                    if scacchiera[i][j] == "O":
                        esito = "G1"
                    if scacchiera[i][j] == "X":
                        esito = "G2"
    
    return esito

def StampaTurno(scacchiera):
    
    for riga in scacchiera:
        Dastampare = ""
        for elem in riga:
            Dastampare = Dastampare + elem
        print(Dastampare)

def Turni(mosse, scacchiera):
    cont = 0
    for mossa in mosse:
        cont = cont + 1 
        esito = vittoria(scacchiera)
        if esito == "no":
            for i in range(6):
                if scacchiera[5-i][mossa[1]] == "-":
                    if mossa[0] == "G1":
                        scacchiera[5-i][mossa[1]] = "O"
                        print("Gioca il giocatore G1")
                        StampaTurno(scacchiera)
                    if mossa[0] == "G2":
                        scacchiera[5-i][mossa[1]] = "X"
                        print("Gioca il giocatore G2")
                        StampaTurno(scacchiera)
        elif esito != "no":
            print("Ha vinto ", esito, "in ", cont, "mosse")               

def main():
    try:
        testo = open("text.txt", "r")
        mosse = LeggiMosse(testo)
        scacchiera = []
        for i in range(6):
            riga = ['-']*7
            scacchiera.append(riga)
            
        print("Griglia vuota")
        print(scacchiera)
        StampaTurno(scacchiera)
        Turni(mosse, scacchiera)
        testo.close()
        
    except FileNotFoundError as msg: 
        print('File non trovato:', msg)

main()