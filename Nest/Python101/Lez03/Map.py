import random
from Cell import Cell

class Map:
    def __init__(self, dim :int):
        self.DimMap = dim
        self.map = self.createMap(dim)
        self.printMap()

    def createMap(self, dim :int):
        mappa = []
        for i in range(dim):
            mappa.append([])
            for j in range(dim):
                mappa[i].append(Cell(random.randint(0,1)))
        return mappa
    
    def changeTurn(self):
        for x in range(self.DimMap):
            for y in range(self.DimMap):
                self.map[x][y].setNumElementNear(self.countNear(x,y))
        for x in range(self.DimMap):
            for y in range(self.DimMap):
                self.map[x][y].modifyValue()
        print("-------------------")
        self.printMap()

    def countNear(self, x :int, y :int) -> int:
        res = 0
        for i in range(x-1, x+2):
            for j in range(y-1, y+2):
                if(self.isInRange(i) and self.isInRange(j)):
                    if((i != x or j!= y) and self.map[i][j].returnisAlive()): 
                        res += 1
        return res

    def isInRange(self, num :int):
        if(num >= 0 and num < self.DimMap):
            return True
        else:
            return False

    def printMap(self):
            for list in self.map:
                for val in list:
                    print(val, end="")
                print()