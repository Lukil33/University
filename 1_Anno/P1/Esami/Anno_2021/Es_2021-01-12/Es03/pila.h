#ifndef PILA_H
#define PILA_H

#include <iostream>
using namespace std;

struct nodo {
	char value;
	nodo* next;
};
typedef nodo* lista;

void init();
void deinit();
bool push(char);
bool top(char &);
bool pop();
bool vuota();


#endif