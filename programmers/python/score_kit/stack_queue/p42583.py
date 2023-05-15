def solution(bridge_length, weight, truck_weights):
    bridge = []
    timer = []
    time = 0

    while truck_weights or bridge:
        time += 1

        for i in range(len(timer)):
            timer[i] -= 1

        while timer and timer[0] == 0:
            timer.pop(0)
            bridge.pop(0)

        if truck_weights and len(bridge) < bridge_length and sum(bridge) + truck_weights[0] <= weight:
            truck = truck_weights.pop(0)
            bridge.append(truck)
            timer.append(bridge_length)

    return time