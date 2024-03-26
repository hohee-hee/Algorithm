function solution(players, callings) {
    let answer = [];
    
    let map = new Map();    
    let prev = [];
    let next = [];
    
    players.forEach((player, idx) => {
        map.set(player, idx);
        prev.push(idx > 0 ? idx - 1 : -1);
        next.push(idx < players.length - 1 ? idx + 1 : -1)
    })
    
    let first = players[0];
    callings.forEach((calling) => {
        const currIdx = map.get(calling);
        const prevIdx = prev[currIdx];
        const nextIdx = next[currIdx];
                
        prev[currIdx] = prev[prevIdx];
        prev[nextIdx] = prevIdx;
        prev[prevIdx] = currIdx;
        
        next[currIdx] = prevIdx;
        next[prevIdx] = nextIdx;
        next[prev[currIdx]] = currIdx;
        
        first = prev[currIdx] === -1 ? calling : first;
    })

    let targetIdx = map.get(first);
    while(targetIdx > -1) {
        answer.push(players[targetIdx]);
        targetIdx = next[targetIdx];
    }

    return answer;
}
