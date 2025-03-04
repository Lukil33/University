class Cell:
    def __init__(self, alive :int):
        self.isAlive = alive
        self.setNumElementNear(0)
        
    def __str__(self):
        return f"[{self.isAlive}] "

    def setNumElementNear(self, num :int):
        self.numElemNear = num

    def modifyValue(self):
        if((self.isAlive == 1) and (self.numElemNear < 2 or self.numElemNear > 3)):
            self.isAlive = 0
        elif((self.isAlive == 0) and (self.numElemNear == 3)):
            self.isAlive = 1
    
    def returnisAlive(self):
        if(self.isAlive == 1):
            return True
        else:
            return False