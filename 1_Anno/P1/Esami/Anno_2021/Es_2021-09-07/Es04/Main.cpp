#include <iostream>


// Inserire qui sotto dichiarazione funzione compute_pi
float compute_pi(int N);
// Inserire qui sopra dichiarazione funzione compute_pi

int main(int argc, char ** argv) {


  int N;

  std::cout << "Inserire numero positivo N= ";
  std::cin >> N;

  std::cout << "Valore approssimato serie Leibniz-Madhava(N="
	    << N << ") = " << compute_pi(N) << std::endl;
  return 0;
}


// Inserire definizione di compute_pi qui sotto
float compute_pi(int N){
    float res=0;
    if(N<0){
        return res;
    }else{
        if(N%2==0){
            res+=1.00/(2.00*float(N)+1.00);
        }else{
            res+=(1.00/(2.00*float(N)+1.00))*(-1.00);
        }
        return (res*4.00)+compute_pi(N-1);
    }
}
// Inserire definizione di compute_pi qui sopra