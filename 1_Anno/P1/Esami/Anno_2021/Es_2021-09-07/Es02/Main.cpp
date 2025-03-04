#include <iostream>


/* Inserire qui sotto la dichiarazione della funzione extract */
char* extract(char* string);
char* ausiliary(char* string, char* res, int counter, int dim_str);
void strcpy(char*, char*&, int);
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

/* Inserire qui sotto la definizione della funzione extract */
char* extract(char* string){
    char* res=new char[0];
    return ausiliary(string, res, 0, 0);
}

char* ausiliary(char* string, char* res, int counter, int dim_str){
    if(string[counter] != '\0'){
        if(string[counter]=='@'){
            char* new_str=new char[dim_str+1];
            strcpy(res, new_str, dim_str);
            new_str[dim_str]='@';
            delete[] res;
            return ausiliary(string, new_str, counter+1, dim_str+1);
        }else{
            return ausiliary(string, res, counter+1, dim_str);
        }
    }else{
        char* new_str=new char[dim_str+1];
        strcpy(res, new_str, dim_str);
        new_str[dim_str]='\0';
        delete[] res;
        return new_str;
    }
}

void strcpy(char* str, char*& new_str, int dim_str){
    if(dim_str > 0){
        new_str[dim_str-1]=str[dim_str-1];
        strcpy(str, new_str, dim_str-1);
    }
}
/* Inserire qui sopra la definizione della funzione extract */