#include <iostream>

#define MAXVALUE 100
#define MAXSIZE 100

typedef struct tree {
  int data;
  struct tree * left;
  struct tree * right;
} tree;

void insert(tree * & result, const int num) {
		if (result == NULL) {
				result = new tree;
				*result = {num, NULL, NULL};
		} else if (result->data > num) {
				insert(result->left, num);
		} else {
				insert(result->right, num);
		}
}

tree * crea_tree(const int num) {
		tree * result = NULL;
		for(int i = 0; i < num; i++) {
				insert(result, rand()%MAXVALUE);
		}
		return result;
}

void print_tree(tree * root, int spazio = 0){
		if (root != NULL) {
				spazio++;
				print_tree(root->right, spazio);

				for (int i = 1; i < spazio; i++) std::cout<<"  ";
				std::cout<<root->data<<"\n";
				print_tree(root->left, spazio);
		}
}

void delete_tree(tree * & root) {
  if (root != NULL) {
    delete_tree(root->left);
    delete_tree(root->right);
    delete root;
    root = NULL;
  }
}

// Add hereafter the declaration of remove_element
tree* remove_element(tree* root, int key);
void add_to_end(tree*& start, tree* end);
// Add here above the declaration of remove_element

int main() {
		srand(unsigned(time(0)));
		//
		// Scommentare la linea seguente per avere comportamento
		// deterministico
		//
		srand(0);
		tree * root = crea_tree(rand()%MAXSIZE);

		std::cout << "Initial tree: " << std::endl;
		print_tree(root);
		std::cout << std::endl;
  int key = 84;
		std::cout << "removing: " << key << std::endl;
		root = remove_element(root, key);
  key = 77;
		std::cout << "removing: " << key << std::endl;
		root = remove_element(root, key);
  key = rand()%MAXVALUE;
		std::cout << "removing: " << key << std::endl;
		root = remove_element(root, key);
  key = rand()%MAXVALUE;
		std::cout << "removing: " << key << std::endl;
		root = remove_element(root, key);
  key = rand()%MAXVALUE;
		std::cout << "removing: " << key << std::endl;
		root = remove_element(root, key);
		std::cout << "removing: " << key << std::endl;
		root = remove_element(root, key);
		std::cout << "Final tree: " << std::endl;
		print_tree(root);
		std::cout << std::endl;
  delete_tree(root);
		return 0;
}


// Add hereafter the definition of compute_sum
tree* remove_element(tree* root, int key){
    tree* pointer= root;
    tree* back_pointer= nullptr;
    while((pointer != nullptr) && (pointer->data != key)){
        back_pointer=pointer;
        if(pointer->data > key){
            pointer=pointer->left;
        }else{
            pointer=pointer->right;
        }
    }
    if(pointer != nullptr){
        if(pointer->left != nullptr){
            add_to_end(pointer->left, pointer->right);
            if(back_pointer == nullptr){
                root=pointer->left;
            }else{
                if(back_pointer->data > key){
                    back_pointer->left=pointer->left;
                }else{
                    back_pointer->right=pointer->left;
                }
            }
        }else{
            if(back_pointer == nullptr){
                root=pointer->right;
            }else{
                if(back_pointer->data > key){
                    back_pointer->left=pointer->right;
                }else{
                    back_pointer->right=pointer->right;
                }
            }
        }
        delete pointer;
    }
    return root;
}

void add_to_end(tree*& start, tree* end){
    tree* pointer=start;
    while(pointer->right != nullptr){
        pointer=pointer->right;
    }
    pointer->right=end;
}
// Add here above the definition of compute_sum