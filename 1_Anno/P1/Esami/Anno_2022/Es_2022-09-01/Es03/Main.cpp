#include <iostream>
#include <string.h> // definisce la funzione "int strlen (const char * array);"
#include <math.h>   // definisce la funzione "int pow (base, esponente);"
#include "pila.h"   // fare riferimento al file "pila.h" per le funzioni esposte
using namespace std;

int decodificaNumero(char numeroCodificato []);
int numero_minimo(int res);

int main() { 
    int dimensioneMassima = 9;
    char numeroCodificato [dimensioneMassima];
    cout << "Inserisci l'array: ";
    cin >> numeroCodificato;
    int decodifica = decodificaNumero(numeroCodificato);
    cout << "Decodifica: " << decodifica << endl;
}

int decodificaNumero(char numeroCodificato []) {
    // Scrivere il codice qui
    init();
    int len_numero= strlen(numeroCodificato);
    int res=0;
    for(int i=0; i<=len_numero; i++){
        if((i == len_numero) || (numeroCodificato[i] == 'I')){
            res+=numero_minimo(res)*pow(10, len_numero-i);
            int counter=1;
            while(pop()){
                res+=numero_minimo(res)*pow(10, len_numero-i+counter);
                counter+=1;
            }
        }else{
            push(0);
        }
    }
    deinit();
    return res;
    // Potete assumere che l'array rispetti le assunzioni
    // dell'esercizio (non serve fare controlli sull'input)
}

int numero_minimo(int res){
    int max_num=0;
    while(res != 0){
        if(res%10>max_num){
            max_num=res%10;
        }
        res/=10;
    }
    return max_num+1;
}