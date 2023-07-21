package org.codingtest.level2.p86971;

public class Solution {
}

//def solution(n, wires):
//    answer = int(1e9)
//    graph = {i: [] for i in range(n + 1)}
//
//    for wire in wires:
//    graph[wire[0]].append(wire[1])
//    graph[wire[1]].append(wire[0])
//
//    for wire in wires:
//    left_count = dfs(n, graph, wire[0], wire[1])
//    right_count = dfs(n, graph, wire[1], wire[0])
//    answer = min(answer, abs(left_count - right_count))
//    return answer
//
//    def dfs(n, graph, start, visited_node):
//    q = [start]
//    visited = [False] * (n + 1)
//    visited[visited_node] = True
//    count = 0
//
//    while q:
//    node = q.pop(0)
//    if visited[node]:
//    continue
//    visited[node] = True
//
//    q += graph[node]
//
//    count += 1
//    return count
