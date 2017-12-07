def answer(population, x, y, strength):
    population = [row[:] for row in population]
    if len(population)<x:
        return population
    if len(population[0])<y:
        return population
    if population[x][y]<=strength:
        population[x][y]=-1
        length= len(population[0])
        pointList=CreatePoints(x,y,strength);
        population=CheckPoints(population,pointList,strength, length);
        return population
    return population

def IsSafeDown(x):
    if x-1>=0:
        return True
    else:
        return False
def IsSafeUp(x, length):
    if x+1<length:
        return True;
    else:
        return False 
def CheckPoints(array, points, strength, length):
    recursivePoints = [[0 for x in range(2)] for y in range(4)] 
    notNull=False
    for arr in array:
        for val in arr:
            if(val!=0):
                notNull=True
                break;
    if(notNull):
        for point in points:
            if array[point[0]][point[1]]<=strength and array[point[0]][point[1]]!=-1:
                array[point[0]][point[1]]=-1
                recursivePoints= CreatePoints(point[0], point[1], length)
                array = CheckPoints(array, recursivePoints, strength, length)
    return array
        
def CreatePoints(x, y, strength):
    counter= 0
    points = [[0 for z in range(2)] for p in range(4)] 
    if IsSafeDown(x):
        point= [x-1, y]
        points[counter]=point
        counter+=1
    if IsSafeUp(x, strength):
        point= [x+1, y]
        points[counter]=point
        counter+=1
    if IsSafeDown(y):
        point = [x, y-1]
        points[counter]=point
        counter+=1
    if IsSafeUp(y, strength):
        point = [x, y+1]
        points[counter]=point
        counter+=1
    return points
    
        
                
        
  
