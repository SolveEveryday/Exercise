def solution(routes):
    answer = 0
    routes.sort(key = lambda x : x[1])
    cameraList = [routes[0][1]]
    for k in range(1, len(routes)):
        if routes[k][0]<=cameraList[-1] and routes[k][1]>=cameraList[-1]:
            continue
        else:
            cameraList.append(routes[k][1])
    return len(cameraList)