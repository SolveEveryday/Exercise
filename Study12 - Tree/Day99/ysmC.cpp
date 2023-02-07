#include <iostream>
#include <vector>
using namespace std;


int n;
struct Node {
	char start;
	Node* left;
	Node* right;
};
//전위순회 -루트부터 시작->왼쪽 자식 -> 오른쪽 자식
void preorder(Node* node) {
	cout << node->start;
	if (node->left != NULL) {
		preorder(node->left);
	}

	if (node->right != NULL) {
		preorder(node->right);
	}
}

//중위순회 - 왼쪽 자식 끝부터 시작 -> 루트 -> 오른쪽 자식
void inorder(Node* node) {

	if (node->left != NULL) {
		inorder(node->left);
	}

	cout << node->start;

	if (node->right != NULL) {
		inorder(node->right);
	}
}

//후위 순회 - 왼쪽 자식 끝부터 시작 -> 오른쪽 자식 -> 루트
void postorder(Node* node) {

	if (node->left != NULL) {
		postorder(node->left);
	}

	if (node->right != NULL) {
		postorder(node->right);
	}

	cout << node->start;
}
int main() {
	cin >> n;
	vector<Node> node(26);
	Node* root;

	for (int x = 0; x < n; x++) {
		char parent, L, R;
		cin >> parent >> L >> R;
		node[parent - 'A'].start = parent;


		if (L != '.') {
			node[parent - 'A'].left = &node[L - 'A'];
		}

		if (R != '.') {
			node[parent - 'A'].right = &node[R - 'A'];
		}
	}

	root = &node[0];
	preorder(root);
	cout << endl;
	inorder(root);
	cout << endl;
	postorder(root);
	return 0;
   
}