""" Node is defined as
class node:
  def __init__(self, data):
      self.data = data
      self.left = None
      self.right = None
"""
def check(root, nodes_list):
    if root:
        if check(root.left, nodes_list) == 0:
            return False

        if len(nodes_list) != 0:
            if root.data in nodes_list or root.data < nodes_list[-1]:
                return 0

        nodes_list.append(root.data)

        if check(root.right, nodes_list) == 0:
            return False


def check_binary_search_tree_(root):
    nodes_list = []
    if check(root, nodes_list) in [False, 0]:
        return False
    else:
        return True
