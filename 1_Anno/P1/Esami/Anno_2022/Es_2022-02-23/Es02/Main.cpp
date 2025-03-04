#include <iostream>
#include <cstdlib>
#include <cstddef>
#include <ctime>

typedef struct List {
		int info;
		struct List * next;
} List;

const int MAXNUM = 50;

void do_print(const List *l);
void stampa_list(const List * l, const char * prefix);
List * create_random_list(int i = 0);
void dealloca(List * & l);

// ---------------------------------------------------------------
// Inserire qui sotto la dichiarazione della funzione compute_list
void compute_list(List* l, List*& l1, List*& l2);
List* last_node(List* list);
int calcola_lunghezza(List* l, int len);
void place_node(List*& l, List* created);
// Inserire qui sopra la dichiarazione della funzione compute_list
// ---------------------------------------------------------------

// NON modificare il main
int main(int argc, char ** argv) {
		// Non modificare il main
		if (argc != 1) {
				std::cerr << "Usage: " << argv[0] << std::endl;
				exit(1);
		}

		int seed = 0;
		// Inizializzare random_seed a true per un comportamento random
		bool random_seed = false;
		if (random_seed)
				seed = time(NULL);

		srand(seed);
		List * l = create_random_list();
		stampa_list(l, "Lista iniziale");
		List * l1, *l2;
		compute_list(l, l1, l2);
		stampa_list(l1, "Lista l1");
		stampa_list(l2, "Lista l2");
		dealloca(l);
		dealloca(l1);
		dealloca(l2);
}

// ---------------------------------------------------------------
// Inserire qui sotto la definizione della funzione compute_list
void compute_list(List* l, List*& l1, List*& l2){
    if(l == nullptr){
        List* created_l1=new List{calcola_lunghezza(l1, 0), nullptr};
        place_node(l1, created_l1);
        List* created_l2=new List{calcola_lunghezza(l2, 0), nullptr};
        place_node(l2, created_l2);
    }else{
        if(l->info%3 == 0){
            List* created=new List{l->info, nullptr};
            place_node(l2, created);
        }else if(l->info%2 == 0){
            List* created=new List{l->info, nullptr};
            place_node(l1, created);
        }
        compute_list(l->next, l1, l2);
    }
}

void place_node(List*& l, List* created){
    if(l == nullptr){
        l=created;
    }else{
        List* pointer=last_node(l);
        pointer->next=created;
    }
}

List* last_node(List* list){
    if(list->next == nullptr){
        return list;
    }else{
        return last_node(list->next);
    }
}

int calcola_lunghezza(List* l, int len){
    if(l==nullptr){
        return len;
    }else{
        return calcola_lunghezza(l->next, len+1);
    }
}

// Inserire qui sopra la definizione della funzione compute_list
// ---------------------------------------------------------------

// ---------------------------------------------------------------
// NON MODIFICARE IL CODICE SOTTOSTANTE
// ---------------------------------------------------------------
// Non modificare questa funzione
void do_print(const List *l) {
		if (l != NULL) {
				std::cout << " \"" << l->info << "\"";
				do_print(l->next);
		}
}
// Non modificare questa funzione
void stampa_list(const List * l, const char * prefix) {
		std::cout << prefix << " :";
		do_print(l);
		std::cout << std::endl;
}

// Non modificare questa funzione
List * create_random_list(int i) {
		List * res = NULL;
		if (i < MAXNUM) {
				res = new List{rand() % MAXNUM, create_random_list(++i)};
		}
		return res;
}

// Non modificare questa funzione
void dealloca(List * & l) {
		if (l != NULL) {
				List * n = l;
				dealloca(l->next);
				delete n;
		}
}
