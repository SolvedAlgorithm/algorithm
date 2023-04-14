n = int(input())
tree = dict()

for _ in range(n):
    root, left, right = map(str, input().split())
    tree[root] = (left, right)

def preorder(root):
    print(root, end="")
    left, right = tree.get(root)
    if left != ".":
        preorder(left)
    if right != ".":
        preorder(right)
preorder('A')
print("")

def inorder(root):
    left, right = tree.get(root)
    if left != ".":
        inorder(left)
    print(root, end="")
    if right != ".":
        inorder(right)
inorder('A')
print("")

def postorder(root):
    left, right = tree.get(root)
    if left != ".":
        postorder(left)
    if right != ".":
        postorder(right)
    print(root, end="")
postorder('A')
print("")

class Node:
    def __init__(self, data, left_node, right_node):
        self.data = data
        self.left_node = left_node
        self.right_node = right_node