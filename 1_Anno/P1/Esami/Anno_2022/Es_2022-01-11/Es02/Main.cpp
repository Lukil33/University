#include <iostream>
#include <cstdlib>
#include <cassert>

struct node {
		char info;
		node * next;
};

void dealloca(node *& s) {
		while(s != NULL) {
				node * t = s;
				s = s->next;
				delete t;
		}
}

void stampa_lista(const char * testo, node * s) {
		std::cout << testo;
		for( ; s!= NULL; s=s->next) {
				std::cout << " " << s->info;
		}
		std::cout << std::endl;
}

// Scrivere qui sotto la dichiarazione della funzione compute_lists ed
// eventuali funzioni accessorie
void compute_lists(const char argv[], node*& s1, node*& s2);
char conversion(char start, char end, char letter);
void add_node(node*& s, char carattere);
node* add_to_end(node*pointer);
// Scrivere qui sopra la dichiarazione della funzione compute_lists ed
// eventuali funzioni accessorie

int main(int argc, char **argv) {
    if (argc != 2) {
            std::cout << "Usage: " << argv[0]<< " \"stringa di caratteri\"" << std::endl;
            exit(1);
    }
    node * s1, * s2;
    std::cout << "La stringa da analizzare e': " << argv[1] << std::endl;

    compute_lists(argv[1], s1, s2);

    stampa_lista("Lista s1:", s1);
    stampa_lista("Lista s2:", s2);
    dealloca(s1);
    dealloca(s2);
}

// Scrivere qui sotto la definizione della funzione compute_lists ed
// eventuali funzioni accessorie
char conversion(char start, char end, char letter){
    char carattere=end-(letter-start);
    carattere+='a'-'A';
    return carattere;
}

void add_node(node*& s, char carattere){
    node* created=new node{carattere, nullptr};
    if(s == nullptr){
        s=created;
    }else{
        node* pointer=s;
        pointer = add_to_end(pointer);
        pointer->next=created;
    }
}

node* add_to_end(node*pointer){
    if(pointer->next != nullptr){
        return add_to_end(pointer->next);
    }else{
        return pointer;
    }
}

void compute_lists(const char argv[], node*& s1, node*& s2){
    if(argv[0] != '\0'){
        if(argv[0] >= 'A' && argv[0] <= 'M'){
            char carattere=conversion('A', 'M', argv[0]);
            add_node(s1, carattere);
        }else if(argv[0] >= 'N' && argv[0] <= 'Z'){
            char carattere=conversion('N', 'Z', argv[0]);
            add_node(s2, carattere);
        }
        compute_lists(++argv, s1, s2);
    }
}
// Scrivere qui sopra la definizione della funzione compute_lists ed
// eventuali funzioni accessorie