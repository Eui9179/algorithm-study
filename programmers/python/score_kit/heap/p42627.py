import heapq


def insert_jobs_ready(ready, jobs, cur_time):
    while jobs and jobs[0][0] <= cur_time:
        job = jobs.pop(0)
        heapq.heappush(ready, (job[1], job[0]))


def solution(jobs):
    jobs.sort(key=lambda x: (x[0], x[1]))

    result_sum = 0
    jobs_len = len(jobs)
    time = 0

    ready = []

    while jobs or ready:
        insert_jobs_ready(ready, jobs, time)
        if ready:
            job = heapq.heappop(ready)
            request_time = job[1]
            job_time = job[0]
            result_sum += (time - request_time) + job_time
            time += job_time
        else:
            time += 1

    return result_sum // jobs_len


print(solution([[0, 3], [1, 9], [2, 6]]))