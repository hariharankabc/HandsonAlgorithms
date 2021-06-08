

"""class Node:
    def __init__(self, freq,data):
        self.freq= freq
        self.data=data
        self.left = None
        self.right = None
"""        

# Enter your code here. Read input from STDIN. Print output to STDOUT
def decodeHuff(root, s):
    current_node = root
    for cur_var in s:
        if cur_var == '0':
            current_node = current_node.left 
        else:
            current_node = current_node.right
        if (current_node.left is None) and (current_node.right is None):
            print(current_node.data, end='')
            current_node = root

