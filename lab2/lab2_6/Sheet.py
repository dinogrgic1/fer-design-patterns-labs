import ast
from Cell import Cell


class Sheet:
    table = None
    x = 0
    y = 0

    def __init__(self, x, y):
        self.table = [[Cell(0, 0) for j in range(y)] for i in range(x)]
        self.x = x
        self.y = y

        ref = 'A'
        for i in range(x):
            for j in range(y):
                self.table[i][j] = Cell(f'{ref}{j+1}', '0')
            ref = chr(ord(ref) + 1)

    def set(self, ref, content):
        for i in range(self.x):
            for j in range(self.y):
                if self.table[i][j].ref == ref:
                    self.table[i][j] = Cell(ref, content)
                    break

    def get(self, ref):
        for i in range(self.x):
            for j in range(self.y):
                if self.table[i][j].ref == ref:
                    return self.table[i][j]

    def getrefs(self, cell):
        l = set()
        if '+' in cell:
            cell_split = cell.split('+')
            for i in range(self.x):
                for j in range(self.y):
                    for c in cell_split:
                        if c in self.table[i][j].content:
                            l.add(self.get(c))
        return l

    def evaluate(self, cell):
        for i in range(self.x):
            for j in range(self.y):
                if cell == self.table[i][j].ref:
                    d = {}
                    l = self.getrefs(self.table[i][j].content)
                    for k in l:
                        d[k.ref] = k.content
                    self.table[i][j] = Cell(self.table[i][j].ref, self.eval_expression(self.table[i][j].content, d))

    def print(self):
        for i in range(self.x):
            for j in range(self.y):
                print(self.table[i][j], end='  ')
            print()

    @staticmethod
    def eval_expression(exp, variables={}):
        def _eval(node):
            if isinstance(node, ast.Num):
                return node.n
            elif isinstance(node, ast.Name):
                return variables[node.id]
            elif isinstance(node, ast.BinOp):
                return _eval(node.left) + _eval(node.right)
            else:
                raise Exception('Unsupported type {}'.format(node))
        node = ast.parse(exp, mode='eval')
        return _eval(node.body)
