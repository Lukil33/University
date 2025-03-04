def LeggiTesto(testo):
    canzoni = {}
    for line in testo:
        linea = line.split(":")
        note = linea[1].split()
        canzoni[linea[0]] = list(map(int, note))
    return canzoni #canzoni = {nome:note}

def Analizza(c1, c2):
    L = max(len(c1), len(c2))
    esito = "null"
    for i in range (L-4):
        if len(c1)>=len(c2):
            note1 = [c1[i], c1[i+1], c1[i+2], c1[i+3]]
            for j in range(len(c2)-4):
                note2 = [c2[j], c2[j+1], c2[j+2], c2[j+3]]
                if note1 == note2:
                    esito = "copiatura"
                elif (c1[i]-c2[j])==(c1[i+1]-c2[j+1])==(c1[i+2]-c2[j+2])==(c1[i+3]-c2[j+3]):
                    esito = "sospetto"
        if len(c1)<len(c2):
            note1 = [c2[i], c2[i+1], c2[i+2], c2[i+3]]
            for j in range(len(c1)-4):
                note2 = [c1[j], c1[j+1], c1[j+2], c1[j+3]]
                if note1 == note2:
                    esito = "copiatura"
                elif (c1[j]-c2[i])==(c1[j+1]-c2[i+1])==(c1[j+2]-c2[i+2])==(c1[j+3]-c2[i+3]):
                    esito = "sospetto"
    return esito    

def ConfrontoCanzoni(canzoni):
    visti = []
    for key in canzoni:
        Daconfrontare = [key, canzoni[key]]
        for i in canzoni:
            if i != key and key not in visti:
                if Daconfrontare[1] == canzoni[i]:
                    print(i, "è un PLAGIO di", key)
                    visti.append(i)
                else:
                    analisi = Analizza(Daconfrontare[1], canzoni[i])
                    if analisi == "copiatura":
                        print(i, "è una COPIATURA di", key)
                        visti.append(i)
                    elif analisi == "sospetto":
                        print(i, "è un SOSPETTO di", key)
                        visti.append(i)


def main():
    try:
        testo = open("text.txt", "r")
        canzoni = LeggiTesto(testo)
        ConfrontoCanzoni(canzoni)
        testo.close()
    except FileNotFoundError as msg: 
        print('File non trovato:', msg)

main()