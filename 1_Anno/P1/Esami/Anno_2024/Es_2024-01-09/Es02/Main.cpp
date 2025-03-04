#include <iostream>
#include <cstdlib>

#define MAX_DIM 75

void fill_random_array(char * A, int N) {
  if (NULL != A) {
    for(int i = 0; i < N; i++) {
      A[i] = 'A' + rand()%(('A' - 'Z')+1);
    }
  }
}

void print_array(const char msg[], char * A, int N) {
  std::cout << msg;
  if (NULL != A) {
    for (int i = 0; i < N; i++) {
      std::cout << A[i];
    }
  }
  std::cout << std::endl;
}

/* Inserire qui sotto la dichiarazione della funzione conta */
void conta(char A[], int D, int i, int j, int*& res);
int count_repetition(char A[], int i, int j);
void insert_in_res(char A[], int i, int j, int*& res, int counter);
/* Inserire qui sopra la dichiarazione della funzione conta */

int main(int argc, char **argv) {
  unsigned int seed = (unsigned int)time(NULL);
  // seed = 60000
  seed = 1697033220;
  if (argc > 1) {
    seed = atoi(argv[1]);
  }
  std::cout << "Seed = " << seed << std::endl;
  srand(seed);

  char A[MAX_DIM];

  fill_random_array(A, MAX_DIM);
  print_array("A[] = ", A, MAX_DIM);
  int i, j;
  i = 0; j = -1;
  while(i > j) {
    i = rand()%MAX_DIM;
    j = rand()%MAX_DIM;
  }
  int * res;
  conta(A, MAX_DIM, i, j, res);
  std::cout << "i = " << i << ", j = " << j << std::endl;
  std::cout << "A[" << i << "] = " << A[i];
  std::cout << "  A[" << j << "] = " << A[j] << std::endl;
  std::cout << "There are " << res[0] << " occurrences of the searched pattern";
  std::cout << " between indexes " << i << " and " << j
            << " (with A[" << i << "] included and A[" << j << "] excluded)" << std::endl;
  if (res[0] > 0) {
    std::cout << "They are at indexes: ";
    for(int l = 1; l < res[0]+1; l++) {
      std::cout << res[l] << " ";
    }
    std::cout << std::endl;
  }
  delete [] res;
}

/* Inserire qui sotto la definizione della funzione conta */
int count_repetition(char A[], int i, int j){
    if(i<j){
        if(A[i] == A[j]){
            return 1 + count_repetition(A, i+1, j);
        }else{
            return count_repetition(A, i+1, j);
        }
    }
    return 0;
}

void insert_in_res(char A[], int i, int j, int*& res, int counter){
    if(i<j){
        if(A[i] == A[j]){
            res[counter]=i;
            insert_in_res(A, i+1, j, res, counter+1);
        }else{
            insert_in_res(A, i+1, j, res, counter);
        }
    }
}

void conta(char A[], int D, int i, int j, int*& res){
    int dim=count_repetition(A, i, j);
    res=new int[dim+1];
    res[0]=dim;
    insert_in_res(A, i, j, res, 1);
}
/* Inserire qui sotto la definizione della funzione conta */
