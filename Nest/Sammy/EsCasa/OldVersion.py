def LeggiMeteo(meteo):
    Datimeteo = {}
    for line in meteo:
        parti = line.split(";")
        if parti[1] not in Datimeteo:
            Datimeteo[parti[1]] = parti[2]
    return Datimeteo
# datimeteo = {ora:kwh}

def LeggiAbitazioni(impianti):
    abitazioni = {}
    for line in impianti:
        parti = line.split(";")
        if parti[0] not in abitazioni:
            abitazioni[parti[0]] = [parti[1], parti[2]]
    return abitazioni
# abitazioni = {id:[dim, efficienza]}

def LeggiConsumi(consumi):
    daticonsumi = {}
    for line in consumi:
        parti = line.split(";")
        if parti[0] not in daticonsumi:
            daticonsumi[parti[0]] = id()
            id[parti[2]]= parti[3]
        else:
            id[parti[2]]= parti[3]
    return daticonsumi
# daticonsumi = {nome:id{ora:cosumo}}


def CalcolaCasa(DatiMeteo,DatiAbitazioni, Daticonsumi):
    en_istant_casa = {} #{abitazioneid : ora{} }
    j = 0
    for i in range len(DatiAbitazioni):
         j = 0
        for c in range len(Daticonsumi):
            if DatiAbitazioni[i] = Daticonsumi[c]:
                en_prod[Datimeteo[j]] = DatiAbitazioni[i[0]]*DatiAbitazioni[i[1]]*Datimeteo[j[0]]
                en_istant_casa[DatiAbitazione[i]] = en_prod()
                

        
    #energia_prodotta = efficienza_impianto × dimensione_impianto × radiazione_solare


def main():
        try:
            consumi = open('consumi.txt', 'r')
            impianti = open('impianti.txt', 'r')
            meteo = open('meteo.txt', 'r')
            LeggiMeteo(meteo)
            DatiAbitazioni = LeggiAbitazioni(impianti)
            DatiMeteo = LeggiMeteo(meteo)
            DatiConsumi = LeggiConsumi(consumi)

        except:
            FileNotFoundError()
            print("File non trovato")


main()