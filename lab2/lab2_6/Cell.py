class Cell:
    ref = ''
    content = ''

    def __init__(self, x, y):
        self.ref = x
        self.content = y
    
    def __str__(self):
        return f'({self.ref}, {self.content})'