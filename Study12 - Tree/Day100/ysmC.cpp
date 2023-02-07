#include <iostream>
#include <vector>
using namespace std;

int n;
struct Node {
	int start;
	Node* left;
	Node* right;
};
void postorder(Node* node) {
	if (node->left != NULL) {
		postorder(node);
	}

	if (node->right != NULL) {
		postorder(node);
	}
	cout << node->start;
}
int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    int data; cin >> data;
    Node* root = new Node();
    root->start = data; root->left = NULL; root->right = NULL;

    while (cin >> data) {
        if (data == EOF) break;
        Node* node = new Node();
        node->start = data; node->left = NULL; node->right = NULL;

        Node* tmp = root;
        while (1) {
            if (data <= tmp->start) {
                if (tmp->left == NULL) {
                    tmp->left = node;
                    break;
                }
                else tmp = tmp->left;
            }
            else {
                if (tmp->right == NULL) {
                    tmp->right = node;
                    break;
                }
                else tmp = tmp->right;
            }
        }
    }
    postorder(root);
}