#include <iostream>


/* Inserire qui sotto la dichiarazione della funzione extract */
char* extract(char* input_string);
char* ausiliary(char* input_string, char* result, int i, int dim_ris);
char* cpy(char* result, char* nuova_stringa, int dim_ris);
/* Inserire qui sopra la dichiarazione della funzione extract */

/* Solo di esempio, non fate assunzioni su questo valore */
const int DIM = 255;

int main(int argc, char ** argv) {
  char input_string[DIM+1];
  char * extracted;
  char answer;

  do {
    std::cout << "Inserire la stringa da controllare: ";
    std::cin >> input_string;

    extracted = extract(input_string);
    std::cout << "La stringa estratta e': " << extracted << std::endl;

    delete [] extracted;
    std::cout << "Si vuole inserire un'altra stringa? [*/n]";
    std::cin >> answer;
  } while (answer != '\0' && answer != 'N' && answer != 'n');
  return 0;
}

/* Inserire qui sotto la definizione della funzione estract */
char* extract(char* input_string){
    int i=0, dim_ris=0;
    char* result={};
    return ausiliary(input_string, result, i, dim_ris);
}

char* ausiliary(char* input_string, char* result, int i, int dim_ris){
    if(input_string[i] == '\0'){
        char* nuova_stringa= new char[dim_ris+1];
        cpy(result, nuova_stringa, dim_ris);
        nuova_stringa[dim_ris]='\0';
        delete result;
        return nuova_stringa;
    }
    if(input_string[i] == '@'){
        char* nuova_stringa= new char[dim_ris+1];
        cpy(result, nuova_stringa, dim_ris);
        nuova_stringa[dim_ris]='@';
        delete result;
        return ausiliary(input_string, nuova_stringa, i+1, dim_ris+1);
    }else{
        return ausiliary(input_string, result, i+1, dim_ris);
    }
}

char* cpy(char* result, char* nuova_stringa, int dim_ris){
    if(dim_ris == 0){
        return nuova_stringa;
    }
    nuova_stringa[dim_ris-1]=result[dim_ris-1];
    return cpy(result, nuova_stringa, dim_ris-1);
}
/* Inserire qui sopra la definizione della funzione estract */