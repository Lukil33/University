(*ESAME luglio 2023

    Si scriva una funzione conta_duplicati (avente tipo ''a list -> (''a * int) list) che riceve come argomento una lista di ''a e restituisce una lista di tuple ''a * int. 
    La funzione conta_duplicati ritorna una lista di coppie (elemento, numero di occorrenze dell'elemento), cioè per ogni elemento distinto e della lista di input, la lista di output contiene una coppia (e, numero di occorrenze di e).
    
    Come esempio, l'invocazione conta_duplicati [2, 2, 2, 2]; deve avere risultato [(2,4)],
    conta_duplicati ["lunedi'", "lunedi'", "martedi'", "lunedi'"]; deve avere risultato [("lunedi'",3), ("martedi'",1)] e
    conta_duplicati ["blu", "verde", "verde", "blu", "rosso"]; deve avere risultato [("blu",2), ("verde",2), ("rosso",1)].

    IMPORTANTE: notare il tipo della funzione!.

    L'ordine delle coppie all'interno della lista risultante non è rilevante.

    La funzione conta_duplicati deve essere definita in un file .sml autocontenuto ma separato da qualsiasi codice di test si sia usato. 
    Il file .sml deve contenere la chiamata a conta_duplicati. Si consegni il file .sml contenente la definizione di conta_duplicati rinominandolo Cognome_Nome_Matricola.sml.
*)

fun count(x, nil) = 0
    |count(x, y::ys) = if(x = y) then(1+count(x, ys)) else(count(x, ys));

fun remove(x, nil) = nil
    |remove(x, y::ys) = if(x = y) then(remove(x, ys)) else(y::remove(x, ys));

fun conta_duplicati(nil) = nil
    |conta_duplicati(x::xs) = (x,count(x, x::xs))::conta_duplicati(remove(x, x::xs));

conta_duplicati(["blu", "verde", "verde", "blu", "rosso"]);