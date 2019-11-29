const {iterativeDeepeningDFS} = require('./iterative_deepening_dfs');

// Smaller graph used for dijkstra
var start = {
    value: 0, children: [
        {
            value: 1, children: [
                {value: 3, children: []},
                {value: 4, children: []}
            ]
        }, {
            value: 2, children: [
                {value: 5, children: []},
                {value: 6, children: []}
            ]
        }]
};

// Bigger graph specifically for this algorithm
// TODO

// Should be 6
console.log(iterativeDeepeningDFS(start, 6).value);

