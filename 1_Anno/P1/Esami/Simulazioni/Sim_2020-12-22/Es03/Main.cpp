using namespace std;
#include <iostream>

#include "queue.h"


int main ()
{
    char scelta;
    queue q;
  
    long val;
    
    init(q);

    do 
    {
        cout << "Operazioni possibili:\n"
             << "e : enqueue\n"
             << "d : dequeue\n"
             << "f : first\n"
             << "p : print\n"
             << "u : uscita\n"
             << "Che operazione vuoi eseguire? ";
        cin >> scelta;
        switch (scelta) {
          case 'e':
            cout << "Valore da inserire? ";
            cin >> val;
            enqueue(q, val);
            break;
          case 'd':
            if (! dequeue(q)) 
                cout << "Coda vuota!\n";
            else 
                cout << "Dequeue ok!\n"; 
            break;
          case 'f':
            if (! first(q, val))
                cout << "Coda vuota!\n";
            else
              cout << "Primo elemento della coda: " << val << endl;
            break;            
          case 'p':
            cout << "Contenuto della coda: ";
            print(q);
            break;
          default:
            if (scelta != 'u') 
                cout << "Operazione non valida: " << scelta << endl;
        }
    } while (scelta != 'u');

    return 0;
}
