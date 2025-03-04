#include <iostream>
#include <cstring>
#include <cstdlib>

using namespace std;

// Inserire la dichiarazione qui sotto
int genera_k_mer(int k);
int pow_4(int k, int x);
// Inserire la dichiarazione qui sopra

int main(int argc, char * argv[]) {
  if (argc != 2) {
    cout << "Formato accettato: " << argv[0] << " <numero_positivo> " << endl;
    exit(1);
  }
  int k = atoi(argv[1]);
  if (k <= 0) {
    cout << "Formato accettato: " << argv[0] << " <numero_positivo> " << endl;
  }
  cout << "Start" << endl;
  int count = genera_k_mer(k);
  cout << "Numero di k-mer generati: " << count << endl;
  cout << "Finish!" << endl;
  return 0;
}

// Inserire la definizione qui sotto
int pow(int k, int x){
    int ris=1;
    while(k>0){
        ris*=x;
        k-=1;
    }
    return ris;
}

int genera_k_mer(int k){
    for(int i=0; i<pow(k, 4); i++){
        for(int g=0; g<k; g++){
            int counter=i/pow(g, 4);
            counter=counter%4;
            switch(counter%4){
                case 0:
                    cout<<"A";
                    break;
                case 1:
                    cout<<"C";
                    break;
                case 2:
                    cout<<"G";
                    break;
                case 3:
                    cout<<"T";
                    break;
            }
        }
        cout<<endl;
    }
    return pow(k, 4);
}
// Inserire la definizione qui sopra
