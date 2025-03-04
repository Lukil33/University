#include <iostream>
#include <cstring>
#include <cstdlib>

using namespace std;

// Dichiarazione della funzione
void StampaFrazioneEgizia(const int nr, const int dr);


int main(int argc, char ** argv) {
  if (argc != 3) {
    cout << "Formato accettato: " << argv[0] << " <numero_positivo> <numero_positivo> " << endl;
    exit(1);
  }
  int nr = atoi(argv[1]);
  int dr = atoi(argv[2]);
  if ((nr < 0) || (dr < 0)) {
    cout << "Formato accettato: " << argv[0] << " <numero_positivo> <numero_positivo> " << endl;
  }

  cout << "Frazione iniziale: " << nr << "/" << dr << endl;
  cout << "Frazione egizia:   ";
  StampaFrazioneEgizia(nr, dr);
  cout << endl;
}

// Inizio definizione della funzione StampaFrazioneEgizia
// ADD YOUR SOLUTION HERE
void StampaFrazioneEgizia(const int nr, const int dr){
  if(nr==0||dr==0){
    return;
  }else if(nr%dr==0){
    cout<<"1/"<<nr/dr<<endl;
    return;
  }else if(dr%nr==0){
    cout<<"1/"<<dr/nr<<endl;
    return;
  }else if(nr>dr){
    cout<<"1/"<<(nr/dr)<<" + ";
    return StampaFrazioneEgizia((nr%dr), dr);
  }else if(dr>nr){
    int x=(int)(dr/nr)+1;
    cout<<"1/"<<x<<" + ";
    return StampaFrazioneEgizia((nr*x)-dr, (dr*x));
  }
}
// Fine definizione della funzione StampaFrazioneEgizia