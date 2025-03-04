#include <iostream>
#include <cstdlib>

using namespace std;

// Scrivere qui sotto la dichiarazione e definizione della funzione "funzione"
int funzione(int n){
    int num=n%10;
    if(n/10 == 0){
        return 0;
    }else{
        if(num != (n/10)%10){
            return 1 + funzione(n/10);
        }else{
            return funzione(n/10);
        }
    }
}
// Scrivere qui sopra la dichiarazione e definizione della funzione "funzione"

int main(int argc, char ** argv) {
  if (argc != 2) {
    std::cout << "Usage: " << argv[0] << " <positivenum> " << std::endl;
    exit(1);
  }
  int n = atoi(argv[1]);
  std::cout << "The read string is: " << argv[1] << std::endl;
  std::cout << "The converted value is: " << n << std::endl;
  std::cout << "function("<< n << ") = " << funzione(n) << std::endl;
}