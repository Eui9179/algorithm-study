def solution(priorities, location):
    tasks = []

    for i in range(len(priorities)):
        tasks.append((i, priorities[i]))

    priorities.sort(reverse=True)
    index = 0

    while index < len(tasks):
        task = tasks[index]
        if priorities[index] == task[1]:
            index += 1
            if task[0] == location:
                return index

        else:
            tasks.pop(index)
            tasks.append(task)