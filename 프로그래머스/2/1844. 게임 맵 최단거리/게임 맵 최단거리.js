function solution(maps) {
    let answer = -1;
    const rows = maps.length;
    const cols = maps[0].length;
    
    let isVisited = Array.from(Array(rows), () => Array(cols).fill(0));
    let queue = [];
    let pointer = 0;
    
    const dr = [-1,0,1,0];
    const dc = [0,1,0,-1];
    
    queue.push([0, 0, 1]);
    isVisited[0][0] = true;
    let test = 0;
    bfs: while(pointer < queue.length) {
        const cr = queue[pointer][0];
        const cc = queue[pointer][1];
        const cd = queue[pointer][2];
        pointer++;
        
        for(let i = 0 ; i < 4 ; i++) {
            const nr = cr + dr[i];
            const nc = cc + dc[i];
            if(nr === rows - 1 && nc === cols - 1) {
                answer = cd + 1;
                break bfs;
            }
                 
            if(nr >= rows || nc >= cols || nr < 0 || nc < 0) continue;
            if(maps[nr][nc] === 0) continue;
            if(isVisited[nr][nc] === 1) continue;
            
            isVisited[nr][nc] = 1;
            queue.push([nr, nc, cd + 1]);
        }
        test++;
    }
    
    return answer;
}