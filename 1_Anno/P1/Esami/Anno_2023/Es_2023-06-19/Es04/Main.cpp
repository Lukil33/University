#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <ctime>

#define MAXSIZE 20
#define MAXVALUE 100

void print_matrix(int ** A, int N, int M) {
  for(int i = 0; i < N; i++) {
    std::cout << std::setw(5);
    for (int j = 0; j < M; j++)
      std::cout << A[i][j] << std::setw(5);
    std::cout << std::endl;
  }
}

void dealloca(int ** A, int N, int M) {
  for (int i = 0; i < N; i++)
    delete[] A[i];
  delete[] A;
}

int ** generate(int N, int M) {
  int ** res = new int * [N];
  for (int i = 0; i < N; i++) {
    res[i] = new int[M];
    for (int j = 0; j < M; j++)
      res[i][j] = rand()%MAXVALUE;
  }
  return res;
}

int** trasposta(int** A, int N, int M);

int main(int argc, char * argv[]) {
  srand(unsigned(time(0)));
		//
		// Commentare la linea seguente per avere comportamento
		// non-deterministico
		//
		srand(0);
  int N = rand()%MAXSIZE;
  int M = rand()%MAXSIZE;
  int **A = generate(N, M);
  std::cout << "Matrice A["<< N << "][" << M << "]" << std::endl;
  print_matrix(A, N, M);
  int **AT = trasposta(A, N, M);
  dealloca(A, N, M);
  std::cout << "Matrice AT["<< M << "][" << N << "]" << std::endl;
  print_matrix(AT, M, N);
  dealloca(AT, M, N);
}

void allocaMatriceRicorsiva(int **& matrice, int N, int M, int index){
    if(index == M){ //Se si è arrivati ad M ho finito;
        return;
    }else{
        matrice[index] = new int[N]; //Alloco una nuova riga ed aumento di uno l'indice;
        index++;
        allocaMatriceRicorsiva(matrice, N, M, index); //Richiamo la funzione ricorsiva ed aumento di 1 l'indice;
    }
}

void modificaLaMatriceRicorsiva(int **A, int**&matrice, int indexY, int N, int indexX){

    if(indexX == N){ //Scorro tra le colonne fino a quando non raggiungo il limite;
        return;
    }else{
        matrice[indexY][indexX] = A[indexX][indexY]; //Faccio la trasposizione degli elementi da A ad matrice;
        indexX++;
        modificaLaMatriceRicorsiva(A, matrice, indexY, N, indexX); //Aumento di 1 l'indice delle colonne e richiamo;
    }

}

void modificaLaMatrice(int **A, int**& matrice, int indexY, int M, int N){

    if(indexY == M){ //Scorro per le righe fino a quando non raggiungo il limite;
        return;
    }else{
        modificaLaMatriceRicorsiva(A, matrice, indexY, N, 0); //Funzione ricorsiva che scorre tra le colonne;
        indexY++;
        modificaLaMatrice(A, matrice, indexY, M, N); //Aumento di 1 l'indice delle righe e richiamo;
    }

}

// Scrivere qui sotto la definizione di trasposta
void insert_num(int**& matrix, int** A, int N, int M){
    if(N>0){
        matrix[M-1][N-1]=A[N-1][M-1];
        insert_num(matrix, A, N-1, M);
    }
}

void ausiliary(int**& matrix, int** A, int N, int M){
    if(M>0){
        matrix[M-1]=new int[N];
        insert_num(matrix, A, N, M);
        ausiliary(matrix, A, N, M-1);
    }
}

int** trasposta(int** A, int N, int M){
    int** matrix=new int*[M];
    ausiliary(matrix, A, N, M);
    return matrix;
}