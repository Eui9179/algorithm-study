def solution(bridge_length, weight, truck_weights):
    time = 0
    doing = []
    timer = []

    while truck_weights or doing:
        for i in range(len(timer)):
            timer[i] -= 1

        if timer and timer[0] == 0:
            doing.pop(0)
            timer.pop(0)

        if truck_weights:
            cur_truck = truck_weights[0]

            if sum(doing) + cur_truck <= weight and len(doing) + 1 <= bridge_length:
                doing.append(truck_weights.pop(0))
                timer.append(bridge_length)

        time += 1

    return time