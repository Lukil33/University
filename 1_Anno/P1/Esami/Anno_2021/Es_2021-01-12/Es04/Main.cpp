#include <cstddef>
#include <cstring>
#include <cstdlib>
#include <iostream>

using namespace std;

#define MAXSSIZE 50
struct libro {
  char titolo[MAXSSIZE];
  char autore[MAXSSIZE];
  char ISBN[MAXSSIZE];
  int id;
};

struct tree {
  libro info;
  tree * left;
  tree * right;
};

void stampalibro(const libro & l) {
  cout << "==============================" << endl;
  cout << "Titolo: " << l.titolo << endl;
  cout << "Autore: " << l.autore << endl;
  cout << "ISBN: " << l.ISBN << endl;
  cout << "Id: " << l.id << endl;
  cout << "==============================" << endl;
}

libro leggilibro() {
  libro res;
  char b[100];
  cout << "Titolo: "; cin.getline(b, MAXSSIZE);
  strncpy(res.titolo, b, MAXSSIZE);
  cout << "Autore: "; cin.getline(b, MAXSSIZE);
  strncpy(res.autore, b, MAXSSIZE);
  cout << "ISBN: "; cin.getline(b, MAXSSIZE);
  strncpy(res.ISBN, b, MAXSSIZE);
  cout << "Id: "; cin >> b;
  res.id = atoi(b);
  return res;
}

int compara(const libro & l1, const libro & l2) {
  return strcmp(l1.autore, l2.autore);
}

int comparaautore(const char * autore, const libro & l) {
  return strcmp(autore, l.autore);
}

void init(tree * & t) {
  t = (tree *)NULL;
}

void deinit(tree * & t) {
  if (t != NULL) {
    deinit(t->left);
    deinit(t->right);
    delete t;
  }
}

void insert(tree * & t, const libro & v) {
  if (t == (tree*)NULL) {
    t = new (nothrow) tree;
    if (t != (tree*)NULL) {
      t->info = v;
      t->left = (tree*)NULL;
      t->right = (tree*)NULL;
    }
  }
  else if (compara(v, t->info) <= 0)
    insert(t->left, v);
  else if (compara(v, t->info) > 0)
    insert(t->right, v);
}

void stampaordinata(const tree * t) {
  if (t != (tree *)NULL) {
    stampaordinata(t->left);
    stampalibro(t->info);
    stampaordinata(t->right);
  }
}

//////////////////////////////////////////
// Inserire funzione stampatutti qui sotto
//////////////////////////////////////////
void stampatutti(tree* biblioteca, char autore[]){
    if(biblioteca!=nullptr){
        if(comparaautore(autore, biblioteca->info)==0){
            stampalibro(biblioteca->info);
            stampatutti(biblioteca->left, autore);
        }else if(comparaautore(autore, biblioteca->info)>0){
            stampatutti(biblioteca->right, autore);
        }else{
            stampatutti(biblioteca->left, autore);
        }
    }
}
//////////////////////////////////////////
// Inseririre funzione stampatutti qui sopra
//////////////////////////////////////////

int main() {
  tree * biblioteca;

  init(biblioteca);
  char res;

  do {
    cout << "Operazioni possibili: " << endl
     	 << "Inserimento (i)" << endl
     	 << "Stampa ordinata (o)" << endl
     	 << "Stampa tutti (t)" << endl
     	 << "Fine (f)" << endl;
    cout << "Inserire scelta: ";
    res = cin.get();
    switch (res) {
    case 'i': {
      libro l = leggilibro();
      insert(biblioteca, l);
      break;
    }
    case 'o': {
      cout << "La biblioteca completa e':" << endl;
      stampaordinata(biblioteca);
      cout << endl;
      break;
    }
    case 't': {
      char autore[MAXSSIZE];
      cout << "Autore ?";
      cin.getline(autore, MAXSSIZE);
      cout << endl << "Tutti i libri con autore \""
	   << autore << "\" sono:" << endl;
      stampatutti(biblioteca, autore);
      break;
    }
    case 'f':
      break;
    default:
      cout << "Operazione sconosciuta" << endl;
      break;
    }
  } while (res != 'f');

  deinit(biblioteca);
}
