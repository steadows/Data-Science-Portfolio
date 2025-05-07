def Floyd_Warshall(matrixA):

    vertices = len(matrixA)
    matrixM = matrixA
    # print(matrixM)

    for i in matrixM:
        for index, item in enumerate(i):
            if item == 0:
                i[index] = float('inf')


    for k in range(vertices):
        for i in range(vertices):
            for j in range(vertices):
                matrixM[i][j] = min(matrixM[i][j], matrixM[i][k] + matrixM[k][j])

    # return matrixM
    print(matrixM)



# Floyd_Warshall([[0,1,0,0],[0,0,1,0],[0,0,0,1],[1,0,0,0]])
#Floyd_Warshall([[0, 0, 3, 0], [2, 0, 0, 0], [0, 7, 0, 1], [6, 0, 0, 0]])
Floyd_Warshall([[0,3,0,0,5,0,0,0], [0,0,4,4,0,0,0,0], [1,0,0,0,2,5,4,0],[0,2,0,0,0,0,0,0],[0,0,0,0,0,0,2,8],[0,0,0,0,0,0,0,0],[0,0,9,0,2,0,0,6],[0,0,0,0,0,9,0,0]])
#Floyd_Warshall([[0,3,4,8,0,0,0,0], [5,0,1,6,0,0,1,0], [6,0,0,0,0,0,5,0],[0,4,0,0,0,5,0,8],[0,0,2,0,0,0,0,7],[0,2,0,0,0,0,0,0],[0,0,0,0,0,8,0,0],[0,0,0,0,0,0,8,0]])