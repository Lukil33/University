#include <iostream>
#include <string>

using namespace std;

typedef struct _list {
  int code;
  struct _list * next;
} list;

#define MAXCODE 100
#define MAXDIP 10

// Add hereafter the declaration of estrai
list* estrai(list* l1, list* l2);
void ausiliary(list* l1, list* l2, list*& result);
int occorrenze(list* lista, int number);
list* end_of_list(list* pointer);
// Add here above the declaration of estrai

list * crea_lista(int num) {
  int * a = new int[num];
  for (int i = 0; i < num; i++) {
    a[i] = rand()%MAXCODE + 1;
    for (int j = 0; j < i; j++) {
      if (a[i] == a[j]) { i--; break;}
    }
  }
  list * res = NULL;
  for (int i = 0; i < num; i++) {
    res = new list{a[i], res};
  }
  delete [] a;
  return res;
}

list * crea_l2(list * const l1, const int t = 5) {
  list * res = NULL;
  for (int k = t; k >= 0; k--) {
    for (list * d = l1; d != NULL; d = d->next) {
      if (rand()%2 == 0) {
        res = new list{d->code, res};
      }
    }
  }
  return res;
}

void print_list(list * l, const char * prefix) {
  std::cout << prefix;
  for( ; l != NULL; l = l->next)
    std::cout << " " << l->code;
  std::cout << std::endl;
}

void delete_list(list * & l) {
  while(l != NULL) {
    list * p = l;
    l = l->next;
    delete p;
  }
}

int main(int argc, char ** argv) {
  srand(unsigned(time(0)));
		//
		// Scommentare la linea seguente per avere comportamento
		// deterministico
		//
		srand(0);

  list * l1 = crea_lista(MAXDIP);
  print_list(l1, "Lista L1:");
  list * l2 = crea_l2(l1);
  print_list(l2, "Lista L2:");
  list * l3 = estrai(l1, l2);
  print_list(l3, "Lista L3:");
  delete_list(l1);
  delete_list(l2);
  delete_list(l3);
  return 0;
}


// Add hereafter the definition of estrai
list* estrai(list* l1, list* l2){
    list* result=nullptr;
    ausiliary(l1, l2, result);
    return result;
}

void ausiliary(list* l1, list* l2, list*& result){
    if(l1 != nullptr){
        int num=-1;
        if(l1->code%2 == 0){
            num=occorrenze(l2, l1->code);
        }
        list* created=new list{num, nullptr};
        if(result == nullptr){
            result=created;
        }else{
            list* pointer=result;
            pointer = end_of_list(pointer);
            pointer->next=created;
        }
        ausiliary(l1->next, l2, result);
    }
}

int occorrenze(list* lista, int number){
    if(lista == nullptr){
        return 0;
    }else{
        if(lista->code == number){
            return 1 + occorrenze(lista->next, number);
        }else{
            return occorrenze(lista->next, number);
        }
    }
}

list* end_of_list(list* pointer){
    if(pointer->next == nullptr){
        return pointer;
    }else{
        return end_of_list(pointer->next);
    }
}
// Add here above the definition of estrai
