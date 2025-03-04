def LeggiConsumi(consumi):
    Daticonsumi = {}

    for line in consumi:
        parti = line.split(";")
        gma = parti[1].split("/")       # Divido la stringa "GG/MM/AAAA" in una stringa di lunghezza 3 -> ['GG', 'MM', 'AAAA']
        hm = parti[2].split(":")        # Divido la stringa "HH:MM" in una stringa di lunghezza 2 -> ['HH', 'MM']
        gmahm = int(gma[0])*10**10 + int(gma[1])*10**8 + int(gma[2])*10**4 + int(hm[0])*10**2 + int(hm[1])*10**0

        if parti[0] not in Daticonsumi:
            Daticonsumi[parti[0]] = [int(gmahm)]
        else:
            Daticonsumi[parti[0]].append(int(gmahm))
        Daticonsumi[parti[0]].append(float(parti[3]))

    #print("Consumi:")
    #print(Daticonsumi)    # Nel caso in cui volessi vedere come è strutturato Daticonsumi ti ho lasciato il print

    return Daticonsumi    
# daticonsumi = {ID:[GiorniMesiAnniOreMinuti,Consumo]}

def LeggiAbitazioni(impianti):
    abitazioni = {}
    
    for line in impianti:
        parti = line.split(";")     # Divido la stringa "ID;Dimensione;Efficienza" in una stringa di lunghezza 3 -> ['ID', 'DImensione', 'Efficienza']
        
        if parti[0] not in abitazioni:
            abitazioni[parti[0]] = [float(parti[1]), float(parti[2])]   # I cast (ovvero: float(parti[1]) ) servono per assegnare un Data type ai vari elementi
                                                                        # e dunque per eliminare eventuali "impurità" presenti nel file di input (Es: \n)
    #print("Abitazioni:")
    #print(abitazioni)   # Nel caso in cui volessi vedere come è strutturato Abitazioni ti ho lasciato il print

    return abitazioni
# abitazioni = {ID:[Dimensione,Efficienza]}

def LeggiMeteo(meteo):
    Datimeteo = {}
    
    for line in meteo:
        parti = line.split(";")         # Divido la stringa "GG/MM/AAAA;HH:MM;Consumo" in una stringa di lunghezza 3 -> ['GG/MM/AAAA', 'HH:MM', 'Consumo']
        gma = parti[0].split("/")       # Divido la stringa "GG/MM/AAAA" in una stringa di lunghezza 3 -> ['GG', 'MM', 'AAAA']
        hm = parti[1].split(":")        # Divido la stringa "HH:MM" in una stringa di lunghezza 2 -> ['HH', 'MM']
        gmahm = int(gma[0])*10**10 + int(gma[1])*10**8 + int(gma[2])*10**4 + int(hm[0])*10**2 + int(hm[1])*10**0

        if gmahm not in Datimeteo:
            Datimeteo[gmahm] = [float(parti[2])]     # Inserisco i dati all'interno di Datimeteo
    
    #print("Meteo:")
    #print(Datimeteo)    # Nel caso in cui volessi vedere come è strutturato Datimeteo ti ho lasciato il print

    return Datimeteo
# datimeteo = {GiorniMesiAnniOreMinuti:[Radiazione]}

def CalcolaCasa(DatiConsumi,DatiAbitazioni,DatiMeteo):
    DatiCompletiAbitazioni = {}

    for id in DatiAbitazioni:
        for i in range (0,len(DatiConsumi[id]),2):
            data = DatiConsumi[id][i]
            nome = id + "-" +str(data)
            
            DatiCompletiAbitazioni[nome] = []
            DatiCompletiAbitazioni[nome].append(DatiAbitazioni[id][0]*DatiAbitazioni[id][1]*DatiMeteo[data][0])     # Aggiungo l'Energia prodotta

            if DatiCompletiAbitazioni[nome][0]-DatiConsumi[id][i+1] <= 0:       # Aggiungo l'Energia immessa (Probabilmente il calcolo è sbagliato, non mi interessava più di tanto onestamente)
                DatiCompletiAbitazioni[nome].append(0)
            else:
                DatiCompletiAbitazioni[nome].append(DatiCompletiAbitazioni[nome][0]-DatiConsumi[id][i+1])

            if DatiCompletiAbitazioni[nome][0] >= DatiConsumi[id][i+1] :
                DatiCompletiAbitazioni[nome].append(DatiConsumi[id][i+1])     # Aggiungo l'Energia autoconsumata (Probabilmente il calcolo è sbagliato, non mi interessava più di tanto onestamente)
            else:
                DatiCompletiAbitazioni[nome].append(DatiConsumi[id][i+1]-DatiCompletiAbitazioni[nome][0])    # Aggiungo l'Energia autoconsumata
    
    print(DatiCompletiAbitazioni)

    return DatiCompletiAbitazioni

# daticompletiabitazione = {ID-GiorniMesiAnniOreMinuti:[E.Prodotta, E.Immessa, E.Autoconsumata, Autoconsumo, Autosufficienza]}



def main():
        try:
            consumi = open('consumi.txt', 'r')
            impianti = open('impianti.txt', 'r')
            meteo = open('meteo.txt', 'r')
            DatiConsumi = LeggiConsumi(consumi)
            DatiAbitazioni = LeggiAbitazioni(impianti)
            DatiMeteo = LeggiMeteo(meteo)
            CalcolaCasa(DatiConsumi,DatiAbitazioni,DatiMeteo)

        except:
            FileNotFoundError()
            print("File non trovato")

main()