#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <ctime>

#define MAXVAL 20
#define MAXSIZE 10

void printSquareMatrix(float ** A, int N) {
  for(int i = 0; i < N; i++) {
    std::cout << std::setw(10);
    for (int j = 0; j < N; j++)
      std::cout << std::setprecision(3) <<  A[i][j] << std::setw(10);
    std::cout << std::endl;
  }
}

float ** randomSquareMatrix(const int N) {
  float ** result = new float * [N];
  for(int i = 0; i < N; i++) {
    result[i] = new float[N];
    for(int j = 0; j < N; j++) {
      result[i][j] = rand()%MAXVAL;
    }
  }
  return result;
}

void deallocateSquaredMatrix(float ** & M, const int N) {
  for(int i = 0; i < N; i++)
    delete [] M[i];
  delete [] M;
  M = NULL;
}

// Inserire qui sotto la dichiarazione della procedura triangolarizza
void triangolarizza(float** A, int N);
// Inserire qui sopra la dichiarazione della procedura triangolarizza


int main(int argc, char * argv[]) {
  unsigned s = unsigned(time(0));
  srand(s);
		//
		// Commentare la linea seguente per avere comportamento
		// non-deterministico
		//
		srand(1688544644);
  int N = rand()%MAXSIZE;
  float **A = randomSquareMatrix(N);
  std::cout << "Matrice A["<< N << "][" << N << "]" << std::endl;
  printSquareMatrix(A, N);
  triangolarizza(A,N);
  std::cout << "Matrice AT["<< N << "][" << N << "]" << std::endl;
  printSquareMatrix(A, N);
  deallocateSquaredMatrix(A,N);
}

// Inserire qui sotto la definizione della procedura triangolarizza
bool is_valid(float** A, int N){
    bool valid=1;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            if(i>j && A[i][j] != 0){
                valid=0;
            }
        }
    }
    return valid;
}

//il programma funziona ed è tutto molto bello finchè uno dei pivot non diventa 0, in quel caso si creano non pochi problemi

void triangolarizza(float** A, int N){
    int i_iniziale=0;
    int j_iniziale=0;
    while(!is_valid(A, N)){
        for(int i=i_iniziale+1; i<N; i++){
            for(int j=N-1; j>=j_iniziale; j--){
                A[i][j]-=A[i_iniziale][j]*(A[i][j_iniziale]/A[i_iniziale][j_iniziale]);
            }
        }
        i_iniziale+=1;
        j_iniziale+=1;
    }
}
// Inserire qui sopra la definizione della procedura triangolarizza