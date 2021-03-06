def bfs(graph, start):
    """
    Implementation of Breadth-First-Search (BFS) using adjacency matrix.
    This returns nothing (yet), it is meant to be a template for whatever you want to do with it,
    e.g. finding the shortest path in a unweighted graph.
    This has a runtime of O(|V|^2) (|V| = number of Nodes), for a faster implementation see @see ../fast/BFS.java (using adjacency Lists)
    :param graph: an adjacency-matrix-representation of the graph where (x,y) is True if the the there is an edge between nodes x and y.
    :param start: the node to start from.
    :return: Array array containing the shortest distances from the given start node to each other node
    """
    # A Queue to manage the nodes that have yet to be visited, intialized with the start node
    queue = [start]
    # A boolean array indicating whether we have already visited a node
    visited = [False] * len(graph)
    # (The start node is already visited)
    visited[start] = True
    # Keeping the distances (might not be necessary depending on your use case)
    distances = [float("inf")] * len(
        graph)  # Technically no need to set initial values since every node is visted exactly once
    # (the distance to the start node is 0)
    distances[start] = 0
    # While there are nodes left to visit...
    while len(queue) > 0:
        print("Visited nodes: " + str(visited))
        print("Distances: " + str(distances))
        node = queue.pop(0)
        print("Removing node " + str(node) + " from the queue...")
        # ...for all neighboring nodes that haven't been visited yet....
        for i in range(len(graph[node])):
            if graph[node][i] and not visited[i]:
                # Do whatever you want to do with the node here.
                # Visit it, set the distance and add it to the queue
                visited[i] = True
                distances[i] = distances[node] + 1
                queue.append(i)
                print("Visiting node " + str(i) + ", setting its distance to " + str(
                    distances[i]) + " and adding it to the queue")

    print("No more nodes in the queue. Distances: " + str(distances))
    return distances
