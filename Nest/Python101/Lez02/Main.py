# Per qualunque cosa chiedete o cercate su internet

# Stampa "Hello, World" sulla console
print("Hello, World")

# Utilizando delle variabli stampa, dei numeri da 1 a 10
for i in range(1,11):
    print(i)

# Con un array di supporto implementa il calcolo dei numeri di fibonacci
array = [0,1]
for i in range(100):
    new_number = array[0]+array[1]
    print(new_number)
    array.pop(0)
    array.append(new_number)

# Stampa solo i caratteri dispari di una stringa utilizando gli approcci
# - iterativo
string = "[aosldf,sidjnv,isnv,sdivn,ownvdm]"
for i in range(len(string)):
    if(i%2 == 1):
        print(string[i])

# - indici del array
print(string[1:len(string):2])

# - ricorsivo
def palle(string,counter) -> None:
    if(counter < len(string)):
        if(counter%2 == 1):
            print(string[counter])
        palle(string, counter+1)

palle(string, 0)

# Write a function that prints 'Yes' when the input parameter is a
# 'yes' string in any case form (e.g. 'Yes', 'yEs', 'yeS', 'YeS', ...)
# otherwise print 'No'
array = ['Yes', 'yEs', 'yeS', 'YeS', "..."]
for index in range(len(array)):
    if(array[index].lower() == "yes"):
        array[index] = "Yes"
    else:
        array[index] = "No"
print(array)

# Implementa una funzione che accetti una password: string, ritorni
# True se valida, una password valida rispetta questi vincoli:
# - al minimo 6 caratteri
# - al massimo 10 caratteri
# - contenga almeno un simbolo speciale, un numero, una lettera
#   minuscola e una maiuscola
def passwordChecker(password) -> bool:
    if(len(password) < 6 or len(password) > 10):
        return False
    else:
        checkMaiuscola = False
        checkMinuscola = False
        checkSimbolo = False
        checkNumero = False
        for i in range(len(password)):
            if(password[i] >= 'A' and password[i] <= 'Z'):
                checkMaiuscola = True
            elif(password[i] >= 'a' and password[i] <= 'z'):
                checkMinuscola = True
            elif(password[i] >= '0' and password[i] <= '9'):
                checkNumero = True
            elif(not password[i].isalpha()):
                checkSimbolo = True
        return checkMinuscola & checkMaiuscola & checkSimbolo & checkNumero

password = "lhsno2.A"
print(passwordChecker(password))

# Implementa fizzbazz: per ogni numero divisibile per 3 stampa fizz e
# per ogni numero divisibile per 5 stampa bazz, se divisibile sia per
# 3 che per 5 stampa fizzbazz
for i in range(20):
    if(i%3 == 0 and i%5 == 0):
        print("fizzbazz")
    elif(i%3 == 0):
        print("fizz")
    elif(i%5 == 0):
        print("bazz")

# Definito il dizionario ("Nome
# della persona", "Numero di carta di identita") implementate le seguenti funzioni:
# Get: IdNum. data un dizionario e una string ritorna il IdNum
# Set: Boolean. date 2 string aggiungi al dizionario e ritorna True se
#      non era gia presente e False se gia c'era


# Senza un array di support implementa il calcolo dei numeri di fibonacci
# metodo ricorsivo
def fibonacci(n):
    if(n == 0 or n == 1):
        return n
    else:
        return fibonacci(n-1) + fibonacci(n-2)

print(fibonacci(10))

# Senza un array di supporto implementa il calcolo dei numeri di fibonacci
# con memoization


# Implementa in algoritmo di sorting a piacere tra (Bubble sort, Merge
# sort, Insertion sort)


# Implementa una funzione che ricerchi un elemento in un array in
# tempo O(n*log(n)), utilizzando la ricerca binaria


# Crea una funzione 'simulate' che prende in input lo stato di una board
# di Conway Game Of Life e ritorno lo stato successivo