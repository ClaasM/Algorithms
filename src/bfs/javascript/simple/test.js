const {bfs} = require('./bfs');


var graph = [
    [false, true, true, false, false, false],
    [false, false, false, true, true, false],
    [false, true, false, true, false, false],
    [false, false, false, false, true, true],
    [false, false, false, false, false, true],
    [false, false, false, false, false, false],
];

// Should be [0, 1, 1, 2, 2, 3]
console.log(bfs(graph, 0));
    

