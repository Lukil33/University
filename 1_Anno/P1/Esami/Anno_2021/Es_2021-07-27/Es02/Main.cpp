#include <iostream>
#include <cstdlib>
using namespace std;

int funzione(int n);

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

int funzione(int n){
    if(n<=0){
        return 0;
    }else{
        if(n%10 == (n/10)%10){
            return 1+funzione(n/10);
        }else{
            return funzione(n/10);
        }
    }
}