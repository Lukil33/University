#include <iostream>

#include "pila.h"

#define MAXSIZE 20

struct list {
  int node;
  struct list * next;
};

bool ** genera(const int N) {
  bool ** result = new bool * [N];
  for (int i = 0; i < N; i++) {
    result[i] = new bool[N]();
    for (int j = 0; j < N; j++) {
      result[i][j] = (bool)(rand()%2);
    }
  }
  return result;
}

void dealloca(bool * * & r, int N) {
  for(int i = 0; i < N; i++) {
    delete [] r[i];
  }
  delete [] r;
  r = NULL;
}

void print(bool ** G, int N) {
  for(int i = 0; i < N; i++) {
    for(int j = 0; j < N; j++) {
      std::cout << G[i][j] << " ";
    }
    std::cout << std::endl;
  }
}

void print(list * l) {
  std::cout << "Lista: ";
  while(l!=NULL) {
    std::cout << l->node << ((l->next != NULL) ? " " : "");
    l = l->next;
  }
  std::cout << std::endl;
}

void dealloca(list * l) {
  while(l!=NULL) {
    list * t = l;
    l=l->next;
    delete t;
  }
}

// Inserire qui sotto la dichiarazione di visita
list* visit(bool**, int, int);
// Inserire qui sopra la dichiarazione di visita


int main(int argc, char * argv[]) {
  unsigned s = unsigned(time(0));
  srand(s);
		//
		// Commentare la linea seguente per avere comportamento
		// non-deterministico
		//
		srand(1688544644);
  int N = rand()%MAXSIZE;
  bool **G = genera(N);
  int i = rand()%N;
  std::cout << "Grafo G["<< N << "][" << N << "]" << std::endl;
  print(G, N);
  list * res = visit(G,N,i);
  print(res);
  dealloca(G,N);
  dealloca(res);
}

// Inserire qui sotto la definizione di visita
list* visit(bool** mat, int dim, int start){
    bool* visited = new bool[dim];
    for(int i=0; i<dim; i++){
        visited[i] = 0;
    }

    list* res = nullptr;
    Stack* pila = init();
    push(pila, start);

    while(!isEmpty(pila)){
        int nodo = pop(pila);
        if(!visited[nodo]){
            res = new list{nodo, res};
            visited[nodo] = true;
            for(int i=0; i<dim; i++){
                if(mat[nodo][i]){
                    push(pila, i);
                }
            }
        }
    }

    quit(pila);
    return res;
}
// Inserire qui sopra la definizione di visita
