#include <iostream>
#include "pila.h"

using namespace std;

char parseEspressioneBooleanaPrefissa(char espressione [], bool & corretta);
bool find_element(char& element, bool& corretta);

int main() { 

    int dimensioneMassima = 100;
    char espressioneBooleana [dimensioneMassima];
    bool corretta = true;
    char risultatoEspressione;

    cout << "Inserisci l'espressione: ";
    cin >> espressioneBooleana;

    risultatoEspressione = parseEspressioneBooleanaPrefissa(espressioneBooleana, corretta);

    if (corretta) {
        cout << "Risultato: " << risultatoEspressione << endl;
    }
    else {
        cout << "Espressione malformata" << endl;
    }
    
    return 0;
}

char parseEspressioneBooleanaPrefissa(char espressione [], bool & corretta) {
    init();
    for(int i=0; espressione[i] != '\0'; i++){
        push(espressione[i]);
    }
    char first_element, second_element, sign;
    while((!vuota())&&(corretta)){
        if(find_element(first_element, corretta)){
            if(find_element(second_element, corretta)){
                top(sign);
                if(sign != '&'){
                    corretta=false;
                }else{
                    pop();
                    if(first_element=='T'&&second_element=='T'){
                        push('T');
                    }else{
                        push('F');
                    }
                }
            }else{
            }
        }else{
            corretta=false;
        }
    }
    return first_element;
}

bool find_element(char& element, bool& corretta){
    char seguente;
    if(top(element)){
        if(element != 'F' && element != 'T'){
            corretta=false;
        }else{
            pop();
            do{
                top(seguente);
                if(seguente=='!'){
                    element='T'-(element-'F');
                    pop();
                }
            }while(seguente=='!');
        }
        return 1;
    }else{
        return 0;
    }
}